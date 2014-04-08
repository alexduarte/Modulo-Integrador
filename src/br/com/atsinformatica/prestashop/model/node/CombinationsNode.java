/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.node;

import java.util.ArrayList;
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
    "combinations",
})
@XmlRootElement(name = "combinations")
public class CombinationsNode {
    
    @XmlAttribute(name = "node_type")
    protected String nodeType = "cobinations";    
    @XmlElement(name = "combinations")
    private List<CombinationsChild> combinations;

    /**
     * @return the combinations
     */
    public List<CombinationsChild> getCombinations() {
        if(combinations == null){
            combinations = new ArrayList<>();
        }
        return combinations;
    }

    /**
     * @param combinations the combinations to set
     */
    public void setCombinations(List<CombinationsChild> combinations) {
        this.combinations = combinations;
    }
    
}
