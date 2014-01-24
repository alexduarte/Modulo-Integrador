package br.com.atsinformatica.prestashop.list;

import br.com.atsinformatica.prestashop.api.AccessXMLAttribute;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "productFeature" })
@XmlRootElement(name = "product_features")
public class ProductFeatures {

	@XmlElement(name="product_feature")
	protected List<AccessXMLAttribute> productFeature;

	public List<AccessXMLAttribute> getProductFeature() {
		if (productFeature == null) {
			productFeature = new ArrayList<AccessXMLAttribute>();
		}
		return this.productFeature;
	}

    public void setProductFeature(List<AccessXMLAttribute> productFeature) {
        this.productFeature = productFeature;
    }
        

}
