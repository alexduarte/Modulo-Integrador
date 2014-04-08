/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.prestashop.model.list.prestashop.AccessXMLAttribute;
import br.com.atsinformatica.prestashop.model.list.prestashop.PrestashopItens;
import br.com.atsinformatica.prestashop.model.root.Prestashop;
import br.com.atsinformatica.prestashop.model.root.ProductOption;
import br.com.atsinformatica.prestashop.model.root.ProductOptionValue;
import com.sun.jersey.api.client.ClientResponse;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author AlexsanderPimenta
 */
public class ProductOptionValueDAO extends GenericPrestashopDAO<ProductOptionValue> implements IGenericPrestashopDAO<ProductOptionValue> {

    @Override
    public void post(String path, ProductOptionValue t) {
        Prestashop prestashop = new Prestashop();
        prestashop.setProductOptionValue(t);
        String xml = createTOXML(prestashop);
        ClientResponse response = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(ClientResponse.class, xml);
        System.out.println(response.getStatus());
    }

    @Override
    public void put(String path, ProductOptionValue t) {
        Prestashop prestashop = new Prestashop();
        prestashop.setProductOptionValue(t);
        String xml = createTOXML(prestashop);
        ClientResponse response = getWebResource().path(path).type(MediaType.APPLICATION_XML).put(ClientResponse.class, xml);        
        System.out.println("Response: "+response);
    }
    
     public int postProductOptionValue(String path, ProductOptionValue p){
        Prestashop prestashop = new Prestashop();
        prestashop.setProductOptionValue(p);
        String xml = createTOXML(prestashop);
        Prestashop post = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(Prestashop.class, xml);
        return Integer.parseInt(post.getProductOptionValue().getId());
    }

    @Override
    public List<ProductOptionValue> get(String path) {
        PrestashopItens getListItens = getWebResource().path(path).type(MediaType.APPLICATION_XML).get(PrestashopItens.class);
        List<ProductOptionValue> listProductOptionValue = new ArrayList<>();
        for (AccessXMLAttribute accessXMLAttribute : getListItens.getProductOptionValues().getProductOptionValue()) {
            Prestashop prestashop = getWebResource().path(path).path(accessXMLAttribute.getId()).type(MediaType.APPLICATION_XML).get(Prestashop.class);
            listProductOptionValue.add(prestashop.getProductOptionValue());  
        }
        return listProductOptionValue;
    }

    @Override
    public ProductOptionValue getId(String path, int key) {
        Prestashop prestashop = getWebResource().path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).get(Prestashop.class);
        return prestashop.getProductOptionValue();
    }

    @Override
    public void delete(String path, String id) {
        getWebResource().path(path).path(id).type(MediaType.APPLICATION_XML).delete();
    }
    
}
