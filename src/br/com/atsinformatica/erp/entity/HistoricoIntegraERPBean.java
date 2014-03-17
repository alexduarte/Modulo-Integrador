/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.entity;

import com.towel.el.annotation.Resolvable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author AlexsanderPimenta
 */
public class HistoricoIntegraERPBean {
    @Resolvable(colName = "Id")
    private int id;
    @Resolvable(colName = "Entidade")
    private String entidade;
    @Resolvable(colName = "Cod. Entidade")
    private String codEntidade;
    @Resolvable(colName = "Data entrada")
    private Date dataEnt;
    @Resolvable(colName = "Data integração")
    private Date dataInteg;
    @Resolvable(colName = "Tipo Operação")
    private String tipoOperacao;
    //Objeto generico de sincronização
    private Object objectSinc;
    
    public HistoricoIntegraERPBean(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.entidade = rs.getString("entidade");
        this.codEntidade = rs.getString("codentidade");
        this.dataEnt = rs.getDate("dataent");
        this.dataInteg = rs.getDate("dataint");
        this.tipoOperacao = rs.getString("tipooper");
    }
    
    public HistoricoIntegraERPBean(){
        
    }
    
    
    
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the entidade
     */
    public String getEntidade() {
        return entidade;
    }

    /**
     * @param entidade the entidade to set
     */
    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    /**
     * @return the codEntidade
     */
    public String getCodEntidade() {
        return codEntidade;
    }

    /**
     * @param codEntidade the codEntidade to set
     */
    public void setCodEntidade(String codEntidade) {
        this.codEntidade = codEntidade;
    }

    /**
     * @return the dataEnt
     */
    public Date getDataEnt() {
        return dataEnt;
    }

    /**
     * @param dataEnt the dataEnt to set
     */
    public void setDataEnt(Date dataEnt) {
        this.dataEnt = dataEnt;
    }

    /**
     * @return the dataInteg
     */
    public Date getDataInteg() {
        return dataInteg;
    }

    /**
     * @param dataInteg the dataInteg to set
     */
    public void setDataInteg(Date dataInteg) {
        this.dataInteg = dataInteg;
    }

    /**
     * @return the tipoOperacao
     */
    public String getTipoOperacao() {
        return tipoOperacao;
    }

    /**
     * @param tipoOperacao the tipoOperacao to set
     */
    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    /**
     * @return the objectSinc
     */
    public Object getObjectSinc() {
        return objectSinc;
    }

    /**
     * @param objectSinc the objectSinc to set
     */
    public void setObjectSinc(Object objectSinc) {
        this.objectSinc = objectSinc;
    }

    
    
}
