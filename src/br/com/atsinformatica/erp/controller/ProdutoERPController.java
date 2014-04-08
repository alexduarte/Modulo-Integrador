/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.dao.GradeERPDAO;
import br.com.atsinformatica.erp.dao.ProdGradeERPDAO;
import br.com.atsinformatica.erp.dao.ProdutoDAO;
import br.com.atsinformatica.erp.entity.GradeERPBean;
import br.com.atsinformatica.erp.entity.ProdGradeERPBean;
import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.prestashop.controller.ProductController;
import br.com.atsinformatica.prestashop.controller.ProductOptionValueController;
import br.com.atsinformatica.prestashop.controller.StockAvailableController;
import br.com.atsinformatica.prestashop.model.root.Product;
import br.com.atsinformatica.prestashop.model.root.StockAvailable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
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
        StockAvailableController stockController = new StockAvailableController();
        ProdutoDAO dao = new ProdutoDAO();
        try {
            Product p = prodController.createProductPrestashop(obj);
            if (p != null) {
                StockAvailable stock = stockController.getStock(p.getAssociations().getStockAvailables().getStockAvailable().get(0).getId());
                obj.setIdProdutoEcom(Integer.parseInt(p.getId().getContent()));
                stock.setQuantity(Integer.parseInt(obj.getEstoqueDisponivel().toString()));
                stockController.updateStockAvailable(stock);
                dao.alterar(obj);
            }
            Logger.getLogger(ProdutoERPController.class).info("Produto cadastrado com sucesso na loja virtual.");
        } catch (Exception e) {
            Logger.getLogger(ProdutoERPController.class).info("Erro ao cadastrar produto na loja virtual: " + e);

        }

    }

    @Override
    public void update(ProdutoERPBean obj) {
        try {
            prodController.updateProduto(obj);            
        } catch (SQLException ex) {
            //Logger.getLogger(ProdutoERPController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
