//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b01 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2013.11.11 a las 08:18:12 PM CET 
//
package br.com.atsinformatica.prestashop.model.root;


import br.com.atsinformatica.prestashop.model.node.*;
import br.com.atsinformatica.utils.Funcoes;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product", propOrder = {
    "id",
    "ean13",
//    "idManufacturer",
//    "idSupplier",
    "idCategoryDefault",
//    "_new",
//    "cacheDefaultAttribute",
//    "idTaxRulesGroup",
//    "positionInCategory",
//    "quantity",
//    "type",
//    "idShopDefault",
    "width",
    "height",
//    "depth",
    "weight",
//    "quantityDiscount",
//    "cacheIsPack",
//    "cacheHasAttachments",
//    "isVirtual",
//    "onSale",
//    "onlineOnly",
//    "ecotax",
//    "minimalQuantity",
//    "wholesalePrice",
//    "unitPriceRatio",
//    "additionalShippingCost",
//    "customizable",
//    "textFields",
//    "uploadableFiles",
    "active",
//    "redirectType",
//    "idProductRedirected",
//    "availableForOrder",
//    "availableDate",
    "condition",
//    "showPrice",
//    "indexed",
//    "visibility",
//    "advancedStockManagement",
//    "dateAdd",
//    "dateUpd",
    "linkRewrite",
    "name",
    "price",
    "description",
//    "descriptionShort",
})
@XmlRootElement(name = "product")
public class Product {

    public static String URLPRODUCTS = "products/";
    
    @XmlElement(name = "id", required = true)
    protected Id id;
    @XmlElement(name ="ean13")
    protected String ean13;
//    @XmlElement(name = "id_manufacturer")
//    protected Integer idManufacturer;
//    @XmlElement(name = "id_supplier")
//    protected Integer idSupplier;
    @XmlElement(name = "id_category_default")
    protected Integer idCategoryDefault;
//    @XmlElement(name = "new")
//    protected Integer _new;
//    @XmlElement(name = "cache_default_attribute")
//    protected Integer cacheDefaultAttribute;
//    @XmlElement(name = "id_tax_rules_group")
//    protected Integer idTaxRulesGroup;
//    @XmlElement(name = "position_in_category")
//    protected PositionInCategory positionInCategory;
//    @XmlElement(name = "quantity")
//    protected Quantity quantity;
//    @XmlElement(name = "type")
//    protected Type type;
//    @XmlElement(name = "id_shop_default")
//    protected Integer idShopDefault;
    @XmlElement(name = "width")
    protected String width;
    @XmlElement(name = "height")
    protected String height;
//    @XmlElement(name = "depth")
//    protected String depth;
    @XmlElement(name = "weight")
    protected String weight;
//    @XmlElement(name = "quantity_discount")
//    protected Integer quantityDiscount;
//    @XmlElement(name = "cache_is_pack")
//    protected Integer cacheIsPack;
//    @XmlElement(name = "cache_has_attachments")
//    protected Integer cacheHasAttachments;
//
//    @XmlElement(name = "is_virtual")
//    protected Integer isVirtual;
    @XmlElement(name = "on_sale")
    protected Integer onSale;
//    @XmlElement(name = "online_only")
//    protected Integer onlineOnly;
//    @XmlElement(name = "ecotax")
//    protected String ecotax;
//    @XmlElement(name = "minimal_quantity")
//    protected Integer minimalQuantity;
//    @XmlElement(name = "wholesale_price")
//    protected String wholesalePrice;
//    @XmlElement(name = "unit_price_ratio")
//    protected String unitPriceRatio;
//    @XmlElement(name = "additional_shipping_cost")
//    protected String additionalShippingCost;
//    @XmlElement(name = "customizable")
//    protected Integer customizable;
//    @XmlElement(name = "text_fields")
//    protected Integer textFields;
//    @XmlElement(name = "uploadable_files")
//    protected Integer uploadableFiles;
    @XmlElement(name = "active")
    protected Integer active;
//    @XmlElement(name = "redirect_type")
//    protected String redirectType;
//    @XmlElement(name = "id_product_redirected")
//    protected Integer idProductRedirected;
//    @XmlElement(name = "available_for_order")
//    protected Integer availableForOrder;
//    @XmlElement(name = "available_date")
//    protected String availableDate;
    @XmlElement(name = "condition")
    protected String condition;
//    @XmlElement(name = "show_price")
//    protected Integer showPrice;   
//    @XmlElement(name = "indexed")
//    protected Integer indexed;
//    @XmlElement(name = "visibility")
//    protected String visibility;
//    @XmlElement(name = "advanced_stock_management")
//    protected Integer advancedStockManagement;
//    @XmlElement(name = "date_add")
//    protected String dateAdd;
//    @XmlElement(name = "date_upd")
//    protected String dateUpd;
    @XmlElement(name = "link_rewrite")
    protected LinkRewrite linkRewrite;
    @XmlElement(name = "name")
    protected Name name;
    @XmlElement(name = "price")
    protected Price price;
    @XmlElement(name = "description")
    protected Description description;
//    @XmlElement(name = "description_short")
//    protected DescriptionShort descriptionShort;
    public Product() {
        
//        idManufacturer = null;
//        idSupplier = null;
        idCategoryDefault = 2;
//        cacheDefaultAttribute = null;
//        idTaxRulesGroup = 1;
//        idShopDefault = 1;
        width = "0.000000";
        height = "0.000000";
//        depth = "0.000000";
        weight = "0.000000";
//        quantityDiscount = 0;
//        cacheIsPack = 0;
//        cacheHasAttachments = 0;
//        isVirtual = 0;
        onSale = 0;
//        onlineOnly = 0;
//        ecotax = "0.000000";
//        minimalQuantity = 1;
//        wholesalePrice = "0.000000";
//        unitPriceRatio = "0.000000";
//        additionalShippingCost = "0.00";
//        customizable = 0;
//        textFields = 0;
//        uploadableFiles = 0;
        active = 0;
//        redirectType = "404";
//        idProductRedirected = 0;
//        availableForOrder = 1;
        condition = "new";
//        showPrice = 1;
//        indexed = 1;
//        visibility = "both";
//        advancedStockManagement = 0;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id value) {
        this.id = value;
    }

//    public Integer getIdManufacturer() {
//        return idManufacturer;
//    }
//
//    public void setIdManufacturer(Integer idManufacturer) {
//        this.idManufacturer = idManufacturer;
//    }
//
//    public Integer getIdSupplier() {
//        return idSupplier;
//    }
//
//    public void setIdSupplier(Integer idSupplier) {
//        this.idSupplier = idSupplier;
//    }
//
    public Integer getIdCategoryDefault() {
        return idCategoryDefault;
    }

