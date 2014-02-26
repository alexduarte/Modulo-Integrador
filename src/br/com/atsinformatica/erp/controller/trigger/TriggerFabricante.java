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
public class TriggerFabricante implements ITrigger {
    private Logger logger = Logger.getLogger(TriggerProduto.class);
    private Connection conn;
    
    
    @Override
    public void createTriggerAu() throws SQLException {
       PreparedStatement pstmt = null;
        try{
            if(ConexaoATS.getConnection().isClosed())ConexaoATS.conectaERP();
            conn = ConexaoATS.getConnection();
            String trigger = "CREATE trigger fabricante_ecomm_au for cadfabr " +
                             "active after update position 0 " +
                             "AS " +
                             "begin " +
                             "    INSERT INTO HISTINTEGECOM (ENTIDADE, CODENTIDADE, DATAENT, DATAINT, TIPOOPER) " +
                             "    VALUES ('fabricante', New.codfabric, current_timestamp, NULL, 'update'); " +
                             "end ";
            pstmt = conn.prepareStatement(trigger);
            pstmt.executeUpdate();
            logger.info("Trigger AFTER UPDATE de fabricante, criada com sucesso. ");
        }catch(Exception e){
            logger.error("Erro ao criar trigger AFTER UPDATE de fabricante: "+e);            
        }finally{
            pstmt.close();
            conn.close();            
        }
    }

    @Override
    public void createTriggerAi() throws SQLException {
        PreparedStatement pstmt = null;
        try{
            if(ConexaoATS.getConnection().isClosed())ConexaoATS.conectaERP();
            conn = ConexaoATS.getConnection();
            String trigger = "CREATE trigger fabricante_ecomm_ai for cadfabr " +
                             "active after insert position 0 " +
                             "AS " +
                             "begin " +
                             "    INSERT INTO HISTINTEGECOM (ENTIDADE, CODENTIDADE, DATAENT, DATAINT, TIPOOPER) " +
                             "    VALUES ('fabricante', New.codfabric, current_timestamp, NULL, 'update'); " +
                             "end";
            pstmt = conn.prepareStatement(trigger);
            pstmt.executeUpdate();
            logger.info("Trigger AFTER INSERT de fabricante, criada com sucesso. ");
        }catch(Exception e){
            logger.error("Erro ao criar trigger AFTER INSER de fabricante: "+e);            
        }finally{
            pstmt.close();
            conn.close();            
        }
    }

    @Override
    public void createTriggerAd() throws SQLException {
         PreparedStatement pstmt = null;
        try{
            if(ConexaoATS.getConnection().isClosed())ConexaoATS.conectaERP();
            conn = ConexaoATS.getConnection();
            String trigger = "CREATE trigger fabricante_ecomm_ad for cadfabr " +
                             "active after delete position 0 " +
                             "AS " +
                             "begin " +
                             "    INSERT INTO HISTINTEGECOM (ENTIDADE, CODENTIDADE, DATAENT, DATAINT, TIPOOPER) " +
                             "    VALUES ('fabricante', Old.codfabric, current_timestamp, NULL, 'update'); " +
                             "end";
            pstmt = conn.prepareStatement(trigger);
            pstmt.executeUpdate();
            logger.info("Trigger AFTER DELETE de fabricante, criada com sucesso. ");
        }catch(Exception e){
            logger.error("Erro ao criar trigger AFTER DELETE de fabricante: "+e);            
        }finally{
            pstmt.close();
            conn.close();            
        }
    }
    
}
