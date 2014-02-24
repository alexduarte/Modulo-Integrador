/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.prestashop.model.node;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author ricardosilva
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "position_in_category")
public class PositionInCategory {

    @XmlValue
    protected Integer content;
    @XmlAttribute(name = "not_filterable", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String notFilterable;

    public PositionInCategory() {
        content = 0;
    }
  
    public Integer getContent() {
        return content;
    }


    public void setContent(Integer value) {
        this.content = value;
    }

    public String getNotFilterable() {
        return notFilterable;
    }

    public void setNotFilterable(String value) {
        this.notFilterable = value;
    }
}
