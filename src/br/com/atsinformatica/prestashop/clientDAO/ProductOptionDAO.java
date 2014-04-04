/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.prestashop.model.list.prestashop.AccessXMLAttribute;
import br.com.atsinformatica.prestashop.model.list.prestashop.PrestashopItens;
import br.com.atsinformatica.prestashop.model.root.Prestashop;
import br.com.atsinformatica.prestashop.model.root.ProductOption;
import com.sun.jersey.api.client.ClientResponse;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author AlexsanderPimenta
 */
public class ProductOptionDAO extends GenericPrestashopDAO<ProductOption> implements IGenericPrestashopDAO<ProductOption> {

    @Override
    public void post(String path, ProductOption t) {
        Prestashop prestashop = new Prestashop();
        prestashop.setProductOption(t);
        String xml = createTOXML(prestashop);
        ClientResponse response = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(ClientResponse.class, xml);
        System.out.println(response.getStatus());
    }
    
    public int posProductOption(String path, ProductOption p){
        Prestashop prestashop = new Prestashop();
        prestashop.setProductOption(p);
        String xml = createTOXML(prestashop);
        Prestashop post = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(Prestashop.class, xml);
        return Integer.parseInt(post.getProductOption().getId());
    }

    @Override
    public void put(String path, ProductOption t) {
        Prestashop prestashop = new Prestashop();
        prestashop.setProductOption(t);
        String xml = createTOXML(prestashop);
        ClientResponse response = getWebResource().path(path).type(MediaType.APPLICATION_XML).put(ClientResponse.class, xml);        
        System.out.println("Response: "+response);
    }

    @Override
    public List<ProductOption> get(String path) {
        PrestashopItens getListItens = getWebResource().path(path).type(MediaType.APPLICATION_XML).get(PrestashopItens.class);
        List<ProductOption> listProductOption = new ArrayList<>();
        for (AccessXMLAttribute accessXMLAttribute : getListItens.getProductOptions().getProductOption()) {
            Prestashop prestashop = getWebResource().path(path).path(accessXMLAttribute.getId()).type(MediaType.APPLICATION_XML).get(Prestashop.class);
            listProductOption.add(prestashop.getProductOption());  
        }
        return listProductOption;
    }

    @Override
    public ProductOption getId(String path, int key) {
        Prestashop prestashop = getWebResource().path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).get(Prestashop.class);
        return prestashop.getProductOption();
    }

    @Override
    public void delete(String path, String id) {
        getWebResource().path(path).path(id).type(MediaType.APPLICATION_XML).delete();
    }
    
}
