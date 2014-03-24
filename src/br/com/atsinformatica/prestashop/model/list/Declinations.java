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
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author AlexsanderPimenta
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder = "declination")
public class Declinations {
    
    
    @XmlElement(name="declination")
    private List<AccessXMLAttribute> declination;

    /**
     * @return the image
     */
    public List<AccessXMLAttribute> getDeclinations() {
        if(declination == null){
            declination = new ArrayList<AccessXMLAttribute>();            
        }
        return declination;
    }

    /**
     * @param image the image to set
     */
    public void setDeclination(List<AccessXMLAttribute> declination) {
        this.declination = declination;
    }
    
}
