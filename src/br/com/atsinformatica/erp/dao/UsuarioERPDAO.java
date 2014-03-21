/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.UsuarioERPBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author kennedimalheiros
 */
public class UsuarioERPDAO implements IGenericDAO<UsuarioERPBean> {

    private static Logger logger = Logger.getLogger(UsuarioERPDAO.class);
    private Connection conn;

    @Override
    public void gravar(UsuarioERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(UsuarioERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioERPBean abrir(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioERPBean> listaTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean validarUsuario(UsuarioERPBean usuarioERPBean) throws SQLException {

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoATS.conectaERP();
            String sql = " SELECT U.USUARIO, U.SENHA FROM CADUSUA U "
                    + "   WHERE U.USUARIO = ? "
                    + "     AND U.SENHA = ? ";
            pstmt = conn.prepareStatement(sql);

             pstmt.setString(1, usuarioERPBean.getUsuario() );
             pstmt.setString(2, usuarioERPBean.getSenha());
            
             
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            logger.error("Erro na validação de login do usuario: " + e);
            return false;
        } finally {
            pstmt.close();
            rs.close();
            conn.close();

        }

    }

}
