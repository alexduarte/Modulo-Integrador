/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.erp.controller;

/**
 *
 * @author ricardosilva
 */
public class SubCategoriaController {
    
    public void createSubCategoryPrestaShop(String listSubCategorias){
        
        if(listSubCategorias.isEmpty()) return;       
        String subCategorias[] = listSubCategorias.split("/");
        
        for (int i = 0; i < subCategorias.length; i++) {
             
        }    
    }
}
