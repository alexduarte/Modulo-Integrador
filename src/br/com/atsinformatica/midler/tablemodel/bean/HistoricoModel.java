/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.tablemodel.bean;

import com.towel.el.annotation.Resolvable;

/**
 *
 * @author AlexsanderPimenta
 */
public class HistoricoModel {
    @Resolvable(colName = "Tipo")
    private String tipo;
    @Resolvable(colName = "Nome")
    private String nome;
    @Resolvable(colName = "Servidor")
    private String servidor;
    @Resolvable(colName = "Sincronizar")
    private boolean sincronizar;

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the servidor
     */
    public String getServidor() {
        return servidor;
    }

    /**
     * @param servidor the servidor to set
     */
    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    /**
     * @return the sincronizar
     */
    public boolean isSincronizar() {
        return sincronizar;
    }

    /**
     * @param sincronizar the sincronizar to set
     */
    public void setSincronizar(boolean sincronizar) {
        this.sincronizar = sincronizar;
    }
    
}
