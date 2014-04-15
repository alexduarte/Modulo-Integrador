/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.node;

import java.util.ArrayList;
import java.util.List;
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
    "language",
})
@XmlRootElement(name = "meta_title")
public class MetaTitle {
    
    @XmlElement(name = "language")
    private List<Language> language;

    /**
     * @return the language
     */
    public List<Language> getLanguage() {
        if(language == null){
            language = new ArrayList<>();
        }
        return language;
    }
    
    /**
     * @param language the language to set
     */
    public void setLanguage(List<Language> language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "MetaTitle{" + "language=" + language + '}';
    }
    
     /**
     * Retorna String em do language 1
     * @return String default
     */
    public String getTextMetaTitle(){
        return language.get(0).getContent();
    }
    
}
