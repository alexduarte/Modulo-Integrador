/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.TEST;


import br.com.atsinformatica.prestashop.clientDAO.ProductFeaturePrestashopDAO;
import br.com.atsinformatica.prestashop.model.product_feature.ProductFeature;

/**
 *
 * @author ricardosilva
 */
public class Main {

    public static void main(String args[]) throws Exception {


        //--------NOVO----------------//
//        CategoryPrestashopDAO dao = new CategoryPrestashopDAO();
//        Category category = dao.getId("categories/", 5);
//        category.getDescription().getLanguage().get(0).setContent("teste");
//
//        dao.put("categories/",category,5);
        //------------------------------------------------//
        ProductFeaturePrestashopDAO dao = new ProductFeaturePrestashopDAO();
        ProductFeature feature = dao.getId("product_features/", 5);
        br.com.atsinformatica.prestashop.model.product_feature.Name n = feature.getName();
        n.getLanguage().get(0).setContent("promomomo");
        feature.setName(n);
        feature.setId(null);
        dao.post("product_features/", feature);

    }

}
