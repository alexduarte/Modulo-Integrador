package br.com.atsinformatica.prestashop.model.category;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ricardosilva
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        propOrder = {"category"})
@XmlRootElement(name = "prestashop")
public class Prestashop {

    @XmlElement(name = "category", required = true)
    protected Category category;

    public Prestashop(Category category) {
        this.category = category;
    }

    public Prestashop() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
