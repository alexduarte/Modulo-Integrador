/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.GradeERPBean;
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
public class GradeERPDAO implements IGenericDAO<GradeERPBean> {

    private Connection conn;

    @Override
    public void gravar(GradeERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(GradeERPBean object) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn = ConexaoATS.conectaERP();
            String querie = "UPDATE GRADE                  "
                          + " IDGRADEECOM = ?              "
                          + "WHERE CODGRADE = ?            ";
            pstmt = conn.prepareStatement(querie);
            pstmt.setString(1, object.getCodGrade());
            pstmt.setString(2, object.getCodGrade());
            pstmt.executeUpdate();
            Logger.getLogger(GradeERPDAO.class).info("Grade alterada com sucesso!");
        } catch (Exception e) {
            Logger.getLogger(GradeERPDAO.class).error("Erro ao alterar grade: " + e);
        } finally {
            pstmt.close();
            conn.close();
        }
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GradeERPBean abrir(String id) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = ConexaoATS.conectaERP();
            String sql = "Select * from grade where     "
                        +"IDGRADEECOM = ?               ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(id));
            rs = pstmt.executeQuery();
            GradeERPBean grade = null;
            while(rs.next()){
                grade = new GradeERPBean();
                grade.setCodGrade(rs.getString("codgrade"));
                grade.setDescricao(rs.getString("descricao"));
                grade.setIdGradeEcom(rs.getInt("idgradeecom"));
            }
            Logger.getLogger(ProdGradeERPDAO.class).info("Grade retornada com sucesso!");
            return grade;
        }catch(Exception e){
            Logger.getLogger(ProdGradeERPDAO.class).error("Erro ao retornar grade: "+e);
            return null;            
        }finally{
            rs.close();
            pstmt.close();
        }
    
    }

    @Override
    public List<GradeERPBean> listaTodos() throws SQLException {
        List<GradeERPBean> lista = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexaoATS.conectaERP();
            String sql = "Select * from grade";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            GradeERPBean grade = null;
            while (rs.next()) {
                grade = new GradeERPBean();
                grade.setCodGrade(rs.getString("codgrade"));
                grade.setDescricao(rs.getString("descricao"));
                grade.setIdGradeEcom(rs.getInt("idgradeecom"));
                lista.add(grade);
            }
            Logger.getLogger(GradeERPBean.class).info("Lista de grade retornada com sucesso!");
            return lista;
        } catch (Exception e) {
            Logger.getLogger(GradeERPBean.class).error("Erro ao retornar lista de grade: " + e);
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
