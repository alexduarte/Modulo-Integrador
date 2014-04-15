/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.prestashop.clientDAO.OrderCarriersTrackingNumberPrestashopDAO;
import br.com.atsinformatica.prestashop.model.root.OrderCarriersTrackingNumber;

/**
 *
 * @author kennedimalheiros
 */
public class OrderCarriersTrackingNumberController {

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(OrderCarriersTrackingNumberController.class);

    public void updateOrderCarriersTrackingNumber(int orderId, String codRastreamento) {
        try {
            OrderCarriersTrackingNumberPrestashopDAO dao = new OrderCarriersTrackingNumberPrestashopDAO();
            OrderCarriersTrackingNumber orderCarriersTrackingNumber = dao.getId(OrderCarriersTrackingNumber.URLORDERCARRIERSTATUS, orderId);
            orderCarriersTrackingNumber.setTrackingNumber(String.valueOf(codRastreamento));
            dao.put(OrderCarriersTrackingNumber.URLORDERCARRIERSTATUS, orderCarriersTrackingNumber);

        } catch (Exception e) {
            logger.error("Erro em (updateOrderCarriersTrackingNumber) ao atualizar Cod Rastreamento :(" + codRastreamento + ") do PedidosEcon Cod:(" + orderId + ") na loja Prestashop: " + e);
            return;

        }
    }
}
