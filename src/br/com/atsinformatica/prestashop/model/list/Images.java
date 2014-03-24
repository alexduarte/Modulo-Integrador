/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.list;

import br.com.atsinformatica.prestashop.model.list.prestashop.AccessXMLAttribute;
import java.util.ArrayList;
import java.util.List;
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
@XmlType(name="", propOrder = "image")
public class Images {
    
    @XmlElement(name="image")
    private List<AccessXMLAttribute> image;

    /**
     * @return the image
     */
    public List<AccessXMLAttribute> getImage() {
        if(image == null){
            image = new ArrayList<AccessXMLAttribute>();            
        }
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(List<AccessXMLAttribute> image) {
        this.image = image;
    }
    
    
    
}
