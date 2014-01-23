/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.entity.CategoriaERPBean;
import br.com.atsinformatica.erp.dao.CategoriaERPDAO;
import br.com.atsinformatica.prestashop.client.ClientPrestashop;
import br.com.atsinformatica.prestashop.model.CategoriaPrestashopBean;
import br.com.atsinformatica.prestashop.model.product.Prestashop;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ricardosilva
 */
public class CategoriaController {
   
    List<CategoriaERPBean> listCategoria;
    List<CategoriaPrestashopBean> listPrestashop;
    @SuppressWarnings("empty-statement")
    private void verificaCategorias() throws SQLException {      
         listCategoria = new CategoriaERPDAO().listaTodos();
         //listPrestashop = new ClientPrestashop().getPrestashopPackage("Categories", Prestashop.class);
         listPrestashop = listaItensTestes();
         for (CategoriaERPBean categoriaERPBean : listCategoria) {
            if(checksCategoryExists(categoriaERPBean.getDescricao(),listPrestashop)){
                
            }
        }
         
    }
    private boolean checksCategoryExists(String descricao, List<CategoriaPrestashopBean> listPrestashop) {
        
        if(listPrestashop.isEmpty())return false;
        else{         
            for (CategoriaPrestashopBean categoriaPrestashopBean : listPrestashop) {
                if(categoriaPrestashopBean.getDescricao().equals(descricao)) return true;
            }
            return false;
        } 
    }

    private List<CategoriaPrestashopBean> listaItensTestes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
