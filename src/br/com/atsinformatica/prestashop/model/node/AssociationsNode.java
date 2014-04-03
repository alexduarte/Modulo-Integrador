/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.node;

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
    "categories", 
    
})
@XmlRootElement(name="associations")
public class AssociationsNode {
    
    @XmlElement(name = "categories")    
    private CategoriesNode categories;

    /**
     * @return the categories
     */
    public CategoriesNode getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(CategoriesNode categories) {
        this.categories = categories;
    }
    
}
