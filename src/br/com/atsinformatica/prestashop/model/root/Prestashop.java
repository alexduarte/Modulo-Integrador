package br.com.atsinformatica.prestashop.model.root;

import br.com.atsinformatica.prestashop.model.node.Content;
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
    "content",
    "customer",
    "address",
    "order",
    "cpfmodule_data",})
@XmlRootElement(name = "prestashop")
public class Prestashop {

    @XmlAttribute(name = "xmlns:xlink", required = true)
    protected String xmlns = "http://www.w3.org/1999/xlink";

    @XmlElement(name = "product_feature", required = true)
    protected ProductFeature productFeature;

    @XmlElement(name = "category", required = true)
    protected Category category;

    @XmlElement(name = "product", required = true)
    protected Product product;

    @XmlElement(name = "image", required = true)
    private Image image;

    @XmlElement(name = "content", required = true)
    private byte[] content;

    @XmlElement(name = "customer", required = true)
    protected Customer customer;

    @XmlElement(name = "address", required = true)
    protected Address address;
    @XmlElement(name = "order", required = true)
    protected Order order;

    @XmlElement(name = "cpfmodule_data", required = true)
    protected CPFModuleData cpfmodule_data;

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

    /**
     * @return the content
     */
    public byte[] getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(byte[] content) {
        this.content = content;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public CPFModuleData getCpfmodule_data() {
        return cpfmodule_data;
    }

    public void setCpfmodule_data(CPFModuleData cpfmodule_data) {
        this.cpfmodule_data = cpfmodule_data;
    }

}
