/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.erp.dao.ParaUrlDAO;
import br.com.atsinformatica.erp.entity.ParaUrlWsdlBean;
import br.com.atsinformatica.prestashop.model.list.prestashop.AccessXMLAttribute;
import br.com.atsinformatica.prestashop.model.list.prestashop.PrestashopItens;
import br.com.atsinformatica.prestashop.model.root.prestashop.Prestashop;
import br.com.atsinformatica.prestashop.model.root.Product;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author ricardosilva
 */
public class ProductPrestashopDAO implements IGenericPrestashopDAO<Product> {

    /**
     * Adiciona um item Produto
     *
     * @param path
     * @param t
     * @return boolean
     */
    public boolean postWithVerification(String path, Product t) {

        Prestashop prestashop = new Prestashop();
        prestashop.setProduct(t);
        String xml = createTOXML(prestashop);
        ClientResponse clientResponse = getWebResource().path("product_features").type(MediaType.APPLICATION_XML).post(ClientResponse.class, xml);
        if (clientResponse.getStatus() == 201) {
            return true;
        } else {
            return false;
        }
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
        Prestashop post = getWebResource().path("product_features").type(MediaType.APPLICATION_XML).post(Prestashop.class, xml);
        return post.getProduct();
    }

    /**
     * Atualiza um item específico de Produto.
     *
     * @param path
     * @param t
     */
    @Override
    public void put(String path, Product t, int key) {

        Prestashop prestashop = new Prestashop();
        prestashop.setProduct(t);
        String xml = createTOXML(prestashop);
        ClientResponse response = getWebResource().path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).put(ClientResponse.class, xml);
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
        Prestashop prestashop = getWebResource().path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).get(Prestashop.class);
        return prestashop.getProduct();
    }

    /**
     * Retorna um a WebResource (função obrigatória);
     *
     * @return
     */
    protected WebResource getWebResource() {
        try {
            ClientConfig config = new DefaultClientConfig();
            Client client = Client.create(config);
            List<ParaUrlWsdlBean> paraUrlWsdlBean = new ParaUrlDAO().listaTodos();
            client.addFilter(new HTTPBasicAuthFilter(paraUrlWsdlBean.get(0).getUrlKey(), ""));
            return client.resource(paraUrlWsdlBean.get(0).getUrlWSDL());
        } catch (SQLException ex) {
            Logger.getLogger(CategoryPrestashopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Retorna um a WebResource (função obrigatória);
     *
     * @param Prestashop
     * @return
     */
    protected String createTOXML(Prestashop Prestashop) {
        try {
            JAXBContext context = JAXBContext.newInstance(Prestashop.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter out = new StringWriter();

            marshaller.marshal(Prestashop, new StreamResult(out));
            System.out.println(out);
            return out.toString();
        } catch (JAXBException ex) {
            Logger.getLogger(ProductPrestashopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public void post(String path, Product t) {
        Prestashop prestashop = new Prestashop();
        prestashop.setProduct(t);
        String xml = createTOXML(prestashop);
        ClientResponse clientResponse = getWebResource().path("product_features").type(MediaType.APPLICATION_XML).post(ClientResponse.class, xml);
    }
}
