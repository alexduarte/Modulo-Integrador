/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.node;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author kennedimalheiros
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
    "orderRow"
})
@XmlRootElement(name = "order_rows")
public class OrderRowsNode {

    @XmlAttribute(name = "virtual_entity")
    protected String virtualEntity = "true";
    
    @XmlAttribute(name = "node_type")
    protected String nodeType = "order_row";
    @XmlElement(name = "order_row")
    private List<OrderRowNode> orderRow;

    public OrderRowsNode() {
        this.virtualEntity = "true";
        this.nodeType = "order_row";
    }

    public List<OrderRowNode> getOrderRow() {
        if (orderRow == null) {
            orderRow = new ArrayList<>();
        }
        return orderRow;
    }

    public void setOrderRow(List<OrderRowNode> orderRow) {
        this.orderRow = orderRow;
    }

}
