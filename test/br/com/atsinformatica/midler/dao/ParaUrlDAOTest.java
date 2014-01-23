/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.dao;

import br.com.atsinformatica.erp.dao.ParaUrlDAO;
import br.com.atsinformatica.erp.entity.ParaUrlWsdlBean;
import java.util.ArrayList;
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
public class ParaUrlDAOTest extends TestCase {
    
    public ParaUrlDAOTest(String testName) {        
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
    
    
     /**
     * Suite que seta a ordem de execução dos testes
     * @return suite
     */
    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTest(new ParaUrlDAOTest("testUltimoRegistro"));
        suite.addTest(new ParaUrlDAOTest("testGravar"));
        suite.addTest(new ParaUrlDAOTest("testAlterar"));
        suite.addTest(new ParaUrlDAOTest("testListaTodos"));
        suite.addTest(new ParaUrlDAOTest("testAbrir"));       
        suite.addTest(new ParaUrlDAOTest("testDeletar"));      
        return  suite;
    }

    /**
     * Test of gravar method, of class ParaUrlDAO.
     */
    @Test
    public void testGravar() throws Exception {
        try{
            System.out.println("gravar");
            ParaUrlWsdlBean object = new ParaUrlWsdlBean();
            ParaUrlDAO instance = new ParaUrlDAO();
            object.setUrlWSDL("localhost/lojaprestashop/api");
            instance.gravar(object);
        // TODO review the generated test code and remove the default call to fail.        
        }catch(Exception e){
           fail("Falha ao testar metodo gravar");  
        }
        
    }

    /**
     * Test of alterar method, of class ParaUrlDAO.
     */
    @Test
    public void testAlterar() throws Exception {
        try{
            System.out.println("alterar");
            ParaUrlWsdlBean object = new ParaUrlWsdlBean();
            ParaUrlDAO instance = new ParaUrlDAO();
            object.setCodParaUrlWsdl("000000");
            object.setUrlWSDL("www.moveisuniversal@api");
            instance.alterar(object);           
        }catch(Exception e){
            fail("Falha ao testar método alterar.");
            
        }
       
    }  

    /**
     * Test of abrir method, of class ParaUrlDAO.
     */
    @Test
    public void testAbrir() throws Exception {
        try{
            System.out.println("abrir");
            String id = "000000";
            ParaUrlDAO instance = new ParaUrlDAO();
            ParaUrlWsdlBean result = instance.abrir(id);
            assertNotNull(result);     
        }catch(Exception e){
            fail("Falha ao testar metodo abrir."); 
        }
       
    }

    /**
     * Test of listaTodos method, of class ParaUrlDAO.
     */
    @Test
    public void testListaTodos() throws Exception {
        try{
            System.out.println("listaTodos");
            ParaUrlDAO instance = new ParaUrlDAO();
            List<ParaUrlWsdlBean> result = new ArrayList<>();
            result.addAll(instance.listaTodos());
            assertNotNull(result);  
        }catch(Exception e){
            fail("Falha ao testar método listaTodos.");
        }        
    }

    /**
     * Test of ultimoRegistro method, of class ParaUrlDAO.
     */
    @Test
    public void testUltimoRegistro() throws Exception {
        try{
            System.out.println("ultimoRegistro");
            ParaUrlDAO instance = new ParaUrlDAO();
            String result = instance.ultimoRegistro();
            assertNotNull(result); 
        }catch(Exception e){
            fail("Falha ao retornar último registro.");
        }
        
    }
    
     /**
     * Test of deletar method, of class ParaUrlDAO.
     */
    @Test
    public void testDeletar() throws Exception {
        try{
            System.out.println("deletar");
            String id = "000000";
            ParaUrlDAO instance = new ParaUrlDAO();
            instance.deletar(id); 
        }catch(Exception e){
            fail("Falha ao testar método deletar.");
        }
        
    }
    
}