package br.com.atsinformatica.prestashop.model.root;



import javax.xml.bind.annotation.*;

/**
 *
 * @author ricardosilva
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
    "productFeature",
    "category",
    "product",
    "image",
    "combination",
    "productOption",
    "productOptionValue",    
    "stockAvailable",  
})
@XmlRootElement(name = "prestashop")
public class Prestashop{
    
    @XmlAttribute(name = "xmlns:xlink", required = true)
    protected String xmlns = "http://www.w3.org/1999/xlink";
    
    @XmlElement(name = "product_feature",required = true)
    protected ProductFeature productFeature;
    
    @XmlElement(name = "category",required = true)
    protected Category category;
    
    @XmlElement(name = "product",required = true)
    protected Product product;
    
    @XmlElement(name = "image",required = true)
    private Image image;
    
    @XmlElement(name = "combination")
    private Combination combination;
    
    @XmlElement(name = "product_option")
    private ProductOption productOption;
    
    @XmlElement(name = "product_option_value")
    private ProductOptionValue productOptionValue;
    
    @XmlElement(name = "stock_available")
    private StockAvailable stockAvailable;
    
//    @XmlElement(name = "content",required = true)
//    private byte[] content;

    public ProductFeature getProductFeature() {
        return productFeature;
    }
    
    public void setProductFeature(ProductFeature value) {
        this.productFeature = value;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Prestashop{" + "xmlns=" + xmlns + ", productFeature=" + productFeature + ", category=" + category + ", product=" + product + '}';
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }

//    /**
//     * @return the content
//     */
//    public byte[] getContent() {
//        return content;
//    }
//
//    /**
//     * @param content the content to set
//     */
//    public void setContent(byte[] content) {
//        this.content = content;
//    }

    /**
     * @return the combination
     */
    public Combination getCombination() {
        return combination;
    }

    /**
     * @param combination the combination to set
     */
    public void setCombination(Combination combination) {
        this.combination = combination;
    }

    /**
     * @return the productOption
     */
    public ProductOption getProductOption() {
        return productOption;
    }

    /**
     * @param productOption the productOption to set
     */
    public void setProductOption(ProductOption productOption) {
        this.productOption = productOption;
    }

    /**
     * @return the productOptionValue
     */
    public ProductOptionValue getProductOptionValue() {
        return productOptionValue;
    }

    /**
     * @param productOptionValue the productOptionValue to set
     */
    public void setProductOptionValue(ProductOptionValue productOptionValue) {
        this.productOptionValue = productOptionValue;
    }

    /**
     * @return the stockAvailable
     */
    public StockAvailable getStockAvailable() {
        return stockAvailable;
    }

    /**
     * @param stockAvailable the stockAvailable to set
     */
    public void setStockAvailable(StockAvailable stockAvailable) {
        this.stockAvailable = stockAvailable;
    }
}

