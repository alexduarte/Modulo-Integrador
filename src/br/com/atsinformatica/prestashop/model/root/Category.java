/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.root;


import br.com.atsinformatica.prestashop.model.node.*;
import br.com.atsinformatica.utils.Funcoes;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.*;

/**
 *
 * @author ricardosilva
 */
@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "category",
        propOrder = {
            "id",
            "idParent",
            "active",
            "idShopDefault",
            "isRootCategory",
            //"position",
            "dataAdd",
            "dataUpd",
            "idErp",
            "name",
            "description",
            "linkRewrite",
            
        })

public class Category {

    public static String URLCATEGORY = "categories/";

    @XmlElement(name = "id", required = true)
    private String id;

    @XmlElement(name = "id_parent")
    private Integer idParent;

    @XmlElement(name = "active")
    private Short active;

//    @XmlElement(name = "position")
//    private Integer position;

    @XmlElement(name = "date_add")
    private String dataAdd;

    @XmlElement(name = "date_upd")
    private String dataUpd;
    
    @XmlElement(name = "id_erp")
    private Integer idErp;

    @XmlElement(name = "id_shop_default")
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
        //this.id = String.valueOf(70);        
        this.idShopDefault = 1;
        this.active = 1;
        this.isRootCategory = 0;
        //this.position = 0;
        this.idParent = 2;
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

    public void setIdParent(Integer idParent) {
        this.idParent = idParent;
    }

    public Short getActive() {
        return active;
    }

//    public Integer getPosition() {
//        return position;
//    }

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

    public void setDataUpd(Date dataUpd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.dataUpd = sdf.format(dataUpd);
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
        linkRewrite.getLanguage().get(0).setContent(Funcoes.ReplaceAcento(linkRewrite.getLanguage().get(0).getContent()));
        linkRewrite.getLanguage().get(0).setContent(linkRewrite.getLanguage().get(0).getContent().replaceAll("[ ]+", "-"));
        this.linkRewrite = linkRewrite;
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

   
    
}
