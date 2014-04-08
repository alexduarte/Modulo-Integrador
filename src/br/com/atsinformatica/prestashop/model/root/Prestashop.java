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
    "customer",
    "address",
    "order",
    "cpfModuleData",
    "state",
    "combination",
    "productOption",
    "productOptionValue",    
    "stockAvailable", 
    "carrier",
})
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
    
    @XmlElement(name = "combination")
    private Combination combination;
    
    @XmlElement(name = "product_option")
    private ProductOption productOption;
    
    @XmlElement(name = "product_option_value")
    private ProductOptionValue productOptionValue;
    
    @XmlElement(name = "stock_available")
    private StockAvailable stockAvailable;

    @XmlElement(name = "customer", required = true)
    protected Customer customer;

    @XmlElement(name = "address", required = true)
    protected Address address;
    @XmlElement(name = "order", required = true)
    protected Order order;

    @XmlElement(name = "cpfmodule_data", required = true)
    protected CPFModuleData cpfModuleData;
    
    @XmlElement(name = "state", required = true)
    private State state;
    
    @XmlElement(name = "carrier", required = true)
    private Carrier carrier;

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
        return cpfModuleData;
    }

    public void setCpfmodule_data(CPFModuleData cpfmodule_data) {
        this.cpfModuleData = cpfmodule_data;
    }

    /**
     * @return the state
     */
    public State getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(State state) {
        this.state = state;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

}
