/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.dao.LogErroEcomDAO;
import br.com.atsinformatica.erp.entity.LogErroEcomBean;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Controladora de log de erros de integração
 * @author AlexsanderPimenta
 */
public class LogEcomErroController {
    
    private static LogEcomErroController instance;
    private LogErroEcomDAO dao;
    
    public static LogEcomErroController getInstance(){
        if(instance==null){
            instance = new LogEcomErroController();
        }
        return instance;
    }
    
    /**
     * Gera log de erro
     * @param idInteg id do item de integração
     * @param descricaoErro descrição do erro
     */
    public void geraErroLog(int idInteg, String descricaoErro){
        dao = new LogErroEcomDAO();
        LogErroEcomBean log = new LogErroEcomBean();
        try{
            log.setIdInteg(idInteg);
            log.setDescricaoErro(descricaoErro);
            log.setDataErro(new Date());
            dao.gravar(log);
        }catch(Exception e){
            Logger.getLogger(LogEcomErroController.class).error("Erro ao gerar log"+e);            
        }
    }
    
    /**
     * Retorna lista de log de erros de integração
     * @param idInteg id do item de integração
     * @return List<LogErroEcomBean>
     */
    public List<LogErroEcomBean> listaLogErros(int idInteg){
        try{
            dao = new LogErroEcomDAO();
            return dao.listaErroPorIDInteg(idInteg);
        }catch(Exception e){
            Logger.getLogger(LogEcomErroController.class).error("Erro ao retornar lista de logs de erro: "+e);
            return null;
            
        }
    }
}
