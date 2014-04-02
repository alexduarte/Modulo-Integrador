/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.prestashop.model.list.prestashop.AccessXMLAttribute;
import br.com.atsinformatica.prestashop.model.list.prestashop.PrestashopItens;
import br.com.atsinformatica.prestashop.model.root.Prestashop;
import br.com.atsinformatica.prestashop.model.root.Product;

import com.sun.jersey.api.client.ClientResponse;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ricardosilva
 */
public class ProductPrestashopDAO extends GenericPrestashopDAO<Product> implements IGenericPrestashopDAO<Product> {

    /**
     * Adiciona um item Produto
     * @param path
     * @param t
     * @return boolean
     */
    public int postWithVerification(String path, Product t) {
        Prestashop prestashop = new Prestashop();
        prestashop.setProduct(t);
        String xml = createTOXML(prestashop);
        Prestashop post = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(Prestashop.class, xml);
        return Integer.parseInt(post.getProduct().getId().getContent());
        //String xmlResponse = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(String.class, xml);
      //  return 0;        
    }

    /**
     * Adiciona um item e retorna o objeto salvo
     *
     * @param path
     * @param t
     * @return
     */
    public Product postProduct(String path, Product t) {
        Prestashop prestashop = new Prestashop();
        prestashop.setProduct(t);
        String xml = createTOXML(prestashop);
        String xmlResponse = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(String.class, xml);
        return unmarshallContext(xmlResponse).getProduct();
    }

    /**
     * Atualiza um item específico de Produto.
     * @param path
     * @param t
     */
    @Override
    public void put(String path, Product t) {
        Prestashop prestashop = new Prestashop();
        prestashop.setProduct(t);
        String xml = createTOXML(prestashop);
        ClientResponse response = getWebResource().path(path).type(MediaType.APPLICATION_XML).put(ClientResponse.class, xml);
        System.out.println(response);
    }

    /**
     * retorna todos itens de Produto
     *
     * @param path
     * @return
     */
    @Override
    public List<Product> get(String path) {
        PrestashopItens getListItens = getWebResource().path(path).type(MediaType.APPLICATION_XML).get(PrestashopItens.class);
        List<Product> listProdFeature = new ArrayList<>();
        for (AccessXMLAttribute attribute : getListItens.getProducts().getProduct()) {
            Prestashop prestashop = getWebResource().path(path).path(attribute.getId()).type(MediaType.APPLICATION_XML).get(Prestashop.class);
            listProdFeature.add(prestashop.getProduct());
        }
        return listProdFeature;
    }

    /**
     * Retorna um item em específico da Produto
     *
     * @param path
     * @param key
     * @return
     */
    @Override
    public Product getId(String path, int key) {
        String xml = getWebResource().path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).get(String.class);
        Product p = unmarshallContext(xml).getProduct();
        return p;
    }

    @Override
    public void post(String path, Product t) {
        Prestashop prestashop = new Prestashop();
        prestashop.setProduct(t);
        String xml = createTOXML(prestashop);
        ClientResponse clientResponse = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(ClientResponse.class, xml);
    }

    @Override
    public void delete(String path, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
