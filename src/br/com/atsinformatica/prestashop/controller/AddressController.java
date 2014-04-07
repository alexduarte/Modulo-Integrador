/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.entity.EnderecoERPBean;
import br.com.atsinformatica.prestashop.clientDAO.AddressPrestashopDAO;
import br.com.atsinformatica.prestashop.model.root.Address;
import org.apache.log4j.Logger;

/**
 *
 * @author kennedimalheiros
 */
public class AddressController {

    private static Logger logger = Logger.getLogger(AddressController.class);

    public EnderecoERPBean syncAddressControllerPrestashop(int codEntrega, int codCobranca) {
        AddressPrestashopDAO dao = new AddressPrestashopDAO();

        Address address = dao.getId(Address.URLADDRESS, codEntrega);
        EnderecoERPBean bean = new EnderecoERPBean();
        try {

            bean.setId_customer(address.getId_customer());
            bean.setAlias(address.getAlias());
            bean.setLastname(address.getLastname());
            bean.setFirstname(address.getFirstname());
            bean.setAddress1(address.getAddress1());
            bean.setNumero(address.getNumero());
            bean.setAddress2(address.getAddress2());
            bean.setPostcode(address.getPostcode());
            bean.setCity(address.getCity());
            bean.setOther(address.getOther());
            bean.setPhone(address.getPhone());
            bean.setPhone_mobile(address.getPhone_mobile());
            bean.setId_state(address.getId_state());

            /*
             Buscando Endereço de cobrança
             */
            Address addressCobraca = dao.getId(Address.URLADDRESS, codCobranca);

            bean.setEnderecoCob(addressCobraca.getAddress1());
            bean.setNumeroCob(addressCobraca.getNumero());
            bean.setBairroCob(addressCobraca.getAddress2());
            bean.setCepCob(addressCobraca.getPostcode());
            bean.setCidadeCob(addressCobraca.getCity());
            bean.setEstadoCob(addressCobraca.getId_state());

        } catch (Exception e) {
            logger.error("Erro ao consultar endereço Entrega ID Ecom:(" + codEntrega + "), endereço cobrança ID Ecom:(" + codCobranca + "): " + e);
            return null;
        }

        return bean;

    }

}
