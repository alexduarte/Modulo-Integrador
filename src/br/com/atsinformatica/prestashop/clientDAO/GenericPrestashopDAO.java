/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.erp.dao.ParaUrlDAO;
import br.com.atsinformatica.erp.entity.ParaUrlWsdlBean;
import br.com.atsinformatica.prestashop.model.node.StockAvailableProduct;
import br.com.atsinformatica.prestashop.model.node.StockAvailablesProduct;
import br.com.atsinformatica.prestashop.model.root.Prestashop;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author AlexsanderPimenta
 */
public class GenericPrestashopDAO<T> {

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
     * Retorna o xml (função obrigatória);
     *
     * @param ps
     * @return
     */
    public String createTOXML(Prestashop ps) {
        try {
            JAXBContext context = JAXBContext.newInstance(ps.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter out = new StringWriter();
            marshaller.marshal(ps, new StreamResult(out));
            System.out.println(out);
            return out.toString();
        } catch (JAXBException ex) {
            Logger.getLogger(CategoryPrestashopDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * Deserializa o objeto, através do xml
     *
     * @param xml
     * @return
     */
    public Prestashop unmarshallContext(String xml) {
        try {
            JAXBContext context = JAXBContext.newInstance(Prestashop.class);
            Unmarshaller unmarshalContext = context.createUnmarshaller();
            Prestashop p = (Prestashop) unmarshalContext.unmarshal(new StringReader(xml));
            StockAvailablesProduct stocks = new StockAvailablesProduct();
            stocks.getStockAvailable().add(getStockByTagName(xml));
            p.getProduct().setStockAvailables(stocks);
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Retorna estoque baseado em xml de retorno do produto
     * @param xml xml de retorno do produto
     * @return StockAvailableProduct
     */
    private StockAvailableProduct getStockByTagName(String xml) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(xml)));
            NodeList nList = doc.getElementsByTagName("stock_available");
            StockAvailableProduct stockAvailableProduct = new StockAvailableProduct();
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                Element element = (Element) node;
                stockAvailableProduct.setId(Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()));
                stockAvailableProduct.setIdProductAttribute(Integer.parseInt(element.getElementsByTagName("id_product_attribute").item(0).getTextContent()));
            }
            return stockAvailableProduct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
