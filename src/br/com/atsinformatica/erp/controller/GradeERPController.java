/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.entity.GradeERPBean;
import br.com.atsinformatica.prestashop.clientDAO.ProductOptionValueDAO;
import br.com.atsinformatica.prestashop.model.list.ProductOptionValues;

/**
 *
 * @author AlexsanderPimenta
 */
public class GradeERPController extends SincERPController<GradeERPBean> {

   // private productoptionco
    @Override
    public void post(GradeERPBean obj) throws Exception {
     //   ProductOptionValueDAO 
        try{
            
        }catch(Exception e){
            
        }
    }

    @Override
    public void update(GradeERPBean obj) {
        super.update(obj); 
    }

    @Override
    public void delete(GradeERPBean obj) {
        super.delete(obj); 
    }
    
    
    
}
