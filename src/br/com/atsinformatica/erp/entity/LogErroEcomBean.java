/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.entity;

import java.util.Date;

/**
 *
 * @author AlexsanderPimenta
 */
public class LogErroEcomBean {
    
    private int id;
    private int idInteg;
    private String descricaoErro;
    private Date dataErro;

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
     * @return the idInteg
     */
    public int getIdInteg() {
        return idInteg;
    }

    /**
     * @param idInteg the idInteg to set
     */
    public void setIdInteg(int idInteg) {
        this.idInteg = idInteg;
    }

    /**
     * @return the descricaoErro
     */
    public String getDescricaoErro() {
        return descricaoErro;
    }

    /**
     * @param descricaoErro the descricaoErro to set
     */
    public void setDescricaoErro(String descricaoErro) {
        this.descricaoErro = descricaoErro;
    }

    /**
     * @return the dataErro
     */
    public Date getDataErro() {
        return dataErro;
    }

    /**
     * @param dataErro the dataErro to set
     */
    public void setDataErro(Date dataErro) {
        this.dataErro = dataErro;
    }
    
}
