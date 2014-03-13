/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.prestashop.model.node.Name;
import br.com.atsinformatica.prestashop.model.node.LinkRewrite;
import br.com.atsinformatica.prestashop.model.node.Language;
import br.com.atsinformatica.erp.entity.CategoriaERPBean;
import br.com.atsinformatica.erp.dao.CategoriaERPDAO;
import br.com.atsinformatica.erp.dao.CategoriaEcomDAO;
import br.com.atsinformatica.erp.entity.CategoriaEcomBean;
import br.com.atsinformatica.prestashop.clientDAO.CategoryPrestashopDAO;
import br.com.atsinformatica.prestashop.model.node.Description;
import br.com.atsinformatica.prestashop.model.root.Category;
import br.com.atsinformatica.utils.Funcoes;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author ricardosilva
 */
public class CategoriaController {

    List<CategoriaERPBean> categoriesNotRegistered;

    /**
     * Cria uma lista de Categoria no prestashop
     *@param cat  Categoria
     * @return 
     */
    public int createCategoryPrestashop(CategoriaEcomBean cat) {
        //List<Category> listCategoryPrestaShop = new CategoryPrestashopDAO().get(Category.URLCATEGORY);
        //String idParent = checksCategoryExists(categoriaERP, listCategoryPrestaShop);
        //if (idParent.isEmpty()) {
           // return new SubCategoriaController().createSubCategoryPrestaShop(new CategoryPrestashopDAO().postCategory(Category.URLCATEGORY, addCategoryPrestashop(categoriaERP)),subCategoriaERP);
        return new CategoryPrestashopDAO().postCategory(Category.URLCATEGORY, addCategoryPrestashop(cat));
        //} else {
         //   return new SubCategoriaController().createSubCategoryPrestaShop(Integer.valueOf(idParent),subCategoriaERP);
       // }  
        
    }

    /**
     * Verifica se todas as categorias do ERP estão cadastradas no Prestashop Se
     * sim, return true. Se não, cadastra o item e retorna false;
     *
     * @return boolean
     * @throws SQLException
     */
    public List<CategoriaERPBean> checkAllCategory() throws SQLException {

        List<CategoriaERPBean> listCategoriaERP = new CategoriaERPDAO().listaTodos();
        List<Category> listCategoryPrestaShop = new CategoryPrestashopDAO().get(Category.URLCATEGORY);

        categoriesNotRegistered = new ArrayList<>();
        for (CategoriaERPBean categoriaERPBean : listCategoriaERP) {
            if (!checksCategoryExistsAll(categoriaERPBean.getDescricao(), listCategoryPrestaShop)) {
                categoriesNotRegistered.add(categoriaERPBean);
            }
        }
        return categoriesNotRegistered;
    }

    /**
     * Compara o descrição de um item no ERP com o do presta e verifica se o
     * mesmo existe no Prestashop
     *
     * @param descricao
     * @param listPrestashop
     * @return boolean
     */
    private String checksCategoryExists(String descricao, List<Category> listCategoryPrestaShop) {
        if (listCategoryPrestaShop.isEmpty()) {
            return "";
        } else {
            for (Category categoriaPrestashopBean : listCategoryPrestaShop) {
                if (categoriaPrestashopBean.getName().getTextName().toLowerCase().equals(descricao.toLowerCase())) {
                    return categoriaPrestashopBean.getId();
                }
            }
            return "";
        }
    }

    /**
     * Compara o descrição de um item no ERP com o do presta e verifica se o
     * mesmo existe no Prestashop
     *
     * @param descricao
     * @param listPrestashop
     * @return boolean
     */
    private boolean checksCategoryExistsAll(String descricao, List<Category> listCategoryPrestaShop) {
        if (listCategoryPrestaShop.isEmpty()) {
            return false;
        } else {
            for (Category categoriaPrestashopBean : listCategoryPrestaShop) {
                if (categoriaPrestashopBean.getName().getTextName().toLowerCase().equals(descricao.toLowerCase())) {
                    return true;
                }
            }
            return false;
        }
    }
    
//    private Category addCategoryPrestashop(String categoriaERP) {
//        Category category = new Category();
//        category.setDataAdd(new Date());
//        category.setDataUpd(new Date());
//        LinkRewrite linkRewrite = new LinkRewrite();
//        linkRewrite.getLanguage().add(new Language(categoriaERP.toLowerCase()));
//        category.setLinkRewrite(linkRewrite);
//
//        Name name = new Name();
//        name.getLanguage().add(new Language(categoriaERP));
//        category.setName(name);
//        return category;
//    }
    
    
      private Category addCategoryPrestashop(CategoriaEcomBean cat) {
         Category category = new Category();
         category.setDataAdd(new Date());
         category.setDataUpd(new Date());        
         category.setIdErp(Integer.parseInt(cat.getCodCategoria()));         
         LinkRewrite linkRewrite = new LinkRewrite();
         linkRewrite.getLanguage().add(new Language(cat.getDescricao().toLowerCase()));
         if(cat.getCodCategoriaSuperior() != null){
             try{
                 CategoriaEcomDAO dao = new CategoriaEcomDAO();
                 CategoriaEcomBean sub = dao.abrir(cat.getCodCategoriaSuperior());
                 category.setIdParent(sub.getIdCategoriaEcom());
             }catch(SQLException ex){
                 Logger.getLogger(CategoriaController.class).error("Erro ao retornar categoria superior: "+ex);
             }             
         }
         category.setLinkRewrite(linkRewrite);
         category.setDescription(new Description(cat.getDescricaoCompleta()));
         category.setName(new Name(cat.getDescricao()));
         return category;
    }

}
