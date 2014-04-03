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
public class PedidoIERPBean {
    private String codEmpresa;  
    private String codPedido;   
    private String codProdERP;  
    private String codGradERP;
    private double quantidade;
    private double precoUnit;
    private double totalItem;   //(Quantidade x Preço Unitário)
    private double peso;        // peso unitario
    private String unidadeSaida; 
    private String codClienteERP;

    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }


    public String getCodProdERP() {
        return codProdERP;
    }

    public void setCodProdERP(String codProdERP) {
        this.codProdERP = codProdERP;
    }

    public String getCodGradERP() {
        return codGradERP;
    }

    public void setCodGradERP(String codGradERP) {
        this.codGradERP = codGradERP;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(double precoUnit) {
        this.precoUnit = precoUnit;
    }

    public double getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(double totalItem) {
        this.totalItem = totalItem;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getUnidadeSaida() {
        return unidadeSaida;
    }

    public void setUnidadeSaida(String unidadeSaida) {
        this.unidadeSaida = unidadeSaida;
    }

    public String getCodClienteERP() {
        return codClienteERP;
    }

    public void setCodClienteERP(String codClienteERP) {
        this.codClienteERP = codClienteERP;
    }
    
    
    
}
