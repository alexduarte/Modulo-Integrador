/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.dao.AtributoGradeEcomDAO;
import br.com.atsinformatica.erp.dao.CategoriaEcomDAO;
import br.com.atsinformatica.erp.dao.GradeERPDAO;
import br.com.atsinformatica.erp.dao.ParaUrlDAO;
import br.com.atsinformatica.erp.dao.ProdGradeERPDAO;
import br.com.atsinformatica.erp.dao.SubGradeERPDAO;
import br.com.atsinformatica.erp.entity.CategoriaEcomErpBean;
import br.com.atsinformatica.erp.entity.GradeERPBean;
import br.com.atsinformatica.erp.entity.ProdGradeERPBean;
import br.com.atsinformatica.prestashop.model.node.Name;
import br.com.atsinformatica.prestashop.model.node.Language;
import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.erp.entity.SubGradeERPBean;
import br.com.atsinformatica.prestashop.clientDAO.ProductPrestashopDAO;
import br.com.atsinformatica.prestashop.model.node.*;
import br.com.atsinformatica.prestashop.model.root.Product;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author ricardosilva
 */
public class ProductController {

    List<ProdutoERPBean> listProduct;

    /**
     * Adiciona um produto no prestashop e caso possua categoria ele salva em
     * uma existente ou cria uma e associa.
     *
     * @param listProdutoERP
     * @return
     */
    public Product createProductPrestashop(ProdutoERPBean produtoErp) throws SQLException {
        // return listProduct;
        return new ProductPrestashopDAO().postProduct(Product.URLPRODUCTS, createProduct(produtoErp));

    }

    public void updateProduto(ProdutoERPBean produtoERPBean) throws SQLException {
        new ProductPrestashopDAO().put(Product.URLPRODUCTS, createProduct(produtoERPBean));
    }
    
    public Product getProductById(int id){
        return new ProductPrestashopDAO().getId(Product.URLPRODUCTS, id);
    }

    private Product createProduct(ProdutoERPBean produtoERP) throws SQLException {
        Product p = new Product();
        Name name = new Name();
        if (produtoERP.getIdProdutoEcom() != 0) {
            Id id = new Id();
            id.setContent(String.valueOf(produtoERP.getIdProdutoEcom()));
            p.setId(id);
        }
        name.getLanguage().add(new Language(produtoERP.getNomeProd()));
        MetaDescription metaDesc = new MetaDescription();
        metaDesc.getLanguage().add(new Language(produtoERP.getMetaDescricao()));
        MetaKeyWord metaKey = new MetaKeyWord();
        metaKey.getLanguage().add(new Language(produtoERP.getPalavrasChave()));
        Description description = new Description();
        description.getLanguage().add(new Language(produtoERP.getDescricaoCompleta()));
        Price price = new Price();
        price.setContent(String.valueOf(produtoERP.getPrecoCheio()));
        LinkRewrite linkRewrite = new LinkRewrite();
        linkRewrite.getLanguage().add(new Language(produtoERP.getDescricaoCompleta()));
        if (produtoERP.getAtivo().equals("S")) {
            p.setActive(1);
        }
        AssociationsNode associations = new AssociationsNode();
        associations.setCategories(createCategories(produtoERP.getCodCategoria()));
        associations.setProductOptionValues(this.createProductOptionValues(produtoERP));
        associations.setCombinations(this.createCombinations(produtoERP));
        p.setAssociations(associations);
        p.setEan13(produtoERP.getCodBarras());
        p.setIdCategoryDefault(new CategoriaEcomDAO().abrir(produtoERP.getCodCategoria()).getIdCategoriaEcom());
        p.setDepth(String.valueOf(produtoERP.getProfundidade()));
        p.setWeight(String.valueOf(produtoERP.getPeso()));
        p.setWidth(String.valueOf(produtoERP.getLargura()));
        p.setHeight(String.valueOf(produtoERP.getAltura()));
        p.setMetaDescription(metaDesc);
        p.setMetaKeyWord(metaKey);
        p.setDescription(description);
        p.setCondition(getCondition(produtoERP.getCondicao()));
        p.setIdErp(Integer.parseInt(produtoERP.getCodProd()));
        p.setName(name);
        p.setPrice(price);
        p.setLinkRewrite(linkRewrite);
        return p;
    }

