/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.entity.EnderecoEcomBean;
import br.com.atsinformatica.prestashop.clientDAO.AddressPrestashopDAO;
import br.com.atsinformatica.prestashop.model.root.Address;

/**
 *
 * @author kennedimalheiros
 */
public class AddressController {

    public EnderecoEcomBean syncAddressControllerPrestashop(int cod) {
        AddressPrestashopDAO dao = new AddressPrestashopDAO();

        Address address = dao.getId(Address.URLADDRESS, cod);

        EnderecoEcomBean bean = new EnderecoEcomBean();
        bean.setId_customer(address.getId_customer());
        bean.setAlias(address.getAlias());
        bean.setLastname(address.getLastname());
        bean.setFirstname(address.getFirstname());
        bean.setAddress1(address.getAddress1());
        bean.setAddress2(address.getAddress2());
        bean.setPostcode(bean.getPostcode());
        bean.setCity(address.getCity());
        bean.setOther(address.getOther());
        bean.setPhone(address.getPhone());
        bean.setPhone_mobile(address.getPhone_mobile());
        return bean;

    }

}
