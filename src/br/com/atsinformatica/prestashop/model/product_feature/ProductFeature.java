/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.prestashop.model.product_feature;

import br.com.atsinformatica.prestashop.model.product_feature.Name;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ricardosilva
 */
@XmlRootElement(name = "product_feature")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "product_feature",
        propOrder = {"id","position","name"}
)
public class ProductFeature {
    
    @XmlElement(name = "id")
    private String id;
 
    @XmlElement(name = "position")
    private String position;
 
    @XmlElement(name = "name")
    private Name name;
 
    //Gerar métodos get/set
        public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductFeature{" + "id=" + id + ", position=" + position + ", name=" + name + '}';
    }
}
