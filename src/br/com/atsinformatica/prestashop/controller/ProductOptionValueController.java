/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.entity.GradeERPBean;
import br.com.atsinformatica.erp.entity.SubGradeERPBean;
import br.com.atsinformatica.prestashop.clientDAO.ProductOptionValueDAO;
import br.com.atsinformatica.prestashop.model.node.Language;
import br.com.atsinformatica.prestashop.model.node.Name;
import br.com.atsinformatica.prestashop.model.root.ProductOptionValue;

/**
 *
 * @author AlexsanderPimenta
 */
public class ProductOptionValueController {

    public int createProductOptionValuePrestashop(Object obj) {
        return new ProductOptionValueDAO().postProductOptionValue(ProductOptionValue.URLPRODUCTOPTIONVALUE, createProductOptionValue(obj));
    }

    private ProductOptionValue createProductOptionValue(Object obj) {
        ProductOptionValue prodOptionValue = new ProductOptionValue();
        Name name = null;
        if (obj.getClass().equals(GradeERPBean.class)) {
            GradeERPBean grade = (GradeERPBean) obj;
            if(grade.getIdGradeEcom()!=0)prodOptionValue.setId(String.valueOf(grade.getIdGradeEcom()));
            name = new Name();
            prodOptionValue.setIdAttributeGroup(grade.getIdAtributo());
            name.getLanguage().add(new Language(grade.getDescricaoGrade()));
            prodOptionValue.setName(name);
        }
        if(obj.getClass().equals(SubGradeERPBean.class)){
            SubGradeERPBean subGrade = (SubGradeERPBean) obj;
            if(subGrade.getIdSubgradeEcom()!=0)prodOptionValue.setId(String.valueOf(subGrade.getIdSubgradeEcom()));
            name = new Name();
            prodOptionValue.setIdAttributeGroup(subGrade.getIdAtributo());
            name.getLanguage().add(new Language(subGrade.getDescSubGrade()));
            prodOptionValue.setName(name);            
        }
        return prodOptionValue;
    }
}
