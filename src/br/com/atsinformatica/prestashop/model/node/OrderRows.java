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
    "id",
    "productId", //Cod do Produto
    "productAttributeId",
    "productQuantity", //Quantidade
    "productName", //Nome produto
    "productReference", //Referencia do produto
    "unitPriceTaxIncl" //Preço do produto com imposto incluido
})
@XmlRootElement(name = "order_row")

public class OrderRows {

    @XmlElement(name = "id", required = true)
    private int id;

    @XmlElement(name = "product_id", required = true)
    private int productId;

    @XmlElement(name = "product_attribute_id")
    private int productAttributeId;

    @XmlElement(name = "product_quantity")
    private int productQuantity;

    @XmlElement(name = "product_name")
    private String productName;

    @XmlElement(name = "product_reference")
    private String productReference;

    @XmlElement(name = "unit_price_tax_incl")
    private double unitPriceTaxIncl;

    public OrderRows() {
    }

    public OrderRows(int id, int productId, int productAttributeId, int productQuantity, String productName, String productReference, double unitPriceTaxIncl) {
        this.id = id;
        this.productId = productId;
        this.productAttributeId = productAttributeId;
        this.productQuantity = productQuantity;
        this.productName = productName;
        this.productReference = productReference;
        this.unitPriceTaxIncl = unitPriceTaxIncl;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductAttributeId() {
        return productAttributeId;
    }

    public void setProductAttributeId(int productAttributeId) {
        this.productAttributeId = productAttributeId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductReference() {
        return productReference;
    }

    public void setProductReference(String productReference) {
        this.productReference = productReference;
    }

    public double getUnitPriceTaxIncl() {
        return unitPriceTaxIncl;
    }

    public void setUnitPriceTaxIncl(double unitPriceTaxIncl) {
        this.unitPriceTaxIncl = unitPriceTaxIncl;
    }
    
    
}
