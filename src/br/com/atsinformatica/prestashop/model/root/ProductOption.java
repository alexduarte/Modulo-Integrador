/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.root;

import br.com.atsinformatica.prestashop.model.node.Name;
import br.com.atsinformatica.prestashop.model.node.PublicName;
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
    "isColorGroup",
    "groupType",
    "position",
    "name",
    "publicName",
})
@XmlRootElement(name = "product_option")
public class ProductOption {
    public static String URLPRODUCTOPTIONS = "product_options/";
    @XmlElement(name = "id")
    private String id;
    @XmlElement(name = "is_color_group")
    private int isColorGroup;
    @XmlElement(name = "group_type")
    private String groupType;
    @XmlElement(name = "position")
    private int position;
    @XmlElement(name = "name")
    private Name name;
    @XmlElement(name="public_name")
    private PublicName publicName;


    public ProductOption() {
        this.groupType = "select";
    }

    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the isColorGroup
     */
    public int getIsColorGroup() {
        return isColorGroup;
    }

    /**
     * @param isColorGroup the isColorGroup to set
     */
    public void setIsColorGroup(int isColorGroup) {
        this.isColorGroup = isColorGroup;
    }

    /**
     * @return the groupType
     */
    public String getGroupType() {
        return groupType;
    }

    /**
     * @param groupType the groupType to set
     */
    public void setGroupType(String groupType) {
        this.groupType = groupType;
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

    /**
     * @return the publicName
     */
    public PublicName getPublicName() {
        return publicName;
    }

    /**
     * @param publicName the publicName to set
     */
    public void setPublicName(PublicName publicName) {
        this.publicName = publicName;
    }
    
    
    
}
