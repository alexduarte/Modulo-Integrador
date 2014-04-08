/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.node;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author AlexsanderPimenta
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
    "prodOptionsValues",
})
@XmlRootElement(name = "product_option_values")
public class ProductOptionValuesNode {
    
    @XmlAttribute(name = "node_type")
    protected String nodeType = "product_options_values";    
    @XmlElement(name = "product_options_values")
    private List<ProductOptionsValuesNode> prodOptionsValues;

    /**
     * @return the prodOptionsValues
     */
    public List<ProductOptionsValuesNode> getProdOptionsValues() {
        if(prodOptionsValues==null){
            prodOptionsValues = new ArrayList<>();
        }
        return prodOptionsValues;
    }

    /**
     * @param prodOptionsValues the prodOptionsValues to set
     */
    public void setProdOptionsValues(List<ProductOptionsValuesNode> prodOptionsValues) {
        this.prodOptionsValues = prodOptionsValues;
    }
    
}