    public void setIdCategoryDefault(Integer idCategoryDefault) {
        this.idCategoryDefault = idCategoryDefault;
    }

//    public Integer getNew() {
//        return _new;
//    }
//
//    public void setNew(Integer _new) {
//        this._new = _new;
//    }
//
//    public Integer getCacheDefaultAttribute() {
//        return cacheDefaultAttribute;
//    }
//
//    public void setCacheDefaultAttribute(Integer cacheDefaultAttribute) {
//        this.cacheDefaultAttribute = cacheDefaultAttribute;
//    }
//
//    public Integer getIdTaxRulesGroup() {
//        return idTaxRulesGroup;
//    }
//
//    public void setIdTaxRulesGroup(Integer idTaxRulesGroup) {
//        this.idTaxRulesGroup = idTaxRulesGroup;
//    }
//
//    public PositionInCategory getPositionInCategory() {
//        return positionInCategory;
//    }
//
//    public void setPositionInCategory(PositionInCategory positionInCategory) {
//        this.positionInCategory = positionInCategory;
//    }
//
//    public Quantity getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Quantity quantity) {
//        this.quantity = quantity;
//    }
//
//    public Type getType() {
//        return type;
//    }
//
//    public void setType(Type type) {
//        this.type = type;
//    }
//
//    public Integer getIdShopDefault() {
//        return idShopDefault;
//    }
//
//    public void setIdShopDefault(Integer idShopDefault) {
//        this.idShopDefault = idShopDefault;
//    }
//
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

//    public String getDepth() {
//        return depth;
//    }
//
//    public void setDepth(String depth) {
//        this.depth = depth;
//    }
//
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

//    public Integer getQuantityDiscount() {
//        return quantityDiscount;
//    }
//
//    public void setQuantityDiscount(Integer quantityDiscount) {
//        this.quantityDiscount = quantityDiscount;
//    }
//
//    public Integer getCacheIsPack() {
//        return cacheIsPack;
//    }
//
//    public void setCacheIsPack(Integer cacheIsPack) {
//        this.cacheIsPack = cacheIsPack;
//    }
//
//    public Integer getCacheHasAttachments() {
//        return cacheHasAttachments;
//    }
//
//    public void setCacheHasAttachments(Integer cacheHasAttachments) {
//        this.cacheHasAttachments = cacheHasAttachments;
//    }
//
//    public Integer getIsVirtual() {
//        return isVirtual;
//    }
//
//    public void setIsVirtual(Integer isVirtual) {
//        this.isVirtual = isVirtual;
//    }
//
    public Integer getOnSale() {
        return onSale;
    }

