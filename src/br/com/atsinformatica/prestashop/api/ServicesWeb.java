package br.com.atsinformatica.prestashop.api;

import br.com.atsinformatica.prestashop.model.list.ProductFeatures;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "productFeatures",
})
@XmlRootElement(name = "prestashop")
public class ServicesWeb{

//    @XmlElement
//    protected Products products;
    
    @XmlElement(name="product_features")
    protected ProductFeatures productFeatures;

//    @XmlElement(name="languages")
//    protected Languages languages;

    
    /**
     *
     * @return
     */
//    public Languages getLanguages() {
//        return languages;
//    }
//
//    /**
//     *
//     * @param languages
//     */
//    public void setLanguages(Languages languages) {
//        this.languages = languages;
//    }
//    
//	//==========PRODUCTS=========================//
//    /**
//     * Obtiene el valor de la propiedad products.
//     * 
//     * @return
//     *     possible object is
//     *     {@link Products }
//     *     
//     */
//    public Products getProducts() {
//        return products;
//    }
//
//    /**
//     * Define el valor de la propiedad products.
//     * 
//     * @param value
//     *     allowed object is
//     *     {@link Products }
//     *     
//     */
//    public void setProducts(Products value) {
//        this.products = value;
//    }

  //==========PRODUCT_SUPPLIERS=========================//
    /**
     * Obtiene el valor de la propiedad Product_suppliers.
     * 
     * @return
     *     possible object is
     *     {@link Product_suppliers }
     *     
     */
    public ProductFeatures getProductFeatures() {
		return productFeatures;
	}

    /**
     * Define el valor de la propiedad Product_suppliers.
     * 
     *     
     * @param productFeatures
     */
    public void setProductFeatures(ProductFeatures productFeatures) {
		this.productFeatures = productFeatures;
	}
    
    
}
