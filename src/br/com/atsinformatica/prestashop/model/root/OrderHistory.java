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
@XmlRootElement(name = "order_histories")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "order_histories", propOrder = {
    "idOrderState",
    "idOrder",
    "idEmployee",
    "dateAdd",})
public class OrderHistory {

    public static String URLORDERHISTORY = "order_histories/";
    @XmlElement(name = "id_order_state")
    private String idOrderState;
    @XmlElement(name = "id_order")
    private String idOrder;
    @XmlElement(name = "id_employee")
    private String idEmployee;
    @XmlElement(name = "date_add")
    private String dateAdd;

    public String getIdOrderState() {
        return idOrderState;
    }

    public void setIdOrderState(String idOrderState) {
        this.idOrderState = idOrderState;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

}
