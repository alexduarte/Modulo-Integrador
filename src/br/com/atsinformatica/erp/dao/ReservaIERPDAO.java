/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.ReservaIERP;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author kennedimalheiros
 */
public class ReservaIERPDAO implements IGenericDAO<ReservaIERP> {

    private static Logger logger = Logger.getLogger(ReservaIERPDAO.class);

    @Override
    public void gravar(ReservaIERP object) throws SQLException {

        PreparedStatement pstmt = null;
        try {
            if (PedidoCERPDAO.connPedido.isClosed()) {
                PedidoCERPDAO.connPedido = ConexaoATS.conectaERP();
            }
            PedidoCERPDAO.connPedido.setAutoCommit(false);

            String sql = " INSERT INTO RESERVASI "
                    + "   (CODRESERVA, CODPROD, QUANTIDADE, PRECO, BAIXADO, CODGRADE) "
                    + "     VALUES (?, ?, ?, ?, ?, ?);";

            pstmt = PedidoCERPDAO.connPedido.prepareStatement(sql);
            pstmt.setInt(1, object.getCodReservar());
            pstmt.setString(2, object.getCodProd());
            pstmt.setDouble(3, object.getQuantidade());
            pstmt.setDouble(4, object.getPreco());
            pstmt.setString(5, object.getBaixado());
            pstmt.setString(6, object.getCodGrade());

            pstmt.executeUpdate();
            PedidoCERPDAO.connPedido.commit();
            logger.info("Reservar dos Itens da Reserva:(" + object.getCodReservar() + "), Gravado com sucesso.");

        } catch (Exception e) {
            logger.info("ERRO ao Gravar Reservar dos Itens da Reserva :(" + object.getCodReservar() + "), ERRO: " + e);
            PedidoCERPDAO.connPedido.rollback();
            PedidoCERPDAO.connPedido.close();
        } finally {
            PedidoCERPDAO.connPedido.close();
            pstmt.close();
        }
    }

    @Override
    public void alterar(ReservaIERP object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReservaIERP abrir(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReservaIERP> listaTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
