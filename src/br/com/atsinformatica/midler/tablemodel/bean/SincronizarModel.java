/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.tablemodel.bean;

import com.towel.el.annotation.Resolvable;
import java.util.Date;

/**
 *
 * @author AlexsanderPimenta
 */
public class SincronizarModel {
    
    @Resolvable(colName = "Id")
    private int id;
    @Resolvable(colName = "Entidade")
    private String entidade;
    @Resolvable(colName = "XML")
    private String xml;
    @Resolvable(colName = "Data entrada")
    private Date dataEnt;
    @Resolvable(colName = "Data integração")
    private Date dataInteg;

    /**
     * @return the entidade
     */
    public String getEntidade() {
        return entidade;
    }

    /**
     * @param entidade the entidade to set
     */
    public void setEntidade(String entidade) {
        this.entidade = entidade;
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
        this.id = id;
    }

    /**
     * @return the xml
     */
    public String getXml() {
        return xml;
    }

    /**
     * @param xml the xml to set
     */
    public void setXml(String xml) {
        this.xml = xml;
    }

    /**
     * @return the dataEnt
     */
    public Date getDataEnt() {
        return dataEnt;
    }

    /**
     * @param dataEnt the dataEnt to set
     */
    public void setDataEnt(Date dataEnt) {
        this.dataEnt = dataEnt;
    }

    /**
     * @return the dataInteg
     */
    public Date getDataInteg() {
        return dataInteg;
    }

    /**
     * @param dataInteg the dataInteg to set
     */
    public void setDataInteg(Date dataInteg) {
        this.dataInteg = dataInteg;
    }

    
    
}
