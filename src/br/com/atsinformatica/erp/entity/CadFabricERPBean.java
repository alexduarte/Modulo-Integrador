/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.entity;

/**
 *
 * @author AlexsanderPimenta
 */
public class CadFabricERPBean {
    
    private String codFabric;
    private String descricao;
    private int idFabricanteEcom;
    private String cgCpf;

    /**
     * @return the codFabric
     */
    public String getCodFabric() {
        return codFabric;
    }

    /**
     * @param codFabric the codFabric to set
     */
    public void setCodFabric(String codFabric) {
        this.codFabric = codFabric;
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
     * @return the idFabricanteEcom
     */
    public int getIdFabricanteEcom() {
        return idFabricanteEcom;
    }

    /**
     * @param idFabricanteEcom the idFabricanteEcom to set
     */
    public void setIdFabricanteEcom(int idFabricanteEcom) {
        this.idFabricanteEcom = idFabricanteEcom;
    }

    /**
     * @return the cgCpf
     */
    public String getCgCpf() {
        return cgCpf;
    }

    /**
     * @param cgCpf the cgCpf to set
     */
    public void setCgCpf(String cgCpf) {
        this.cgCpf = cgCpf;
    }
    
}
