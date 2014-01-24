/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.TEST;


import br.com.atsinformatica.prestashop.clientDAO.CategoryPrestashopDAO;
import br.com.atsinformatica.prestashop.clientDAO.ProductFeaturePrestashopDAO;
import br.com.atsinformatica.prestashop.model.category.Category;
import br.com.atsinformatica.prestashop.model.product_feature.ProductFeature;
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
//        category.getDescription().getLanguage().get(0).setContent("teste");
//        category.getName().getLanguage().get(0).setContent("joaozinho");
//        category.getLinkRewrite().getLanguage().get(0).setContent("joaozinho");
//        category.setId(null);
//        daoC.post("categories/",category);
        //------------------------------------------------//
//        ProductFeaturePrestashopDAO dao = new ProductFeaturePrestashopDAO();
//        ProductFeature feature = dao.getId(ProductFeature.URLPRODUCTFEATURE, 5);
//        br.com.atsinformatica.prestashop.model.product_feature.Name n = feature.getName();
//        n.getLanguage().get(0).setContent("promomomo");
//        feature.setName(n);
//        feature.setId(null);
//        ProductFeature postProductFeature = dao.postProductFeature("product_features/", feature);

    }

}
