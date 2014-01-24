/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.prestashop.api.AccessXMLAttribute;
import br.com.atsinformatica.prestashop.api.GetListItens;
import br.com.atsinformatica.prestashop.model.category.Category;
import br.com.atsinformatica.prestashop.model.category.PrestashopCategory;
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
public class CategoryPrestashopDAO implements IGenericPrestashopDAO<Category> {

    /**
     * Adiciona um item Categoria
     *
     * @param path
     * @param t
     */
    @Override
    public void post(String path, Category t) {
        PrestashopCategory prestashopCategory = new PrestashopCategory(t);
        String xml = createTOXML(prestashopCategory);
        WebResource webResource = getWebResource();
        prestashopCategory = webResource.path(path).type(MediaType.APPLICATION_XML).post(PrestashopCategory.class, xml);
        System.out.println(prestashopCategory);
    }

    /**
     * Atualiza um item específico de Categoria.
     *
     * @param path
     * @param t
     */
    @Override
    public void put(String path, Category t, int key) {

        PrestashopCategory prestashopCategory = new PrestashopCategory(t);
        WebResource webResource = getWebResource();
        String xml = createTOXML(prestashopCategory);
        ClientResponse response = webResource.path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).put(ClientResponse.class, xml);
        System.out.println(response);
    }

    /**
     * retorna todos itens de categoria
     *
     * @param path
     * @return
     */
    @Override
    public List<Category> get(String path) {

        WebResource webresource = getWebResource();
        GetListItens getListItens = webresource.path(path).type(MediaType.APPLICATION_XML).get(GetListItens.class);

        List<Category> listCategory = new ArrayList<>();
        for (AccessXMLAttribute attribute : getListItens.getCategories().getCategory()) {
            PrestashopCategory prestashop = webresource.path(path).path(attribute.getId()).type(MediaType.APPLICATION_XML).get(PrestashopCategory.class);
            listCategory.add(prestashop.getCategory());
        }
        return listCategory;
    }

    /**
     * Retorna um item em específico da Categoria
     *
     * @param path
     * @param key
     * @return
     */
    @Override
    public Category getId(String path, int key) {
        WebResource webresource = getWebResource();
        PrestashopCategory prestashop = webresource.path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).get(PrestashopCategory.class);
        return prestashop.getCategory();
    }
    private final String pass = "W6AYITEGCXEFALUDYV0S952CPTAKNF8Q";
    private final String url = "http://localhost/prestashop/api/";

    /**
     * Retorna um a WebResource (função obrigatória);
     *
     * @return
     */
    protected WebResource getWebResource() {

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        client.addFilter(new HTTPBasicAuthFilter(pass, ""));
        return client.resource(url);
//        try {
//            ClientConfig config = new DefaultClientConfig();
//            Client client = Client.create(config);
//            List<ParaUrlWsdlBean> paraUrlWsdlBean = new ParaUrlDAO().listaTodos();
//            client.addFilter(new HTTPBasicAuthFilter(paraUrlWsdlBean.get(0).getUrlKey(), ""));
//            return client.resource(paraUrlWsdlBean.get(0).getUrlWSDL());
//        } catch (SQLException ex) {
//            Logger.getLogger(CategoryPrestashopDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
    }

    /**
     * Retorna um a WebResource (função obrigatória);
     *
     * @param prestashopCategory
     * @return
     */
    protected String createTOXML(PrestashopCategory prestashopCategory) {
        try {
            JAXBContext context = JAXBContext.newInstance(prestashopCategory.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter out = new StringWriter();

            marshaller.marshal(prestashopCategory, new StreamResult(out));
            System.out.println(out);
            String xml = out.toString();
            xml = xml.replace("<xlink:", "<");
            xml = xml.replace("</xlink:", "</");
            return xml;

        } catch (JAXBException ex) {
            Logger.getLogger(CategoryPrestashopDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
