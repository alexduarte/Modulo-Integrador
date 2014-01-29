/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.category;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ricardosilva
 */
@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "category",
        propOrder = {
            "id",
            "idParent",
            "levelDepth",
            "position",
            "active",
            "dataAdd",
            "dataUpd",
            "idShopDefault",
            "isRootCategory",
            "name",
            "description",
            "linkRewrite"  
        })

public class Category {

    public static String URLCATEGORY = "categories/";

    @XmlElement(name = "id", required = true)
    private String id;

    @XmlElement(name = "id_parent")
    private Integer idParent;

    @XmlElement(name = "level_depth")
    private Integer levelDepth;
    
    @XmlElement(name = "position")
    private Integer position;

    @XmlElement(name = "active")
    private Short active;

    @XmlElement(name = "date_add")
    private String dataAdd;

    @XmlElement(name = "date_upd")
    private String dataUpd;

    @XmlElement(name = "id_Shop_default")
    private Short idShopDefault;

    @XmlElement(name = "is_root_category")
    private Short isRootCategory;

    @XmlElement(name = "name")
    private Name name;

    @XmlElement(name = "description")
    private Description description;

    @XmlElement(name = "link_rewrite")
    private LinkRewrite linkRewrite;

    public Category() {
        this.idParent = 0;
        this.levelDepth = 0;
        this.idShopDefault = 1;
        this.active = 1;
        this.isRootCategory = 0;
        this.position = 0;
    }

    public void setIdParent(Integer idParent) {
        this.idParent = idParent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIdParent() {
        return idParent;
    }

    public Integer getLevelDepth() {
        return levelDepth;
    }

    public Short getActive() {
        return active;
    }

    public String getDataAdd() {
        return dataAdd;
    }

    public void setDataAdd(Date dataAdd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.dataAdd = sdf.format(dataAdd);
    }

    public String getDataUpd() {
        return dataUpd;
    }

    public void setDataUpd(Date dataAdd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.dataAdd = sdf.format(dataAdd);
    }

    public Short getIdShopDefault() {
        return idShopDefault;
    }

    public Short getIsRootCategory() {
        return isRootCategory;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public LinkRewrite getLinkRewrite() {
        return linkRewrite;
    }

    public void setLinkRewrite(LinkRewrite linkRewrite) {
        this.linkRewrite = linkRewrite;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
    
}
