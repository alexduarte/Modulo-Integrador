/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.dao.ProdutoDAO;
import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.prestashop.controller.ProductController;
import br.com.atsinformatica.prestashop.controller.StockAvailableController;
import br.com.atsinformatica.prestashop.model.root.Product;
import br.com.atsinformatica.prestashop.model.root.StockAvailable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        StockAvailableController stockController = new StockAvailableController();
        Product p = prodController.createProductPrestashop(obj);
        if (p != null) {
            StockAvailable stock = new StockAvailable();
            stock.setId(p.getStockAvailables().getStockAvailable().get(0).getId());
            stock.setQuantity(obj.getEstoqueDisponivel().intValue());
            int idProduct = Integer.parseInt(p.getId().getContent());
            stock.setIdProduct(idProduct);
            obj.setIdProdutoEcom(idProduct);            
            stockController.updateStockAvailable(stock);
            if(obj.getGrade()!=0){
                //chama contralodora da grade, cadastra atributo e grade na loja virtual
                //retorna codigo de cadastradas para serem inserida na combinação do produto
                
            }
            ProdutoDAO dao = new ProdutoDAO();
            dao.alterar(obj);
        }
    }

    @Override
    public void update(ProdutoERPBean obj) {
        try {
            prodController.updateProduto(obj);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoERPController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
