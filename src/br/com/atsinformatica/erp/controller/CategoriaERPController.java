/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.dao.CategoriaEcomDAO;
import br.com.atsinformatica.erp.entity.CategoriaEcomErpBean;
import br.com.atsinformatica.prestashop.controller.CategoriaController;
import org.apache.log4j.Logger;

/**
 *
 * @author AlexsanderPimenta
 */
public class CategoriaERPController extends SincERPController<CategoriaEcomErpBean> {

    private CategoriaController catController;
    
    public CategoriaERPController(){
        catController = new CategoriaController();
    }

    @Override
    public void post(CategoriaEcomErpBean obj) {
        try {
            //faz o post das categorias pendentes de sincronização
            catController = new CategoriaController();
            int codCatEcom = catController.createCategoryPrestashop(obj);
            if (codCatEcom != 0) {
                obj.setIdCategoriaEcom(codCatEcom);
                CategoriaEcomDAO dao = new CategoriaEcomDAO();
                //salvando código da categoria cadastrada 
                dao.alteraIdEcom(obj);
            }
            Logger.getLogger(CategoriaERPController.class).info("Categoria sincronizada na loja virtual com sucesso.");
        } catch (Exception e) {
            Logger.getLogger(CategoriaERPController.class).error("Erro ao sincronizar categoria na loja virtual: "+e);
        }
    }

    @Override
    public void update(CategoriaEcomErpBean obj) {
         try{
            catController.updateCategoryPrestashop(obj);
            Logger.getLogger(CategoriaERPController.class).info("Categoria atualizada na loja virtual com sucesso.");
         }catch(Exception e){
            Logger.getLogger(CategoriaERPController.class).error("Erro ao atualizar categoria na loja virtual: "+e);             
         }                  
    }   
    public void delete(String id) {
        try{
            catController.deleteCategoryPrestashop(id);
            Logger.getLogger(CategoriaERPController.class).info("Categoria deletada na loja virtual com sucesso.");
        }catch(Exception e){
            Logger.getLogger(CategoriaERPController.class).error("Erro ao deletar categoria na loja virtual");
            
        }
    }
}
