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
public class TriggerCategoria implements ITrigger {
   private Logger logger = Logger.getLogger(TriggerProduto.class);
   private Connection conn;
     
    /**
     * Cria trigger AFTER UPDATE
     */
   @Override
   public void createTriggerAu() throws SQLException{
        PreparedStatement pstmt = null;
        try{
            if(ConexaoATS.getConnection().isClosed())ConexaoATS.conectaERP();
            conn = ConexaoATS.getConnection();
            String trigger = "CREATE OR ALTER trigger categoria_ecomm_au for categoriasecom " +
                             "active after update position 0 " +
                             "AS " +
                             "begin " +
                             "    INSERT INTO HISTINTEGECOM (ENTIDADE, CODENTIDADE, DATAENT, DATAINT, TIPOOPER) " +
                             "    VALUES ('categoria', NEW.codcategoria, current_timestamp, NULL, 'update'); " +
                             "end ";
            pstmt = conn.prepareStatement(trigger);
            pstmt.executeUpdate();
            logger.info("Trigger AFTER UPDATE de categoria, criada com sucesso. ");
        }catch(Exception e){
            logger.error("Erro ao criar trigger AFTER UPDATE de categoria: "+e);            
        }finally{
            pstmt.close();
            conn.close();            
        }
        
    }
    
    /**
     * Cria trigger AFTER UPDATE
     */
   @Override
    public void createTriggerAi() throws SQLException{
        PreparedStatement pstmt = null;
        try{
            if(ConexaoATS.getConnection().isClosed())ConexaoATS.conectaERP();
            conn = ConexaoATS.getConnection();
            String trigger = "CREATE trigger categoria_ecomm_ai for categoriasecom " +
                             "active after insert position 0 " +
                             "AS " +
                             "begin " +
                             "   INSERT INTO HISTINTEGECOM (ENTIDADE, CODENTIDADE, DATAENT, DATAINT, TIPOOPER) " +
                             "   VALUES ('categoria', NEW.codcategoria, current_timestamp, NULL, 'insert'); " +
                             "end ";
            pstmt = conn.prepareStatement(trigger);
            pstmt.executeUpdate();
            logger.info("Trigger AFTER INSERT de categoria, criada com sucesso. ");
        }catch(Exception e){
            logger.error("Erro ao criar trigger AFTER INSERT de categoria: "+e);            
        }finally{
            pstmt.close();
            conn.close();            
        }
        
    }
        
    /**
     * Cria trigger AFTER DELETE
     */
   @Override
    public void createTriggerAd() throws SQLException{
        PreparedStatement pstmt = null;
        try{
            if(ConexaoATS.getConnection().isClosed())ConexaoATS.conectaERP();
            conn = ConexaoATS.getConnection();
            String trigger = "CREATE trigger categoria_ecomm_ad for categoriasecom " +
                             "active after delete position 0 " +
                             "AS " +
                             "begin " +
                             "   INSERT INTO HISTINTEGECOM (ENTIDADE, CODENTIDADE, DATAENT, DATAINT, TIPOOPER) " +
                             "   VALUES ('categoria', Old.codcategoria, current_timestamp, NULL, 'delete'); " +
                             "end";
            pstmt = conn.prepareStatement(trigger);
            pstmt.executeUpdate();
            logger.info("Trigger AFTER DELETE de categoria, criada com sucesso. ");
        }catch(Exception e){
            logger.error("Erro ao criar trigger AFTER DELETE de categoria: "+e);            
        }finally{
            pstmt.close();
            conn.close();            
        }
        
    } 
}
