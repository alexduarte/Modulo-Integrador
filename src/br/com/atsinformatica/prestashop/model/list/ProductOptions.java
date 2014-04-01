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
@XmlType(propOrder = {"productOption"})
@XmlRootElement(name = "product_options")
public class ProductOptions {

    @XmlElement(name = "product_options")
    protected List<AccessXMLAttribute> productOption;

    public List<AccessXMLAttribute> getProductOption() {
        if (productOption == null) {
            productOption = new ArrayList<AccessXMLAttribute>();
        }
        return this.productOption;
    }

    public void setProductOption(List<AccessXMLAttribute> productOption) {
        this.productOption = productOption;
    }
}
