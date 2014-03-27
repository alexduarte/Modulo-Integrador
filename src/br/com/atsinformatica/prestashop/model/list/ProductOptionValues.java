/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.list;

import br.com.atsinformatica.prestashop.model.list.prestashop.AccessXMLAttribute;
import java.util.ArrayList;
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
@XmlType(propOrder = {"productOptionValue"})
@XmlRootElement(name = "product_option_values")
public class ProductOptionValues {
    
    @XmlElement(name = "product_option_values")
    protected List<AccessXMLAttribute> productOptionValue;

    public List<AccessXMLAttribute> getProductOptionValue() {
        if (productOptionValue == null) {
            productOptionValue = new ArrayList<AccessXMLAttribute>();
        }
        return this.productOptionValue;
    }

    public void setProductOptionValue(List<AccessXMLAttribute> productOptionValue) {
        this.productOptionValue = productOptionValue;
    }
    
}
