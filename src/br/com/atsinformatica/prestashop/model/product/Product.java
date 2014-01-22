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


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}id"/>
 *         &lt;element ref="{}new"/>
 *         &lt;element ref="{}type"/>
 *         &lt;element ref="{}supplier_reference"/>
 *         &lt;element ref="{}location"/>
 *         &lt;element ref="{}upc"/>
 *         &lt;element ref="{}price"/>
 *         &lt;element ref="{}unity"/>
 *         &lt;element ref="{}redirect_type"/>
 *         &lt;element ref="{}name"/>
 *         &lt;element ref="{}description"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://prestashop/api/products/id", name = "", propOrder = {
    "id",
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
    @XmlElement(name = "new", required = true)
    protected String _new;
    @XmlElement(required = true)
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
