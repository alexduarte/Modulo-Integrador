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
    "category",
})
@XmlRootElement(name="categories")
public class CategoriesNode {
    
    @XmlAttribute(name = "node_type")
    protected String nodeType = "category";    
    @XmlElement(name = "category")
    private List<CategoryNode> category;
    
    public CategoriesNode(){
        this.nodeType = "category";
    }

    /**
     * @return the category
     */
    public List<CategoryNode> getCategory() {
        if(category == null){
            category = new ArrayList<>();
        }
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(List<CategoryNode> category) {
        this.category = category;
    }
    
}
