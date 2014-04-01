/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.EstadoERPBean;
import br.com.atsinformatica.erp.entity.PedidoERPBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import br.com.atsinformatica.utils.Funcoes;
import br.com.atsinformatica.utils.Log;
import java.sql.Connection;
import java.sql.Date;
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
public class PedidoERPDAO implements IGenericDAO<PedidoERPBean> {

    private static Logger logger = Logger.getLogger(ListaPedidoDAO.class);
    private Connection conn;

    @Override
    public void gravar(PedidoERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(PedidoERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PedidoERPBean abrir(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PedidoERPBean> listaTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select max(CODPEDIDO) cod from PEDIDOC";
            stmt = ConexaoATS.conectaERP().createStatement();
            rs = stmt.executeQuery(sql);
            int cod = 0;
            while (rs.next()) {
                if (rs.getString("cod") != null) {
                    cod = Integer.valueOf(rs.getString("cod")) + 1;
                }
            }
            return Funcoes.preencheCom(Integer.toString(cod), "0", 8, Funcoes.LEFT);
        } catch (Exception e) {
            return null;
        } finally {
            stmt.close();
            rs.close();
        }
    }

    /**
     * Verificar se numero do pedido informado ja existe no banco do ERP
     *
     * @param codPedidoEcom : Codigo do pedido gerado pelo Ecom
     * @return True se Existir, False se não existir.
     * @throws SQLException
     */
    public boolean verificarPedidoEcomExisteERP(String codPedidoEcom) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = ConexaoATS.conectaERP();

            String sql = "  SELECT P.IDPEDIDOECOM FROM PEDIDOC P "
                    + "                          WHERE IDPEDIDOECOM = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codPedidoEcom);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error("Erro na Verificação de Cliente já existente: " + e);
            return false;
        } finally {
            pstmt.close();
            rs.close();
            conn.close();
        }
    }

    public void gravarPedido(PedidoERPBean pedidoERPBean, String codClienteERP) throws SQLException {
        PreparedStatement pstmt = null;
        try {

            conn = ConexaoATS.conectaERP();
            String sql = " INSERT INTO PEDIDOC (CODPEDIDO, IDPEDIDOECOM, "
                    + "                      CODCLIENTE, DATAPEDIDO, HORA, FRETE) "
                    + "              VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, ultimoRegistro());
            pstmt.setString(2, pedidoERPBean.getId());
            pstmt.setString(3, codClienteERP);
            pstmt.setDate(6, new Date(pedidoERPBean.getDate_add().getTime()));
            pstmt.setString(7, pedidoERPBean.getHora());
            pstmt.setString(8, pedidoERPBean.getTotal_shipping());

            pstmt.execute();

            //Gerando log
            Log.geraLog("PEDICOC", ultimoRegistro(), "Inclusão", "Incluindo pedido sincronizado do Ecommercer");

        } catch (SQLException e) {
            logger.error("Erro ao soncronizar Pedido Ecom ( " + ultimoRegistro() + " ): " + e);

        } finally {
            conn.close();
            pstmt.close();
        }
    }

}
