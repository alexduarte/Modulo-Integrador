/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.list;

import br.com.atsinformatica.prestashop.model.list.prestashop.AccessXMLAttribute;
import br.com.atsinformatica.prestashop.model.root.ProductOptionValue;
import java.util.List;
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
    "productOptionValues",
})
@XmlRootElement(name = "associoations")
public class Associations {
    
    @XmlElement(name = "product_option_values")
    private ProductOptionValues productOptionValues;

    /**
     * @return the productOptionValues
     */
    public ProductOptionValues getProductOptionValues() {
        return productOptionValues;
    }

    /**
     * @param productOptionValues the productOptionValues to set
     */
    public void setProductOptionValues(ProductOptionValues productOptionValues) {
        this.productOptionValues = productOptionValues;
    }

    
    
    
    
}
