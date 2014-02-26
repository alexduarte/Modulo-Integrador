/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller.trigger;

import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author AlexsanderPimenta
 */
public class TriggerController {
    private Connection conn;

    public void createTriggers() {
        TriggerProduto triggerProduto = new TriggerProduto();
        TriggerCategoria triggerCategoria = new TriggerCategoria();
        TriggerFabricante triggerFabricante = new TriggerFabricante();
        TriggerCompProd triggerCompProd = new TriggerCompProd();
        try{
           //Produto
           if(!verificaTrigger("PRODUTO_ECOMM_AU"))triggerProduto.createTriggerAu();
           if(!verificaTrigger("PRODUTO_ECOMM_AI"))triggerProduto.createTriggerAi();
           if(!verificaTrigger("PRODUTO_ECOMM_AD"))triggerProduto.createTriggerAd();
           //Fabricante
           if(!verificaTrigger("categoria_ecomm_au"))triggerCategoria.createTriggerAu();
           if(!verificaTrigger("categoria_ecomm_ai"))triggerCategoria.createTriggerAi();
           if(!verificaTrigger("categoria_ecomm_ad"))triggerCategoria.createTriggerAd();
           //Categoria
           if(!verificaTrigger("fabricante_ecomm_au"))triggerFabricante.createTriggerAu();
           if(!verificaTrigger("fabricante_ecomm_ai"))triggerFabricante.createTriggerAi();
           if(!verificaTrigger("fabricante_ecomm_ad"))triggerFabricante.createTriggerAd();
           //compprod
           if(!verificaTrigger("compprod_ecomm_au"))triggerCompProd.createTriggerAu();
           
        }catch(Exception e){
            
        }        
    }

    private boolean verificaTrigger(String triggerName) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        boolean exist = false;
        try {
            conn = ConexaoATS.conectaERP();
            String sql = "select * "
                           + " from rdb$triggers "
                           + " where upper(rdb$trigger_name) = upper('" + triggerName + "')";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                exist = true;
            }
        } catch (Exception e) {
        }finally{
            rs.close();
            stmt.close();
            conn.close();
        }
        return exist;
    }
}
