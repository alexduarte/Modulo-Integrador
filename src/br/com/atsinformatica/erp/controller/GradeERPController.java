/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.entity.GradeERPBean;

/**
 *
 * @author AlexsanderPimenta
 */
public class GradeERPController extends SincERPController<GradeERPBean> {

    @Override
    public void post(GradeERPBean obj) throws Exception {        
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
