/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.entity;

/**
 *
 * @author AlexsanderPimenta
 */
public class AtributoGradeEcom {    
    private String codAtributo;
    private String descricao;
    private int idAtributoEcom;

    /**
     * @return the codAtributo
     */
    public String getCodAtributo() {
        return codAtributo;
    }

    /**
     * @param codAtributo the codAtributo to set
     */
    public void setCodAtributo(String codAtributo) {
        this.codAtributo = codAtributo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the idAtributoEcom
     */
    public int getIdAtributoEcom() {
        return idAtributoEcom;
    }

    /**
     * @param idAtributoEcom the idAtributoEcom to set
     */
    public void setIdAtributoEcom(int idAtributoEcom) {
        this.idAtributoEcom = idAtributoEcom;
    }
    
}
