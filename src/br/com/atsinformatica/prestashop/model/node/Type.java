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



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "type")
public class Type {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "not_filterable", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String notFilterable;

    public Type() {
        content = "simple";
    }

    
    public String getContent() {
        return content;
    }


    public void setContent(String value) {
        this.content = value;
    }

   
    public String getNotFilterable() {
        return notFilterable;
    }

    public void setNotFilterable(String value) {
        this.notFilterable = value;
    }

}
