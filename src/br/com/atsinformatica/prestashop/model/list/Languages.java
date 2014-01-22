/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.prestashop.model.list;

import br.com.atsinformatica.prestashop.api.AccessXMLAttribute;
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
@XmlType(name = "", propOrder = { "listLanguage" })
@XmlRootElement(name = "languages")
public class Languages {
    
	@XmlElement(name="language")
	protected List<AccessXMLAttribute> listLanguage;
        
//        @XmlElement(name="language")
//        protected AccessXMLAttribute language;

	public List<AccessXMLAttribute> getLanguage() {
		if (listLanguage == null) {
			listLanguage = new ArrayList<AccessXMLAttribute>();
		}
		return this.listLanguage;
	}

    public void setLanguage(List<AccessXMLAttribute> language) {
        this.listLanguage = language;
    }
}