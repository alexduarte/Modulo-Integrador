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
import br.com.atsinformatica.prestashop.model.category.Prestashop;
import br.com.atsinformatica.prestashop.sax.NamespaceFilter;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import java.io.IOException;
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
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamResult;
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
     * Adiciona um item Categoria
     *
     * @param path
     * @param t
     */
    @Override
    public void post(String path, Category t) {
        Prestashop prestashopCategory = new Prestashop(t);
        String xml = createTOXML(prestashopCategory);
        xml = xml.replace("ns2", "xlink");
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
        Prestashop prestashopCategory = new Prestashop(t);
        String xml = createTOXML(prestashopCategory);
        xml = xml.replace("ns2", "xlink");
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

        Prestashop prestashopCategory = new Prestashop(t);
        String xml = createTOXML(prestashopCategory);
        xml = xml.replace("ns2", "xlink");
        ClientResponse response = getWebResource().path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).put(ClientResponse.class, xml);
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

        GetListItens getListItens = getWebResource().path(path).type(MediaType.APPLICATION_XML).get(GetListItens.class);

        List<Category> listCategory = new ArrayList<>();
        for (AccessXMLAttribute attribute : getListItens.getCategories().getCategory()) {
            Prestashop prestashop = getPrestaShopItem(getWebResource().path(path).path(attribute.getId()).type(MediaType.APPLICATION_XML).get(ClientResponse.class));
            //listCategory.add(prestashop);
            System.err.println("");
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
     * @param prestashopCategory
     * @return
     */
    protected String createTOXML(Prestashop prestashopCategory) {
        try {
            JAXBContext context = JAXBContext.newInstance(prestashopCategory.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter out = new StringWriter();

            marshaller.marshal(prestashopCategory, new StreamResult(out));
            System.out.println(out);
            return out.toString();

        } catch (JAXBException ex) {
            Logger.getLogger(CategoryPrestashopDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    private Prestashop getPrestaShopItem(ClientResponse get) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Prestashop.class);
            /*
            * @sin
            */
            //Crear XMLFilter
            XMLFilter filter = new NamespaceFilter("http://www.w3.org/1999/xlink", true);
            
            //El XMLReader ser� encapsulado en nuestro XMLFilter.
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();
            filter.setParent(xr);
            
            //Modificar UnmarshalerHandler como ContentHandler en XMLFilter
            Unmarshaller unmarshall = jaxbContext.createUnmarshaller();
            UnmarshallerHandler unmarshallerHandler = unmarshall.getUnmarshallerHandler();
            filter.setContentHandler(unmarshallerHandler);
            
            //Parse del XML
            InputSource sr = new InputSource(get.getEntityInputStream());
            filter.parse(sr);
            
            
            return (Prestashop) unmarshallerHandler.getResult();
        } catch (ParserConfigurationException | SAXException | JAXBException | IOException ex) {
            Logger.getLogger(CategoryPrestashopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
