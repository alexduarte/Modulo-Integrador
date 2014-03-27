/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.root;

import br.com.atsinformatica.prestashop.model.node.Name;
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
    "id",
    "idAttributeGroup",
    "position",
    "name",
})
@XmlRootElement(name = "product_option_value")
public class ProductOptionValue {
    public static String URLPRODUCTOPTIONVALUE = "product_option_values/";    
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "id_attribute_group")
    private int idAttributeGroup;
    @XmlElement(name = "position")
    private int position;
    @XmlElement(name = "name")
    private Name name;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idAttributeGroup
     */
    public int getIdAttributeGroup() {
        return idAttributeGroup;
    }

    /**
     * @param idAttributeGroup the idAttributeGroup to set
     */
    public void setIdAttributeGroup(int idAttributeGroup) {
        this.idAttributeGroup = idAttributeGroup;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @return the name
     */
    public Name getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(Name name) {
        this.name = name;
    }
    
    
}
