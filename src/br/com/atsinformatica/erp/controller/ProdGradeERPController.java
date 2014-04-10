/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.dao.ProdGradeERPDAO;
import br.com.atsinformatica.erp.dao.ProdutoDAO;
import br.com.atsinformatica.erp.entity.ProdGradeERPBean;
import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.prestashop.controller.StockAvailableController;
import br.com.atsinformatica.prestashop.model.node.StockAvailableNode;
import br.com.atsinformatica.prestashop.model.root.Product;
import br.com.atsinformatica.prestashop.model.root.StockAvailable;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author AlexsanderPimenta
 */
public class ProdGradeERPController {
    
    public void atualizaEstoque(ProdutoERPBean prodBean){
        ProdutoERPController prodController = new ProdutoERPController();
        ProdGradeERPDAO prodGradeDAO = new ProdGradeERPDAO();
        ProdutoDAO prodDao = new ProdutoDAO();
        List<ProdGradeERPBean> listaGrades = null;
        StockAvailableController stockController = new StockAvailableController();
        StockAvailable stock = null;
        try{            
            //Produto da loja virtual
            Product p = prodController.get(prodBean.getIdProdutoEcom());
            if(p!=null){
                //produto possui grade
                if(prodBean.getGrade()!=0){
                    //grade comum
                    if(prodBean.getGrade()==1)listaGrades = prodGradeDAO.searchGradeComumByCodProd(prodBean.getCodProd());
                    //grade composta
                    if(prodBean.getGrade()==2)listaGrades = prodGradeDAO.searchGradeCompostaByCodProd(prodBean.getCodProd());                        
                    for(StockAvailableNode stockAvailableNode : p.getAssociations().getStockAvailables().getStockAvailable()){
                        for(ProdGradeERPBean prodGrade : listaGrades){
                            if(stockAvailableNode.getIdProductAttribute()==prodGrade.getIdProdGradeEcom()){
                                stock = stockController.getStock(stockAvailableNode.getId());
                                stock.setQuantity(prodGrade.getEstoque().intValue());                                
                                //atualiza estoque da grade
                                stockController.updateStockAvailable(stock);
                            }
                        }
                    }
                }else{
                    stock = stockController.getStock(p.getAssociations().getStockAvailables().getStockAvailable().get(0).getId());
                    Double estoqueProd = prodDao.retornaEstoqueProd(prodBean.getCodProd());
                    stock.setQuantity(estoqueProd.intValue());
                    stockController.updateStockAvailable(stock);
                }                
            }
            Logger.getLogger(ProdGradeERPController.class).info("Estoque atualizado com sucesso.");
        }catch(Exception e){
            Logger.getLogger(ProdGradeERPController.class).error("Erro ao atualizar estoque: "+e);
            
        }
    }
    
}
