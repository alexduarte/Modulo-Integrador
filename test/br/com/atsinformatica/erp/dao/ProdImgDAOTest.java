/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.ProdImgBean;
import java.util.List;
import javax.swing.ImageIcon;
import static junit.framework.Assert.assertEquals;
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
public class ProdImgDAOTest extends TestCase {
    
    public ProdImgDAOTest(String testName) {
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
    
    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTest(new ProdImgDAOTest("testAbrir"));
        return suite;
    }

    /**
     * Test of gravar method, of class ProdImgDAO.
     */
    @Test
    public void testGravar() throws Exception {
        System.out.println("gravar");
        ProdImgBean object = null;
        ProdImgDAO instance = new ProdImgDAO();
        instance.gravar(object);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class ProdImgDAO.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        ProdImgBean object = null;
        ProdImgDAO instance = new ProdImgDAO();
        instance.alterar(object);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class ProdImgDAO.
     */
    @Test
    public void testDeletar() throws Exception {
        System.out.println("deletar");
        String id = "";
        ProdImgDAO instance = new ProdImgDAO();
        instance.deletar(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of abrir method, of class ProdImgDAO.
     */
    @Test
    public void testAbrir() throws Exception {
        try{
            System.out.println("abrir");
            String id = "000927";
            ProdImgDAO instance = new ProdImgDAO();
            ProdImgBean result = instance.abrir(id);
            ImageIcon img = new ImageIcon(result.getFoto());
            assertNotNull(result);
        }catch(Exception e){
            fail("Falha ao testar metodo abrir: "+e);
        }      
    }

    /**
     * Test of listaTodos method, of class ProdImgDAO.
     */
    @Test
    public void testListaTodos() throws Exception {
        System.out.println("listaTodos");
        ProdImgDAO instance = new ProdImgDAO();
        List expResult = null;
        List result = instance.listaTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ultimoRegistro method, of class ProdImgDAO.
     */
    @Test
    public void testUltimoRegistro() throws Exception {
        System.out.println("ultimoRegistro");
        ProdImgDAO instance = new ProdImgDAO();
        String expResult = "";
        String result = instance.ultimoRegistro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}