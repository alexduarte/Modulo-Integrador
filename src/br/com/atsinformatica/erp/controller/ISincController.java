/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

/**
 * Contrato entre as classes que farão sincronização com a loja virtual
 * @author AlexsanderPimenta
 */
public interface ISincController<T> {    
    void post(T obj) throws Exception;
    void update(T obj) throws Exception;
    void delete(String id) throws Exception;
    
}
