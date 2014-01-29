/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.prestashop.model.category.Category;
import br.com.atsinformatica.prestashop.model.category.Prestashop;
import com.sun.jersey.api.client.WebResource;
import java.util.List;
import junit.framework.TestCase;
import junit.framework.TestSuite;
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
public class CategoryPrestashopDAOTest extends TestCase {

    public CategoryPrestashopDAOTest(String testCase) {
        super(testCase);
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
        suite.addTest(new CategoryPrestashopDAOTest("testPost"));
        return suite;
    }
    /**
     * Test of post method, of class CategoryPrestashopDAO.
     */
    @Test
    public void testPost() {     
        try{
            System.out.println("post");
            String path = "";
            Category t = new Category();
            CategoryPrestashopDAO instance = new CategoryPrestashopDAO();
            instance.post(path, t);
        }catch(Exception e){
            fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of postCategory method, of class CategoryPrestashopDAO.
     */
    @Test
    public void testPostCategory() {
        System.out.println("postCategory");
        String path = "";
        Category t = null;
        CategoryPrestashopDAO instance = new CategoryPrestashopDAO();
        int expResult = 0;
        int result = instance.postCategory(path, t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of put method, of class CategoryPrestashopDAO.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        String path = "";
        Category t = null;
        int key = 0;
        CategoryPrestashopDAO instance = new CategoryPrestashopDAO();
        instance.put(path, t, key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class CategoryPrestashopDAO.
     */
    @Test
    public void testGet() {
        try {
            System.out.println("get");
            CategoryPrestashopDAO instance = new CategoryPrestashopDAO();
            List result = instance.get("categories/");
            assertNotNull(result);
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }

    }

    /**
     * Test of getId method, of class CategoryPrestashopDAO.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        String path = "";
        int key = 0;
        CategoryPrestashopDAO instance = new CategoryPrestashopDAO();
        Category expResult = null;
        Category result = instance.getId(path, key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWebResource method, of class CategoryPrestashopDAO.
     */
    @Test
    public void testGetWebResource() {
        System.out.println("getWebResource");
        CategoryPrestashopDAO instance = new CategoryPrestashopDAO();
        WebResource expResult = null;
        WebResource result = instance.getWebResource();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTOXML method, of class CategoryPrestashopDAO.
     */
    @Test
    public void testCreateTOXML() {
        System.out.println("createTOXML");
        Prestashop prestashopCategory = new Prestashop();
        
        CategoryPrestashopDAO instance = new CategoryPrestashopDAO();
        String expResult = "";
        String result = instance.createTOXML(prestashopCategory);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}