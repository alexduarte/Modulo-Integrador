/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.product_feature;

/**
 *
 * @author ricardosilva
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ricardosilva
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
    "productFeature"
})
@XmlRootElement(name = "prestashop")
public class PrestashopProductFeature {

    @XmlElement(name = "product_feature", required = true)
    protected ProductFeature productFeature;

    public PrestashopProductFeature(ProductFeature productFeature) {
        this.productFeature = productFeature;
    }

    public PrestashopProductFeature() {
    }

    public ProductFeature getProductFeature() {
        return productFeature;
    }

    public void setProductFeature(ProductFeature value) {
        this.productFeature = value;
    }    
}
