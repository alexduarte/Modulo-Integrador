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
    private String filialSincronizacao;
    private String codEmpresaEcom;
    private String codVendendEcom;
    private String prodPaiFilho;
    private String codOperDentroEstado;
    private String codOperForaEstado;
    private String caminhoRavePedido;
    private String grupoProdNSincronizar;
   

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

    /**
     * @return the filialSincronizacao
     */
    public String getFilialSincronizacao() {
        return filialSincronizacao;
    }

    /**
     * @param filialSincronizacao the filialSincronizacao to set
     */
    public void setFilialSincronizacao(String filialSincronizacao) {
        this.filialSincronizacao = filialSincronizacao;
    }

    /**
     * @return the codEmpresaEcom
     */
    public String getCodEmpresaEcom() {
        return codEmpresaEcom;
    }

    /**
     * @param codEmpresaEcom the codEmpresaEcom to set
     */
    public void setCodEmpresaEcom(String codEmpresaEcom) {
        this.codEmpresaEcom = codEmpresaEcom;
    }

    /**
     * @return the codVendendEcom
     */
    public String getCodVendendEcom() {
        return codVendendEcom;
    }

    /**
     * @param codVendendEcom the codVendendEcom to set
     */
    public void setCodVendendEcom(String codVendendEcom) {
        this.codVendendEcom = codVendendEcom;
    }

    /**
     * @return the prodPaiFilho
     */
    public String getProdPaiFilho() {
        return prodPaiFilho;
    }

    /**
     * @param prodPaiFilho the prodPaiFilho to set
     */
    public void setProdPaiFilho(String prodPaiFilho) {
        this.prodPaiFilho = prodPaiFilho;
    }

    /**
     * @return the codOperDentroEstado
     */
    public String getCodOperDentroEstado() {
        return codOperDentroEstado;
    }

    /**
     * @param codOperDentroEstado the codOperDentroEstado to set
     */
    public void setCodOperDentroEstado(String codOperDentroEstado) {
        this.codOperDentroEstado = codOperDentroEstado;
    }

    /**
     * @return the codOperForaEstado
     */
    public String getCodOperForaEstado() {
        return codOperForaEstado;
    }

    /**
     * @param codOperForaEstado the codOperForaEstado to set
     */
    public void setCodOperForaEstado(String codOperForaEstado) {
        this.codOperForaEstado = codOperForaEstado;
    }

    /**
     * @return the caminhoRavePedido
     */
    public String getCaminhoRavePedido() {
        return caminhoRavePedido;
    }

    /**
     * @param caminhoRavePedido the caminhoRavePedido to set
     */
    public void setCaminhoRavePedido(String caminhoRavePedido) {
        this.caminhoRavePedido = caminhoRavePedido;
    }

    /**
     * @return the grupoProdNSincronizar
     */
    public String getGrupoProdNSincronizar() {
        return grupoProdNSincronizar;
    }

    /**
     * @param grupoProdNSincronizar the grupoProdNSincronizar to set
     */
    public void setGrupoProdNSincronizar(String grupoProdNSincronizar) {
        this.grupoProdNSincronizar = grupoProdNSincronizar;
    }
}
