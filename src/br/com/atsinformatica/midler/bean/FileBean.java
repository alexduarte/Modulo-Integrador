/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.bean;


/**
 *
 * @author AlexsanderPimenta
 */
public class FileBean {
    
//    @Resolvable(colName = "MINIATURA DA IMAGEM")
    private byte[] imagemArray;    
    private Object caminho;    
    private String nomeArquivo;       
    private String tamanho;
    
    private int id;
    
    
    private String extensao;

    /**
     * @return the caminho
     */
    public Object getCaminho() {
        return caminho;
    }

    /**
     * @param caminho the caminho to set
     */
    public void setCaminho(Object caminho) {
        this.caminho = caminho;
    }

    /**
     * @return the nomeFile
     */
    public String getNomeArquivo() {
        return nomeArquivo;
    }

    /**
     * @param nomeFile the nomeFile to set
     */
    public void setNomeArquivo(String nomeImagem) {
        this.nomeArquivo = nomeImagem;
    }

    /**
     * @return the tamanho
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * @return the extensao
     */
    public String getExtensao() {
        return extensao;
    }

    /**
     * @param extensao the extensao to set
     */
    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    /**
     * @return the imagemArray
     */
    public byte[] getImagemArray() {
        return imagemArray;
    }

    /**
     * @param imagemArray the imagemArray to set
     */
    public void setImagemArray(byte[] imagemArray) {
        this.imagemArray = imagemArray;
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

    
   
    
}
