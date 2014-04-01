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
@XmlRootElement(name = "cpfmodule_data")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cpfmodule_data", propOrder = {
    "id_customer", //Id do cliente
    "type", //Tipo CPF  ou  CNPJ
    "doc", //numero do documento
    "idt", //documento RG para pessoa fisica, Inscrição para Juridica
})

public class CPFModuleData {

    public static String URLCPFModuleData = "cpf_module_data/";

    @XmlElement(name = "id_customer", required = true)
    private String id_customer;
    @XmlElement(name = "type")
    private String type;
    @XmlElement(name = "doc")
    private String doc;
    @XmlElement(name = "idt")
    private String idt;

    public String getId_customer() {
        return id_customer;
    }

    public void setId_customer(String id_customer) {
        this.id_customer = id_customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getIdt() {
        return idt;
    }

    public void setIdt(String idt) {
        this.idt = idt;
    }

}
