/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.TEST;

import br.com.atsinformatica.prestashop.clientDAO.CategoryPrestashopDAO;
import br.com.atsinformatica.prestashop.model.category.Category;
import java.util.List;



/**
 *
 * @author ricardosilva
 */
public class Main {

    public static void main(String args[]) throws Exception {

        //--------NOVO----------------//
        CategoryPrestashopDAO daoC = new CategoryPrestashopDAO();
        List<Category> category = daoC.get(Category.URLCATEGORY);

    }

}
