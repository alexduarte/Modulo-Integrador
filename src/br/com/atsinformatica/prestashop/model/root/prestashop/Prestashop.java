package br.com.atsinformatica.prestashop.model.root.prestashop;



import br.com.atsinformatica.prestashop.model.root.*;
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
}

