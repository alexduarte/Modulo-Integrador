/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.entity.CategoriaERPBean;
import br.com.atsinformatica.erp.dao.CategoriaERPDAO;
import br.com.atsinformatica.prestashop.clientDAO.GenericPrestashopDAO;
import br.com.atsinformatica.prestashop.model.category.Category;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ricardosilva
 */
public class CategoriaController {


    List<CategoriaERPBean> categoriesNotRegistered;

    /**
     * Verifica se todas as categorias do ERP estão cadastradas no Prestashop
     * Se sim, return true.
     * Se não, cadastra o item e retorna false;
     * @return boolean
     * @throws SQLException
     */
    public List<CategoriaERPBean> checkAllCategory() throws SQLException {

        List<CategoriaERPBean> listCategoria = new CategoriaERPDAO().listaTodos();
       // List<Category> listCategoryPrestaShop = new GenericPrestashopDAO().get("categories/");
        
        categoriesNotRegistered = new ArrayList<>();
//        for (CategoriaERPBean categoriaERPBean : listCategoria) {
//            if (!checksCategoryExists(categoriaERPBean.getDescricao(), listCategoryPrestaShop)) {
//                categoriesNotRegistered.add(categoriaERPBean);
//            }
//        }
        return categoriesNotRegistered;

    }
    
    /**
     * Compara o descrição de um item no ERP com o do presta e verifica 
     * se o mesmo existe no Prestashop
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
}
