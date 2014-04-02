/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.root;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author kennedimalheiros
 */
@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "order", propOrder = {
    "id", //Cod Pedido
    "id_address_delivery", // ID Endereço Entrega
    "id_address_invoice", // ID Endereço Fatura
    "id_customer", // ID Cliente
    "id_carrier", //ID Serviço de Transportadora
    "current_state", // ID do Status do Pedido
    "module",       // Modulo de Pagamento      
    "invoice_number", // Numero da Fatura Ecom
    "invoice_date", // Data Faturamento do Pedido
    "delivery_date", // Data Envio
    "date_add", // Data Adicionou o pedido
    "payment", // Modulo de Pagamento  
    "total_discounts", // Total de desconto
    "total_paid", // Total do Pedido Com Desconto
    "total_paid_real", // Total do Pedido Real
    "total_products", // Total apenas dos produtos (Preço de varejo antes(sem) do imposto)
    "total_shipping", //Total de Frete
    "reference", // Referencia do Pedido
})

public class Order {

    public static String URLORDER = "orders/";
    @XmlElement(name = "id", required = true)
    private String id;
    @XmlElement(name = "id_address_delivery")
    private String id_address_delivery;
    @XmlElement(name = "id_address_invoice")
    private String id_address_invoice;
    @XmlElement(name = "id_customer")
    private String id_customer;
    @XmlElement(name = "id_carrier")
    private String id_carrier;
    @XmlElement(name = "current_state")
    private String current_state;
    @XmlElement(name = "module")
    private String module;
    @XmlElement(name = "invoice_number")
    private String invoice_number;
    @XmlElement(name = "invoice_date")
    private String invoice_date;
    @XmlElement(name = "delivery_date")
    private String delivery_date;
    @XmlElement(name = "date_add")
    private String date_add;
    @XmlElement(name = "payment")
    private String payment;
    @XmlElement(name = "total_discounts")
    private String total_discounts;
    @XmlElement(name = "total_paid")
    private String total_paid;
    @XmlElement(name = "total_paid_real")
    private String total_paid_real;
    @XmlElement(name = "total_products")
    private String total_products;
    @XmlElement(name = "total_shipping")
    private String total_shipping;
    @XmlElement(name = "reference")
    private String reference;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        Date dtTemp;
        String dtformatada = null;
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//formato do mySQL
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");//formato para mostrar
            dtTemp = sdf1.parse(invoice_date);
            dtformatada = sdf2.format(dtTemp);
        } catch (ParseException ex) {
            Logger.getLogger("br.com.atsinformatica.prestashop.model.root.Order.Class: " + ex);
        }
        return dtformatada;
    }

    public void setInvoice_date(String invoice_date) {
        this.invoice_date = invoice_date;
    }

    public String getDelivery_date() {

        Date dtTemp;
        String dtformatada = null;
        try {

            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//formato do mySQL
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");//formato para mostrar
            dtTemp = sdf1.parse(delivery_date);
            dtformatada = sdf2.format(dtTemp);
        } catch (ParseException ex) {
            Logger.getLogger("br.com.atsinformatica.prestashop.model.root.Order.Class: " + ex);
        }
        return dtformatada;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getDate_add() {
        Date dtTemp;
        String dtformatada = null;
        try {

            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//formato do mySQL
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");//formato para mostrar
            dtTemp = sdf1.parse(date_add);
            dtformatada = sdf2.format(dtTemp);
        } catch (ParseException ex) {
            Logger.getLogger("br.com.atsinformatica.prestashop.model.root.Order.Class: " + ex);
        }
        return dtformatada;
    }

    public void setDate_add(String date_add) {
        this.date_add = date_add;
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

}
