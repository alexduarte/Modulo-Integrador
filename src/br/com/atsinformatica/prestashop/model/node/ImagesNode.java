/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.node;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author AlexsanderPimenta
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
    "image",})
@XmlRootElement(name = "images")
public class ImagesNode {

    @XmlAttribute(name = "node_type")
    protected String nodeType = "image";
    @XmlElement(name = "image")
    private List<ImageNode> image;

    /**
     * @return the image
     */
    public List<ImageNode> getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(List<ImageNode> image) {
        this.image = image;
    }
}
