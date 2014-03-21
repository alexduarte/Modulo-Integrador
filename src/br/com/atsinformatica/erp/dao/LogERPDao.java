/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.LogERPBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author kennedimalheiros
 */
public class LogERPDao implements IGenericDAO<LogERPBean> {

    private static Logger logger = Logger.getLogger(UsuarioERPDAO.class);
    private Connection conn;

    @Override
    public void gravar(LogERPBean object) throws SQLException {
        PreparedStatement pstmt = null;
        

        try {
            conn = ConexaoATS.conectaERP();
            String sql = " INSERT INTO MOVLOG (NOMETAB, CHAVE, ACAO, USUARIO, "
                    + "                     DATA, HORA, SISTEMA, OBSERVACAO) "
                    + "VALUES (?,?,?,?,?,?,?,?);";
//                          "VALUES ('CDOPERC', '013', 'Alteração', 'ADMIN', '23-JUL-2012 16:29:18', '16:29:18', 'FAT', '');";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, object.getNomeTabela());
            pstmt.setString(2, object.getChaveRegistro());
            pstmt.setString(3, object.getAcao());
            pstmt.setString(4, object.getUsuario());
            pstmt.setDate(5, new Date(object.getData().getTime()));
            pstmt.setString(6, object.getHora());
            pstmt.setString(7, object.getSistema());
            pstmt.setString(8, object.getObservacao());

            pstmt.execute();

        } catch (SQLException e) {
            logger.error("Erro ao gravar log: " + e);
            System.out.println("" + e);

        } finally {
            pstmt.close();
           
            conn.close();

        }
    }

    @Override
    public void alterar(LogERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LogERPBean abrir(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LogERPBean> listaTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
