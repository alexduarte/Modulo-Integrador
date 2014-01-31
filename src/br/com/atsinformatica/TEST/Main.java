/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.TEST;

import br.com.atsinformatica.erp.controller.ProdutoController;
import br.com.atsinformatica.prestashop.clientDAO.CategoryPrestashopDAO;
import br.com.atsinformatica.prestashop.model.node.Language;
import br.com.atsinformatica.prestashop.model.root.Category;
import java.util.List;

/**
 *
 * @author ricardosilva
 */
public class Main {

    public static void main(String args[]) throws Exception {

        //--------NOVO----------------//
        CategoryPrestashopDAO daoC = new CategoryPrestashopDAO();
        //List<Category> get = daoC.get(Category.URLCATEGORY);
        Category category = daoC.getId(Category.URLCATEGORY,4);
        category.setId(null);
        category.getName().getLanguage().remove(0);
        category.getName().getLanguage().add(new Language("calcados"));
        daoC.post(Category.URLCATEGORY, category);
        
    }

}
