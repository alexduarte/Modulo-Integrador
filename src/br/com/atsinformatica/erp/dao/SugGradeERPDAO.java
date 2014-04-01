/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.SubGradeERPBean;
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
public class SugGradeERPDAO implements IGenericDAO<SubGradeERPBean> {
    private Connection conn;

    @Override
    public void gravar(SubGradeERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(SubGradeERPBean object) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn = ConexaoATS.conectaERP();
            String querie = "UPDATE SUBGRADE               "
                          + " IDSUBGRADEECOM = ?           "
                          + "WHERE CODSUBGRADE = ?         ";
            pstmt = conn.prepareStatement(querie);
            pstmt.setInt(1, object.getIdSubgradeEcom());
            pstmt.setString(2, object.getCodSubgrade());
            pstmt.executeUpdate();
            Logger.getLogger(GradeERPDAO.class).info("SubGrade alterada com sucesso!");
        } catch (Exception e) {
            Logger.getLogger(GradeERPDAO.class).error("Erro ao alterar subgrade: " + e);
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
    public SubGradeERPBean abrir(String id) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = ConexaoATS.conectaERP();
            String sql = "Select * from subgrade where     "
                        +"IDSUBGRADEECOM = ?               ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(id));
            rs = pstmt.executeQuery();
            SubGradeERPBean grade = null;
            while(rs.next()){
                grade = new SubGradeERPBean();
                grade.setCodSubgrade(rs.getString("codsubgrade"));
                grade.setDescSubGrade(rs.getString("descsubgrade"));
                grade.setIdSubgradeEcom(rs.getInt("idsubgradeecom"));
                grade.setTipoDivisao(rs.getInt("tipodivisao"));
            }
            Logger.getLogger(ProdGradeERPDAO.class).info("Subgrade retornada com sucesso!");
            return grade;
        }catch(Exception e){
            Logger.getLogger(ProdGradeERPDAO.class).error("Erro ao retornar subgrade: "+e);
            return null;            
        }finally{
            rs.close();
            pstmt.close();
        }
    }

    @Override
    public List<SubGradeERPBean> listaTodos() throws SQLException {
        List<SubGradeERPBean> lista = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexaoATS.conectaERP();
            String sql = "Select * from subgrade";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            SubGradeERPBean grade = null;
            while (rs.next()) {
                grade = new SubGradeERPBean();
                grade.setCodSubgrade(rs.getString("codsubgrade"));
                grade.setDescSubGrade(rs.getString("descsubgrade"));
                grade.setIdSubgradeEcom(rs.getInt("idsubgradeecom"));
                grade.setTipoDivisao(rs.getInt("tipodivisao"));
                lista.add(grade);
            }
            Logger.getLogger(SubGradeERPBean.class).info("Lista de subgrade retornada com sucesso!");
            return lista;
        } catch (Exception e) {
            Logger.getLogger(SubGradeERPBean.class).error("Erro ao retornar lista de subgrade: " + e);
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
