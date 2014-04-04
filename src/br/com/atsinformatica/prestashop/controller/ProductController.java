/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.dao.CategoriaEcomDAO;
import br.com.atsinformatica.erp.dao.ParaUrlDAO;
import br.com.atsinformatica.erp.entity.CategoriaEcomErpBean;
import br.com.atsinformatica.prestashop.model.node.Name;
import br.com.atsinformatica.prestashop.model.node.Language;
import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.prestashop.clientDAO.ProductPrestashopDAO;
import br.com.atsinformatica.prestashop.model.node.*;
import br.com.atsinformatica.prestashop.model.root.Product;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

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
    
    public void updateProduto(ProdutoERPBean produtoERPBean) throws SQLException{
        new ProductPrestashopDAO().put(Product.URLPRODUCTS, createProduct(produtoERPBean));
    }

    private Product createProduct(ProdutoERPBean produtoERP) throws SQLException {
        Product p = new Product();
        Name name = new Name();       
        if(produtoERP.getIdProdutoEcom()!=0){
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
        if(produtoERP.getAtivo().equals("S"))
            p.setActive(1);
        AssociationsNode associations = new AssociationsNode();
        associations.setCategories(createCategories(produtoERP.getCodCategoria()));
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
     * @param codCategory
     * @return 
     */
    private CategoriesNode createCategories(String codCategory){
        try{
            CategoriesNode categories = new CategoriesNode();
            List<CategoriaEcomErpBean> categoriasEcomErp = new CategoriaEcomDAO().retornaCategoriasPai(codCategory);
            String url = new ParaUrlDAO().listaTodos().get(0).getUrlWSDL()+"/";
            List<CategoryNode> listCategory = new ArrayList<>();
            for(CategoriaEcomErpBean catEcom : categoriasEcomErp){
                CategoryNode categorieNode = new CategoryNode(catEcom.getIdCategoriaEcom(), url+catEcom.getIdCategoriaEcom());
                listCategory.add(categorieNode);
            }
            categories.setCategory(listCategory);
            return categories;
        }catch(Exception e){
            return null;            
        }
    }
    
    /**
     * Retorna a condição do produto, novo, usado e etc
     * @param conditionErp
     * @return 
     */
    private String getCondition(int conditionErp){
        String condition = "";
        switch(conditionErp){
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
}
