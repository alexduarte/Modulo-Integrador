/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.entity;

/**
 *
 * @author AlexsanderPimenta
 */
public class CompProdBean {
    private String codProd;
    private String codGrade;
    private double estoqueDisponivel;

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
     * @return the estoqueDisponivel
     */
    public double getEstoqueDisponivel() {
        return estoqueDisponivel;
    }

    /**
     * @param estoqueDisponivel the estoqueDisponivel to set
     */
    public void setEstoqueDisponivel(double estoqueDisponivel) {
        this.estoqueDisponivel = estoqueDisponivel;
    }
        
}
