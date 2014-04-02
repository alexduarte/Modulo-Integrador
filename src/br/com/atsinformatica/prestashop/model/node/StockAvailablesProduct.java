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
@XmlType(name = "stock_available",propOrder = {
    "stockAvailable",
})
@XmlRootElement(name = "stock_availables")
public class StockAvailablesProduct {
    
    @XmlAttribute(name = "node_type")
    protected String nodeType = "stock_available";    
    @XmlElement(name = "stock_available")
    private List<StockAvailableProduct> stockAvailable;
    
    
    public StockAvailablesProduct(){
        this.nodeType = "stock_available";
    }

    /**
     * @return the stockAvailable
     */
    public List<StockAvailableProduct> getStockAvailable() {
        if(stockAvailable == null){
            stockAvailable = new ArrayList<>();
        }
        return stockAvailable;
    }

    /**
     * @param stockAvailable the stockAvailable to set
     */
    public void setStockAvailable(List<StockAvailableProduct> stockAvailable) {
        this.stockAvailable = stockAvailable;
    }
    
    
}
