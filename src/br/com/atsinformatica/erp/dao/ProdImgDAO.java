/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.ProdImgBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author AlexsanderPimenta
 */
public class ProdImgDAO implements IGenericDAO<ProdImgBean> {
    private Logger logger = Logger.getLogger(ProdImgDAO.class);
    private Connection conn;

    @Override
    public void gravar(ProdImgBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(ProdImgBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProdImgBean abrir(String id) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = ConexaoATS.conectaERP();
            String querie = "select * from prodimg where prodimg.codprod = ?";
            pstmt = conn.prepareStatement(querie);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            ProdImgBean bean = null;
            while(rs.next()){
                bean = new ProdImgBean();
                bean.setCodProd(rs.getString("codprod"));
                bean.setFoto(rs.getBytes("foto"));                
            }
            logger.info("Imagens do produto retornadas com sucesso!");
            return bean;
        }catch(Exception e){
            logger.error("Erro ao retornar imagens do produto: "+e);            
            return null;
        }finally{
            rs.close();
            pstmt.close();
            conn.close();
        }   
    }

    @Override
    public List<ProdImgBean> listaTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
