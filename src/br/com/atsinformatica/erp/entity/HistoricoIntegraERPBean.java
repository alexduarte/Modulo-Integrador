/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.entity;

import com.towel.el.annotation.Resolvable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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

    public HistoricoIntegraERPBean(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.entidade = rs.getString("entidade");
        this.codEntidade = rs.getString("codentidade");
        this.dataEnt = rs.getDate("dataent");
        this.dataInteg = rs.getDate("dataint");
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
    
    
}