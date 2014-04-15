/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.prestashop.model.root.OrderCarriersTrackingNumber;
import br.com.atsinformatica.prestashop.model.root.Prestashop;
import com.sun.jersey.api.client.ClientResponse;
import java.util.List;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author kennedimalheiros
 */
public class OrderCarriersTrackingNumberPrestashopDAO extends GenericPrestashopDAO<OrderCarriersTrackingNumber> implements IGenericPrestashopDAO<OrderCarriersTrackingNumber> {

    @Override
    public void post(String path, OrderCarriersTrackingNumber t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void put(String path, OrderCarriersTrackingNumber t) {
        Prestashop prestaShopStatusOder = new Prestashop();
        prestaShopStatusOder.setOrderCarriersStatus(t);
        String xml = createTOXML(prestaShopStatusOder);
        ClientResponse response = getWebResource().path(path).type(MediaType.APPLICATION_XML).put(ClientResponse.class, xml);
        System.out.println("Response: " + response);

    }

    @Override
    public List<OrderCarriersTrackingNumber> get(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderCarriersTrackingNumber getId(String path, int key) {
        Prestashop prestashop = getWebResource().path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).get(Prestashop.class);
        return prestashop.getOrderCarriersStatus();

    }

    @Override
    public void delete(String path, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
