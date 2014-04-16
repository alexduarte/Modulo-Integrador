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
public class ReservaIERP {

    private int codReservar;
    private String codProd;
    private double quantidade;
    private double preco;
    private String baixado;
    private String codGrade;

    public int getCodReservar() {
        return codReservar;
    }

    public void setCodReservar(int codReservar) {
        this.codReservar = codReservar;
    }

    public String getCodProd() {
        return codProd;
    }

    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getBaixado() {
        return baixado;
    }

    public void setBaixado(String baixado) {
        this.baixado = baixado;
    }

    public String getCodGrade() {
        return codGrade;
    }

    public void setCodGrade(String codGrade) {
        this.codGrade = codGrade;
    }

}
