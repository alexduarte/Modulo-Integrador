/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.prestashop.model.node;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author kennedimalheiros
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
    "orderRowsNode", 
})
@XmlRootElement(name = "associations")
public class AssociationsOrder {
    
    @XmlElement(name = "order_rows")
    private OrderRowsNode orderRowsNode;

    /**
     * @return the orderRowsNode
     */
    public OrderRowsNode getOrderRowsNode() {
        return orderRowsNode;
    }

    /**
     * @param orderRowsNode the orderRowsNode to set
     */
    public void setOrderRowsNode(OrderRowsNode orderRowsNode) {
        this.orderRowsNode = orderRowsNode;
    }
    
}
