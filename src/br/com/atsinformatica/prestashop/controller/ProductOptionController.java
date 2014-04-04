/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.entity.AtributoGradeEcom;
import br.com.atsinformatica.prestashop.clientDAO.ProductOptionDAO;
import br.com.atsinformatica.prestashop.model.node.Language;
import br.com.atsinformatica.prestashop.model.node.Name;
import br.com.atsinformatica.prestashop.model.node.PublicName;
import br.com.atsinformatica.prestashop.model.root.ProductOption;

/**
 *
 * @author AlexsanderPimenta
 */
public class ProductOptionController {
    
    
    public int createProductOptionPrestashop(AtributoGradeEcom atributo){
        return new ProductOptionDAO().posProductOption(ProductOption.URLPRODUCTOPTIONS, createProductOption(atributo));
    }
    
    public void updateProductOptionPrestashop(AtributoGradeEcom atributo){
        ProductOptionDAO dao = new ProductOptionDAO();
        dao.put(ProductOption.URLPRODUCTOPTIONS, createProductOption(atributo));
    }
    
    public void deleteProductOption(String id){
        ProductOptionDAO dao = new ProductOptionDAO();
        dao.delete(ProductOption.URLPRODUCTOPTIONS, id);
    }

    private ProductOption createProductOption(AtributoGradeEcom atributo) {
        ProductOption prodOption = new ProductOption();
        if(atributo.getIdAtributoEcom()!=0)prodOption.setId(String.valueOf(atributo.getIdAtributoEcom()));
        Name name = new Name();
        PublicName publicName = new PublicName();
        publicName.getLanguage().add(new Language(atributo.getDescricao()));
        name.getLanguage().add(new Language(atributo.getDescricao()));
        prodOption.setName(name);
        prodOption.setPublicName(publicName);
        return prodOption;
    }
}
