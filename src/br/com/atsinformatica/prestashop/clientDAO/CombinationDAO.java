/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.prestashop.model.list.prestashop.AccessXMLAttribute;
import br.com.atsinformatica.prestashop.model.list.prestashop.PrestashopItens;
import br.com.atsinformatica.prestashop.model.root.Combination;
import br.com.atsinformatica.prestashop.model.root.Prestashop;
import com.sun.jersey.api.client.ClientResponse;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author AlexsanderPimenta
 */
public class CombinationDAO extends GenericPrestashopDAO<Combination> implements IGenericPrestashopDAO<Combination> {

    @Override
    public void post(String path, Combination t) {
        Prestashop prestashop = new Prestashop();
        prestashop.setCombination(t);
        String xml = createTOXML(prestashop);
        ClientResponse response = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(ClientResponse.class, xml);
        System.out.println(response.getStatus());
    }
    
     public int postCombination(String path, Combination p){
        Prestashop prestashop = new Prestashop();
        prestashop.setCombination(p);
        String xml = createTOXML(prestashop);
        Prestashop post = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(Prestashop.class, xml);
        return post.getCombination().getId();
    }

    @Override
    public void put(String path, Combination t) {
        Prestashop prestashop = new Prestashop();
        prestashop.setCombination(t);
        String xml = createTOXML(prestashop);
        ClientResponse response = getWebResource().path(path).type(MediaType.APPLICATION_XML).put(ClientResponse.class, xml);
        System.out.println("Response: " + response);
    }

    @Override
    public List<Combination> get(String path) {
        PrestashopItens getListItens = getWebResource().path(path).type(MediaType.APPLICATION_XML).get(PrestashopItens.class);
        List<Combination> listCombinations = new ArrayList<>();
        for (AccessXMLAttribute accessXMLAttribute : getListItens.getCombinations().getCombination()) {
            Prestashop prestashop = getWebResource().path(path).path(accessXMLAttribute.getId()).type(MediaType.APPLICATION_XML).get(Prestashop.class);
            listCombinations.add(prestashop.getCombination());
        }
        return listCombinations;
    }

    @Override
    public Combination getId(String path, int key) {
         Prestashop prestashop = getWebResource().path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).get(Prestashop.class);
        return prestashop.getCombination();
    }

    @Override
    public void delete(String path, String id) {
        getWebResource().path(path).path(id).type(MediaType.APPLICATION_XML).delete();
    }
}
