/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.TEST;

<<<<<<< HEAD
import br.com.atsinformatica.prestashop.api.AccessXMLAttribute;
import br.com.atsinformatica.prestashop.api.GetListItens;
import br.com.atsinformatica.prestashop.clientDAO.GenericPrestashopDAO;
import br.com.atsinformatica.prestashop.clientDAO.ClientPrestashop;
import br.com.atsinformatica.prestashop.list.ProductFeatures;
import br.com.atsinformatica.prestashop.model.product.Description;
import br.com.atsinformatica.prestashop.model.product.Language;
import br.com.atsinformatica.prestashop.model.product.Name;
import br.com.atsinformatica.prestashop.model.product.Prestashop;
import br.com.atsinformatica.prestashop.model.product.Price;
import br.com.atsinformatica.prestashop.model.product.Product;
import br.com.atsinformatica.prestashop.model.product.Type;
import br.com.atsinformatica.prestashop.prestashop.GetPrestashopItem;
import java.io.IOException;
import java.util.ArrayList;
=======

import br.com.atsinformatica.prestashop.clientDAO.CategoryPrestashopDAO;
import br.com.atsinformatica.prestashop.clientDAO.ProductFeaturePrestashopDAO;
import br.com.atsinformatica.prestashop.model.category.Category;
import br.com.atsinformatica.prestashop.model.product_feature.ProductFeature;
>>>>>>> 7e39c55b8bb4dbec6f4e1eba320aff707432a92c
import java.util.List;

/**
 *
 * @author ricardosilva
 */
public class Main {

    public static void main(String args[]) throws Exception {
<<<<<<< HEAD
        // m = new Main();
        //m.getItensPrestaShop();
        //m.getItemPrestaShop();
       // m.testPostProduct();
        GenericPrestashopDAO dAO = new GenericPrestashopDAO();
       // List<Category> list = dAO.get("categories/");
//        CategoriaERPDAO categoriaDAO = new CategoriaERPDAO();
//        List<CategoriaERPBean> list = categoriaDAO.listaTodos();
    }
=======
>>>>>>> 7e39c55b8bb4dbec6f4e1eba320aff707432a92c


        //--------NOVO----------------//
        CategoryPrestashopDAO daoC = new CategoryPrestashopDAO();
        List<Category> category = daoC.get("categories/");
//        category.getDescription().getLanguage().get(0).setContent("teste");
//        category.getName().getLanguage().get(0).setContent("joaozinho");
//        category.getLinkRewrite().getLanguage().get(0).setContent("joaozinho");
//        category.setId(null);
//        daoC.post("categories/",category);
        //------------------------------------------------//
//        ProductFeaturePrestashopDAO dao = new ProductFeaturePrestashopDAO();
//        ProductFeature feature = dao.getId("product_features/", 5);
//        br.com.atsinformatica.prestashop.model.product_feature.Name n = feature.getName();
//        n.getLanguage().get(0).setContent("promomomo");
//        feature.setName(n);
//        feature.setId(null);
//        dao.post("product_features/", feature);

    }

}
