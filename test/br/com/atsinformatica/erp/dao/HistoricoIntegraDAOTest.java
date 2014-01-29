/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.HistoricoIntegraERPBean;
import java.util.Date;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
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
public class HistoricoIntegraDAOTest extends TestCase {
    
    public HistoricoIntegraDAOTest(String testName){
        super(testName);
    }
    
    public HistoricoIntegraDAOTest() {
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
        suite.addTest(new HistoricoIntegraDAOTest("testListaUltimosInteg"));
      //  suite.addTest(new HistoricoIntegraDAOTest("testAlterar"));
        
        return suite;
    }
    
    

    /**
     * Test of gravar method, of class HistoricoIntegraDAO.
     */
    @Test
    public void testGravar() throws Exception {
        System.out.println("gravar");
        HistoricoIntegraERPBean object = null;
        HistoricoIntegraDAO instance = new HistoricoIntegraDAO();
        instance.gravar(object);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class HistoricoIntegraDAO.
     */
    @Test
    public void testAlterar() throws Exception {        
        try{
            System.out.println("alterar");
            HistoricoIntegraERPBean object = new HistoricoIntegraERPBean();
            HistoricoIntegraDAO instance = new HistoricoIntegraDAO();
            object.setCodEntidade("000003");
            object.setDataInteg(new Date());
            instance.alterar(object); 
        }catch(Exception e){
            fail("Falha ao testar metodo alterar: "+e);
            
        }       
    }

    /**
     * Test of deletar method, of class HistoricoIntegraDAO.
     */
    @Test
    public void testDeletar() throws Exception {
        System.out.println("deletar");
        String id = "";
        HistoricoIntegraDAO instance = new HistoricoIntegraDAO();
        instance.deletar(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of abrir method, of class HistoricoIntegraDAO.
     */
    @Test
    public void testAbrir() throws Exception {
        System.out.println("abrir");
        String id = "";
        HistoricoIntegraDAO instance = new HistoricoIntegraDAO();
        HistoricoIntegraERPBean expResult = null;
        HistoricoIntegraERPBean result = instance.abrir(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listaTodos method, of class HistoricoIntegraDAO.
     */
    @Test
    public void testListaTodos() throws Exception {
        try{
            System.out.println("listaTodos");
            HistoricoIntegraDAO instance = new HistoricoIntegraDAO();
            List result = instance.listaTodos();
            assertNotNull(result); 
        }catch(Exception e){              
            fail("Falha ao testar metodo listaTodos: "+e);
        }
    }

    /**
     * Test of ultimoRegistro method, of class HistoricoIntegraDAO.
     */
    @Test
    public void testUltimoRegistro() throws Exception {
        System.out.println("ultimoRegistro");
        HistoricoIntegraDAO instance = new HistoricoIntegraDAO();
        String expResult = "";
        String result = instance.ultimoRegistro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testListaUltimosInteg(){
        try{
           System.out.println("listaUltimosInteg");
           HistoricoIntegraDAO instance = new HistoricoIntegraDAO();
           assertNotNull(instance.listaUltimosInteg());           
        }catch(Exception e){
           fail("Falha ao testar metodo listaUltimosInteg: "+e);
            
        }
    }
}