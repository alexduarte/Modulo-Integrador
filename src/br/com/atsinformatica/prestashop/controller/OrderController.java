/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.dao.PedidoERPDAO;
import br.com.atsinformatica.erp.entity.PedidoERPBean;
import br.com.atsinformatica.prestashop.clientDAO.OrderPrestashopDAO;
import br.com.atsinformatica.prestashop.model.root.Order;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kennedimalheiros
 */
public class OrderController {

    public PedidoERPBean syncOrderControllerPrestashop(int cod) {
        OrderPrestashopDAO dao = new OrderPrestashopDAO();

        Order order = dao.getId(Order.URLORDER, cod);
        PedidoERPBean bean = new PedidoERPBean();

        bean.setId_ecom(order.getId());
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

    public List<PedidoERPBean> syncListaOrder() throws SQLException {
        PedidoERPDAO pedidoERPDAO = new PedidoERPDAO();
        OrderPrestashopDAO dao = new OrderPrestashopDAO();
        PedidoERPBean bean = null;
        List<PedidoERPBean> lista = new ArrayList<>();
        List<Order> listOrder = dao.get(Order.URLORDER);

        for (Order order : listOrder) {

            bean = new PedidoERPBean();
            if (order != null) {

                if (order.getId() != null) {
                    //Return True se Existir, Não faz nada.
                    //       False se não existir, Adiciona a Lista.                    
                    if (!pedidoERPDAO.verificarPedidoEcomExisteERP(order.getId())) {
                        bean.setId_ecom(order.getId());
                        bean.setId_address_delivery(order.getId_address_delivery());
                        bean.setId_address_invoice(order.getId_address_invoice());
                        bean.setId_customer(order.getId_customer());
                        bean.setId_carrier(order.getId_carrier());
                        bean.setCurrent_state(order.getCurrent_state());
                        bean.setModule(order.getModule());
                        bean.setInvoice_number(order.getInvoice_number());
                        bean.setInvoice_date(order.getInvoice_date());
                        bean.setDelivery_date(order.getDelivery_date());

                        try {
                            Date dataPedido;

                            dataPedido = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(order.getDate_add());
                            bean.setDate_add(dataPedido);

                            String horaPedido = new SimpleDateFormat("HH:mm:ss").format(dataPedido);                          
                            bean.setHora(horaPedido);

                        } catch (ParseException ex) {
                            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        bean.setPayment(order.getPayment());
                        bean.setTotal_discounts(order.getTotal_discounts());
                        bean.setTotal_paid(order.getTotal_paid());
                        bean.setTotal_paid_real(order.getTotal_paid_real());
                        bean.setTotal_products(order.getTotal_products());
                        bean.setTotal_shipping(order.getTotal_shipping());
                        bean.setReference(order.getReference());

                        lista.add(bean);
                    }
                }
            }
        }
        return lista;
    }

}
