/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.prestashop.clientDAO.OrderHistoryPestashopDAO;
import br.com.atsinformatica.prestashop.clientDAO.OrderPrestashopDAO;
import br.com.atsinformatica.prestashop.model.root.OrderHistory;

/**
 *
 * @author kennedimalheiros
 */
public class OrderHistoryController {

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(OrderHistoryController.class);

    public void insertOrderHistory(int idOrder, int codStatus) {
        try {
            OrderHistoryPestashopDAO dao = new OrderHistoryPestashopDAO();
            OrderHistory orderHistory = new OrderHistory();
            orderHistory.setIdEmployee("999999");
            orderHistory.setIdOrder(String.valueOf(idOrder));
            orderHistory.setIdOrderState(String.valueOf(codStatus));
            dao.post(OrderHistory.URLORDERHISTORY, orderHistory);

        } catch (Exception e) {
            logger.error("Erro ao inserir Historio do pedido para Status Cod:(" + codStatus + ") do PedidosEcon Cod:(" + idOrder + ") na loja Prestashop: " + e);
            return;
        }
    }
}
