/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ats.sincronizador.erp.bean;

import java.util.Date;

/**
 *
 * @author AlexsanderPimenta
 */
public class MovimentoGeralBean {
    
    private String codProd;
    private String codGrade;    
    private Date dt_movimento;

    /**
     * @return the codProd
     */
    public String getCodProd() {
        return codProd;
    }

    /**
     * @param codProd the codProd to set
     */
    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

    /**
     * @return the codGrade
     */
    public String getCodGrade() {
        return codGrade;
    }

    /**
     * @param codGrade the codGrade to set
     */
    public void setCodGrade(String codGrade) {
        this.codGrade = codGrade;
    }

    /**
     * @return the dt_movimento
     */
    public Date getDt_movimento() {
        return dt_movimento;
    }

    /**
     * @param dt_movimento the dt_movimento to set
     */
    public void setDt_movimento(Date dt_movimento) {
        this.dt_movimento = dt_movimento;
    }
    
    
}
