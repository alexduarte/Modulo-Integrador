/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.entity.ClienteERPBean;
import br.com.atsinformatica.prestashop.clientDAO.CustomerPrestashopDAO;
import br.com.atsinformatica.prestashop.model.root.Customer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;

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
    private static Logger logger = Logger.getLogger(CustomerController.class);

    public ClienteERPBean syncCustomerPrestashop(int cod) throws ParseException {

        CustomerPrestashopDAO dao = new CustomerPrestashopDAO();
        ClienteERPBean bean = new ClienteERPBean();

        try {
            Customer customer = dao.getId(Customer.URLCUSTOMER, cod);
            bean.setId(customer.getId());
            bean.setFirstname(customer.getFirstname());
            bean.setLastname(customer.getLastname());
            bean.setEmail(customer.getEmail());
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(customer.getBirthday());
            bean.setBirthday(data);
            logger.info("Buscando clientes da loja Prestashop com sucesso.");
        } catch (Exception e) {
            logger.error("Erro ao Buscar clientes da loja Prestashop: "+ e);
            return null;
        }

        return bean;
    }

}
