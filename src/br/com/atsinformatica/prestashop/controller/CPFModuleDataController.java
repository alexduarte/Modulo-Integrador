/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.entity.CPFClienteBean;
import br.com.atsinformatica.prestashop.clientDAO.CPFModuleDataPrestashopDAO;
import br.com.atsinformatica.prestashop.model.root.CPFModuleData;
import org.apache.log4j.Logger;

/**
 *
 * @author kennedimalheiros
 */
public class CPFModuleDataController {
    private static Logger logger = Logger.getLogger(CPFModuleDataController.class);
    public CPFClienteBean sysncCPDModuleData(int idCliente) {
        CPFModuleDataPrestashopDAO dao = new CPFModuleDataPrestashopDAO();
        CPFClienteBean bean = new CPFClienteBean();
        try {
            CPFModuleData cPFModuleData = dao.getId(CPFModuleData.URLCPFModuleData, idCliente);

            bean.setIdCLiente(cPFModuleData.getId_customer());
            bean.setCpf_Cnpj(cPFModuleData.getDoc());
            bean.setRg_inscricao(cPFModuleData.getIdt());

            if (cPFModuleData.getType().equals("cpf")) {
                bean.setTipoDocumento("F");
            } else if (cPFModuleData.getType().equals("cnpj")) {
                bean.setTipoDocumento("J");
            }

        } catch (Exception e) {
            logger.error("Erro ao consultar numero CPF/CNPJ do Cliente ID Ecom:(" + idCliente + "): " + e);
        }
        return bean;

    }

}
