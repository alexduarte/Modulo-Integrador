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
import br.com.atsinformatica.prestashop.model.category.Category;
import br.com.atsinformatica.prestashop.sax.NamespaceFilter;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;

/**
 *
 * @author ricardosilva
 */
public class CategoryPrestashopDAO implements IGenericPrestashopDAO<Category>{

    /**
     * Adiciona um item prestashop
     * @param path
     * @param t
     */
    @Override
    public void post(String path, Category t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Atualiza um item específico 
     * @param path
     * @param t
     */
    @Override
    public void put(String path, Category t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * retorna todos itens de categoria
     * @param path
     * @return
     */
    @Override
    public List<Category> get(String path){ 
        try {
            ClientConfig config = new DefaultClientConfig();
            Client client = Client.create(config);
            List<ParaUrlWsdlBean> paraUrlWsdlBean = new ParaUrlDAO().listaTodos();
  //          client.addFilter(new HTTPBasicAuthFilter(pass, ""));
            
            WebResource webresource = client.resource(paraUrlWsdlBean.get(0).getUrlWSDL());
            ClientResponse response = webresource.path(path).type(MediaType.APPLICATION_XML).get(ClientResponse.class);
            System.out.println(response.getStatus());
            JAXBContext jaxbContext = JAXBContext.newInstance(GetListItens.class);
            
            //Crear XMLFilter
            XMLFilter filter = new NamespaceFilter("http://www.w3.org/1999/xlink", true);
            
            //El XMLReader ser� encapsulado en nuestro XMLFilter.
//            SAXParserFactory spf = SAXParserFactory.newInstance();
//            spf.setNamespaceAware(true);
//            SAXParser sp = spf.newSAXParser();
//            XMLReader xr = sp.getXMLReader();
//            filter.setParent(xr);
//            
//            //Modificar UnmarshalerHandler como ContentHandler en XMLFilter
//            Unmarshaller unmarshall = jaxbContext.createUnmarshaller();
//            UnmarshallerHandler unmarshallerHandler = unmarshall.getUnmarshallerHandler();
//            filter.setContentHandler(unmarshallerHandler);
//            
//            //Parse del XML
//            InputSource sr = new InputSource(response.getEntityInputStream());
//            filter.parse(sr);
//             presta = unmarshallerHandler.getResult();
            

        } catch (SQLException | JAXBException ex) {
            Logger.getLogger(CategoryPrestashopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Retorna um item em específico da Categoria
     * @param path
     * @param key
     * @return
     */
    @Override
    public Category getId(String path, int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
