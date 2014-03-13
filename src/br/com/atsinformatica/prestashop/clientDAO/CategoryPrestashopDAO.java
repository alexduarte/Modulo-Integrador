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
import br.com.atsinformatica.prestashop.model.root.Category;
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
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author ricardosilva
 */
public class CategoryPrestashopDAO extends GenericPrestashopDAO<Category> implements IGenericPrestashopDAO<Category> {
    
    /**
     * Adiciona um item Categoria
     *
     * @param path
     * @param t
     */
    @Override
    public void post(String path, Category t) {
        Prestashop prestashopCategory = new Prestashop();
        prestashopCategory.setCategory(t);
        String xml = createTOXML(prestashopCategory);
        ClientResponse response = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(ClientResponse.class, xml);
        System.out.println(response.getStatus());
    }

    /**
     * Adiciona uma categoria e retorna o objeto salvo
     * @param path
     * @param t
     * @return
     */
    public int postCategory(String path, Category t) {
        Prestashop prestashopCategory = new Prestashop();
        prestashopCategory.setCategory(t);
        String xml = createTOXML(prestashopCategory);
        Prestashop post = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(Prestashop.class, xml);
        return Integer.parseInt(post.getCategory().getId());
    }
    
    /**
     * Atualiza um item específico de Categoria.
     *
     * @param path
     * @param t
     */
    @Override
    public void put(String path, Category t, int key) {
        Prestashop prestashopCategory = new Prestashop();
        prestashopCategory.setCategory(t);
        String xml = createTOXML(prestashopCategory);
        ClientResponse response = getWebResource().path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).put(ClientResponse.class, xml);
    }

    /**
     * retorna todos itens de categoria
     *
     * @param path
     * @return
     */
    @Override
    public List<Category> get(String path) {
        PrestashopItens getListItens = getWebResource().path(path).type(MediaType.APPLICATION_XML).get(PrestashopItens.class);
        List<Category> listCategory = new ArrayList<>();
        for (AccessXMLAttribute accessXMLAttribute : getListItens.getCategories().getCategory()) {
            Prestashop prestashop = getWebResource().path(path).path(accessXMLAttribute.getId()).type(MediaType.APPLICATION_XML).get(Prestashop.class);
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
        Prestashop prestashop = getWebResource().path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).get(Prestashop.class);
        return prestashop.getCategory();
    }
//    /**
//     * Retorna um a WebResource (função obrigatória);
//     *
//     * @return
//     */
//    protected WebResource getWebResource() {
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
//    }
//
//    /**
//     * Retorna um a WebResource (função obrigatória);
//     *
//     * @param prestashopCategory
//     * @return
//     */
//    public String createTOXML(Prestashop prestashopCategory) {
//        try {
//            JAXBContext context = JAXBContext.newInstance(prestashopCategory.getClass());
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            StringWriter out = new StringWriter();
//            marshaller.marshal(prestashopCategory, new StreamResult(out));
//            System.out.println(out);
//            return out.toString();
//        } catch (JAXBException ex) {
//            Logger.getLogger(CategoryPrestashopDAO.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//        return "";
//    }
}
