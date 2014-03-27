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
@XmlRootElement(name="meta_keywords")
public class MetaKeyWord {
    
    public MetaKeyWord(){
        
    }
    
    public MetaKeyWord(String metaKeyWord){
        getLanguage().add(new Language(metaKeyWord));
    }
    
    public String getMetaKeyWord(){
        return getLanguage().get(0).getContent();      
    }

    @XmlElement(required = true)
    protected List<Language> language;

    public List<Language> getLanguage() {
        if (language == null) {
            language = new ArrayList<Language>();
        }
        return this.language;
    }
    
}
