/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.model.root;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author kennedimalheiros
 */
@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address", propOrder = {
    "id_customer", //id Cliente
    "alias", // Descrição do endereço
    "lastname",
    "firstname",
    "address1", //Endereço
    "address2", //Bairro
    "postcode", //CEP
    "city", // Cidade
    "other", //Outras informações do Endereço
    "phone", //Telefone
    "phone_mobile", //Telefone Movel
    "id_state", //ID do Estado
})

public class Address {

    public static String URLADDRESS = "addresses/";

    @XmlElement(name = "id_customer", required = true)
    private String id_customer;
    @XmlElement(name = "alias")
    private String alias;
    @XmlElement(name = "lastname")
    private String lastname;
    @XmlElement(name = "firstname")
    private String firstname;
    @XmlElement(name = "address1")
    private String address1;
    @XmlElement(name = "address2")
    private String address2;
    @XmlElement(name = "postcode")
    private String postcode;
    @XmlElement(name = "city")
    private String city;
    @XmlElement(name = "other")
    private String other;
    @XmlElement(name = "phone")
    private String phone;
    @XmlElement(name = "phone_mobile")
    private String phone_mobile;
    @XmlElement(name = "id_state")
    private String id_state;

    public String getId_customer() {
        return id_customer;
    }

    public void setId_customer(String id_customer) {
        this.id_customer = id_customer;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone_mobile() {
        return phone_mobile;
    }

    public void setPhone_mobile(String phone_mobile) {
        this.phone_mobile = phone_mobile;
    }

    public String getId_state() {
        return id_state;
    }

    public void setId_state(String id_state) {
        this.id_state = id_state;
    }

}
