/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.node;

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
@XmlType(propOrder = {
    "id",
    "idProductAttribute",
})
@XmlRootElement(name = "stock_available")
public class StockAvailableNode {
   
    @XmlElement(name = "id", required = true)
   // @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private int id;
    //@XmlAttribute(name = "xlink:href", required = true)
    //protected String href ="http://192.168.2.249/lojaprestashop/api/stock_availables/:id";
    @XmlElement(name = "id_product_attribute", required = true)
    private int idProductAttribute;

    public StockAvailableNode(){
            
    }
    public StockAvailableNode(int id, int idProductAttribute){
        this.id = id;
        this.idProductAttribute = idProductAttribute;
      //  this.href = this.href.replace(":id", String.valueOf(10));        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
       // this.href = this.href.replace(":id", id);
        this.id = id;
       
    }

    /**
     * @return the idProductAttribute
     */
    public int getIdProductAttribute() {
        return idProductAttribute;
    }

    /**
     * @param idProductAttribute the idProductAttribute to set
     */
    public void setIdProductAttribute(int idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
    }

    
   
   

    
    
}
