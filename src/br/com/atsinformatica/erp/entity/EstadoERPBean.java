/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.entity;

/**
 *
 * @author kennedimalheiros
 */
public class EstadoERPBean {

    private String id;
    private String sigla;
    private String descricao;
    
    private String siglaCobracao;
    private String descricaoCobracao;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSiglaCobracao() {
        return siglaCobracao;
    }

    public void setSiglaCobracao(String siglaCobracao) {
        this.siglaCobracao = siglaCobracao;
    }

    public String getDescricaoCobracao() {
        return descricaoCobracao;
    }

    public void setDescricaoCobracao(String descricaoCobracao) {
        this.descricaoCobracao = descricaoCobracao;
    }

}
