/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.dao.ProdutoDAO;
import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.prestashop.controller.ProdutoController;
import br.com.atsinformatica.prestashop.controller.StockAvailableController;
import br.com.atsinformatica.prestashop.model.root.Product;
import br.com.atsinformatica.prestashop.model.root.StockAvailable;

/**
 * Controladora de sincronização do produto do ERP
 *
 * @author AlexsanderPimenta
 */
public class ProdutoERPController extends SincERPController<ProdutoERPBean> {
    //controladora do produto no prestashop

    private ProdutoController prodController;

    public ProdutoERPController() {
        prodController = new ProdutoController();
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
            ProdutoDAO dao = new ProdutoDAO();
            dao.alterar(obj);
        }
    }

    @Override
    public void update(ProdutoERPBean obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
