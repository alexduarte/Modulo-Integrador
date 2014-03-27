/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.root;

import br.com.atsinformatica.prestashop.model.node.Ecotax;
import br.com.atsinformatica.prestashop.model.node.Price;
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
    "location",
    "ean13",
    "upc",
    "quantity",
    "reference",
    "supplierReference",
    "wholeSalePrice",
    "price",
    "ecotax",
    "weight",
    "unitPriceImpact",
    "minalQuantity",
    "defaultOn",
    "availableDate",
        
})
@XmlRootElement(name = "combination")
public class Combination {
    public static String URLCOMBINATION = "combinations/";
    @XmlElement(name = "id")    
    private int id;
    @XmlElement(name = "id_product")
    private int idProduct;
    @XmlElement(name = "location")
    private String location;
    @XmlElement(name = "ean13")
    private String ean13;
    @XmlElement(name = "upc")
    private String upc;
    @XmlElement(name = "quantity")
    private int quantity;
    @XmlElement(name = "reference")
    private String reference;
    @XmlElement(name = "supplier_reference")
    private String suplierReference;
    @XmlElement(name = "wholesale_price")
    private String wholeSalePrice;
    @XmlElement(name = "price")
    private Price price;
    @XmlElement(name = "ecotax")
    private Ecotax ecotax;
    @XmlElement(name = "weight")
    private String weight;
    @XmlElement(name = "unit_price_impact")
    private String unitPriceImpact;
    @XmlElement(name = "minimal_quantity")
    private int minimalQuantity;
    @XmlElement(name = "default_on")
    private String defaultOn;
    @XmlElement(name = "available_date")
    private String availableDate;

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
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the ean13
     */
    public String getEan13() {
        return ean13;
    }

    /**
     * @param ean13 the ean13 to set
     */
    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    /**
     * @return the upc
     */
    public String getUpc() {
        return upc;
    }

    /**
     * @param upc the upc to set
     */
    public void setUpc(String upc) {
        this.upc = upc;
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
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return the suplierReference
     */
    public String getSuplierReference() {
        return suplierReference;
    }

    /**
     * @param suplierReference the suplierReference to set
     */
    public void setSuplierReference(String suplierReference) {
        this.suplierReference = suplierReference;
    }

    /**
     * @return the wholeSalePrice
     */
    public String getWholeSalePrice() {
        return wholeSalePrice;
    }

    /**
     * @param wholeSalePrice the wholeSalePrice to set
     */
    public void setWholeSalePrice(String wholeSalePrice) {
        this.wholeSalePrice = wholeSalePrice;
    }

    /**
     * @return the price
     */
    public Price getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Price price) {
        this.price = price;
    }

    /**
     * @return the ecotax
     */
    public Ecotax getEcotax() {
        return ecotax;
    }

    /**
     * @param ecotax the ecotax to set
     */
    public void setEcotax(Ecotax ecotax) {
        this.ecotax = ecotax;
    }

    /**
     * @return the weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * @return the unitPriceImpact
     */
    public String getUnitPriceImpact() {
        return unitPriceImpact;
    }

    /**
     * @param unitPriceImpact the unitPriceImpact to set
     */
    public void setUnitPriceImpact(String unitPriceImpact) {
        this.unitPriceImpact = unitPriceImpact;
    }

    /**
     * @return the minimalQuantity
     */
    public int getMinimalQuantity() {
        return minimalQuantity;
    }

    /**
     * @param minimalQuantity the minimalQuantity to set
     */
    public void setMinimalQuantity(int minimalQuantity) {
        this.minimalQuantity = minimalQuantity;
    }

    /**
     * @return the defaultOn
     */
    public String getDefaultOn() {
        return defaultOn;
    }

    /**
     * @param defaultOn the defaultOn to set
     */
    public void setDefaultOn(String defaultOn) {
        this.defaultOn = defaultOn;
    }

    /**
     * @return the availableDate
     */
    public String getAvailableDate() {
        return availableDate;
    }

    /**
     * @param availableDate the availableDate to set
     */
    public void setAvailableDate(String availableDate) {
        this.availableDate = availableDate;
    }
    
    
}
