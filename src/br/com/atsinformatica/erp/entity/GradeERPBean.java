/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.entity;

/**
 *
 * @author AlexsanderPimenta
 */
public class GradeERPBean {

    private String codGrade;    
    private String descricaoGrade;       
    private int idAtributo;
    private int idGradeEcom;


    /**
     * @return the idAtributo
     */
    public int getIdAtributo() {
        return idAtributo;
    }

    /**
     * @param idAtributo the idAtributo to set
     */
    public void setIdAtributo(int idAtributo) {
        this.idAtributo = idAtributo;
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
     * @return the idGradeEcom
     */
    public int getIdGradeEcom() {
        return idGradeEcom;
    }

    /**
     * @param idGradeEcom the idGradeEcom to set
     */
    public void setIdGradeEcom(int idGradeEcom) {
        this.idGradeEcom = idGradeEcom;
    }

   
   

}
