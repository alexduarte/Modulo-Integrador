/*
 * To change this template, choose Tools | Templates
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
 * @author AlexsanderPimenta
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
    "id",
    "idProduct",
    "idProductAttribute",
    "idShop",
    "idShopGroup",
    "quantity",
    "dependsOnStock",
    "outOfStock",
})
@XmlRootElement(name = "stock_available")
public class StockAvailable {
    public static String URLSTOCKAVAILABLE = "stock_availables/";
 
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "id_product")
    private int idProduct;
    @XmlElement(name = "id_product_attribute")
    private int idProductAttribute;
    @XmlElement(name = "id_shop")
    private int idShop;
    @XmlElement(name = "id_shop_group")
    private int idShopGroup;
    @XmlElement(name = "quantity")
    private int quantity;
    @XmlElement(name = "depends_on_stock")
    private int dependsOnStock;
    @XmlElement(name = "out_of_stock")
    private int outOfStock;
    
    public StockAvailable(){
        this.idShop = 1;
        this.idShopGroup = 0;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idProduct
     */
    public int getIdProduct() {
        return idProduct;
    }

    /**
     * @param idProduct the idProduct to set
     */
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * @return the idProductAttribute
     */
    public int getIdProductAttribute() {
        return idProductAttribute;
    }

    /**
     * @param idProductAttribute the idProductAttribute to set
     */
    public void setIdProductAttribute(int idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
    }

    /**
     * @return the idShop
     */
    public int getIdShop() {
        return idShop;
    }

    /**
     * @param idShop the idShop to set
     */
    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    /**
     * @return the idShopGroup
     */
    public int getIdShopGroup() {
        return idShopGroup;
    }

    /**
     * @param idShopGroup the idShopGroup to set
     */
    public void setIdShopGroup(int idShopGroup) {
        this.idShopGroup = idShopGroup;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the dependsOnStock
     */
    public int getDependsOnStock() {
        return dependsOnStock;
    }

    /**
     * @param dependsOnStock the dependsOnStock to set
     */
    public void setDependsOnStock(int dependsOnStock) {
        this.dependsOnStock = dependsOnStock;
    }

    /**
     * @return the outOfStock
     */
    public int getOutOfStock() {
        return outOfStock;
    }

    /**
     * @param outOfStock the outOfStock to set
     */
    public void setOutOfStock(int outOfStock) {
        this.outOfStock = outOfStock;
    }
    
    
}
