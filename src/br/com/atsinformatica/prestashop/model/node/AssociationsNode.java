/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.node;

import br.com.atsinformatica.prestashop.model.list.Combinations;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author AlexsanderPimenta
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
    "categories",
    "combinations",
    "productOptionValues",    
    "stockAvailables",
    "images",
})
@XmlRootElement(name="associations")
public class AssociationsNode {
    
    @XmlElement(name = "categories")    
    private CategoriesNode categories;
    @XmlElement(name = "combinations")
    private CombinationsNode combinations;
    @XmlElement(name = "product_option_values")
    private ProductOptionValuesNode productOptionValues;
    @XmlElement(name = "images")
    private ImagesNode images;
    
    @XmlElement(name = "stock_availables")
    private StockAvailablesNode stockAvailables;
    /**
     * @return the categories
     */
    public CategoriesNode getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(CategoriesNode categories) {
        this.categories = categories;
    }

    /**
     * @return the stockAvailables
     */
    public StockAvailablesNode getStockAvailables() {
        return stockAvailables;
    }

    /**
     * @param stockAvailables the stockAvailables to set
     */
    public void setStockAvailables(StockAvailablesNode stockAvailables) {
        this.stockAvailables = stockAvailables;
    }

    /**
     * @return the combinations
     */
    public CombinationsNode getCombinations() {
        return combinations;
    }

    /**
     * @param combinations the combinations to set
     */
    public void setCombinations(CombinationsNode combinations) {
        this.combinations = combinations;
    }

    /**
     * @return the productOptionValues
     */
    public ProductOptionValuesNode getProductOptionValues() {
        return productOptionValues;
    }

    /**
     * @param productOptionValues the productOptionValues to set
     */
    public void setProductOptionValues(ProductOptionValuesNode productOptionValues) {
        this.productOptionValues = productOptionValues;
    }

    /**
     * @return the images
     */
    public ImagesNode getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(ImagesNode images) {
        this.images = images;
    }
    
}
