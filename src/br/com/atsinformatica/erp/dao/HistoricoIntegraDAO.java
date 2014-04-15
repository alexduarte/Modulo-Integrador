/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.CategoriaEcomErpBean;
import br.com.atsinformatica.erp.entity.HistoricoIntegraERPBean;
import br.com.atsinformatica.erp.entity.ParaEcomBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AlexsanderPimenta
 */
public class HistoricoIntegraDAO implements IGenericDAO<HistoricoIntegraERPBean> {

    private static Logger logger = Logger.getLogger(HistoricoIntegraDAO.class);
    private Connection conn;

    @Override
    public void gravar(HistoricoIntegraERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(HistoricoIntegraERPBean object) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn = ConexaoATS.conectaERP();
            conn.setAutoCommit(false);
            String querie = "UPDATE HISTINTEGECOM SET dataint = ?"
                    + " where codentidade = ?";
            pstmt = conn.prepareStatement(querie);
//            pstmt.setDate(1, new Date(object.getDataInteg().getTime()));
            pstmt.setString(2, object.getCodEntidade());
            pstmt.executeUpdate();
            conn.commit();
            logger.info("Historico de integração alterado com sucesso!");
        } catch (Exception e) {
            logger.error("Erro ao alterar histórico de integração: " + e);
        } finally {
            conn.close();
            pstmt.close();
        }
    }

    public void alteraDataInt(int id) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn = ConexaoATS.conectaERP();
            Date dataAtual = new Date();
            String querie = "UPDATE HISTINTEGECOM SET dataint = ?"
                    + " where id = ?";
            pstmt = conn.prepareStatement(querie);
            pstmt.setDate(1, new java.sql.Date(dataAtual.getTime()));
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            logger.info("Historico de integração alterado com sucesso!");
        } catch (Exception e) {
            logger.error("Erro ao alterar histórico de integração: " + e);
        } finally {
            conn.close();
            pstmt.close();
        }
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HistoricoIntegraERPBean abrir(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HistoricoIntegraERPBean> listaTodos() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexaoATS.conectaERP();
            String sql = "select * from histintegecom";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            List<HistoricoIntegraERPBean> listHistBean = new ArrayList<>();
            while (rs.next()) {
                HistoricoIntegraERPBean bean = new HistoricoIntegraERPBean(rs);
                listHistBean.add(bean);
            }
            return listHistBean;
        } catch (Exception e) {
            return null;
        } finally {
            stmt.close();
            rs.close();
            conn.close();
        }
    }

    public List<HistoricoIntegraERPBean> listaUltimosInteg() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexaoATS.conectaERP();
            ParaEcomBean paraEcomBean = new ParaEcomDAO().listaTodos().get(0);
            List<HistoricoIntegraERPBean> listHistBean = new ArrayList<>();
            if (paraEcomBean.getQtdMantido() != 0) {
                String sql = "select first " + paraEcomBean.getQtdMantido() + " histintegecom.* from histintegecom "
                        + "where histintegecom.dataint is not null "
                        + "order by histintegecom.dataint desc";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    HistoricoIntegraERPBean bean = new HistoricoIntegraERPBean(rs);
                    listHistBean.add(bean);
                }
            }
            return listHistBean;
        } catch (Exception e) {
            return null;
        } finally {
            stmt.close();
            rs.close();
            conn.close();
        }
    }

    /**
     * Retorna itens pendentes de integração
     *
     * @return lista com itens pendentes
     * @throws SQLException
     */
    public List<HistoricoIntegraERPBean> listaPendentes() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexaoATS.conectaERP();
            ParaEcomBean paraEcomBean = new ParaEcomDAO().listaTodos().get(0);
            String sql = "select first " + paraEcomBean.getQtdeRegistros() + " histintegecom.* from histintegecom  "
                    + "where dataint is null order by histintegecom.entidade asc;                                  ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            List<HistoricoIntegraERPBean> listHistBean = new ArrayList<>();
            while (rs.next()) {
                HistoricoIntegraERPBean bean = new HistoricoIntegraERPBean(rs);
                if (bean.getEntidade().equals("categoria")) {
                    CategoriaEcomErpBean cat = new CategoriaEcomDAO().abrir(bean.getCodEntidade());
                    bean.setObjectSinc(cat);
                    listHistBean.add(bean);
                }
                if (bean.getEntidade().equals("produto")) {
                    bean.setObjectSinc(new ProdutoDAO().abrir(bean.getCodEntidade()));
                    listHistBean.add(bean);
                }
                if(bean.getEntidade().equals("atributograde")){
                    bean.setObjectSinc(new AtributoGradeEcomDAO().abrir(bean.getCodEntidade()));
                    listHistBean.add(bean);
                }
                if(bean.getEntidade().equals("fabricante")){
                    bean.setObjectSinc(new CadFabrERPDAO().abrir(bean.getCodEntidade()));
                    listHistBean.add(bean);
                }
            }
            return listHistBean;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
