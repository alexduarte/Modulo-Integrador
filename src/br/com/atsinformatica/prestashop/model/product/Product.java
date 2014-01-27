//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b01 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2013.11.11 a las 08:18:12 PM CET 
//


package br.com.atsinformatica.prestashop.model.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://localhost/prestashop/api/products/id", name = "", propOrder = {
    "id",
    "idCategoryDefault",
    "idShopDefault",
    "idTaxRulesGroup",
    "onSale",
    "ecotax",
    "onlineOnly",
    "quantity",
    "minimal_quantity",
    "unitPriceRatio",
    "wholesalePrice",
    "reference",
    "width",
    "height",
    "depth",
    "weight",
    "out_of_stock",
    "quantity_discount",
    "customizable",
    "uploadableFiles",
    "_new",
    "type",
    "supplierReference",
    "location",
    "upc",
    "price",
    "unity",
    "redirectType",
    "name",
    "description",
})
@XmlRootElement(name = "product")
public class Product {
	
    @XmlElement(name="id", required = true)
    protected Id id;
    
    @XmlElement(name="id_category_default")
    protected Integer idCategoryDefault;
    
    @XmlElement(name = "new", required = true)
    protected String _new;
      
    @XmlElement(name="reference")
    protected String reference;

    public Integer getIdCategoryDefault() {
        return idCategoryDefault;
    }

    public void setIdCategoryDefault(Integer idCategoryDefault) {
        this.idCategoryDefault = idCategoryDefault;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getIdShopDefault() {
        return idShopDefault;
    }

    public void setIdShopDefault(Integer idShopDefault) {
        this.idShopDefault = idShopDefault;
    }

    public Integer getIdTaxRulesGroup() {
        return idTaxRulesGroup;
    }

    public void setIdTaxRulesGroup(Integer idTaxRulesGroup) {
        this.idTaxRulesGroup = idTaxRulesGroup;
    }

    public Integer getOnSale() {
        return onSale;
    }

    public void setOnSale(Integer onSale) {
        this.onSale = onSale;
    }

    public Integer getOnlineOnly() {
        return onlineOnly;
    }

    public void setOnlineOnly(Integer onlineOnly) {
        this.onlineOnly = onlineOnly;
    }

    public Integer getEcotax() {
        return ecotax;
    }

    public void setEcotax(Integer ecotax) {
        this.ecotax = ecotax;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getMinimalQuantity() {
        return minimalQuantity;
    }

    public void setMinimalQuantity(Integer minimalQuantity) {
        this.minimalQuantity = minimalQuantity;
    }

    public Integer getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(Integer wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public Integer getUnitPriceRatio() {
        return unitPriceRatio;
    }

    public void setUnitPriceRatio(Integer unitPriceRatio) {
        this.unitPriceRatio = unitPriceRatio;
    }

    public Integer getAdditionalShippingCost() {
        return additionalShippingCost;
    }

    public void setAdditionalShippingCost(Integer additionalShippingCost) {
        this.additionalShippingCost = additionalShippingCost;
    }

    public Integer getOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(Integer outOfStock) {
        this.outOfStock = outOfStock;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeigth() {
        return heigth;
    }

    public void setHeigth(Integer heigth) {
        this.heigth = heigth;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getQuantityDiscount() {
        return quantityDiscount;
    }

    public void setQuantityDiscount(Integer quantityDiscount) {
        this.quantityDiscount = quantityDiscount;
    }

    public Integer getCustomizable() {
        return customizable;
    }

    public void setCustomizable(Integer customizable) {
        this.customizable = customizable;
    }

    public Integer getUploadableFiles() {
        return uploadableFiles;
    }

    public void setUploadableFiles(Integer uploadableFiles) {
        this.uploadableFiles = uploadableFiles;
    }
    
    @XmlElement(name="id_shop_default")
    protected Integer idShopDefault;
    
    @XmlElement(name="id_tax_rules_group")
    protected Integer idTaxRulesGroup;
    
    @XmlElement(name="on_sale")
    protected Integer onSale;
    
    @XmlElement(name="online_only")
    protected Integer onlineOnly;
    
    @XmlElement(name="ecotax")
    protected Integer ecotax;
    
    @XmlElement(name="quantity")
    protected Integer quantity;
    
    @XmlElement(name="minimal_quantity")
    protected Integer minimalQuantity;
    
    @XmlElement(name="wholesale_price")
    protected Integer wholesalePrice;
    
    @XmlElement(name="unit_price_ratio")
    protected Integer unitPriceRatio;
    
    @XmlElement(name="additional_shipping_cost")
    protected Integer additionalShippingCost;
    
    @XmlElement(name="outOfStock")
    protected Integer outOfStock;
    
    @XmlElement(name="width")
    protected Integer width;
    
    @XmlElement(name="heigth")
    protected Integer heigth;
    
    @XmlElement(name="depth")
    protected Integer depth;
    
    @XmlElement(name="weight")
    protected Integer weight;
    
    @XmlElement(name="quantity_discount")
    protected Integer quantityDiscount;
    
    @XmlElement(name="customizable")
    protected Integer customizable;
    
    @XmlElement(name="uploadable_files")
    protected Integer uploadableFiles;
    
    protected Type type;
    
    @XmlElement(name = "supplier_reference", required = true)
    protected String supplierReference;
    
    @XmlElement(required = true)
    protected String location;
    
    @XmlElement(required = true)
    protected String upc;
    
    @XmlElement(required = true)
    protected Price price;
    
    @XmlElement(required = true)
    protected String unity;
    
    @XmlElement(name = "redirect_type", required = true)
    protected String redirectType;
    
    @XmlElement(required = true)
    protected Name name;
    
    @XmlElement(required = true)
    protected Description description;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link Id }
     *     
     */
    public Id getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Id }
     *     
     */
    public void setId(Id value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad new.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNew() {
        return _new;
    }

    /**
     * Define el valor de la propiedad new.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNew(String value) {
        this._new = value;
    }

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link Type }
     *     
     */
    public Type getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link Type }
     *     
     */
    public void setType(Type value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad supplierReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierReference() {
        return supplierReference;
    }

    /**
     * Define el valor de la propiedad supplierReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierReference(String value) {
        this.supplierReference = value;
    }

    /**
     * Obtiene el valor de la propiedad location.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Define el valor de la propiedad location.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Obtiene el valor de la propiedad upc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpc() {
        return upc;
    }

    /**
     * Define el valor de la propiedad upc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpc(String value) {
        this.upc = value;
    }

    /**
     * Obtiene el valor de la propiedad price.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getPrice() {
        return price;
    }

    /**
     * Define el valor de la propiedad price.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setPrice(Price value) {
        this.price = value;
    }

    /**
     * Obtiene el valor de la propiedad unity.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnity() {
        return unity;
    }

    /**
     * Define el valor de la propiedad unity.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnity(String value) {
        this.unity = value;
    }

    /**
     * Obtiene el valor de la propiedad redirectType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRedirectType() {
        return redirectType;
    }

    /**
     * Define el valor de la propiedad redirectType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRedirectType(String value) {
        this.redirectType = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link Name }
     *     
     */
    public Name getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link Name }
     *     
     */
    public void setName(Name value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link Description }
     *     
     */
    public Description getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link Description }
     *     
     */
    public void setDescription(Description value) {
        this.description = value;
    }

}
