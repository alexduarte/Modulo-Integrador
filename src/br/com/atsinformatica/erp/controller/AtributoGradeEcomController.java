/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.dao.AtributoGradeEcomDAO;
import br.com.atsinformatica.erp.entity.AtributoGradeEcom;
import br.com.atsinformatica.prestashop.controller.ProductOptionController;
import org.apache.log4j.Logger;

/**
 *
 * @author AlexsanderPimenta
 */
public class AtributoGradeEcomController extends SincERPController<AtributoGradeEcom> {
    
    private ProductOptionController prodOptionController;
    
    public AtributoGradeEcomController(){
        prodOptionController = new ProductOptionController();
    }
    
    @Override
    public void post(AtributoGradeEcom obj) throws Exception  {
        try {
            //faz o post dos atributos cadastrados
            int codAtributoEcom = prodOptionController.createProductOptionPrestashop(obj);
            if (codAtributoEcom != 0) {
                obj.setIdAtributoEcom(codAtributoEcom);
                AtributoGradeEcomDAO dao = new AtributoGradeEcomDAO();
                //salvando código do atributo cadastrado 
                dao.alterar(obj);
            }
            Logger.getLogger(AtributoGradeEcomController.class).info("Atributo grade sincronizado na loja virtual com sucesso.");
        } catch (Exception e) {
            Logger.getLogger(AtributoGradeEcomController.class).error("Erro ao sincronizar atributo grade na loja virtual: "+e);
        }
    }

    @Override
    public void update(AtributoGradeEcom obj) {
         try{
            prodOptionController.updateProductOptionPrestashop(obj);
            Logger.getLogger(AtributoGradeEcomController.class).info("Atributo grade atualizado na loja virtual com sucesso.");
         }catch(Exception e){
            Logger.getLogger(AtributoGradeEcomController.class).error("Erro ao atualizar atributo grade na loja virtual: "+e);             
         }                  
    } 
    
    public void delete(String id) {
        try{
            prodOptionController.deleteProductOption(id);
            Logger.getLogger(AtributoGradeEcomController.class).info("Atributo grade deletada na loja virtual com sucesso.");
        }catch(Exception e){
            Logger.getLogger(AtributoGradeEcomController.class).error("Erro ao deletar atributo grade na loja virtual");
            
        }
    }
}
