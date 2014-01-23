/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.entity;

/**
 * Bean de paramatros de configuração do Modulo
 * @author AlexsanderPimenta
 */
public class ParaEcomBean {
    
    private String codparaecom;
    private int minutoscadastro;
    private int minutosmov;
    private int qtdeRegistros;
    private int qtdMantido;
    private int ativaSincronizacao;
   

    /**
     * @return the codparaecom
     */
    public String getCodparaecom() {
        return codparaecom;
    }

    /**
     * @param codparaecom the codparaecom to set
     */
    public void setCodparaecom(String codparaecom) {
        this.codparaecom = codparaecom;
    }

    /**
     * @return the minutoscadastro
     */
    public int getMinutoscadastrados() {
        return minutoscadastro;
    }

    /**
     * @param minutoscadastro the minutoscadastro to set
     */
    public void setMinutoscadastrados(int minutoscadastrados) {
        this.minutoscadastro = minutoscadastrados;
    }

    /**
     * @return the minutosmov
     */
    public int getMinutosmov() {
        return minutosmov;
    }

    /**
     * @param minutosmov the minutosmov to set
     */
    public void setMinutosmov(int minutosmov) {
        this.minutosmov = minutosmov;
    }

    /**
     * @return the qtdeRegistros
     */
    public int getQtdeRegistros() {
        return qtdeRegistros;
    }

    /**
     * @param qtdeRegistros the qtdeRegistros to set
     */
    public void setQtdeRegistros(int qtdeRegistros) {
        this.qtdeRegistros = qtdeRegistros;
    }

    /**
     * @return the qtdMantido
     */
    public int getQtdMantido() {
        return qtdMantido;
    }

    /**
     * @param qtdMantido the qtdMantido to set
     */
    public void setQtdMantido(int qtdMantido) {
        this.qtdMantido = qtdMantido;
    }

    /**
     * @return the ativaSincronizacao
     */
    public int getAtivaSincronizacao() {
        return ativaSincronizacao;
    }

    /**
     * @param ativaSincronizacao the ativaSincronizacao to set
     */
    public void setAtivaSincronizacao(int ativaSincronizacao) {
        this.ativaSincronizacao = ativaSincronizacao;
    }    
}
