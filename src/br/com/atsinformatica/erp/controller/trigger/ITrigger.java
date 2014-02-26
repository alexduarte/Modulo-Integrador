/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller.trigger;

import java.sql.SQLException;

/**
 *
 * @author AlexsanderPimenta
 */
public interface ITrigger {
    void createTriggerAu() throws SQLException;
    void createTriggerAi() throws SQLException;
    void createTriggerAd() throws SQLException;
    
}
