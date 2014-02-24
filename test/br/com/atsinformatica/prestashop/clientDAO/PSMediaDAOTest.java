/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.erp.entity.ProdImgBean;
import br.com.atsinformatica.erp.dao.ProdutoDAO;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.swing.ImageIcon;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.DefaultHttpClient;

import org.codehaus.plexus.util.IOUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 *
 * @author AlexsanderPimenta
 */
public class PSMediaDAOTest extends TestCase {

    public PSMediaDAOTest(String testName) {
        super(testName);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new PSMediaDAOTest("testPost"));
        return suite;
    }

    /**
     * Test of post method, of class PSMediaDAO.
     */
    @Test
    public void testPost() {
        try {             
            HttpPost post = new HttpPost("http://TG51GQIW2EI4QW2ZIY7W6SWZBJ9N0WU7@localhost/lojaprestashop/api/images/products/9");                       
            ImageIcon img = new ImageIcon(new ProdutoDAO().abrir("000927").getMedia().getFoto());
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();            
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            File file = new File("C://chuteira-nike1.jpg");
            builder.addPart("images", new ByteArrayBody(new ProdutoDAO().abrir("000927").getMedia().getFoto(), null));
            post.setEntity(builder.build());
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse httpResponse = httpclient.execute(post);
            HttpEntity resEntity = httpResponse.getEntity();
            // Get the HTTP Status Code
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            // Get the contents of the response
            InputStream input = resEntity.getContent();
            String responseBody = IOUtil.toString(input);
            input.close();
            // Print the response code and message body
            System.out.println("HTTP Status Code: "+statusCode);
            System.out.println("Conteudo: "+responseBody);
            //System.out.println("Entidade: "+post.getEntity());
        } catch (Exception e) {
            fail("Erro ao testar método POST: " + e);
        }
        // TODO review the generated test code and remove the default call to fail.      
    }

    /**
     * Test of put method, of class PSMediaDAO.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        String path = "";
        ProdImgBean t = null;
        int key = 0;
        PSMediaDAO instance = new PSMediaDAO();
        instance.put(path, t, key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class PSMediaDAO.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        String path = "";
        PSMediaDAO instance = new PSMediaDAO();
        List expResult = null;
        List result = instance.get(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class PSMediaDAO.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        String path = "";
        int key = 0;
        PSMediaDAO instance = new PSMediaDAO();
        ProdImgBean expResult = null;
        ProdImgBean result = instance.getId(path, key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}