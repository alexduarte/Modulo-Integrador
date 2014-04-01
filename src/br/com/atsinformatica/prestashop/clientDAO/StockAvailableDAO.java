/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.prestashop.model.list.prestashop.AccessXMLAttribute;
import br.com.atsinformatica.prestashop.model.list.prestashop.PrestashopItens;
import br.com.atsinformatica.prestashop.model.root.Prestashop;
import br.com.atsinformatica.prestashop.model.root.StockAvailable;
import com.sun.jersey.api.client.ClientResponse;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author AlexsanderPimenta
 */
public class StockAvailableDAO extends GenericPrestashopDAO<StockAvailable> implements IGenericPrestashopDAO<StockAvailable> {

    @Override
    public void post(String path, StockAvailable t) {
        Prestashop prestashop = new Prestashop();
        prestashop.setStockAvailable(t);
        String xml = createTOXML(prestashop);
        ClientResponse response = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(ClientResponse.class, xml);
        System.out.println(response.getStatus());
    }
    
     public int postStockAvailable(String path, StockAvailable p){
        Prestashop prestashop = new Prestashop();
        prestashop.setStockAvailable(p);
        String xml = createTOXML(prestashop);
        Prestashop post = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(Prestashop.class, xml);
        return post.getStockAvailable().getId();
    }

    @Override
    public void put(String path, StockAvailable t) {
        Prestashop prestashop = new Prestashop();
        prestashop.setStockAvailable(t);
        String xml = createTOXML(prestashop);
        ClientResponse response = getWebResource().path(path).type(MediaType.APPLICATION_XML).put(ClientResponse.class, xml);        
        System.out.println("Response: "+response);
    }

    @Override
    public List<StockAvailable> get(String path) {
        PrestashopItens getListItens = getWebResource().path(path).type(MediaType.APPLICATION_XML).get(PrestashopItens.class);
        List<StockAvailable> stockAvailables = new ArrayList<>();
        for (AccessXMLAttribute accessXMLAttribute : getListItens.getStockAvailables().getStockAvailable()) {
            Prestashop prestashop = getWebResource().path(path).path(accessXMLAttribute.getId()).type(MediaType.APPLICATION_XML).get(Prestashop.class);
            stockAvailables.add(prestashop.getStockAvailable());  
        }
        return stockAvailables;
    }

    @Override
    public StockAvailable getId(String path, int key) {
        Prestashop prestashop = getWebResource().path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).get(Prestashop.class);
        return prestashop.getStockAvailable();
    }

    @Override
    public void delete(String path, String id) {
        getWebResource().path(path).path(id).type(MediaType.APPLICATION_XML).delete();
    }
    
}
