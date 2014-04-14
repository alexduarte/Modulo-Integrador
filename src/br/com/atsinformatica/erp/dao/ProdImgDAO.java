/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.ImgProdBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;


/**
 *
 * @author AlexsanderPimenta
 */ 
public class ProdImgDAO {
    private Connection conn;
    
    
    /**
     * Retorna url de imagens do produto
     * @param codProd
     * @return List<ImgProdBean>
     */
    public List<ImgProdBean> listaImgCodProd(String codProd){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<ImgProdBean> listaImgProdBean = new ArrayList<>();
        try{
            conn = ConexaoATS.conectaERP();
            String sql = "SELECT CODPROD, URLIMAGEM FROM IMGPRODECOMMERCE       "
                       + "WHERE CODPROD = ?                                     ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codProd);
            rs = pstmt.executeQuery();
            ImgProdBean imgProdBean = null;
            while(rs.next()){
                imgProdBean = new ImgProdBean();
                imgProdBean.setCodProd(rs.getString("codprod"));
                imgProdBean.setUrlImagem(rs.getString("urlimagem"));
                listaImgProdBean.add(imgProdBean);
            }
            Logger.getLogger(ProdImgDAO.class).info("Url de imagens do produto, retornada com sucesso!");
            return listaImgProdBean;
        }catch(Exception e){
            Logger.getLogger(ProdImgDAO.class).error("Erro ao retornar url de imagens do produto: "+e);
            return null;
            
        }
    }
    
}
