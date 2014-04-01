package br.com.atsinformatica.prestashop.model.list.prestashop;

import br.com.atsinformatica.prestashop.model.list.StockAvailables;
import br.com.atsinformatica.prestashop.model.list.Categories;
import br.com.atsinformatica.prestashop.model.list.Combinations;
import br.com.atsinformatica.prestashop.model.list.Images;
import br.com.atsinformatica.prestashop.model.list.ProductFeatures;
import br.com.atsinformatica.prestashop.model.list.ProductOptionValues;
import br.com.atsinformatica.prestashop.model.list.ProductOptions;
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
    "combinations",
    "images",
    "productOptions",
    "productOptionValues",
    "stockAvailables",
    
    
    
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
    
    @XmlElement(name = "combinations")
    private Combinations combinations;
    
    @XmlElement(name = "stock_availables")
    private StockAvailables stockAvailables;
    
    @XmlElement(name = "product_options")
    private ProductOptions productOptions;
    
    @XmlElement(name = "product_option_values")
    private ProductOptionValues productOptionValues;
    

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

    /**
     * @return the combinations
     */
    public Combinations getCombinations() {
        return combinations;
    }

    /**
     * @param combinations the combinations to set
     */
    public void setCombinations(Combinations combinations) {
        this.combinations = combinations;
    }

    /**
     * @return the stockAvailables
     */
    public StockAvailables getStockAvailables() {
        return stockAvailables;
    }

    /**
     * @param stockAvailables the stockAvailables to set
     */
    public void setStockAvailables(StockAvailables stockAvailables) {
        this.stockAvailables = stockAvailables;
    }

    /**
     * @return the productOptions
     */
    public ProductOptions getProductOptions() {
        return productOptions;
    }

    /**
     * @param productOptions the productOptions to set
     */
    public void setProductOptions(ProductOptions productOptions) {
        this.productOptions = productOptions;
    }

    /**
     * @return the productOptionValues
     */
    public ProductOptionValues getProductOptionValues() {
        return productOptionValues;
    }

    /**
     * @param productOptionValues the productOptionValues to set
     */
    public void setProductOptionValues(ProductOptionValues productOptionValues) {
        this.productOptionValues = productOptionValues;
    }

}
