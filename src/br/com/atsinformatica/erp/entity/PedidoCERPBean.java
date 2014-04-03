/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.entity;

import br.com.atsinformatica.prestashop.model.node.OrderRowNode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kennedimalheiros
 */
public class PedidoCERPBean {

    private String id_erp;
    private String id_ecom;
    private String id_address_delivery;
    private String id_address_invoice;
    private String id_customer;
    private String id_carrier;
    private String current_state;
    private String module;
    private String invoice_number;
    private String invoice_date;
    private String delivery_date;
    private Date date_add;
    private String payment;
    private String total_discounts;
    private String total_paid;
    private String total_paid_real;
    private String total_products;
    private String total_shipping;
    private String reference;
    private String hora;
    private List<OrderRowNode> listItensPedido = new ArrayList<>();

    public String getId_erp() {
        return id_erp;
    }

    public void setId_erp(String id_erp) {
        this.id_erp = id_erp;
    }

    public String getId_ecom() {
        return id_ecom;
    }

    public void setId_ecom(String id) {
        this.id_ecom = id;
    }

    public String getId_address_delivery() {
        return id_address_delivery;
    }

    public void setId_address_delivery(String id_address_delivery) {
        this.id_address_delivery = id_address_delivery;
    }

    public String getId_address_invoice() {
        return id_address_invoice;
    }

    public void setId_address_invoice(String id_address_invoice) {
        this.id_address_invoice = id_address_invoice;
    }

    public String getId_customer() {
        return id_customer;
    }

    public void setId_customer(String id_customer) {
        this.id_customer = id_customer;
    }

    public String getId_carrier() {
        return id_carrier;
    }

    public void setId_carrier(String id_carrier) {
        this.id_carrier = id_carrier;
    }

    public String getCurrent_state() {
        return current_state;
    }

    public void setCurrent_state(String current_state) {
        this.current_state = current_state;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(String invoice_number) {
        this.invoice_number = invoice_number;
    }

    public String getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(String invoice_date) {
        this.invoice_date = invoice_date;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getTotal_discounts() {
        return total_discounts;
    }

    public void setTotal_discounts(String total_discounts) {
        this.total_discounts = total_discounts;
    }

    public String getTotal_paid() {
        return total_paid;
    }

    public void setTotal_paid(String total_paid) {
        this.total_paid = total_paid;
    }

    public String getTotal_paid_real() {
        return total_paid_real;
    }

    public void setTotal_paid_real(String total_paid_real) {
        this.total_paid_real = total_paid_real;
    }

    public String getTotal_products() {
        return total_products;
    }

    public void setTotal_products(String total_products) {
        this.total_products = total_products;
    }

    public String getTotal_shipping() {
        return total_shipping;
    }

    public void setTotal_shipping(String total_shipping) {
        this.total_shipping = total_shipping;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDate_add() {
        return date_add;
    }

    public void setDate_add(Date date_add) {
        this.date_add = date_add;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public List<OrderRowNode> getListItensPedido() {
        return listItensPedido;
    }

    public void setListItensPedido(List<OrderRowNode> listItensPedido) {
        this.listItensPedido = listItensPedido;
    }

}
