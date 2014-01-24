/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.prestashop.model.product.Language;
import br.com.atsinformatica.prestashop.model.product.Name;
import br.com.atsinformatica.prestashop.model.product.Product;

/**
 *
 * @author ricardosilva
 */
public class ProdutoController {
    
    /**
     *  Adiciona um produto no prestashop e caso possua categoria ele salva em uma
     *  existente ou cria uma e associa.
     * @param produtoERP
     */
    public void createProductPrestashop(ProdutoERPBean produtoERP) {
        
        if(produtoERP == null)return;
        else{
            Product product = createProduct(produtoERP);
            
        }
    }

    private Product createProduct(ProdutoERPBean produtoERP) {
            Product p = new Product();
           
            Name name = new Name();
            name.getLanguage().add(new Language(produtoERP.getDescricao()));
            
            
            
            
            
            
            p.setName(name);
            
            produtoERP.getEstoqueDisponivel();
            produtoERP.getPreco();
            produtoERP.getPrecoCusto();
            produtoERP.getRefFabricante();
            produtoERP.getReferencia();
            produtoERP.getUnidadeEnt();
            produtoERP.getUnidadeSaida();
            
            
            return p;
    }
}
