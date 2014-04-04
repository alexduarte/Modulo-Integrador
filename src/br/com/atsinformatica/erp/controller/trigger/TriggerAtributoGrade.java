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
public class TriggerAtributoGrade implements ITrigger {
    
    private Connection conn;

     /**
     * Cria trigger AFTER UPDATE
     */
   @Override
   public void createTriggerAi() throws SQLException{
        PreparedStatement pstmt = null;
        try{
            if(ConexaoATS.getConnection().isClosed())ConexaoATS.conectaERP();
            conn = ConexaoATS.getConnection();
            String trigger = "CREATE trigger atributogradeecom_ai for atributogradeecom                           " +
                             "active after insert position 0                                                      " +
                             "AS                                                                                  " +
                             "begin                                                                               " +
                             "  INSERT INTO HISTINTEGECOM (ENTIDADE, CODENTIDADE, DATAENT, DATAINT, TIPOOPER)     " +
                             "  VALUES ('atributograde', NEW.codatributo, current_timestamp, NULL, 'insert');     " +
                             "end                                                                                 ";
            pstmt = conn.prepareStatement(trigger);
            pstmt.executeUpdate();
            Logger.getLogger(TriggerAtributoGrade.class).info("Trigger AFTER INSERT de atributo grade, criada com sucesso. ");
        }catch(Exception e){
            Logger.getLogger(TriggerAtributoGrade.class).error("Erro ao criar trigger AFTER INSERT de atributo grade: "+e);            
        }finally{
            pstmt.close();
            conn.close();            
        }
        
    }
    
    /**
     * Cria trigger AFTER UPDATE
     */
   @Override
    public void createTriggerAu() throws SQLException{
        PreparedStatement pstmt = null;
        try{
            if(ConexaoATS.getConnection().isClosed())ConexaoATS.conectaERP();
            conn = ConexaoATS.getConnection();
            String trigger = "CREATE trigger atributogradeecom_au for atributogradeecom                         " +
                             "active before update position 0                                                   " +
                             "AS                                                                                " +
                             "begin                                                                             " +
                             "  if (Old.idatributoecom is not null) then                                        " +
                             "    INSERT INTO HISTINTEGECOM (ENTIDADE, CODENTIDADE, DATAENT, DATAINT, TIPOOPER) " +
                             "    VALUES ('atributograde', NEW.codatributo, current_timestamp, NULL, 'update'); " +
                             "end                                                                               ";
            pstmt = conn.prepareStatement(trigger);
            pstmt.executeUpdate();
            Logger.getLogger(TriggerAtributoGrade.class).info("Trigger AFTER UPDATE de atributo grade, criada com sucesso. ");
        }catch(Exception e){
            Logger.getLogger(TriggerAtributoGrade.class).error("Erro ao criar trigger AFTER UPDATE de atributo grade: "+e);            
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
            String trigger = "CREATE trigger atributogradeecom_ad for atributogradeecom                             " +
                             "active after delete position 0                                                        " +
                             "AS                                                                                    " +
                             "begin                                                                                 " +
                             "  INSERT INTO HISTINTEGECOM (ENTIDADE, CODENTIDADE, DATAENT, DATAINT, TIPOOPER)       " +
                             "  VALUES ('atributograde', Old.idatributoecom, current_timestamp, NULL, 'delete');    " +
                             "end                                                                                   ";
            pstmt = conn.prepareStatement(trigger);
            pstmt.executeUpdate();
            Logger.getLogger(TriggerAtributoGrade.class).info("Trigger AFTER DELETE de atributo grade, criada com sucesso. ");
        }catch(Exception e){
            Logger.getLogger(TriggerAtributoGrade.class).error("Erro ao criar trigger AFTER DELETE de atributo grade: "+e);            
        }finally{
            pstmt.close();
            conn.close();            
        }
        
    } 
    
}
