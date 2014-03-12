/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.prestashop.model.node.Name;
import br.com.atsinformatica.prestashop.model.node.Language;
import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.prestashop.clientDAO.PSMediaDAO;
import br.com.atsinformatica.prestashop.clientDAO.ProductPrestashopDAO;
import br.com.atsinformatica.prestashop.model.node.*;
import br.com.atsinformatica.prestashop.model.root.Product;

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
    public List<ProdutoERPBean> createProductPrestashop(List<ProdutoERPBean> listProdutoERP) {

        if (listProdutoERP.isEmpty() || listProdutoERP == null) {
            return null;
        } else {
            listProduct = new ArrayList<>();
            for (ProdutoERPBean produtoERPBean : listProdutoERP) {
                if (createProduct(produtoERPBean)) {
                    produtoERPBean.setImportadoLoja(true);
                    listProduct.add(produtoERPBean);
                } else {
                    listProduct.add(produtoERPBean);
                }
            }
            return listProduct;
        }
    }

    private boolean createProduct(ProdutoERPBean produtoERP) {
        Product p = new Product();
        Name name = new Name();
        name.getLanguage().add(new Language(produtoERP.getDescricao()));
        Price price = new Price();
        price.setContent(produtoERP.getPreco().toString());
        LinkRewrite linkRewrite = new LinkRewrite();
        linkRewrite.getLanguage().add(new Language(produtoERP.getDescricao()));
        p.setName(name);
        p.setPrice(price);
        p.setLinkRewrite(linkRewrite);
        PSMediaDAO mediaDAO = new PSMediaDAO();
        mediaDAO.post("", produtoERP.getMedia());
      //  p.setIdCategoryDefault(new CategoriaController().createCategoryAndSubCategoryPrestashop(produtoERP.getCategoria(), produtoERP.getSubCategoria()));
        ProductPrestashopDAO productPrestashopDAO = new ProductPrestashopDAO();
        return productPrestashopDAO.postWithVerification(Product.URLPRODUCTS, p);
    }
}
