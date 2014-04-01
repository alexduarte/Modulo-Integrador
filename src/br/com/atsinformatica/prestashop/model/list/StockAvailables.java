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
@XmlType(propOrder = {"stockAvailable"})
@XmlRootElement(name = "stock_availables")
public class StockAvailables {
    
    @XmlElement(name = "combination")
    protected List<AccessXMLAttribute> stockAvailable;

    public List<AccessXMLAttribute> getStockAvailable() {
        if (stockAvailable == null) {
            stockAvailable = new ArrayList<AccessXMLAttribute>();
        }
        return this.stockAvailable;
    }

    public void setStockAvailables(List<AccessXMLAttribute> stockAvailable) {
        this.stockAvailable = stockAvailable;
    }
    
}
