/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.dao.CadFabrERPDAO;
import br.com.atsinformatica.erp.entity.CadFabricERPBean;
import br.com.atsinformatica.prestashop.controller.ManufacturerController;
import org.apache.log4j.Logger;

/**
 *
 * @author AlexsanderPimenta
 */
public class FabricERPController extends SincERPController<CadFabricERPBean> {
    ManufacturerController manufController = null;
    
    
    @Override
    public void post(CadFabricERPBean obj) {
        try {
            //faz o post das categorias pendentes de sincronização
            manufController = new ManufacturerController();
            int fabricEcom = manufController.createManufacturerPrestashop(obj);
            if (fabricEcom != 0) {
                obj.setIdFabricanteEcom(fabricEcom);
                CadFabrERPDAO dao = new CadFabrERPDAO();
                //salvando código do fabricante cadastrada 
                dao.alterar(obj);
            }
            Logger.getLogger(CategoriaERPController.class).info("Fabricante sincronizado na loja virtual com sucesso.");
        } catch (Exception e) {
            Logger.getLogger(CategoriaERPController.class).error("Erro ao sincronizar fabricante na loja virtual: "+e);
        }
    }

    @Override
    public void update(CadFabricERPBean obj) {
         try{
            manufController = new ManufacturerController();
            manufController.updateManufacturerPrestashop(obj);
            Logger.getLogger(CategoriaERPController.class).info("Fabricante atualizado na loja virtual com sucesso.");
         }catch(Exception e){
            Logger.getLogger(CategoriaERPController.class).error("Erro ao atualizar fabricante na loja virtual: "+e);             
         }                  
    }   
    public void delete(String id) {
        try{
            manufController = new ManufacturerController();
            manufController.deleteManufacturerPrestashop(id);
            Logger.getLogger(CategoriaERPController.class).info("Fabricante deletado na loja virtual com sucesso.");
        }catch(Exception e){
            Logger.getLogger(CategoriaERPController.class).error("Erro ao deletar categoria na loja virtual");
            
        }
    }
    
}