    public void setOnSale(Integer onSale) {
        this.onSale = onSale;
    }

//    public Integer getOnlineOnly() {
//        return onlineOnly;
//    }
//
//    public void setOnlineOnly(Integer onlineOnly) {
//        this.onlineOnly = onlineOnly;
//    }
//
//    public String getEcotax() {
//        return ecotax;
//    }
//
//    public void setEcotax(String ecotax) {
//        this.ecotax = ecotax;
//    }
//
//    public Integer getMinimalQuantity() {
//        return minimalQuantity;
//    }
//
//    public void setMinimalQuantity(Integer minimalQuantity) {
//        this.minimalQuantity = minimalQuantity;
//    }
//
//    public String getWholesalePrice() {
//        return wholesalePrice;
//    }
//
//    public void setWholesalePrice(String wholesalePrice) {
//        this.wholesalePrice = wholesalePrice;
//    }
//
//    public String getUnitPriceRatio() {
//        return unitPriceRatio;
//    }
//
//    public void setUnitPriceRatio(String unitPriceRatio) {
//        this.unitPriceRatio = unitPriceRatio;
//    }
//
//    public String getAdditionalShippingCost() {
//        return additionalShippingCost;
//    }
//
//    public void setAdditionalShippingCost(String additionalShippingCost) {
//        this.additionalShippingCost = additionalShippingCost;
//    }
//
//    public Integer getCustomizable() {
//        return customizable;
//    }
//
//    public void setCustomizable(Integer customizable) {
//        this.customizable = customizable;
//    }
//
//    public Integer getTextFields() {
//        return textFields;
//    }
//
//    public void setTextFields(Integer textFields) {
//        this.textFields = textFields;
//    }
//
//    public Integer getUploadableFiles() {
//        return uploadableFiles;
//    }
//
//    public void setUploadableFiles(Integer uploadableFiles) {
//        this.uploadableFiles = uploadableFiles;
//    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

//    public String getRedirectType() {
//        return redirectType;
//    }
//
//    public void setRedirectType(String redirectType) {
//        this.redirectType = redirectType;
//    }
//
//    public Integer getIdProductRedirected() {
//        return idProductRedirected;
//    }
//
//    public void setIdProductRedirected(Integer idProductRedirected) {
//        this.idProductRedirected = idProductRedirected;
//    }
//
//    public Integer getAvailableForOrder() {
//        return availableForOrder;
//    }
//
//    public void setAvailableForOrder(Integer availableForOrder) {
//        this.availableForOrder = availableForOrder;
//    }
//
//    public String getAvailableDate() {
//        return availableDate;
//    }
//
//    public void setAvailableDate(String availableDate) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        this.availableDate = sdf.format(availableDate);
//    }
//
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

//    public Integer getShowPrice() {
//        return showPrice;
//    }
//
//    public void setShowPrice(Integer showPrice) {
//        this.showPrice = showPrice;
//    }
//
//    public Integer getIndexed() {
//        return indexed;
//    }
//
//    public void setIndexed(Integer indexed) {
//        this.indexed = indexed;
//    }
//
//    public String getVisibility() {
//        return visibility;
//    }
//
//    public void setVisibility(String visibility) {
//        this.visibility = visibility;
//    }
//
//    public Integer getAdvancedStockManagement() {
//        return advancedStockManagement;
//    }
//
//    public void setAdvancedStockManagement(Integer advancedStockManagement) {
//        this.advancedStockManagement = advancedStockManagement;
//    }
//
//    public String getDateAdd() {
//        return dateAdd;
//    }
//
//    public void setDateAdd(String dateAdd) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        this.dateAdd = sdf.format(dateAdd);
//    }
//
//    public String getDateUpd() {
//        return dateUpd;
//    }
//
//    public void setDateUpd(String dateUpd) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        this.dateUpd = sdf.format(dateUpd);
//    }

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

//    public DescriptionShort getDescriptionShort() {
//        return descriptionShort;
//    }
//
//    public void setDescriptionShort(DescriptionShort descriptionShort) {
//        this.descriptionShort = descriptionShort;
//    }

    
}
