package br.com.atsinformatica.prestashop.api;

import br.com.atsinformatica.prestashop.list.Categories;
import br.com.atsinformatica.prestashop.list.ProductFeatures;
import br.com.atsinformatica.prestashop.list.Products;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "productFeatures",
    "products",
    "categories",
})
@XmlRootElement(name = "prestashop")
public class PrestashopItens {

    @XmlElement(name = "product_features")
    protected ProductFeatures productFeatures;
    
    @XmlElement(name = "products")
    protected Products products;
    
    @XmlElement(name = "categories")
    protected Categories categories;

    //----------Getters e Setters-----------------//
    
    public ProductFeatures getProductFeatures() {
        return productFeatures;
    }

    public void setProductFeatures(ProductFeatures productFeatures) {
        this.productFeatures = productFeatures;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

}
