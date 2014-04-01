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
@XmlRootElement(name = "state")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "state", propOrder = {
    "id", // ID
    "iso_code", // MG
    "name", // Minas Gerais
})
public class State {

    public static String URLSTATE = "states/";

    @XmlElement(name = "id", required = true)
    private String id;
    @XmlElement(name = "iso_code", required = true)
    private String iso_code;
    @XmlElement(name = "name", required = true)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIso_code() {
        return iso_code;
    }

    public void setIso_code(String iso_code) {
        this.iso_code = iso_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
