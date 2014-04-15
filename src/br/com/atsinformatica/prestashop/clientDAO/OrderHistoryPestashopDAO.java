/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.prestashop.model.root.OrderHistory;
import br.com.atsinformatica.prestashop.model.root.Prestashop;
import com.sun.jersey.api.client.ClientResponse;
import java.util.List;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author kennedimalheiros
 */
public class OrderHistoryPestashopDAO extends GenericPrestashopDAO<OrderHistory> implements IGenericPrestashopDAO<OrderHistory>{

    @Override
    public void post(String path, OrderHistory t) {
        Prestashop prestaOrderHistory = new Prestashop();
        prestaOrderHistory.setOrderHistory(t);
        String xml = createTOXML(prestaOrderHistory);
        ClientResponse response = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(ClientResponse.class, xml);
        System.out.println("Response: " + response);

    }

    @Override
    public void put(String path, OrderHistory t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderHistory> get(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderHistory getId(String path, int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String path, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
