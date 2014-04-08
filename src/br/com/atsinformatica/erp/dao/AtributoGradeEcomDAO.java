/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.AtributoGradeEcom;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author AlexsanderPimenta
 */
public class AtributoGradeEcomDAO implements IGenericDAO<AtributoGradeEcom> {

    private Connection conn;

    @Override
    public void gravar(AtributoGradeEcom object) throws SQLException {
    }

    @Override
    public void alterar(AtributoGradeEcom object) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn = ConexaoATS.conectaERP();
            String querie = "UPDATE ATRIBUTOGRADEECOM               "
                    + "SET DESCRICAO = ?,                           "
                    + "    IDATRIBUTOECOM = ?                       "
                    + "WHERE CODATRIBUTO = ?;                       ";
            pstmt = conn.prepareStatement(querie);
            pstmt.setString(1, object.getDescricao());
            pstmt.setInt(2, object.getIdAtributoEcom());
            pstmt.setString(3, object.getCodAtributo());
            pstmt.executeUpdate();
            Logger.getLogger(AtributoGradeEcomDAO.class).info("Atributo grade alterado com sucesso.");
        } catch (Exception e) {
            Logger.getLogger(AtributoGradeEcomDAO.class).error("Erro ao alterar atributo da grade: " + e);
        }
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Retorna atributo da grade através do codigo do atributo
     *
     * @param cod01
     * @return AtributoGradeEcom
     */
    @Override
    public AtributoGradeEcom abrir(String cod) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //if (conn == null) {
            conn = ConexaoATS.conectaERP();
            //}
            String sql = "SELECT * FROM ATRIBUTOGRADEECOM   "
                    + "WHERE CODATRIBUTO =?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cod);
            rs = pstmt.executeQuery();
            AtributoGradeEcom atributoGrade = null;
            while (rs.next()) {
                atributoGrade = new AtributoGradeEcom();
                atributoGrade.setCodAtributo(rs.getString("codatributo"));
                atributoGrade.setDescricao(rs.getString("descricao"));
                atributoGrade.setIdAtributoEcom(rs.getInt("idatributoecom"));
            }
            Logger.getLogger(AtributoGradeEcomDAO.class).info("Atributo grade retornado com sucesso.");
            return atributoGrade;
        } catch (Exception e) {
            Logger.getLogger(AtributoGradeEcomDAO.class).error("Erro ao retornar atributo grade: " + e);
            return null;
        } finally {
            conn.close();
            rs.close();
            pstmt.close();
        }
    }

    @Override
    public List<AtributoGradeEcom> listaTodos() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        List<AtributoGradeEcom> listaAtributoGrade = new ArrayList<>();
        try {
            conn = ConexaoATS.conectaERP();
            String sql = "SELECT * FROM ATRIBUTOGRADEECOM";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            AtributoGradeEcom atributoGrade = null;
            while (rs.next()) {
                atributoGrade = new AtributoGradeEcom();
                atributoGrade.setCodAtributo(rs.getString("codatributo"));
                atributoGrade.setDescricao(rs.getString("descricao"));
                atributoGrade.setIdAtributoEcom(rs.getInt("idatributoecom"));
                listaAtributoGrade.add(atributoGrade);
            }
            Logger.getLogger(AtributoGradeEcomDAO.class).info("Lista de atributo de grade retornada com sucesso.");
            return listaAtributoGrade;
        } catch (Exception e) {
            Logger.getLogger(AtributoGradeEcomDAO.class).error("Erro ao retornar lista de atributos da grade: " + e);
            return null;
        } finally {
            conn.close();
            stmt.close();
            rs.close();
        }
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
