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
public class SincronizarModel {
    @Resolvable(colName = "Entidade")
    private String entidade;
    @Resolvable(colName = "Descrição")
    private String itemDescricao;
    @Resolvable(colName = "Origem")
    private String origem;
    @Resolvable(colName = "Sincronizado")
    private boolean sincronizado;

    /**
     * @return the entidade
     */
    public String getEntidade() {
        return entidade;
    }

    /**
     * @param entidade the entidade to set
     */
    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    /**
     * @return the itemDescricao
     */
    public String getItemDescricao() {
        return itemDescricao;
    }

    /**
     * @param itemDescricao the itemDescricao to set
     */
    public void setItemDescricao(String itemDescricao) {
        this.itemDescricao = itemDescricao;
    }

    /**
     * @return the origem
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    /**
     * @return the sincronizado
     */
    public boolean isSincronizado() {
        return sincronizado;
    }

    /**
     * @param sincronizado the sincronizado to set
     */
    public void setSincronizado(boolean sincronizado) {
        this.sincronizado = sincronizado;
    }
    
}
