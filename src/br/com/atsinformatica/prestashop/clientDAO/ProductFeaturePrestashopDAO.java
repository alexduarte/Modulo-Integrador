/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.erp.dao.ParaUrlDAO;
import br.com.atsinformatica.erp.entity.ParaUrlWsdlBean;
import br.com.atsinformatica.prestashop.api.AccessXMLAttribute;
import br.com.atsinformatica.prestashop.api.GetListItens;
import br.com.atsinformatica.prestashop.model.product_feature.PrestashopProductFeature;
import br.com.atsinformatica.prestashop.model.product_feature.ProductFeature;

import com.sun.jersey.api.client.Client;
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
public class ProductFeaturePrestashopDAO implements IGenericPrestashopDAO<ProductFeature> {

    /**
     * Adiciona um item Produto
     *
     * @param path
     * @param t
     */
    @Override
    public void post(String path, ProductFeature t) {
        PrestashopProductFeature prestashopProductFeature = new PrestashopProductFeature(t);
        String xml = createTOXML(prestashopProductFeature);
        xml = xml.replace("ns2", "xlink");
        WebResource webResource = getWebResource();   
        ClientResponse clientResponse = webResource.path("product_features").type(MediaType.APPLICATION_XML).post(ClientResponse.class, xml);
        System.out.println(clientResponse.getStatus());
    }

    /**
     * Atualiza um item específico de Produto.
     *
     * @param path
     * @param t
     */
    @Override
    public void put(String path, ProductFeature t, int key) {

        PrestashopProductFeature prestashopProductFeature = new PrestashopProductFeature(t);
        WebResource webResource = getWebResource();
        String xml = createTOXML(prestashopProductFeature);
        xml = xml.replace("ns2", "xlink");
        ClientResponse response = webResource.path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).put(ClientResponse.class, xml);
        System.out.println(response);
    }

    /**
     * retorna todos itens de Produto
     *
     * @param path
     * @return
     */
    @Override
    public List<ProductFeature> get(String path) {

        WebResource webresource = getWebResource();
        GetListItens getListItens = webresource.path(path).type(MediaType.APPLICATION_XML).get(GetListItens.class);

        List<ProductFeature> listProdFeature = new ArrayList<>();
        for (AccessXMLAttribute attribute : getListItens.getProductFeatures().getProductFeature()) {
            PrestashopProductFeature prestashop = webresource.path(path).path(attribute.getId()).type(MediaType.APPLICATION_XML).get(PrestashopProductFeature.class);
            listProdFeature.add(prestashop.getProductFeature());
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
    public ProductFeature getId(String path, int key) {
        WebResource webresource = getWebResource();
        PrestashopProductFeature prestashop = webresource.path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).get(PrestashopProductFeature.class);
        return prestashop.getProductFeature();
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
     * @param prestashopProductFeature
     * @return
     */
    protected String createTOXML(PrestashopProductFeature prestashopProductFeature) {
        try {
            JAXBContext context = JAXBContext.newInstance(prestashopProductFeature.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            
            StringWriter out = new StringWriter();
            
            marshaller.marshal(prestashopProductFeature, new StreamResult(out));
            System.out.println(out);
            return out.toString();
        } catch (JAXBException ex) {
            Logger.getLogger(ProductFeaturePrestashopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
