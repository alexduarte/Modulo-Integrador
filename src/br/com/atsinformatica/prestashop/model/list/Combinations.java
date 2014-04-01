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
@XmlType(propOrder = {"combination"})
@XmlRootElement(name = "combinations")
public class Combinations {

    @XmlElement(name = "combination")
    protected List<AccessXMLAttribute> combination;

    public List<AccessXMLAttribute> getCombination() {
        if (combination == null) {
            combination = new ArrayList<AccessXMLAttribute>();
        }
        return this.combination;
    }

    public void setCombination(List<AccessXMLAttribute> listCombination) {
        this.combination = listCombination;
    }
}
