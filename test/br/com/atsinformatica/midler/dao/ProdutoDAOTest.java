/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.dao;

import br.com.atsinformatica.erp.entity.ProdutoERPBean;
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
public class ProdutoDAOTest extends TestCase {
    
    public ProdutoDAOTest(String testName) {
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
        suite.addTest(new ProdutoDAOTest("testAbrir"));
        return suite;
    } 
    /**
     * Test of listaASincronizar method, of class ProdutoDAO.
     */
    @Test
    public void testListaTodos() {
        try{
            System.out.println("listaASincronizar");
            ProdutoDAO instance = new ProdutoDAO();
            List<ProdutoERPBean> result = instance.listaTodos();
            for(ProdutoERPBean prod: result){
                System.out.println("Produto: "+prod + "\n");               
            }          
            assertNotNull(result); 
        }catch(Exception e){
            fail("Falha ao testar método listaASincronizar.");
            
        }
        
    }
    @Test
    public void testAtualizaStatusImportacao(){
       try{
           System.out.println("atualizaStatusImportacao");
           ProdutoDAO instance = new ProdutoDAO();
           instance.atualizaStatusImportacao("000002", 0);
       } catch(Exception e){
           fail("Falha ao testar metodo atualizaStatusImportacao: "+e);
           
       }
        
    }
    
    @Test
    public void testAbrir(){
        try{
            System.out.println("abrir");
            ProdutoDAO instance = new ProdutoDAO();
            ProdutoERPBean bean = instance.abrir("000002");
            assertNotNull(bean);
        }catch(Exception e){
            fail("Falha ao testar metodo abrir: "+e);
            
        }
    }
}