/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.root;

import br.com.atsinformatica.prestashop.model.node.Description;
import br.com.atsinformatica.prestashop.model.node.LinkRewrite;
import br.com.atsinformatica.prestashop.model.node.MetaDescription;
import br.com.atsinformatica.prestashop.model.node.MetaKeyWord;
import br.com.atsinformatica.prestashop.model.node.MetaTitle;
import br.com.atsinformatica.prestashop.model.node.Name;
import br.com.atsinformatica.prestashop.model.node.ShortDescription;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    "id",
    "active",
    "linkRewrite",
    "name",
    "dateAdd",
    "dateUpd",
    "idErp",
    "description",
    "shortDescription",
    "metaTitle",
    "metaDescription",
    "metaKeywords",
})
@XmlRootElement(name = "manufacturer")
public class Manufacturer {
    
    public static final String URLMANUFACTURERS = "manufacturers/";

    public Manufacturer() {
        active = 1;
    }    
    
    @XmlElement(name = "id")
    private String id;
    @XmlElement(name = "active")
    private int active;
    @XmlElement(name = "link_rewrite")
    private LinkRewrite linkRewrite;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "date_add")
    private String dateAdd;
    @XmlElement(name="date_upd")
    private String dateUpd;
    @XmlElement(name = "id_erp")
    private String idErp;
    @XmlElement(name = "description")
    private Description description;
    @XmlElement(name = "short_description")
    private ShortDescription shortDescription;
    @XmlElement(name = "meta_title")
    private MetaTitle metaTitle;
    @XmlElement(name = "meta_description")
    private MetaDescription metaDescription;
    @XmlElement(name = "meta_keywords")
    private MetaKeyWord metaKeywords;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the active
     */
    public int getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(int active) {
        this.active = active;
    }

    /**
     * @return the linkRewrite
     */
    public LinkRewrite getLinkRewrite() {
        return linkRewrite;
    }

    /**
     * @param linkRewrite the linkRewrite to set
     */
    public void setLinkRewrite(LinkRewrite linkRewrite) {
        this.linkRewrite = linkRewrite;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dateAdd
     */
    public String getDateAdd() {
        return dateAdd;
    }

    /**
     * @param dateAdd the dateAdd to set
     */
    public void setDateAdd(Date dateAdd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.dateAdd = sdf.format(dateAdd);
    }

    /**
     * @return the dateUpd
     */
    public String getDateUpd() {
        return dateUpd;
    }

    /**
     * @param dateUpd the dateUpd to set
     */
    public void setDateUpd(Date dateUpd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.dateUpd = sdf.format(dateUpd);
    }

    /**
     * @return the idErp
     */
    public String getIdErp() {
        return idErp;
    }

    /**
     * @param idErp the idErp to set
     */
    public void setIdErp(String idErp) {
        this.idErp = idErp;
    }

    /**
     * @return the description
     */
    public Description getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(Description description) {
        this.description = description;
    }

    /**
     * @return the shorDescription
     */
    public ShortDescription getShortDescription() {
        return shortDescription;
    }

    /**
     * @param shorDescription the shorDescription to set
     */
    public void setShortDescription(ShortDescription shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * @return the metaTitle
     */
    public MetaTitle getMetaTitle() {
        return metaTitle;
    }

    /**
     * @param metaTitle the metaTitle to set
     */
    public void setMetaTitle(MetaTitle metaTitle) {
        this.metaTitle = metaTitle;
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
     * @return the metaKeywords
     */
    public MetaKeyWord getMetaKeywords() {
        return metaKeywords;
    }

    /**
     * @param metaKeywords the metaKeywords to set
     */
    public void setMetaKeywords(MetaKeyWord metaKeywords) {
        this.metaKeywords = metaKeywords;
    }
    
    
}
