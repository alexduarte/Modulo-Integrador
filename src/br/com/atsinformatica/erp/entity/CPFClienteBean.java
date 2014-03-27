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
public class CPFClienteBean {

    private String idCLiente;

    private String tipoDocumento;

    private String cpf_Cnpj;

    private String rg_inscricao;

    public String getIdCLiente() {
        return idCLiente;
    }

    public void setIdCLiente(String idCLiente) {
        this.idCLiente = idCLiente;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCpf_Cnpj() {
        return cpf_Cnpj;
    }

    public void setCpf_Cnpj(String cpf_Cnpj) {
        this.cpf_Cnpj = cpf_Cnpj;
    }

    public String getRg_inscricao() {
        return rg_inscricao;
    }

    public void setRg_inscricao(String rg_inscricao) {
        this.rg_inscricao = rg_inscricao;
    }

   
}
