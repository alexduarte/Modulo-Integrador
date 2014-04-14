/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.dao.ParaUrlDAO;
import br.com.atsinformatica.erp.dao.ProdImgDAO;
import br.com.atsinformatica.erp.entity.ImgProdBean;
import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.prestashop.clientDAO.GenericPrestashopDAO;
import br.com.atsinformatica.prestashop.clientDAO.ProductPrestashopDAO;
import br.com.atsinformatica.prestashop.model.node.ImageNode;
import br.com.atsinformatica.prestashop.model.root.Product;
import com.sun.jersey.api.client.WebResource;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;

/**
 * Serviço de upload de imagens do produto na loja virtual
 * @author AlexsanderPimenta
 */
public class ImageController extends GenericPrestashopDAO<ImageNode> {
    
    
    
    /**
     * Prepara upload de imagens do produto
     * @param idProduct 
     */
    public void prepareUpload(ProdutoERPBean prod){
        ParaUrlDAO paraUrlDao = new ParaUrlDAO();
        ProdImgDAO prodImgDao = new ProdImgDAO();
        try{            
            //url do web service
            String urlWS = paraUrlDao.listaTodos().get(0).getUrlWSDL();
            //chave do web service
            String urlKey = paraUrlDao.listaTodos().get(0).getUrlKey();
            //lista de imagens para o produto
            List<ImgProdBean> listaImgs = prodImgDao.listaImgCodProd(prod.getCodProd());            
            this.deleteImagesProduct(prod.getIdProdutoEcom());
            for(ImgProdBean imgProdBean : listaImgs){
                uploadImageProduct(urlWS, urlKey, String.valueOf(prod.getIdProdutoEcom()), imgProdBean.getUrlImagem().replace("\\", "/"));
            }              
        }catch(Exception e){
            Logger.getLogger(ImageController.class).error("Erro ao iniciar processo de upload de imagens do produto: "+e);
        }
    }

    
    /**
     * Realiza upload de imagem na loja virtual
     * @param urlWS Url da loja
     * @param urlKey Chave de acesso a loja
     * @param codProd Código do produto
     * @param urlImg url da imagem
     */
    private void uploadImageProduct(String urlWs, String urlKey, String codProd, String urlImg){
        try{
            //url do serviço de upload de imagens
            String urlService = urlWs.replace("api", "")+"imageservice/img.php";
            //Cria url com parametros para serem passados para o serviço de upload de imagens da loja virtual
            String urlFinal = urlService+"?"+"id="+codProd+"&"+"url_image="+urlImg+"&"+"key="+urlKey+"&"+"ipServidorPasta="+urlWs;
            URL url = new URL(urlFinal);
            URLConnection conn = url.openConnection();
            conn.connect();            
            System.out.println("Result: "+conn.getContent());           
            Logger.getLogger(ImageController.class).info("Upload de imagem do produto realizado com sucesso.");                    
        }catch(Exception e){
            Logger.getLogger(ImageController.class).error("Erro ao realizar upload de imagem do produto: "+e);
            
        }
        
    }
    
    /**
     * Deleta imagens do produto
     * @param codProdEcom 
     */
    private void deleteImagesProduct(int codProdEcom){
        ProductPrestashopDAO prodDao = new ProductPrestashopDAO();
        try{
            Product p = prodDao.getId(Product.URLPRODUCTS, codProdEcom);
            WebResource resource = null;
            for(ImageNode img : p.getAssociations().getImages().getImage()){
                 getWebResource().path("images/products").path(String.valueOf(codProdEcom))
                         .path(img.getId()).type(MediaType.APPLICATION_XML).delete();                
            }
            Logger.getLogger(ImageController.class).info("Imagens do produto deletadas com sucesso.");
        }catch(Exception e){
            Logger.getLogger(ImageController.class).info("Erro ao deletar imagens do produto: "+e);
            
        }
    }
    
}
