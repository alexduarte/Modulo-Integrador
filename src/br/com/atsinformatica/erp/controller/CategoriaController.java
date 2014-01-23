/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.entity.CategoriaERPBean;
import br.com.atsinformatica.erp.dao.CategoriaERPDAO;
import br.com.atsinformatica.prestashop.model.CategoriaPrestashopBean;
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
        List<CategoriaPrestashopBean> listPrestashop = listaItensTestes();
        
        categoriesNotRegistered = new ArrayList<>();
        for (CategoriaERPBean categoriaERPBean : listCategoria) {
            if (!checksCategoryExists(categoriaERPBean.getDescricao(), listPrestashop)) {
                categoriesNotRegistered.add(categoriaERPBean);
            }
        }
        return categoriesNotRegistered;

    }
    
    /**
     * Compara o descrição de um item no ERP com o do presta e verifica 
     * se o mesmo existe no Prestashop
     * @param descricao
     * @param listPrestashop
     * @return boolean
     */
    private boolean checksCategoryExists(String descricao, List<CategoriaPrestashopBean> listPrestashop) {

        if (listPrestashop.isEmpty()) {
            return false;
        } else {
            for (CategoriaPrestashopBean categoriaPrestashopBean : listPrestashop) {
                if (categoriaPrestashopBean.getDescricao().equals(descricao)) {
                    return true;
                }
            }
            return false;
        }
    }

    private List<CategoriaPrestashopBean> listaItensTestes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
