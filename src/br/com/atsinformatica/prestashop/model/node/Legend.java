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
@XmlType(name = "", propOrder = {
    "language"
})
@XmlRootElement(name="legend")
public class Legend {
    
    public Legend(){
        
    }
    
     public Legend(String legend){
        getLanguage().add(new Language(legend));
    }
    
    @XmlElement(required = true)
    protected List<Language> language;

    public List<Language> getLanguage() {
        if (language == null) {
            language = new ArrayList<Language>();
        }
        return this.language;
    }

    @Override
    public String toString() {
        return "Legend{" + "language=" + language + '}';
    }
    
    /**
     * Retorna String em do language 1
     * @return String default
     */
    public String getTextLanguage(){
        return language.get(0).getContent();
    }
    
}
