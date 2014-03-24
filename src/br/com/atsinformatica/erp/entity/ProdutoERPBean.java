/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.entity;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author AlexsanderPimenta
 */
public class ProdutoERPBean {
    
    private String codProd;
    private Double estoqueDisponivel;
    private String descricao;
    private String descricao2;
    private String descricao3;
    private String referencia;
    private String refFabricante;
    private String unidadeEnt;
    private String unidadeSaida;
    private Double preco;
    private Double preco2;
    private Double preco3;
    private Double preco4;
    private Double precoCusto;
    private int grade;
    private String codGrade;
    private String categoria;
    private String subCategoria;
    private boolean importadoLoja;
    
    
    public ProdutoERPBean(){
        super();
        
    }

    public ProdutoERPBean(ResultSet rs) throws SQLException, UnsupportedEncodingException {
        this.codProd = rs.getString("codprod");
        this.estoqueDisponivel = rs.getDouble("estoquedisponivel");
        this.descricao = rs.getString("descricao");
        this.descricao2 = rs.getString("descricao2");
        this.descricao3 = rs.getString("descricao3");
        this.categoria = rs.getString("descgrupo");
        this.subCategoria = rs.getString("descsub");
        this.referencia = rs.getString("referencia");
        this.refFabricante = rs.getString("reffabricante");
        this.unidadeEnt = rs.getString("unidadeent");
        this.unidadeSaida = rs.getString("unidadesaida");
        this.preco = rs.getDouble("preco");
        this.preco2 = rs.getDouble("preco2");
        this.preco3 = rs.getDouble("preco3");
        this.preco4 = rs.getDouble("preco4");
        this.precoCusto = rs.getDouble("precocusto");
        this.grade = rs.getInt("grade");
        this.codGrade = rs.getString("codgrade");
        this.setImportadoLoja(false);
        
       
    }  
    /**
     * @return the codProd
     */
    public String getCodProd() {
        return codProd;
    }

    /**
     * @param codProd the codProd to set
     */
    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

    /**
     * @return the estoqueDisponivel
     */
    public Double getEstoqueDisponivel() {
        return estoqueDisponivel;
    }

    /**
     * @param estoqueDisponivel the estoqueDisponivel to set
     */
    public void setEstoqueDisponivel(Double estoqueDisponivel) {
        this.estoqueDisponivel = estoqueDisponivel;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the descricao2
     */
    public String getDescricao2() {
        return descricao2;
    }

    /**
     * @param descricao2 the descricao2 to set
     */
    public void setDescricao2(String descricao2) {
        this.descricao2 = descricao2;
    }

    /**
     * @return the descricao3
     */
    public String getDescricao3() {
        return descricao3;
    }

    /**
     * @param descricao3 the descricao3 to set
     */
    public void setDescricao3(String descricao3) {
        this.descricao3 = descricao3;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the unidadeEnt
     */
    public String getUnidadeEnt() {
        return unidadeEnt;
    }

    /**
     * @param unidadeEnt the unidadeEnt to set
     */
    public void setUnidadeEnt(String unidadeEnt) {
        this.unidadeEnt = unidadeEnt;
    }

    /**
     * @return the unidadeSaida
     */
    public String getUnidadeSaida() {
        return unidadeSaida;
    }

    /**
     * @param unidadeSaida the unidadeSaida to set
     */
    public void setUnidadeSaida(String unidadeSaida) {
        this.unidadeSaida = unidadeSaida;
    }

    /**
     * @return the preco
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * @return the preco2
     */
    public Double getPreco2() {
        return preco2;
    }

    /**
     * @param preco2 the preco2 to set
     */
    public void setPreco2(Double preco2) {
        this.preco2 = preco2;
    }

    /**
     * @return the preco3
     */
    public Double getPreco3() {
        return preco3;
    }

    /**
     * @param preco3 the preco3 to set
     */
    public void setPreco3(Double preco3) {
        this.preco3 = preco3;
    }

    /**
     * @return the preco4
     */
    public Double getPreco4() {
        return preco4;
    }

    /**
     * @param preco4 the preco4 to set
     */
    public void setPreco4(Double preco4) {
        this.preco4 = preco4;
    }

    /**
     * @return the precoCusto
     */
    public Double getPrecoCusto() {
        return precoCusto;
    }

    /**
     * @param precoCusto the precoCusto to set
     */
    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    /**
     * @return the grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * @return the codGrade
     */
    public String getCodGrade() {
        return codGrade;
    }

    /**
     * @param codGrade the codGrade to set
     */
    public void setCodGrade(String codGrade) {
        this.codGrade = codGrade;
    }

    /**
     * @return the refFabricante
     */
    public String getRefFabricante() {
        return refFabricante;
    }

    /**
     * @param refFabricante the refFabricante to set
     */
    public void setRefFabricante(String refFabricante) {
        this.refFabricante = refFabricante;
    }
      
    @Override
    public String toString() {
        return "ProdutoBean{" + "codProd=" + codProd + ", estoqueDisponivel=" + estoqueDisponivel + ", descricao=" + descricao + ", descricao2=" + descricao2 + ", descricao3=" + descricao3 + ", categoria="+ categoria +", subcategoria=" + subCategoria + ", referencia=" + referencia + ", refFabricante=" + refFabricante + ", unidadeEnt=" + unidadeEnt + ", unidadeSaida=" + unidadeSaida + ", preco=" + preco + ", preco2=" + preco2 + ", preco3=" + preco3 + ", preco4=" + preco4 + ", precoCusto=" + precoCusto + ", grade=" + grade + ", codGrade=" + codGrade + '}';
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the subCategoria
     */
    public String getSubCategoria() {
        return subCategoria;
    }

    /**
     * @param subCategoria the subCategoria to set
     */
    public void setSubCategoria(String subCategoria) {
        this.subCategoria = subCategoria;
    }

    /**
     * @return the importadoERP
     */
    public boolean isImportadoLoja() {
        return importadoLoja;
    }

    /**
     * @param importadoERP the importadoERP to set
     */
    public void setImportadoLoja(boolean importadoLoja) {
        this.importadoLoja = importadoLoja;
    }

//    /**
//     * @return the media
//     */
//    public ProdImgBean getMedia() {
//        return media;
//    }
//
//    /**
//     * @param media the media to set
//     */
//    public void setMedia(ProdImgBean media) {
//        this.media = media;
//    }
       
    
}
