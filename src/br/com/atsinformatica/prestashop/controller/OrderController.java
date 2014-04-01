/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.dao.PedidoERPDAO;
import br.com.atsinformatica.erp.entity.PedidoEcomBean;
import br.com.atsinformatica.prestashop.clientDAO.OrderPrestashopDAO;
import br.com.atsinformatica.prestashop.model.root.Order;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kennedimalheiros
 */
public class OrderController {

    public PedidoEcomBean syncOrderControllerPrestashop(int cod) {
        OrderPrestashopDAO dao = new OrderPrestashopDAO();

        Order order = dao.getId(Order.URLORDER, cod);
        PedidoEcomBean bean = new PedidoEcomBean();

        bean.setId(order.getId());
        bean.setId_address_delivery(order.getId_address_delivery());
        bean.setId_address_invoice(order.getId_address_invoice());
        bean.setId_customer(order.getId_customer());
        bean.setCurrent_state(order.getCurrent_state());
        bean.setInvoice_date(order.getInvoice_date());
        bean.setDelivery_date(order.getDelivery_date());
        bean.setPayment(order.getPayment());
        bean.setTotal_discounts(order.getTotal_discounts());
        bean.setTotal_paid(order.getTotal_paid());
        bean.setTotal_paid_real(order.getTotal_paid_real());
        bean.setTotal_products(order.getTotal_products());
        bean.setReference(order.getReference());

        return bean;
    }

    public List<PedidoEcomBean> syncListaOrder() throws SQLException {
        PedidoERPDAO pedidoERPDAO = new PedidoERPDAO();
        OrderPrestashopDAO dao = new OrderPrestashopDAO();
        PedidoEcomBean bean = null;
        List<PedidoEcomBean> lista = new ArrayList<>();
        List<Order> listOrder = dao.get(Order.URLORDER);

        for (Order order : listOrder) {

            bean = new PedidoEcomBean();
            if (order != null) {

                if (order.getId() != null) {
                    //Return True se Existir, Não faz nada.
                    //       False se não existir, Adiciona a Lista.                    
                    if (!pedidoERPDAO.verificarPedidoEcomExisteERP(order.getId())) {
                        bean.setId(order.getId());
                        lista.add(bean);
                    }
                }
            }
        }
        return lista;
    }

}
