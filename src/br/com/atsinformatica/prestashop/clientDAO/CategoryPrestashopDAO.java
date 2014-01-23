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
import br.com.atsinformatica.prestashop.list.Categories;
import br.com.atsinformatica.prestashop.model.category.Category;
import br.com.atsinformatica.prestashop.model.category.Prestashop;
import br.com.atsinformatica.prestashop.sax.NamespaceFilter;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;

/**
 *
 * @author ricardosilva
 */
public class CategoryPrestashopDAO implements IGenericPrestashopDAO<Category> {

    /**
     * Adiciona um item prestashop
     *
     * @param path
     * @param t
     */
    @Override
    public void post(String path, Category t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Atualiza um item específico
     *
     * @param path
     * @param t
     */
    @Override
    public void put(String path, Category t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                Prestashop prestashop = webresource.path(path).path(attribute.getId()).type(MediaType.APPLICATION_XML).get(Prestashop.class);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Retorna um a WebResource (função obrigatória);
     *
     * @return
     */
    private WebResource getWebResource() {
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

}
