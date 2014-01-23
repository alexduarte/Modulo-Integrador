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
public class SubCategoriaNivelBean {
    
    private SubCategoriaERPBean subCategoriaERPBean;
    
    private Integer nivel;

    public SubCategoriaNivelBean(SubCategoriaERPBean subCategoriaERPBean, Integer nivel) {
        this.subCategoriaERPBean = subCategoriaERPBean;
        this.nivel = nivel;
    }

    public SubCategoriaNivelBean() {
    }

    public SubCategoriaERPBean getSubCategoriaERPBean() {
        return subCategoriaERPBean;
    }

    public void setSubCategoriaERPBean(SubCategoriaERPBean subCategoriaERPBean) {
        this.subCategoriaERPBean = subCategoriaERPBean;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    
    
    
}