    /**
     * Cria associação de categorias
     *
     * @param codCategory
     * @return
     */
    private CategoriesNode createCategories(String codCategory) {
        try {
            CategoriesNode categories = new CategoriesNode();
            List<CategoriaEcomErpBean> categoriasEcomErp = new CategoriaEcomDAO().retornaCategoriasPai(codCategory);
            String url = new ParaUrlDAO().listaTodos().get(0).getUrlWSDL() + "/";
            List<CategoryNode> listCategory = new ArrayList<>();
            for (CategoriaEcomErpBean catEcom : categoriasEcomErp) {
                CategoryNode categorieNode = new CategoryNode(catEcom.getIdCategoriaEcom(), url + catEcom.getIdCategoriaEcom());
                listCategory.add(categorieNode);
            }
            categories.setCategory(listCategory);
            return categories;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Cria valores de grade
     *
     * @param prod
     * @return ProductOptionValuesNode
     */
    private ProductOptionValuesNode createProductOptionValues(ProdutoERPBean prod) {
        ProductOptionValuesNode prodOptionValues = new ProductOptionValuesNode();
        AtributoGradeEcomDAO atributoDao = new AtributoGradeEcomDAO();
        GradeERPDAO gradeDao = new GradeERPDAO();
        SubGradeERPDAO subGradeDAO = new SubGradeERPDAO();
        ProdGradeERPDAO prodGradeDao = new ProdGradeERPDAO();
        try {
            List<ProductOptionsValuesNode> prodOptionsValues = new ArrayList<>();
            //grade simples
            if (prod.getGrade() == 1) {
                List<ProdGradeERPBean> listaProdGrade = prodGradeDao.searchGradeComumByCodProd(prod.getCodProd());
                if (!listaProdGrade.isEmpty()) {
                    ProductOptionsValuesNode prodOptions = null;
                    for (ProdGradeERPBean prodGrade : listaProdGrade) {
                        prodOptions = new ProductOptionsValuesNode();
                        GradeERPBean grade = gradeDao.abrir(prodGrade.getCodGrade());
                        grade.setIdAtributo(atributoDao.abrir(prod.getCodAtributo1()).getIdAtributoEcom());
                        prodOptions.setId(this.getIdGradeEcom(grade));
                        prodOptionsValues.add(prodOptions);
                    }
                }
            }
            //grade composta
            if (prod.getGrade() == 2) {
                List<ProdGradeERPBean> listaProdGrade = prodGradeDao.searchGradeComumByCodProd(prod.getCodProd());
                if (!listaProdGrade.isEmpty()) {
                    //ProductOptionsValuesNode prodOptions = null;
                    for (ProdGradeERPBean prodGrade : listaProdGrade) {
                        //valor para grade
                        ProductOptionsValuesNode gradeOptions = new ProductOptionsValuesNode();
                        //valor para subgrade
                        ProductOptionsValuesNode subGradeOptions = new ProductOptionsValuesNode();
                        //bean de grade
                        SubGradeERPBean grade = subGradeDAO.abrir(prodGrade.getCodGrade().substring(0, 1));
                        grade.setIdAtributo(atributoDao.abrir(prod.getCodAtributo1()).getIdAtributoEcom());
                        //bean de subgrade
                        SubGradeERPBean subGrade = subGradeDAO.abrir(prodGrade.getCodGrade().substring(2, 3));
                        subGrade.setIdAtributo(atributoDao.abrir(prod.getCodAtributo2()).getIdAtributoEcom());
                        gradeOptions.setId(this.getIdSubGradeEcom(grade));
                        subGradeOptions.setId(this.getIdSubGradeEcom(subGrade));
                        prodOptionsValues.add(gradeOptions);
                        prodOptionsValues.add(subGradeOptions);
                    }
                }
            }
            prodOptionValues.setProdOptionsValues(prodOptionsValues);
            Logger.getLogger(ProductController.class).info("Valor de atributo do produto criado ou atualizado com sucesso.");
            return prodOptionValues;
        } catch (Exception e) {
            Logger.getLogger(ProductController.class).info("Erro ao criar ou atualizar valor do atributo do produto: " + e);
            return null;
        }
    }

    /**
     * Retorna o id da grade na loja virtual, cadastra caso não exista
     *
     * @param grade
     * @return
     */
    private int getIdGradeEcom(GradeERPBean grade) {
        GradeERPDAO gradeDao = new GradeERPDAO();
        ProductOptionValueController prodValueController = new ProductOptionValueController();
        try {
            //se grade ainda nao foi integrada
            if (grade.getIdGradeEcom() == 0) {
                prodValueController = new ProductOptionValueController();
                int idProdOptionValue = prodValueController.createProductOptionValuePrestashop(grade);
                if (idProdOptionValue != 0) {
                    grade.setIdGradeEcom(idProdOptionValue);
                    gradeDao.alterar(grade);
                }
            }
            Logger.getLogger(ProductController.class).info("Id da grade na loja virtual retornado com sucesso.");
            return grade.getIdGradeEcom();
        } catch (Exception e) {
            Logger.getLogger(ProductController.class).error("Erro ao retornar id da grade na loja virtual");
            return 0;
        }
    }

    /**
     * Retorna o id da grade na loja virtual, cadastra caso não exista
     *
     * @param grade
     * @return
     */
    private int getIdSubGradeEcom(SubGradeERPBean grade) {
        SubGradeERPDAO gradeDao = new SubGradeERPDAO();
        ProductOptionValueController prodValueController = new ProductOptionValueController();
        try {
            //se grade ainda nao foi integrada
            if (grade.getIdSubgradeEcom() == 0) {
                prodValueController = new ProductOptionValueController();
                int idProdOptionValue = prodValueController.createProductOptionValuePrestashop(grade);
                if (idProdOptionValue != 0) {
                    grade.setIdSubgradeEcom(idProdOptionValue);
                    gradeDao.alterar(grade);
                }
            }
            Logger.getLogger(ProductController.class).info("Id da subgrade na loja virtual, retornado com sucesso.");
            return grade.getIdSubgradeEcom();
        } catch (Exception e) {
            Logger.getLogger(ProductController.class).info("Erro ao retornar id da subgrade na loja virtual: " + e);
            return 0;
        }
    }

    /**
     * Retorna a condição do produto, novo, usado e etc
     *
     * @param conditionErp
     * @return
     */
    private String getCondition(int conditionErp) {
        String condition = "";
        switch (conditionErp) {
            case 0:
                condition = "new";
                break;
            case 1:
                condition = "used";
                break;
            case 2:
                condition = "refurbished";
                break;
        }
        return condition;

    }

    /**
     * Cria nó de combinação de grades
     *
     * @param produtoERP
     * @return
     */
    private CombinationsNode createCombinations(ProdutoERPBean produtoERP) {
        CombinationsNode combinations = new CombinationsNode();
        CombinationController combinationsController = new CombinationController();
        ProdGradeERPDAO prodGradeDAO = new ProdGradeERPDAO();
        List<ProdGradeERPBean> listProdGrade = null;
        try {
            List<CombinationsChild> listCombinationsChilds = new ArrayList<>();
            if (produtoERP.getGrade() == 1) {
                listProdGrade = prodGradeDAO.searchGradeComumByCodProd(produtoERP.getCodProd());
            }
            if (produtoERP.getGrade() == 2) {
                listProdGrade = prodGradeDAO.searchGradeCompostaByCodProd(produtoERP.getCodProd());
            }
            for (ProdGradeERPBean prodGradeERP : listProdGrade) {
                prodGradeERP.setTipoGrade(produtoERP.getGrade());
                CombinationsChild child = new CombinationsChild();                
                if(prodGradeERP.getIdProdGradeEcom()==0){
                    int idCombination = combinationsController.createCombination(prodGradeERP);
                    prodGradeERP.setIdProdGradeEcom(idCombination);
                    prodGradeDAO.alterar(prodGradeERP);
                }
                child.setId(prodGradeERP.getIdProdGradeEcom());
                listCombinationsChilds.add(child);
            }
            combinations.setCombinations(listCombinationsChilds);
            Logger.getLogger(ProductController.class).info("Combinação de grade criada com sucesso.");
            return combinations;
        } catch (Exception e) {
            Logger.getLogger(ProductController.class).info("Erro ao criar combinação de grade: " + e);
            return null;
        }
    }
}
