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
public class TriggerProduto implements ITrigger {
    private Logger logger = Logger.getLogger(TriggerProduto.class);
    private Connection conn;
      
    /**
     * Cria trigger AFTER UPDATE
     */
    @Override
    public void createTriggerAu() throws SQLException{
        PreparedStatement pstmt = null;
        try{
            if(ConexaoATS.getConnection().isClosed())
                ConexaoATS.conectaERP();
            conn = ConexaoATS.getConnection();
            String trigger = "CREATE OR ALTER trigger produto_ecomm_au for produto                                          " +
                             "active after update position 0                                                                " +
                             "AS                                                                                            " +
                             "begin                                                                                         " +
                             "  if(Old.importaprodecom = 1 and Old.idprodutoecom is not null)then begin                     " +
                             "    INSERT INTO HISTINTEGECOM (ENTIDADE, CODENTIDADE, DATAENT, DATAINT, TIPOOPER)             " +
                             "    VALUES ('produto', NEW.codprod, current_timestamp, NULL, 'update');                       " +
                             "  end                                                                                         " +
                             "end                                                                                           ";
            pstmt = conn.prepareStatement(trigger);
            pstmt.executeUpdate();
            logger.info("Trigger AFTER UPDATE do produto, criada com sucesso. ");
        }catch(Exception e){
            logger.error("Erro ao criar trigger AFTER UPDATE do produto: "+e);            
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
            if(ConexaoATS.getConnection().isClosed())
                ConexaoATS.conectaERP();
            conn = ConexaoATS.getConnection();
            String trigger = "CREATE trigger produto_ecomm_ai for produto                                           " +
                             "active after insert position 0                                                        " +
                             "AS                                                                                    " +
                             "begin                                                                                 " +
                             "if(New.importaprodecom = 1)then                                                       " +
                             "   begin                                                                              " +
                             "      INSERT INTO HISTINTEGECOM (ENTIDADE, CODENTIDADE, DATAENT, DATAINT, TIPOOPER)   " +
                             "      VALUES ('produto', NEW.codprod, current_timestamp, NULL, 'insert');             " +
                             "   end                                                                                " +
                             "end                                                                                   ";
            pstmt = conn.prepareStatement(trigger);
            pstmt.executeUpdate();
            logger.info("Trigger AFTER INSERT do produto, criada com sucesso. ");
        }catch(Exception e){
            logger.error("Erro ao criar trigger AFTER INSERT do produto: "+e);            
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
            if(ConexaoATS.getConnection().isClosed())
                ConexaoATS.conectaERP();
            conn = ConexaoATS.getConnection();
            String trigger = "CREATE trigger produto_ecomm_ad for produto                                           " +
                             "active after delete position 0                                                        " +
                             "AS                                                                                    " +
                             "begin                                                                                 " +
                             "  if(Old.importaprodecom = 1)then                                                     " +
                             "     begin                                                                            " +
                             "       INSERT INTO HISTINTEGECOM (ENTIDADE, CODENTIDADE, DATAENT, DATAINT, TIPOOPER)  " +
                             "       VALUES ('produto', Old.idprodutoecom, current_timestamp, NULL, 'delete');      " +
                             "     end                                                                              " +
                             "end                                                                                   ";
            pstmt = conn.prepareStatement(trigger);
            pstmt.executeUpdate();
            logger.info("Trigger AFTER DELETE do produto, criada com sucesso. ");
        }catch(Exception e){
            logger.error("Erro ao criar trigger AFTER DELETE do produto: "+e);            
        }finally{
            pstmt.close();
            conn.close();            
        }
        
    }
  
}
