/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.bean;

/**
 * Bean do erp
 *
 * @author AlexsanderPimenta
 */
public class ERPBean {

    private int id;
    private String nomeERP;
    private String caminho;
    private String usuario;
    private String senha;
    private int qtdeReg;
    private int qtdeMant;
    private boolean ativSinc;
    private String urlWSDL;

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
     * @return the nomeERP
     */
    public String getNomeERP() {
        return nomeERP;
    }

    /**
     * @param nomeERP the nomeERP to set
     */
    public void setNomeERP(String nomeERP) {
        this.nomeERP = nomeERP;
    }

    /**
     * @return the caminho
     */
    public String getCaminho() {
        return caminho;
    }

    /**
     * @param caminho the caminho to set
     */
    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the qtdeReg
     */
    public int getQtdeReg() {
        return qtdeReg;
    }

    /**
     * @param qtdeReg the qtdeReg to set
     */
    public void setQtdeReg(int qtdeReg) {
        this.qtdeReg = qtdeReg;
    }

    /**
     * @return the qtdeMant
     */
    public int getQtdeMant() {
        return qtdeMant;
    }

    /**
     * @param qtdeMant the qtdeMant to set
     */
    public void setQtdeMant(int qtdeMant) {
        this.qtdeMant = qtdeMant;
    }

    /**
     * @return the ativSinc
     */
    public boolean isAtivSinc() {
        return ativSinc;
    }

    /**
     * @param ativSinc the ativSinc to set
     */
    public void setAtivSinc(boolean ativSinc) {
        this.ativSinc = ativSinc;
    }

    /**
     * @return the urlWSDL
     */
    public String getUrlWSDL() {
        return urlWSDL;
    }

    /**
     * @param urlWSDL the urlWSDL to set
     */
    public void setUrlWSDL(String urlWSDL) {
        this.urlWSDL = urlWSDL;
    }
}
