/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.prestashop.model;

/**
 *
 * @author ricardosilva
 */
public class CategoriaPrestashopBean {
    
    private Integer id;
    
    private CategoriaPrestashopBean idParent;
       
    private String Descricao;

    public CategoriaPrestashopBean(Integer id, CategoriaPrestashopBean idParent, String Descricao) {
        this.id = id;
        this.idParent = idParent;
        this.Descricao = Descricao;
    }

    public CategoriaPrestashopBean() {
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CategoriaPrestashopBean getIdParent() {
        return idParent;
    }

    public void setIdParent(CategoriaPrestashopBean idParent) {
        this.idParent = idParent;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }   
}
