/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.entity;

/**
 *
 * @author AlexsanderPimenta
 */
public class ProdGradeERPBean {
    
    private String codProd;
    private String codGrade;
    private String codBarra;
    private Double precoGrade;
    private String descricaoGrade; 
    private Double estoque;
    private int idProdGradeEcom;
    private int tipoGrade;

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
     * @return the codBarra
     */
    public String getCodBarra() {
        return codBarra;
    }

    /**
     * @param codBarra the codBarra to set
     */
    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    /**
     * @return the precoGrade
     */
    public Double getPrecoGrade() {
        return precoGrade;
    }

    /**
     * @param precoGrade the precoGrade to set
     */
    public void setPrecoGrade(Double precoGrade) {
        this.precoGrade = precoGrade;
    }

    /**
     * @return the idProdGradeEcom
     */
    public int getIdProdGradeEcom() {
        return idProdGradeEcom;
    }

    /**
     * @param idProdGradeEcom the idProdGradeEcom to set
     */
    public void setIdProdGradeEcom(int idProdGradeEcom) {
        this.idProdGradeEcom = idProdGradeEcom;
    }

    /**
     * @return the descricaoGrade
     */
    public String getDescricaoGrade() {
        return descricaoGrade;
    }

    /**
     * @param descricaoGrade the descricaoGrade to set
     */
    public void setDescricaoGrade(String descricaoGrade) {
        this.descricaoGrade = descricaoGrade;
    }

    /**
     * @return the estoque
     */
    public Double getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    /**
     * @return the tipoGrade
     */
    public int getTipoGrade() {
        return tipoGrade;
    }

    /**
     * @param tipoGrade the tipoGrade to set
     */
    public void setTipoGrade(int tipoGrade) {
        this.tipoGrade = tipoGrade;
    }
    
    
}
