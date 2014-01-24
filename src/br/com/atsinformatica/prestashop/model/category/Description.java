/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.prestashop.model.category;

import br.com.atsinformatica.prestashop.model.product_feature.Language;
import java.util.ArrayList;
import java.util.List;
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
@XmlType(name = "", propOrder = {
    "language"
})
@XmlRootElement(name = "description")
public class Description {

    @XmlElement(required = true)
    protected List<Language> language;

    public List<Language> getLanguage() {
        if (language == null) {
            language = new ArrayList<Language>();
        }
        return this.language;
    }
    
    /**
     * Retorna String em do language 1
     * @return String default
     */
    public String getTextDescription(){
        return language.get(0).getContent();
    }
    
    /**
     * Retorna language do item selecionado se existente
     * @param index
     * @return
     */
    public String getTextDescription(int index){
        return language.get(index).getContent();
    }
}

