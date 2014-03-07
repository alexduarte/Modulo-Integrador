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
import java.util.ArrayList;

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
                    + "       PC.STATUSPEDIDO, PC.DATAPEDIDO, PC.OBSERVACAO1, PC.DATASINC"
                    + "  FROM PEDIDOC PC JOIN"
                    + "       CLIENTE C ON C.CODCLIENTE = PC.CODCLIENTE"
                    + " WHERE PC.IDPEDIDOECOM IS NOT NULL"
                    + "   -- Status diferente de (Finalizado = 14)  e (Cancelado = 6)"
                    + "   AND PC.statuspedido <> '14'"
                    + "   AND PC.statuspedido <> '6'";
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
    
    public boolean finalizarPedido() throws SQLException{
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoATS.conectaERP();
            String sql = "SELECT PC.CODPEDIDO, PC.IDPEDIDOECOM, C.NOME, PC.TOTALPEDIDO,"
                    + "       PC.STATUSPEDIDO, PC.DATAPEDIDO, PC.OBSERVACAO1, PC.DATASINC"
                    + "  FROM PEDIDOC PC JOIN"
                    + "       CLIENTE C ON C.CODCLIENTE = PC.CODCLIENTE"
                    + " WHERE PC.IDPEDIDOECOM IS NOT NULL"
                    + "   -- Status diferente de (Finalizado = 14)  e (Cancelado = 6)"
                    + "   AND PC.statuspedido <> 1 4"
                    + "   AND PC.statuspedido <> 6 "
                    + "   AND PC.statuspedido <  0 ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
          
  
            return true;
        } catch (Exception e) {
             return false;
        } finally {
            stmt.close();
            rs.close();
            conn.close();
        }

       
        
    }

}
