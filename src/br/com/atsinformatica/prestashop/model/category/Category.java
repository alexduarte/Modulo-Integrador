/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.category;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ricardosilva
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://prestashop/api/categories/id", name = "", propOrder = {
    "id",
    "idParent",
    "levelDepth",
    "active",
    "dataAdd",
    "dataUpd",
    "idShopDefault",
    "isRootCategory",
    "name",
    "description",
    "linkRewrite",})
@XmlRootElement(name = "category")
public class Category {

    @XmlElement(name = "id", required = true)
    private Integer id;

    @XmlElement(name = "id_parent", required = true)
    private Integer idParent;

    @XmlElement(name = "level_depth", required = true)
    private Integer levelDepth;

    @XmlElement(name = "active", required = true)
    private Short active;

    //@Temporal(TemporalType.TIMESTAMP)
    @XmlElement(name = "date_add", required = true)
    private String dataAdd;

    @Temporal(TemporalType.TIMESTAMP)
    @XmlElement(name = "date_upd", required = true)
    private String dataUpd;

    @XmlElement(name = "id_Shop_default", required = true)
    private Short idShopDefault;

    @XmlElement(name = "is_root_category", required = true)
    private Short isRootCategory;

    @XmlElement(name = "name", required = true)
    private Name name;

    @XmlElement(name = "description", required = true)
    private Description description;

    @XmlElement(name = "link_rewrite", required = true)
    private LinkRewrite linkRewrite;

    public Category() {
        this.idParent = 0;
        this.levelDepth = 0;
        this.idShopDefault = 1;
        this.active = 0;
        this.isRootCategory = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdParent() {
        return idParent;
    }

    public void setIdParent(Integer idParent) {
        this.idParent = idParent;
    }

    public Integer getLevelDepth() {
        return levelDepth;
    }

    public void setLevelDepth(Integer levelDepth) {
        this.levelDepth = levelDepth;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public String getDataAdd() {
        return dataAdd;
    }

    public void setDataAdd(String dataAdd) {
        this.dataAdd = dataAdd;
    }

    public String getDataUpd() {
        return dataUpd;
    }

    public void setDataUpd(String dataUpd) {
        this.dataUpd = dataUpd;
    }

    public Short getIdShopDefault() {
        return idShopDefault;
    }

    public void setIdShopDefault(Short idShopDefault) {
        this.idShopDefault = idShopDefault;
    }

    public Short getIsRootCategory() {
        return isRootCategory;
    }

    public void setIsRootCategory(Short isRootCategory) {
        this.isRootCategory = isRootCategory;
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
}
