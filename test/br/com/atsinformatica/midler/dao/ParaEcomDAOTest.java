/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.dao;


import br.com.atsinformatica.erp.dao.ParaEcomDAO;
import br.com.atsinformatica.erp.entity.ParaEcomBean;
import java.util.List;
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
public class ParaEcomDAOTest extends TestSuite{
    
    public ParaEcomDAOTest(String testCase) {
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
     * Test of gravar method, of class ParaEcomDAO.
     */
    @Test
    public void testGravar() throws Exception {
        try{
            System.out.println("gravar");
            ParaEcomBean object = new ParaEcomBean();
            ParaEcomDAO instance = new ParaEcomDAO();
            object.setMinutoscadastrados(10);
            object.setMinutosmov(10);
            object.setQtdMantido(50);
            object.setQtdeRegistros(50);
            object.setAtivaSincronizacao(1);
            instance.gravar(object);
        }catch(Exception e){
            fail("Falhar ao testar metodo gravar: "+e); 
        }
        
    }

    /**
     * Test of alterar method, of class ParaEcomDAO.
     */
    @Test
    public void testAlterar() throws Exception {
        try{
            System.out.println("alterar");
            ParaEcomBean object = new ParaEcomBean();
            ParaEcomDAO instance = new ParaEcomDAO();
            object.setCodparaecom("000000");
            object.setMinutoscadastrados(10);
            object.setMinutosmov(10);
            object.setQtdMantido(50);
            object.setQtdeRegistros(50);
            object.setAtivaSincronizacao(1);
            instance.alterar(object); 
        }catch(Exception e){
            fail("Falha ao testar metodo alterar: "+e);
        }
        
    }

    /**
     * Test of deletar method, of class ParaEcomDAO.
     */
    @Test
    public void testDeletar() throws Exception {
        try{
            System.out.println("deletar");
            String id = "000000";
            ParaEcomDAO instance = new ParaEcomDAO();
            instance.deletar(id);
        }catch(Exception e){
            fail("Falha ao testar metodo deletar: "+e); 
        }
        
        
    }

    /**
     * Test of abrir method, of class ParaEcomDAO.
     */
    @Test
    public void testAbrir() throws Exception {
        try{
            System.out.println("abrir");
            String id = "000000";
            ParaEcomDAO instance = new ParaEcomDAO();
            ParaEcomBean result = instance.abrir(id);
            assertNotNull(result); 
        }catch(Exception e){
            fail("Falha ao testar metodo abrir.");   
        }        
    }

    /**
     * Test of listaTodos method, of class ParaEcomDAO.
     */
    @Test
    public void testListaTodos() throws Exception {
        try{
            System.out.println("listaTodos");
            ParaEcomDAO instance = new ParaEcomDAO();
            List<ParaEcomBean> result = instance.listaTodos();
            assertNotNull(result);
        }catch(Exception e){
            fail("Falha ao testar metodo listaTodos: "+e);            
        }      
    }

    /**
     * Test of ultimoRegistro method, of class ParaEcomDAO.
     */
    @Test
    public void testUltimoRegistro() throws Exception {
        try{
            System.out.println("ultimoRegistro");
            ParaEcomDAO instance = new ParaEcomDAO();
            String result = instance.ultimoRegistro();
            assertNotNull(result); 
        }catch(Exception e){
            fail("Erro ao testar metodo ultimoRegistro: "+e);
        }     
    }
}