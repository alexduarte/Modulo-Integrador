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
import br.com.atsinformatica.prestashop.clientDAO.CategoryPrestashopDAO;
import br.com.atsinformatica.prestashop.model.root.Category;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ricardosilva
 */
public class CategoriaController {

    List<CategoriaERPBean> categoriesNotRegistered;

    /**
     * Cria uma lista de Categoria no prestashop
     *
     * @param categoriaERP
     * @param subCategoriaERP
     * @return
     */
    public int createCategoryAndSubCategoryPrestashop(String categoriaERP, String subCategoriaERP) {

        List<Category> listCategoryPrestaShop = new CategoryPrestashopDAO().get(Category.URLCATEGORY);
        if (!checksCategoryExists(categoriaERP, listCategoryPrestaShop)) {
            return new SubCategoriaController().createSubCategoryPrestaShop(new CategoryPrestashopDAO().postCategory(Category.URLCATEGORY, addCategoryPrestashop(categoriaERP)),subCategoriaERP);
        } else {
            //JOptionPane.showConfirmDialog(null, "Categoria já existente no sistema");
            return 0;
        }  
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
        List<Category> listCategoryPrestaShop = new CategoryPrestashopDAO().get("categories/");

        categoriesNotRegistered = new ArrayList<>();
        for (CategoriaERPBean categoriaERPBean : listCategoriaERP) {
            if (!checksCategoryExists(categoriaERPBean.getDescricao(), listCategoryPrestaShop)) {
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
    private boolean checksCategoryExists(String descricao, List<Category> listCategoryPrestaShop) {

        if (listCategoryPrestaShop.isEmpty()) {
            return false;
        } else {
            for (Category categoriaPrestashopBean : listCategoryPrestaShop) {
                if (categoriaPrestashopBean.getDescription().getTextDescription().equals(descricao)) {
                    return true;
                }
            }
            return false;
        }
    }

    private Category addCategoryPrestashop(String categoriaERP) {
        Category category = new Category();
        category.setDataAdd(new Date());
        category.setDataUpd(new Date());

        LinkRewrite linkRewrite = new LinkRewrite();
        linkRewrite.getLanguage().add(new Language(categoriaERP.toLowerCase()));
        category.setLinkRewrite(linkRewrite);

        Name name = new Name();
        name.getLanguage().add(new Language(categoriaERP));
        category.setName(name);
        return category;
    }

}
