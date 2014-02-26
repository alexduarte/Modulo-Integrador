/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller.trigger;

import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 *
 * @author AlexsanderPimenta
 */
public class TriggerCompProd implements ITrigger {
     private Logger logger = Logger.getLogger(TriggerProduto.class);
     private Connection conn;
     
  
    @Override
    public void createTriggerAu() throws SQLException {
       PreparedStatement pstmt = null;
        try{
            if(ConexaoATS.getConnection().isClosed())ConexaoATS.conectaERP();
            conn = ConexaoATS.getConnection();
            String trigger = "CREATE OR ALTER trigger compprod_ecomm_au for compprod " +
                             "active after update position 0 " +
                             "AS " +
                             "declare variable integra integer; " +
                             "begin " +
                             "select produto.importaprodecom from produto where produto.codprod = New.codprod " +
                             "into integra; " +
                             "if(integra = 1) then " +
                             "    INSERT INTO HISTINTEGECOM (ENTIDADE, CODENTIDADE, DATAENT, DATAINT, TIPOOPER) " +
                             "    VALUES ('compprod', New.codprod, current_timestamp, NULL, 'update'); " +
                             "end";
            pstmt = conn.prepareStatement(trigger);
            pstmt.executeUpdate();
            logger.info("Trigger AFTER UPDATE de movimentações, criada com sucesso. ");
        }catch(Exception e){
            logger.error("Erro ao criar trigger AFTER UPDATE de movimentações: "+e);            
        }finally{
            pstmt.close();
            conn.close();            
        }
    }

    @Override
    public void createTriggerAi() throws SQLException {
        
    }

    @Override
    public void createTriggerAd() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
