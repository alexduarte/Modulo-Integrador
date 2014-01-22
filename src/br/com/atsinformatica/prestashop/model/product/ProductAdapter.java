package br.com.atsinformatica.prestashop.model.product;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;


public class ProductAdapter extends XmlAdapter <String, Product> {
	
	private Map<String, Product> products= new HashMap<String, Product>();

	@Override
	public Product unmarshal(String id) throws Exception {
		// TODO Auto-generated method stub
		return products.get(id);
	}

	@Override
	public String marshal(Product v) throws Exception {
		// TODO Auto-generated method stub
		return v.getId().getContent();
	}
}
