/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.prestashop.list;

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
@XmlType(name = "", propOrder = { "listCategory" })
@XmlRootElement(name = "categories")
public class Categories {
    
	@XmlElement(name="category")
	protected List<AccessXMLAttribute> listCategory;
        
//        @XmlElement(name="language")
//        protected AccessXMLAttribute language;

	public List<AccessXMLAttribute> getCategory() {
		if (listCategory == null) {
			listCategory = new ArrayList<AccessXMLAttribute>();
		}
		return this.listCategory;
	}

    public void setCategory(List<AccessXMLAttribute> listCategory) {
        this.listCategory = listCategory;
    }
}