/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.prestashop.clientDAO.StockAvailableDAO;
import br.com.atsinformatica.prestashop.model.root.StockAvailable;

/**
 *
 * @author AlexsanderPimenta
 */
public class StockAvailableController {
    
    public int createStockAvailable(StockAvailable stock){
        return new StockAvailableDAO().postStockAvailable(StockAvailable.URLSTOCKAVAILABLE, stock);
    }
    
    public void updateStockAvailable(StockAvailable stock){
        new StockAvailableDAO().put(StockAvailable.URLSTOCKAVAILABLE, stock);
    }
    
}
