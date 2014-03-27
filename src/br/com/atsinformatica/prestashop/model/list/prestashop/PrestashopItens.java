package br.com.atsinformatica.prestashop.model.list.prestashop;

import br.com.atsinformatica.prestashop.model.list.Categories;
import br.com.atsinformatica.prestashop.model.list.Orders;
import br.com.atsinformatica.prestashop.model.list.Images;
import br.com.atsinformatica.prestashop.model.list.ProductFeatures;
import br.com.atsinformatica.prestashop.model.list.Products;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "productFeatures",
    "products",
    "categories",
    "images",
    "orders",
})
@XmlRootElement(name = "prestashop")
public class PrestashopItens {

    @XmlAttribute(name = "xmlns:xlink", required = true)
    protected String xmlns = "http://www.w3.org/1999/xlink";
    
    @XmlElement(name = "product_features")
    protected ProductFeatures productFeatures;
    
    @XmlElement(name = "products")
    protected Products products;
    
    @XmlElement(name = "categories")
    protected Categories categories;
    
    @XmlElement(name = "images")
    private Images images;
    
    @XmlElement(name = "orders")
    protected Orders orders;    

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

    /**
     * @return the images
     */
    public Images getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(Images images) {
        this.images = images;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    
    
}
