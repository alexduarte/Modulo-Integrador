/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.LogErroEcomBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;


/**
 *
 * @author AlexsanderPimenta
 */
public class LogErroEcomDAO implements IGenericDAO<LogErroEcomBean>{
    private Connection conn;

    @Override
    public void gravar(LogErroEcomBean object) throws SQLException {
        PreparedStatement pstmt = null;
        try{
            conn = ConexaoATS.conectaERP();
            String querie = "INSERT INTO LOGERROECOM (ID, ID_INTEG, DESCRICAOERRO, DATA_ERRO) VALUES (?,?,?);";
            pstmt = conn.prepareStatement(querie);
            pstmt.setInt(1, object.getId());
            pstmt.setInt(2, object.getIdInteg());
            pstmt.setString(3, object.getDescricaoErro());
            pstmt.setDate(4, new Date(object.getDataErro().getTime()));
            pstmt.executeUpdate();
            //Logger.getLogger(LogErroEcomDAO.class).info("Log de erro salvo com sucesso.");
        }catch(Exception e){
           // Logger.getLogger(LogErroEcomDAO.class).info("Erro ao salvar log de erro: "+e);
        }finally{
            conn.close();
            pstmt.close();
        }
    }

    @Override
    public void alterar(LogErroEcomBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LogErroEcomBean abrir(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Lista log de erros da integração
     * @param idInteg id de integração
     * @return List<LogErroEcomBean> lista com log de erros
     * @throws SQLException 
     */
    public List<LogErroEcomBean> listaErroPorIDInteg(int idInteg) throws SQLException{
        List<LogErroEcomBean> listaErro = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = ConexaoATS.conectaERP();
            String sql = "SELECT * FROM LOGERROECOM WHERE ID_INTEG = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idInteg);
            rs = pstmt.executeQuery();
            LogErroEcomBean logErroEcom = null;
            while(rs.next()){
                logErroEcom = new LogErroEcomBean();
                logErroEcom.setId(rs.getInt("id"));
                logErroEcom.setIdInteg(rs.getInt("id_integ"));
                logErroEcom.setDescricaoErro(rs.getString("descricaoerro"));
                logErroEcom.setDataErro(rs.getDate("data_erro"));
                listaErro.add(logErroEcom);                
            }
            Logger.getLogger(LogErroEcomDAO.class).info("Log de erros retornado com sucesso.");
            return listaErro;
        }catch(Exception e){
            Logger.getLogger(LogErroEcomDAO.class).error("Erro ao retornar log de erros: "+e);
            return null;            
        }finally{
            conn.close();
            pstmt.close();
        }
    }

    @Override
    public List<LogErroEcomBean> listaTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
