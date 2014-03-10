/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.ListaPedidoERPBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.apache.log4j.Logger;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import br.com.atsinformatica.utils.Funcoes;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author kennedimalheiros
 */
public class ListaPedidoDAO implements IGenericDAO<ListaPedidoERPBean> {

    private static Logger logger = Logger.getLogger(ListaPedidoDAO.class);
    private Connection conn;

    @Override
    public void gravar(ListaPedidoERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(ListaPedidoERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaPedidoERPBean abrir(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ListaPedidoERPBean> listaTodos() throws SQLException {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoATS.conectaERP();
            String sql = "SELECT PC.CODPEDIDO, PC.IDPEDIDOECOM, C.NOME, PC.TOTALPEDIDO,"
                    + "       PC.STATUSPEDIDOECOM, PC.DATAPEDIDO, PC.OBSERVACAO1, PC.DTSINCECOM"
                    + "  FROM PEDIDOC PC JOIN"
                    + "       CLIENTE C ON C.CODCLIENTE = PC.CODCLIENTE"
                    + " WHERE PC.IDPEDIDOECOM IS NOT NULL"
                    + "    -- STATUS DIFERENTE DE (FINALIZADO = 14)  E (CANCELADO = 6)"
                    + "   AND PC.STATUSPEDIDOECOM <> 14N"
                    + "   AND PC.STATUSPEDIDOECOM <> 6"
                    + "   AND PC.STATUSPEDIDOECOM >  0";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            List<ListaPedidoERPBean> listaPedBean = new ArrayList<>();
            while (rs.next()) {
                ListaPedidoERPBean bean = new ListaPedidoERPBean(rs);
                listaPedBean.add(bean);
            }
            return listaPedBean;
        } catch (Exception e) {
            return null;
        } finally {
            stmt.close();
            rs.close();
            conn.close();
        }

    }

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean validacaoFinalizarPedido(ListaPedidoERPBean listaPedidoERPBean) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = ConexaoATS.conectaERP();

            String sql = "   SELECT * FROM PEDIDOC P"
                    + "           WHERE P.CODPEDIDO = ?"
                    + "             AND P.IDPEDIDOECOM = ?"
                    + "             AND P.STATUSPEDIDOECOM > 2  -- SE FOR MAIOR QUE 2 (FEZ O PAGAMENTO)"
                    + "             AND P.STATUSPEDIDOECOM <> 6 -- NÃO ESTA CANCELADO";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Funcoes.preencheCom(String.valueOf(listaPedidoERPBean.getCodPedidoResulth()), "0", 8, Funcoes.LEFT));
            pstmt.setString(2, String.valueOf(listaPedidoERPBean.getCodPedidoEcom()));
            rs = pstmt.executeQuery();
            logger.error("Verificação de Finalizar Pedido com sucesso. ");
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error("Erro na Verificação de Finalizar Pedido: " + e);
            return false;
        } finally {
            pstmt.close();
            rs.close();
            conn.close();
        }
    }

    public boolean finalizarPedido(ListaPedidoERPBean listaPedidoERPBean) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn = ConexaoATS.conectaERP();
            String sql = " UPDATE PEDIDOC P SET P.STATUSPEDIDOECOM = ? , p.dtfinalizapedidoecom = ? "
                    + "  WHERE P.CODPEDIDO = ?"
                    + "    AND P.IDPEDIDOECOM = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "14");
            pstmt.setDate(2, new Date(listaPedidoERPBean.getDataFinalizacaoPedido().getTime()));
            //Função preencheCom completa o Codigo do Pedido para 8, completando com zeros a esquerda.
            pstmt.setString(3, Funcoes.preencheCom(String.valueOf(listaPedidoERPBean.getCodPedidoResulth()), "0", 8, Funcoes.LEFT));
            pstmt.setString(4, String.valueOf(listaPedidoERPBean.getCodPedidoEcom()));

            pstmt.executeUpdate();

            logger.info("Pedido Finalizado com sucesso!");
            return true;
        } catch (SQLException e) {
            logger.error("Erro ao Finalizar Pedido: " + e);
            return false;
        } finally {
            conn.close();
            pstmt.close();
        }
    }

}
