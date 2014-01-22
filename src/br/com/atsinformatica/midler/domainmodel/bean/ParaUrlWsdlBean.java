/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.domainmodel.bean;

import com.towel.el.annotation.Resolvable;

/**
 * Bean de configuração de lista de url/wsdl
 * @author AlexsanderPimenta
 */
public class ParaUrlWsdlBean {
    
    @Resolvable(colName = "COD")
    private String codParaUrlWsdl;
    @Resolvable(colName = "Url/WSDL")
    private String urlWSDL;

    /**
     * @return the codParaUrlWsdl
     */
    public String getCodParaUrlWsdl() {
        return codParaUrlWsdl;
    }

    /**
     * @param codParaUrlWsdl the codParaUrlWsdl to set
     */
    public void setCodParaUrlWsdl(String codParaUrlWsdl) {
        this.codParaUrlWsdl = codParaUrlWsdl;
    }

    /**
     * @return the urlWSDL
     */
    public String getUrlWSDL() {
        return urlWSDL;
    }

    /**
     * @param urlWSDL the urlWSDL to set
     */
    public void setUrlWSDL(String urlWSDL) {
        this.urlWSDL = urlWSDL;
    }
    
}
