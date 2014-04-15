/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.root;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author kennedimalheiros
 */
@XmlRootElement(name = "order_carrier")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "order_carrier", propOrder = {
    "id",
    "idOrder",
    "idCarrier",
    "idOrderInvoice",
    "weight",
    "shippingCostTaxExcl",
    "shippingCostTaxIncl",
    "trackingNumber",
    "dateAdd",})
public class OrderCarriersTrackingNumber {

    public static String URLORDERCARRIERSTATUS = "order_carriers_id_order/";

    @XmlElement(name = "id", required = true)
    private String id;
    @XmlElement(name = "id_order")
    private String idOrder;
    @XmlElement(name = "id_carrier")
    private String idCarrier;
    @XmlElement(name = "id_order_invoice")
    private String idOrderInvoice;
    @XmlElement(name = "weight")
    private String weight;
    @XmlElement(name = "shipping_cost_tax_excl")
    private String shippingCostTaxExcl;
    @XmlElement(name = "shipping_cost_tax_incl")
    private String shippingCostTaxIncl;
    @XmlElement(name = "tracking_number")
    private String trackingNumber;
    @XmlElement(name = "date_add")
    private String dateAdd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(String idCarrier) {
        this.idCarrier = idCarrier;
    }

    public String getIdOrderInvoice() {
        return idOrderInvoice;
    }

    public void setIdOrderInvoice(String idOrderInvoice) {
        this.idOrderInvoice = idOrderInvoice;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getShippingCostTaxExcl() {
        return shippingCostTaxExcl;
    }

    public void setShippingCostTaxExcl(String shippingCostTaxExcl) {
        this.shippingCostTaxExcl = shippingCostTaxExcl;
    }

    public String getShippingCostTaxIncl() {
        return shippingCostTaxIncl;
    }

    public void setShippingCostTaxIncl(String shippingCostTaxIncl) {
        this.shippingCostTaxIncl = shippingCostTaxIncl;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

}
