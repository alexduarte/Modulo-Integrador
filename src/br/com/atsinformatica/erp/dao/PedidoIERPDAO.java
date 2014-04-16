/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.PedidoIERPBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author kennedimalheiros
 */
public class PedidoIERPDAO implements IGenericDAO<PedidoIERPBean> {

    private static Logger logger = Logger.getLogger(PedidoIERPDAO.class);
    private Connection conn;

    @Override
    public void gravar(PedidoIERPBean pedidoIERPBean) throws SQLException {

        PreparedStatement pstmt = null;

        try {

            if (PedidoCERPDAO.connPedido.isClosed()) {
                PedidoCERPDAO.connPedido = ConexaoATS.conectaERP();
            }

            String sql = " INSERT INTO PEDIDOI "
                    + "                    (CODEMPRESA, TIPOPEDIDO, CODPEDIDO, CODCLIENTE, "
                    + "                     CODPROD, CODGRADE, QUANTIDADE, PRECOUNIT, UNIDADESAIDA, "
                    + "                     TOTALITEM, PESO ) "
                    + "              VALUES(?,?,?,?,?,?,?,?,?,?,?)";

            pstmt = PedidoCERPDAO.connPedido.prepareStatement(sql);
            pstmt.setString(1, pedidoIERPBean.getCodEmpresa());
            pstmt.setString(2, "55");
            pstmt.setString(3, pedidoIERPBean.getCodPedido());
            pstmt.setString(4, pedidoIERPBean.getCodClienteERP());
            pstmt.setString(5, pedidoIERPBean.getCodProdERP());
            pstmt.setString(6, pedidoIERPBean.getCodGradERP());
            pstmt.setDouble(7, pedidoIERPBean.getQuantidade());
            pstmt.setDouble(8, pedidoIERPBean.getPrecoUnit());
            pstmt.setString(9, pedidoIERPBean.getUnidadeSaida());
            pstmt.setDouble(10, pedidoIERPBean.getTotalItem());
            pstmt.setDouble(11, pedidoIERPBean.getPeso());

            pstmt.executeUpdate();

            logger.info("Produto ERP: " + pedidoIERPBean.getCodProdERP() + " do Pedido ERP: (" + pedidoIERPBean.getCodPedido() + "), Gravado com sucesso.");

        } catch (Exception e) {
            logger.error("Erro ao soncronizar Produto ERP: " + pedidoIERPBean.getCodProdERP() + "  do Pedido Ecom ( " + pedidoIERPBean.getCodPedido() + " ): " + e);
            PedidoCERPDAO.connPedido.rollback();
            PedidoCERPDAO.connPedido.close();

        } finally {
            pstmt.close();
        }

    }

    @Override
    public void alterar(PedidoIERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PedidoIERPBean abrir(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PedidoIERPBean> listaTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
