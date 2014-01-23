package br.com.atsinformatica.prestashop.api;

import br.com.atsinformatica.prestashop.list.ProductFeatures;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "productFeatures",
    "products",
    "categories",})
@XmlRootElement(name = "prestashop")
public class GetListItens {

    @XmlElement(name = "product_features")
    protected ProductFeatures productFeatures;
    
    @XmlElement(name = "products")
    protected ProductFeatures products;
    
    @XmlElement(name = "categories")
    protected ProductFeatures categories;

    //----------Getters e Setters-----------------//
    
    public ProductFeatures getProductFeatures() {
        return productFeatures;
    }

    public void setProductFeatures(ProductFeatures productFeatures) {
        this.productFeatures = productFeatures;
    }

    public ProductFeatures getProducts() {
        return products;
    }

    public void setProducts(ProductFeatures products) {
        this.products = products;
    }

    public ProductFeatures getCategories() {
        return categories;
    }

    public void setCategories(ProductFeatures categories) {
        this.categories = categories;
    }

}
