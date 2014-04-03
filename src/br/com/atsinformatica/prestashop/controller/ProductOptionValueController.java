/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.controller.GradeERPController;
import br.com.atsinformatica.erp.entity.GradeERPBean;
import br.com.atsinformatica.prestashop.clientDAO.ProductOptionValueDAO;
import br.com.atsinformatica.prestashop.model.node.Language;
import br.com.atsinformatica.prestashop.model.node.Name;
import br.com.atsinformatica.prestashop.model.root.ProductOptionValue;

/**
 *
 * @author AlexsanderPimenta
 */
public class ProductOptionValueController {
       
    public int createProductOptionValuePrestashop(GradeERPBean grade){
        return new ProductOptionValueDAO().posProductOptionValue(ProductOptionValue.URLPRODUCTOPTIONVALUE, createProductOptionValue(grade));
    }

    private ProductOptionValue createProductOptionValue(GradeERPBean grade) {
        ProductOptionValue prodOptionValue = new ProductOptionValue();
        Name name = new Name();
        prodOptionValue.setIdAttributeGroup(grade.getIdAtributo());
        name.getLanguage().add(new Language(grade.getDescricao()));
        prodOptionValue.setName(name);
        return prodOptionValue;
    }
    
}
