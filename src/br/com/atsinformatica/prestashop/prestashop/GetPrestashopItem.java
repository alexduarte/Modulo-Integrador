package br.com.atsinformatica.prestashop.prestashop;

import br.com.atsinformatica.prestashop.model.product_feature.ProductFeature;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
    "productFeature",

})
@XmlRootElement(name = "prestashop")
public class GetPrestashopItem{

    @XmlElement(name="product_feature")
    protected ProductFeature productFeature;
    
    public ProductFeature getProductFeature() {
        return productFeature;
    }

    public void setProductFeature(ProductFeature productFeature) {
        this.productFeature = productFeature;
    }  
}
