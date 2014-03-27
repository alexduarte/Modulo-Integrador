/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.entity.ClienteEcomBean;
import br.com.atsinformatica.prestashop.clientDAO.CustomerPrestashopDAO;
import br.com.atsinformatica.prestashop.model.root.Customer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kennedimalheiros
 */
public class CustomerController {

    /**
     * Cria uma lista de Customer no prestashop
     *
     * @param cat Customer
     * @return
     */
    public ClienteEcomBean syncCustomerPrestashop(int cod) throws ParseException {
        CustomerPrestashopDAO dao = new CustomerPrestashopDAO();

        Customer customer = dao.getId(Customer.URLCUSTOMER, cod);
        ClienteEcomBean bean = new ClienteEcomBean();
        bean.setId(customer.getId());
        bean.setFirstname(customer.getFirstname());
        bean.setLastname(customer.getLastname());
        bean.setEmail(customer.getEmail());
        Date data = new SimpleDateFormat("dd/MM/yyyy").parse(customer.getBirthday());
        bean.setBirthday(data);

        return bean;
    }

}
