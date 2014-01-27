/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.prestashop.model.product.Language;
import br.com.atsinformatica.prestashop.model.product.Name;
import br.com.atsinformatica.prestashop.model.product.Price;
import br.com.atsinformatica.prestashop.model.product.Product;
import java.util.List;

/**
 *
 * @author ricardosilva
 */
public class ProdutoController {
    
    /**
     *  Adiciona um produto no prestashop e caso possua categoria ele salva em uma
     *  existente ou cria uma e associa.
     * @param listProdutoERP
     */
    public void createProductPrestashop(List<ProdutoERPBean> listProdutoERP) {
        
        if(listProdutoERP == null || listProdutoERP.size() == 0)return;
        else{
            for (ProdutoERPBean produtoERPBean : listProdutoERP) {
                Product product = createProduct(produtoERPBean);
                
            }
            
            
        }
    }

    private Product createProduct(ProdutoERPBean produtoERP) {
            Product p = new Product();
           
            Name name = new Name();
            name.getLanguage().add(new Language(produtoERP.getDescricao()));
            
            Price price = new Price();
            price.setContent(produtoERP.getPreco().toString());
            
            p.setName(name);
            p.setPrice(price);
            p.setReference(produtoERP.getReferencia());
            
            produtoERP.getEstoqueDisponivel();
            
            produtoERP.getPrecoCusto();
            produtoERP.getRefFabricante();
            
            produtoERP.getUnidadeEnt();
            produtoERP.getUnidadeSaida();
            
            
            return p;
    }
}
