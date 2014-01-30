package br.com.atsinformatica.prestashop.model.list;

import br.com.atsinformatica.prestashop.model.list.prestashop.AccessXMLAttribute;
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
@XmlType(name = "", propOrder = { "category" })
@XmlRootElement(name = "categories")
public class Categories {
    
	@XmlElement(name="category")
	protected List<AccessXMLAttribute> category;

	public List<AccessXMLAttribute> getCategory() {
		if (category == null) {
			category = new ArrayList<AccessXMLAttribute>();
		}
		return this.category;
	}

    public void setCategory(List<AccessXMLAttribute> listCategory) {
        this.category = listCategory;
    }
}