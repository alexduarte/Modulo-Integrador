/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.erp.entity;

/**
 *
 * @author ricardosilva
 */
public class SubCategoriaERPBean {
    
    private Integer id;
    
    private CategoriaERPBean fkCategoria;
    
    private String descrição;
 
    
    //--------Getters e Setters--------//

    
    public SubCategoriaERPBean(Integer id, CategoriaERPBean fkCategoria, String description) {
        this.id = id;
        this.fkCategoria = fkCategoria;
        this.descrição = description;
    }

    public SubCategoriaERPBean() {
    }
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CategoriaERPBean getFkCategoria() {
        return fkCategoria;
    }

    public void setFkCategoria(CategoriaERPBean fkCategoria) {
        this.fkCategoria = fkCategoria;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }
}
