package br.com.atsinformatica.prestashop.model.root;

import br.com.atsinformatica.prestashop.model.list.StockAvailables;
import br.com.atsinformatica.prestashop.model.node.*;
import br.com.atsinformatica.utils.Funcoes;
import java.util.List;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product", propOrder = {
    "id",
    "idCategoryDefault",
    "idManufacturer",
    "idErp",
    "width",
    "height",
    "weight",
    "ean13",
    "depth",
    "active",
    "condition",
    "linkRewrite",
    "name",
    "price",
    "description",
    "metaDescription",
    "metaKeyWord",
    "stockAvailables",
    "availableForOrder",
    "showPrice",        
})

@XmlRootElement(name = "product")
public class Product {
    public static String URLPRODUCTS = "products/";    
    @XmlElement(name = "id", required = true)
    private Id id;
    @XmlElement(name = "id_category_default")
    private Integer idCategoryDefault;
    @XmlElement(name = "id_manufacturer")
    private Integer idManufacturer;
    @XmlElement(name = "id_erp")
    private Integer idErp;
    @XmlElement(name = "width")
    private String width;
    @XmlElement(name = "height")
    private String height;
    @XmlElement(name = "weight")
    private String weight;
    @XmlElement(name = "ean13")
    private String ean13;
    @XmlElement(name = "depth")
    private String depth;
    @XmlElement(name = "active")
    private Integer active;
    @XmlElement(name = "condition")
    private String condition;
    @XmlElement(name = "link_rewrite")
    private LinkRewrite linkRewrite;
    @XmlElement(name = "name")
    private Name name;
    @XmlElement(name = "price")
    private Price price;
    @XmlElement(name = "description")
    private Description description;
    @XmlElement(name = "meta_description")
    private MetaDescription metaDescription;
    @XmlElement(name = "meta_keywords")
    private MetaKeyWord metaKeyWord;
    @XmlElement(name = "stock_availables")
    private StockAvailablesProduct stockAvailables;
    @XmlElement(name="available_for_order")
    private int availableForOrder;
    @XmlElement(name="show_price")
    private int showPrice;
    
    
    public Product() {
        idCategoryDefault = 2;
        width = "0.000000";
        height = "0.000000";
        weight = "0.000000";
        depth = "0.000000";
        active = 0;
        condition = "new";
        ean13 = "0";
        this.showPrice = 1;
        this.availableForOrder = 1;
        
    }

    public Id getId() {
        return id;
    }

    public void setId(Id value) {
        this.id = value;
    }

    public Integer getIdCategoryDefault() {
        return idCategoryDefault;
    }

    public void setIdCategoryDefault(Integer idCategoryDefault) {
        this.idCategoryDefault = idCategoryDefault;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public LinkRewrite getLinkRewrite() {
        return linkRewrite;
    }

    public void setLinkRewrite(LinkRewrite linkRewrite) {
        linkRewrite.getLanguage().get(0).setContent(Funcoes.ReplaceAcento(linkRewrite.getLanguage().get(0).getContent()));
        linkRewrite.getLanguage().get(0).setContent(linkRewrite.getLanguage().get(0).getContent().replaceAll("[ ]+", "-"));
        this.linkRewrite = linkRewrite;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    /**
     * @return the metaDescription
     */
    public MetaDescription getMetaDescription() {
        return metaDescription;
    }

    /**
     * @param metaDescription the metaDescription to set
     */
    public void setMetaDescription(MetaDescription metaDescription) {
        this.metaDescription = metaDescription;
    }

    /**
     * @return the metaKeyWord
     */
    public MetaKeyWord getMetaKeyWord() {
        return metaKeyWord;
    }

    /**
     * @param metaKeyWord the metaKeyWord to set
     */
    public void setMetaKeyWord(MetaKeyWord metaKeyWord) {
        this.metaKeyWord = metaKeyWord;
    }

    /**
     * @return the ean13
     */
    public String getEan13() {
        return ean13;
    }

    /**
     * @param ean13 the ean13 to set
     */
    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    /**
     * @return the idManufacturer
     */
    public Integer getIdManufacturer() {
        return idManufacturer;
    }

    /**
     * @param idManufacturer the idManufacturer to set
     */
    public void setIdManufacturer(Integer idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    

    /**
     * @return the idErp
     */
    public Integer getIdErp() {
        return idErp;
    }

    /**
     * @param idErp the idErp to set
     */
    public void setIdErp(Integer idErp) {
        this.idErp = idErp;
    }

    /**
     * @return the depth
     */
    public String getDepth() {
        return depth;
    }

    /**
     * @param depth the depth to set
     */
    public void setDepth(String depth) {
        this.depth = depth;
    }

    /**
     * @return the stockAvailables
     */
    public StockAvailablesProduct getStockAvailables() {
        return stockAvailables;
    }

    /**
     * @param stockAvailables the stockAvailables to set
     */
    public void setStockAvailables(StockAvailablesProduct stockAvailables) {
        this.stockAvailables = stockAvailables;
    }

    /**
     * @return the availableForOrder
     */
    public int getAvailableForOrder() {
        return availableForOrder;
    }

    /**
     * @param availableForOrder the availableForOrder to set
     */
    public void setAvailableForOrder(int availableForOrder) {
        this.availableForOrder = availableForOrder;
    }

    /**
     * @return the showPrice
     */
    public int getShowPrice() {
        return showPrice;
    }

    /**
     * @param showPrice the showPrice to set
     */
    public void setShowPrice(int showPrice) {
        this.showPrice = showPrice;
    }

    
   
}
