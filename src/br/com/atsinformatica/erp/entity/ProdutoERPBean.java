/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.entity;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AlexsanderPimenta
 */
public class ProdutoERPBean {
    
    private String codProd;
    private int idProdutoEcom;
    private Double estoqueDisponivel;
    private String nomeProd;
    private String ativo;
    private int condicao;
    private String codBarras;
    private String codCategoria;
    private String codFabricante;
    private Double altura;
    private Double largura;
    private Double profundidade;
    private String codAtributo1;
    private Double precoCheio;
    private Double precoFinal;
    private String codAtributo2;
    private String palavrasChave;
    private String metaDescricao;
    private String descricaoCompleta;
    private int grade;
    private String codGrade;
    private Double peso;
    private List<ProdGradeERPBean> listaProdGrade;
    private List<AtributoGradeEcom> listaAtributoGradeEcom;
   
    private boolean importadoLoja;
       
    public ProdutoERPBean(){
        super();
        
    }
    public ProdutoERPBean(ResultSet rs) throws SQLException, UnsupportedEncodingException {
        this.codProd = rs.getString("codprod");
        this.idProdutoEcom = rs.getInt("idprodutoecom");
        this.estoqueDisponivel = rs.getDouble("estoquedisponivel");
        this.grade = rs.getInt("grade");
        this.codGrade = rs.getString("codgrade");
        this.codFabricante = rs.getString("codfabric");
        this.altura = rs.getDouble("altura");
        this.largura = rs.getDouble("largura");
        this.codBarras = rs.getString("codbarras");
        this.codCategoria = rs.getString("codcategoria");
        this.condicao = rs.getInt("condicao");
        this.descricaoCompleta = rs.getString("descricaocompleta");
        this.nomeProd = rs.getString("nomeprod");
        this.ativo = rs.getString("ativo");
        this.metaDescricao = rs.getString("metadescricao");
        this.palavrasChave = rs.getString("palavraschave");
        this.codAtributo1 = rs.getString("codatributo1");
        this.codAtributo2 = rs.getString("codatributo2");
        this.precoCheio = rs.getDouble("precocheio");
        this.precoFinal = rs.getDouble("precofinal");   
        this.peso = rs.getDouble("peso");
        this.profundidade = rs.getDouble("profundidade");
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
     * @return the nomeProd
     */
    public String getNomeProd() {
        return nomeProd;
    }

    /**
     * @param nomeProd the nomeProd to set
     */
    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    /**
     * @return the condicao
     */
    public int getCondicao() {
        return condicao;
    }

    /**
     * @param condicao the condicao to set
     */
    public void setCondicao(int condicao) {
        this.condicao = condicao;
    }

    /**
     * @return the codBarras
     */
    public String getCodBarras() {
        return codBarras;
    }

    /**
     * @param codBarras the codBarras to set
     */
    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    /**
     * @return the codCategoria
     */
    public String getCodCategoria() {
        return codCategoria;
    }

    /**
     * @param codCategoria the codCategoria to set
     */
    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }

    /**
     * @return the altura
     */
    public Double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(Double altura) {
        this.altura = altura;
    }

    /**
     * @return the largura
     */
    public Double getLargura() {
        return largura;
    }

    /**
     * @param largura the largura to set
     */
    public void setLargura(Double largura) {
        this.largura = largura;
    }

    /**
     * @return the profundidade
     */
    public Double getProfundidade() {
        return profundidade;
    }

    /**
     * @param profundidade the profundidade to set
     */
    public void setProfundidade(Double profundidade) {
        this.profundidade = profundidade;
    }

    /**
     * @return the codAtributo1
     */
    public String getCodAtributo1() {
        return codAtributo1;
    }

    /**
     * @param codAtributo1 the codAtributo1 to set
     */
    public void setCodAtributo1(String codAtributo1) {
        this.codAtributo1 = codAtributo1;
    }

    /**
     * @return the precoCheio
     */
    public Double getPrecoCheio() {
        return precoCheio;
    }

    /**
     * @param precoCheio the precoCheio to set
     */
    public void setPrecoCheio(Double precoCheio) {
        this.precoCheio = precoCheio;
    }

    /**
     * @return the precoFinal
     */
    public Double getPrecoFinal() {
        return precoFinal;
    }

    /**
     * @param precoFinal the precoFinal to set
     */
    public void setPrecoFinal(Double precoFinal) {
        this.precoFinal = precoFinal;
    }

    /**
     * @return the codAtributo2
     */
    public String getCodAtributo2() {
        return codAtributo2;
    }

    /**
     * @param codAtributo2 the codAtributo2 to set
     */
    public void setCodAtributo2(String codAtributo2) {
        this.codAtributo2 = codAtributo2;
    }

    /**
     * @return the palavrasChave
     */
    public String getPalavrasChave() {
        return palavrasChave;
    }

    /**
     * @param palavrasChave the palavrasChave to set
     */
    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    /**
     * @return the metaDescricao
     */
    public String getMetaDescricao() {
        return metaDescricao;
    }

    /**
     * @param metaDescricao the metaDescricao to set
     */
    public void setMetaDescricao(String metaDescricao) {
        this.metaDescricao = metaDescricao;
    }

    /**
     * @return the descricaoCompleta
     */
    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }

    /**
     * @param descricaoCompleta the descricaoCompleta to set
     */
    public void setDescricaoCompleta(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
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
     * @return the importadoLoja
     */
    public boolean isImportadoLoja() {
        return importadoLoja;
    }

    /**
     * @param importadoLoja the importadoLoja to set
     */
    public void setImportadoLoja(boolean importadoLoja) {
        this.importadoLoja = importadoLoja;
    }

    /**
     * @return the codFabricante
     */
    public String getCodFabricante() {
        return codFabricante;
    }

    /**
     * @param codFabricante the codFabricante to set
     */
    public void setCodFabricante(String codFabricante) {
        this.codFabricante = codFabricante;
    }

    /**
     * @return the idProdutoEcom
     */
    public int getIdProdutoEcom() {
        return idProdutoEcom;
    }

    /**
     * @param idProdutoEcom the idProdutoEcom to set
     */
    public void setIdProdutoEcom(int idProdutoEcom) {
        this.idProdutoEcom = idProdutoEcom;
    }

    /**
     * @return the listaProdGrade
     */
    public List<ProdGradeERPBean> getListaProdGrade() {
        return listaProdGrade;
    }

    /**
     * @param listaProdGrade the listaProdGrade to set
     */
    public void setListaProdGrade(List<ProdGradeERPBean> listaProdGrade) {
        this.listaProdGrade = listaProdGrade;
    }

    /**
     * @return the peso
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    /**
     * @return the ativo
     */
    public String getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the listaAtributoGradeEcom
     */
    public List<AtributoGradeEcom> getListaAtributoGradeEcom() {
        return listaAtributoGradeEcom;
    }

    /**
     * @param listaAtributoGradeEcom the listaAtributoGradeEcom to set
     */
    public void setListaAtributoGradeEcom(List<AtributoGradeEcom> listaAtributoGradeEcom) {
        this.listaAtributoGradeEcom = listaAtributoGradeEcom;
    }

    
    
}
