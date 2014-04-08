/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.prestashop.clientDAO.CarrierDAO;
import br.com.atsinformatica.prestashop.model.root.Carrier;
import org.apache.log4j.Logger;

/**
 *
 * @author kennedimalheiros
 */
public class CarrierController {

    private static Logger logger = Logger.getLogger(CarrierController.class);

    public String syncCarrierControllerPrestashop(int codCarrier) {
        CarrierDAO dao = new CarrierDAO();
        Carrier carrier;
        try {
            carrier = dao.getId(Carrier.URLCARRIER, codCarrier);
        } catch (Exception e) {
            logger.error("Erro ao consultar nome da Transportadora ID:(" + codCarrier + "): " + e);
            return null;
        }

        return carrier.getName();
    }

}
