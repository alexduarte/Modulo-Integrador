package br.com.atsinformatica.prestashop.model.product_feature;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author ricardosilva
 */
@XmlRootElement(name = "language", namespace = "http://www.w3.org/1999/xlink")
@XmlAccessorType(XmlAccessType.FIELD)

public class Language {
    
    @XmlValue
    protected String content;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlAttribute(name = "xlink:href", required = true)
    protected String href ="http://localhost/prestashop/api/languages/:id";

    public Language() {
        this.href = this.href.replace(":id",String.valueOf(1));   
    }
    
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.href = this.href.replace(":id", id);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Language{" + "content=" + content +", id=" + id + ", href=" + href +'}';
    }
}
