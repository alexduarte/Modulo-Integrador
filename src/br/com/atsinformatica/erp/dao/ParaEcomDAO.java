/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.ParaEcomBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import br.com.atsinformatica.utils.Funcoes;
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
public class ParaEcomDAO implements IGenericDAO<ParaEcomBean> {   
    private static Logger logger = Logger.getLogger(ParaEcomDAO.class);
    private Connection conn;

    @Override
    public void gravar(ParaEcomBean object) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn = ConexaoATS.conectaERP();
            conn.setAutoCommit(false);
            String querie = "INSERT INTO PARAECOM (CODPARAECOM, MINUTOSCADASTRO, MINUTOSMOV, QTDEREGISTROS, QTDEMANTIDOS, "
                    + " ATIVASINCRONIZACAO, CODEMPRESAECOM, CODVENDENDECOM) "
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(querie);
            pstmt.setString(1, ultimoRegistro());
            pstmt.setInt(2, object.getMinutoscadastrados());
            pstmt.setInt(3, object.getMinutosmov());
            pstmt.setInt(4, object.getQtdeRegistros());
            pstmt.setInt(5, object.getQtdMantido());
            pstmt.setInt(6, object.getAtivaSincronizacao());
            pstmt.setString(7, object.getCodEmpresaEcom());
            pstmt.setString(8, object.getCodVendendEcom());
            pstmt.executeUpdate();
            conn.commit();
            logger.info("Parametros salvos com sucesso!");
        } catch (Exception e) {
            logger.error("Erro ao salvar parametros: " + e);
            conn.rollback();
        } finally {
            pstmt.close();
            conn.close();
        }
    }

    @Override
    public void alterar(ParaEcomBean object) throws SQLException {
        PreparedStatement pstmt = null;
        try{
            conn = ConexaoATS.conectaERP();
            conn.setAutoCommit(false);
            String querie = "Update PARAECOM set MINUTOSCADASTRO = ?,"
                    + " MINUTOSMOV = ?,"
                    + " QTDEREGISTROS = ?,"
                    + " QTDEMANTIDOS = ?,"
                    + " ATIVASINCRONIZACAO = ?, "
                    + " CODEMPRESAECOM = ?,"
                    + " CODVENDENDECOM = ? "
                    + " WHERE CODPARAECOM = ?";
            pstmt = conn.prepareStatement(querie);
            pstmt.setInt(1, object.getMinutoscadastrados());
            pstmt.setInt(2, object.getMinutosmov());
            pstmt.setInt(3, object.getQtdeRegistros());
            pstmt.setInt(4, object.getQtdMantido());
            pstmt.setInt(5, object.getAtivaSincronizacao());
            pstmt.setString(6, object.getCodEmpresaEcom());
            pstmt.setString(7, object.getCodVendendEcom());
            pstmt.setString(8, object.getCodparaecom());
            pstmt.executeUpdate();
            conn.commit();
            logger.info("Parametros alterados com sucesso!");
        }catch(Exception e){
            logger.error("Erro ao alterar parametros: "+e);
            conn.rollback();
        }finally{
            pstmt.close();
            conn.close();
            
        }
    }

    @Override
    public void deletar(String id) throws SQLException {
        PreparedStatement pstmt = null;
        try{
            conn = ConexaoATS.conectaERP();
            conn.setAutoCommit(false);
            String querie = "DELETE FROM PARAECOM where CODPARAECOM = ?";
            pstmt = conn.prepareStatement(querie);
            pstmt.setString(1, id);
            conn.commit();
            logger.info("Parametro deletado com sucesso!");
        }catch(Exception e){
            logger.error("Erro ao deletar parametro: "+e);
            conn.rollback();
        }finally{
            pstmt.close();
            conn.close();
        }
    }

    @Override
    public ParaEcomBean abrir(String id) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = ConexaoATS.conectaERP();
            String sql = "SELECT * FROM PARAECOM WHERE CODPARAECOM = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            ParaEcomBean  bean = new ParaEcomBean();
            while(rs.next()){
                bean.setCodparaecom(rs.getString("CODPARAECOM"));
                bean.setMinutoscadastrados(rs.getInt("MINUTOSCADASTRO"));
                bean.setMinutosmov(rs.getInt("MINUTOSMOV"));
                bean.setQtdeRegistros(rs.getInt("QTDEREGISTROS"));
                bean.setQtdMantido(rs.getInt("QTDEMANTIDOS"));
                bean.setAtivaSincronizacao(rs.getInt("ATIVASINCRONIZACAO"));
            }
            logger.info("Parametro retornado com sucesso!");
            return bean;
        }catch(Exception e){
            logger.error("Erro ao rettorna parametro: "+e);
            return null;
        }finally{
            pstmt.close();
            rs.close();
            conn.close();
        }
    }

    @Override
    public List<ParaEcomBean> listaTodos() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try{
            List<ParaEcomBean> listaParaEcom = new ArrayList<>();
            conn = ConexaoATS.conectaERP();
            String sql = "Select * from PARAECOM";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                ParaEcomBean paraEcom = new ParaEcomBean();
                paraEcom.setCodparaecom(rs.getString("CODPARAECOM"));
                paraEcom.setMinutoscadastrados(rs.getInt("MINUTOSCADASTRO"));
                paraEcom.setMinutosmov(rs.getInt("MINUTOSMOV"));
                paraEcom.setQtdeRegistros(rs.getInt("QTDEREGISTROS"));
                paraEcom.setQtdMantido(rs.getInt("QTDEMANTIDOS"));
                paraEcom.setAtivaSincronizacao(rs.getInt("ATIVASINCRONIZACAO"));
                paraEcom.setCodEmpresaEcom(rs.getString("CODEMPRESAECOM"));
                paraEcom.setCodVendendEcom(rs.getString("CODVENDENDECOM"));
                listaParaEcom.add(paraEcom);
            }
            logger.info("Lista de parametros, retornada com sucesso!");
            return listaParaEcom;
        }catch(Exception e){
            logger.error("Erro ao retornar lista de parametros: "+e);
            return null;            
        }finally{
            rs.close();
            stmt.close();
            conn.close();
        }
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select max(CODPARAECOM) cod from PARAECOM";
            stmt = ConexaoATS.conectaERP().createStatement();
            rs = stmt.executeQuery(sql);
            int cod = 0;
            while (rs.next()) {
                if (rs.getString("cod") != null) {
                    cod = Integer.valueOf(rs.getString("cod")) + 1;
                }
            }
            return Funcoes.preencheCom(Integer.toString(cod), "0", 6, Funcoes.LEFT);
        } catch (Exception e) {
            return null;
        } finally {
            stmt.close();
            rs.close();
        }
    }
}
