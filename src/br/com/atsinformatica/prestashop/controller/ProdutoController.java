/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.dao.CategoriaEcomDAO;
import br.com.atsinformatica.prestashop.model.node.Name;
import br.com.atsinformatica.prestashop.model.node.Language;
import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.prestashop.clientDAO.ProductPrestashopDAO;
import br.com.atsinformatica.prestashop.model.node.*;
import br.com.atsinformatica.prestashop.model.root.Product;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ricardosilva
 */
public class ProdutoController {

    List<ProdutoERPBean> listProduct;

    /**
     * Adiciona um produto no prestashop e caso possua categoria ele salva em
     * uma existente ou cria uma e associa.
     *
     * @param listProdutoERP
     * @return
     */
    public int createProductPrestashop(ProdutoERPBean produtoErp) throws SQLException {
        // return listProduct;
        return new ProductPrestashopDAO().postWithVerification(Product.URLPRODUCTS, createProduct(produtoErp));

    }

    private Product createProduct(ProdutoERPBean produtoERP) throws SQLException {
        Product p = new Product();
        Name name = new Name();
        name.getLanguage().add(new Language(produtoERP.getNomeProd()));
        Price price = new Price();
        price.setContent(String.valueOf(produtoERP.getPrecoCheio()));
        LinkRewrite linkRewrite = new LinkRewrite();
        linkRewrite.getLanguage().add(new Language(produtoERP.getDescricaoCompleta()));
       // p.setEan13(produtoERP.getCodBarras());
        p.setIdCategoryDefault(new CategoriaEcomDAO().abrir(produtoERP.getCodCategoria()).getIdCategoriaEcom());
        p.setDepth(String.valueOf(produtoERP.getProfundidade()));
        p.setWeight(String.valueOf(produtoERP.getPeso()));
        p.setWidth(String.valueOf(produtoERP.getLargura()));
        p.setHeight(String.valueOf(produtoERP.getAltura()));
        p.setMetaDescription(new MetaDescription(produtoERP.getMetaDescricao()));
        p.setMetaKeyWord(new MetaKeyWord(produtoERP.getPalavrasChave()));
        p.setDescription(new Description(produtoERP.getDescricaoCompleta()));
        p.setIdErp(Integer.parseInt(produtoERP.getCodProd()));
        p.setName(name);
        p.setPrice(price);
        p.setLinkRewrite(linkRewrite);
        return p;
    }
}
