/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.entity;

/**
 *
 * @author AlexsanderPimenta
 */
public class CategoriaEcomBean {
    
    private String codCategoria;
    private String descricao;
    private String principal;
    private String codCategoriaSuperior;
    private String descricaoDetalhada;
    private String descricaoCompleta;
    private int idCategoriaEcom;

    /**
     * @return the codCategoria
     */
    public String getCodCategoria() {
        return codCategoria;
    }

    /**
     * @param codCategoria the codCategoria to set
     */
    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
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
     * @return the principal
     */
    public String getPrincipal() {
        return principal;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    /**
     * @return the codCategoriaSuperior
     */
    public String getCodCategoriaSuperior() {
        return codCategoriaSuperior;
    }

    /**
     * @param codCategoriaSuperior the codCategoriaSuperior to set
     */
    public void setCodCategoriaSuperior(String codCategoriaSuperior) {
        this.codCategoriaSuperior = codCategoriaSuperior;
    }

    /**
     * @return the descricaoDetalhada
     */
    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    /**
     * @param descricaoDetalhada the descricaoDetalhada to set
     */
    public void setDescricaoDetalhada(String descricaoDetalhada) {
        this.descricaoDetalhada = descricaoDetalhada;
    }

    /**
     * @return the descricaoCompleta
     */
    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }

    /**
     * @param descricaoCompleta the descricaoCompleta to set
     */
    public void setDescricaoCompleta(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    /**
     * @return the idCategoriaEcom
     */
    public int getIdCategoriaEcom() {
        return idCategoriaEcom;
    }

    /**
     * @param idCategoriaEcom the idCategoriaEcom to set
     */
    public void setIdCategoriaEcom(int idCategoriaEcom) {
        this.idCategoriaEcom = idCategoriaEcom;
    }
    
}
