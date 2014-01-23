package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.prestashop.sax.NamespaceFilter;
import java.util.logging.Logger;

import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
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
public class ClientPrestashop {

    public static final Logger log = Logger.getLogger(ClientPrestashop.class.getCanonicalName());
    private final String pass = "W6AYITEGCXEFALUDYV0S952CPTAKNF8Q";
    private final String url = "http://localhost/prestashop/api/";

    /**
     *
     * @param path Qual url ela vai acessar dentro da api
     * @param classe para buscar uma lista instanciar a classe ServiceWeb, Caso
     * vc queira um objeto em especifico passe o PrestashopItens
     * @return
     * @throws JAXBException
     * @throws Exception
     */
    public Object getPrestashopPackage(String path, Class<?> classe) throws JAXBException, Exception {

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        client.addFilter(new HTTPBasicAuthFilter(pass, ""));

        WebResource webresource = client.resource(url + path);
        ClientResponse response = webresource.type(MediaType.APPLICATION_XML).get(ClientResponse.class);

        mostrar(response.getStatus());

        JAXBContext jaxbContext = JAXBContext.newInstance(classe);
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
        InputSource sr = new InputSource(response.getEntityInputStream());
        filter.parse(sr);
        Object presta = unmarshallerHandler.getResult();

        return presta;
    }

    public void postPrestashopPackage(String path, Object itens) throws JAXBException, ParserConfigurationException, SAXException, IOException {
        final StringWriter out = new StringWriter();
        JAXBContext context = null;
        try {

            context = JAXBContext.newInstance(itens.getClass());

            Marshaller marshaller = context.createMarshaller();
            //marshaller.setProperty(MarshallerProperties.NAMESPACE_PREFIX_MAPPER, new MyPrefixMapper());
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE
            );

            marshaller.marshal(itens, new StreamResult(out));
            System.out.println(out);
            String xml = out.toString().replace("<xlink:", "<");
            xml = xml.replace("</xlink:", "</");
            System.out.println(xml);

            ClientConfig config = new DefaultClientConfig();
            Client client = Client.create(config);
            client.addFilter(new HTTPBasicAuthFilter(pass, ""));

            WebResource webresource = client.resource(url);
            ClientResponse response = webresource.path(path).type(MediaType.APPLICATION_XML).post(ClientResponse.class, out.toString());
            System.out.println(response.getStatus());

        } catch (PropertyException e) {
        } catch (JAXBException e) {
        }
    }

    public void mostrar(Object o) {
        System.out.println(o);
    }
}
