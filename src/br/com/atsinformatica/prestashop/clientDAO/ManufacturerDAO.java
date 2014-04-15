/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.prestashop.model.root.Manufacturer;
import br.com.atsinformatica.prestashop.model.root.Prestashop;
import com.sun.jersey.api.client.ClientResponse;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author AlexsanderPimenta
 */
public class ManufacturerDAO extends GenericPrestashopDAO<Manufacturer> {
    
    public int post(String path, Manufacturer t){
        Prestashop prestashop = new Prestashop();
        prestashop.setManufacturer(t);
        String xml = createTOXML(prestashop);
        Prestashop post = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(Prestashop.class, xml);
        return Integer.parseInt(post.getManufacturer().getId());
    }
    
    public void put(String path, Manufacturer t){
        Prestashop prestashop = new Prestashop();
        prestashop.setManufacturer(t);
        String xml = createTOXML(prestashop);
        ClientResponse put = getWebResource().path(path).type(MediaType.APPLICATION_XML).put(ClientResponse.class, xml);
    }
    
    public void delete(String path, String id){
        getWebResource().path(path).path(id).type(MediaType.APPLICATION_XML).delete();
    }
    
    public Manufacturer getById(String path, int key){
        String xml = getWebResource().path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).get(String.class);
        Manufacturer manufacturer = unmarshallContext(xml).getManufacturer();
        return manufacturer;
    }
    
    
    
}
