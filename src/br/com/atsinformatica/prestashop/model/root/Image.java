/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.root;

import br.com.atsinformatica.prestashop.model.node.Legend;
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
@XmlType(name="image",propOrder = {
    "id",
    "idProduct",
    "position",
    "cover",
    "legend"
})
@XmlRootElement(name = "image")
public class Image {
    
    public static String URLIMAGE = "images/products/3";    
    @XmlElement(name = "id", required = true)
    private String id;
    @XmlElement(name = "id_product")
    private int idProduct;
    @XmlElement(name = "position")
    private int position;
    @XmlElement(name = "cover")
    private int cover;
    @XmlElement(name = "legend")
    private Legend legend;
    
    /**
     * @return the idProduct
     */
    public int getIdProduct() {
        return idProduct;
    }

    /**
     * @param idProduct the idProduct to set
     */
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @return the cover
     */
    public int getCover() {
        return cover;
    }

    /**
     * @param cover the cover to set
     */
    public void setCover(int cover) {
        this.cover = cover;
    }

    /**
     * @return the legend
     */
    public Legend getLegend() {
        return legend;
    }

    /**
     * @param legend the legend to set
     */
    public void setLegend(Legend legend) {
        this.legend = legend;
    }

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
    
}
