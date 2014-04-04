/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.entity.EstadoERPBean;
import br.com.atsinformatica.prestashop.clientDAO.StatesPrestashopDAO;
import br.com.atsinformatica.prestashop.model.root.State;

/**
 *
 * @author kennedimalheiros
 */
public class StateController {

    public EstadoERPBean syncStateControllerPrestashop(int codEndereco, int codEnderecoCobranca) {
        StatesPrestashopDAO dao = new StatesPrestashopDAO();

        State state = dao.getId(State.URLSTATE, codEndereco);

        EstadoERPBean bean = new EstadoERPBean();
        bean.setId(state.getId());
        bean.setSigla(state.getIso_code());
        bean.setDescricao(state.getName());
        
        State stateCobranca = dao.getId(State.URLSTATE, codEnderecoCobranca);

        bean.setSiglaCobracao(state.getIso_code());
        bean.setDescricaoCobracao(state.getName());
        
        
        return bean;

    }   
     
    
}
