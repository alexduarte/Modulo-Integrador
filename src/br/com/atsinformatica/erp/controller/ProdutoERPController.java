/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.dao.ProdutoDAO;
import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.prestashop.controller.ProductController;
import br.com.atsinformatica.prestashop.model.root.Product;
import br.com.atsinformatica.prestashop.controller.ImageController;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 * Controladora de sincronização do produto do ERP
 *
 * @author AlexsanderPimenta
 */
public class ProdutoERPController extends SincERPController<ProdutoERPBean> {
    //controladora do produto no prestashop
    private ProductController prodController;

    public ProdutoERPController() {
        prodController = new ProductController();
    }

    @Override
    public void post(ProdutoERPBean obj) throws Exception {
        ProdGradeERPController prodErpController = new ProdGradeERPController();
        ProdutoDAO dao = new ProdutoDAO();
        try {
            Product p = prodController.createProductPrestashop(obj);
            if (p != null) {                
                obj.setIdProdutoEcom(Integer.parseInt(p.getId().getContent()));
                prodErpController.atualizaEstoque(obj);
                this.uploadImagesProduct(obj);
                dao.alterar(obj);
            }
            Logger.getLogger(ProdutoERPController.class).info("Produto cadastrado com sucesso na loja virtual.");
        } catch (Exception e) {
            Logger.getLogger(ProdutoERPController.class).info("Erro ao cadastrar produto na loja virtual: " + e);
        }
    }

    @Override
    public void update(ProdutoERPBean obj) {        
        ProdGradeERPController prodErpController = new ProdGradeERPController();
        try {
            prodController.updateProduto(obj);
            prodErpController.atualizaEstoque(obj);
            this.uploadImagesProduct(obj);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoERPController.class).info("Erro ao atualizar produto na loja virtual: " + ex);
        }
    }
        
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Retorna produto da loja virtual pelo id do produto na loja virtual
     * @param id id do produto na loja virtual
     * @return Product
     */
    public Product get(int id){
        return prodController.getProductById(id);
    }
    
    
    private void uploadImagesProduct(ProdutoERPBean prod) {
        ImageController imgService = new ImageController();
        try {
            imgService.prepareUpload(prod);
        } catch (Exception e) {
        }
    }
    
    
}
