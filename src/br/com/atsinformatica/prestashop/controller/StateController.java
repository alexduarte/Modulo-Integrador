/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.entity.EstadoERPBean;
import br.com.atsinformatica.prestashop.clientDAO.StatesPrestashopDAO;
import br.com.atsinformatica.prestashop.model.root.State;
import org.apache.log4j.Logger;

/**
 *
 * @author kennedimalheiros
 */
public class StateController {

    private static Logger logger = Logger.getLogger(StateController.class);

    public EstadoERPBean syncStateControllerPrestashop(int codEndereco, int codEnderecoCobranca) {
        StatesPrestashopDAO dao = new StatesPrestashopDAO();
        EstadoERPBean bean = new EstadoERPBean();

        try {
            State state = dao.getId(State.URLSTATE, codEndereco);

            bean.setId(state.getId());
            bean.setSigla(state.getIso_code());
            bean.setDescricao(state.getName());

            State stateCobranca = dao.getId(State.URLSTATE, codEnderecoCobranca);

            bean.setSiglaCobracao(state.getIso_code());
            bean.setDescricaoCobracao(state.getName());
            logger.info("Buscando Estado do Endereço do cliente da loja Prestashop com sucesso.");
        } catch (Exception e) {
            logger.error("Erro ao Buscar Estado do Endereço do cliente da loja Prestashop: " + e);
        }

        return bean;

    }

}
