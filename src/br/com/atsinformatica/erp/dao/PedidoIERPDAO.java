/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.PedidoIERPBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import br.com.atsinformatica.utils.Funcoes;
import br.com.atsinformatica.utils.LogERP;
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
public class PedidoIERPDAO implements IGenericDAO<PedidoIERPDAO> {

    private static Logger logger = Logger.getLogger(ListaPedidoDAO.class);
    private Connection conn;

    @Override
    public void gravar(PedidoIERPDAO object) throws SQLException {
    }

    public boolean gravar(PedidoIERPBean pedidoIERPBean) throws SQLException {

        PreparedStatement pstmt = null;

        try {

            conn = ConexaoATS.conectaERP();
            String sql = " INSERT INTO PEDIDOI "
                    + "                    (CODEMPRESA, TIPOPEDIDO, CODPEDIDO, CODCLIENTE, "
                    + "                     CODPROD, CODGRADE, QUANTIDADE, PRECOUNIT, UNIDADESAIDA, "
                    + "                     TOTALITEM, PESO ) "
                    + "              VALUES(?,?,?,?,?,?,?,?,?,?,?)";

            pstmt = conn.prepareStatement(sql);
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

            //Gerando log
            LogERP.geraLog("PEDIDOI", pedidoIERPBean.getCodPedido(), "Inclusão", "Incluindo itens do pedido sincronizado do Ecommercer");
            return true;
        } catch (Exception e) {
            logger.error("Erro ao soncronizar Item do Pedido Ecom ( " + pedidoIERPBean.getCodPedido() + " ): " + e);
            return false;
        } finally {
            conn.close();
            pstmt.close();
        }

    }

    @Override
    public void alterar(PedidoIERPDAO object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PedidoIERPDAO abrir(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PedidoIERPDAO> listaTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String retornaCodClienteERP(String codClienteEcom) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String codClienteERP = "00000000";
        try {
            conn = ConexaoATS.conectaERP();
            
            String sql = "SELECT C.CODCLIENTE COD FROM CLIENTE  C "
                    + "                       WHERE C.CODCLIENTEECOM = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codClienteEcom);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                if (rs.getString("cod") != null) {
                    codClienteERP = rs.getString("CODCLIENTE");
                }
            }
            return Funcoes.preencheCom(codClienteERP, "0", 8, Funcoes.LEFT);
        } catch (Exception e) {
            return "00000000";
        } finally {
            pstmt.close();
            rs.close();
        }
    }
    

    
}
