/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.TEST;

import br.com.atsinformatica.erp.entity.CategoriaERPBean;
import br.com.atsinformatica.erp.entity.SubCategoriaERPBean;
import br.com.atsinformatica.erp.dao.CategoriaERPDAO;
import br.com.atsinformatica.erp.dao.SubCategoriaERPDAO;
import br.com.atsinformatica.prestashop.api.AccessXMLAttribute;
import br.com.atsinformatica.prestashop.api.GetListItens;
import br.com.atsinformatica.prestashop.clientDAO.GenericPrestashopDAO;
import br.com.atsinformatica.prestashop.clientDAO.ClientPrestashop;
import br.com.atsinformatica.prestashop.list.ProductFeatures;
import br.com.atsinformatica.prestashop.model.category.Category;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author ricardosilva
 */
public class Main {

    public static void main(String args[]) throws Exception {
        // m = new Main();
        //m.getItensPrestaShop();
        //m.getItemPrestaShop();
       // m.testPostProduct();
        GenericPrestashopDAO dAO = new GenericPrestashopDAO();
        List<Category> list = dAO.get("categories/");
//        CategoriaERPDAO categoriaDAO = new CategoriaERPDAO();
//        List<CategoriaERPBean> list = categoriaDAO.listaTodos();
    }

    private void getItensPrestaShop() {
        try {
            ClientPrestashop clientPrestashop = new ClientPrestashop();
            GetListItens prestashop = (GetListItens) clientPrestashop.getPrestashopPackage("product_features/2", GetListItens.class);
            ProductFeatures productFeatures = prestashop.getProductFeatures();
            List<AccessXMLAttribute> ps = productFeatures.getProductFeature();
            for (AccessXMLAttribute p : ps) {
                clientPrestashop.mostrar(p.getId() + "---" + p.getHref());
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getItemPrestaShop() throws Exception {
        ClientPrestashop client = new ClientPrestashop();
        GetPrestashopItem clss = new GetPrestashopItem();
        GetPrestashopItem prestashop = (GetPrestashopItem) client.getPrestashopPackage("product_features/2", clss.getClass());
        String id = prestashop.getProductFeature().getId();
        System.out.println(id);
    }
    
    public void testPostProduct() throws JAXBException, ParserConfigurationException, SAXException, IOException, Exception {

        ClientPrestashop client = new ClientPrestashop();

        List<Language> listLang = new ArrayList<Language>();

        Language language = new Language();
        language.setContent("ricardo produto");
        language.setId("1");
        listLang.add(language);
        
        Language language1 = new Language();
        language1.setContent("ricardo ruas silva é um cara muito bom top");
        language1.setId("1");
        listLang.add(language1);

        Name name = new Name();
        name.getLanguage().add(language);

        Description description = new Description();
        description.getLanguage().add(language1);
         
        Price price = new Price();
        price.setContent("9.99");
        
        Type type = new Type();
        type.setContent("peck");
        type.setNotFilterable("true");
        
        
        Product product = new Product();
        product.setDescription(description);
        product.setLocation("demo_123");
        product.setName(name);
        product.setNew("novo");
        product.setPrice(price);
        product.setRedirectType("201");
        product.setSupplierReference("referencia");
        product.setType(type);
        product.setUnity("aaaa");
        product.setUpc("123");
        
        Prestashop prestashop = new Prestashop();
        prestashop.setProduct(product);
        
        client.postPrestashopPackage("products/",prestashop);
    }
}
