/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.prestashop.clientDAO.ImagePrestashopDAO;
import br.com.atsinformatica.prestashop.model.node.Id;
import br.com.atsinformatica.prestashop.model.node.Language;
import br.com.atsinformatica.prestashop.model.node.LinkRewrite;
import br.com.atsinformatica.prestashop.model.node.Name;
import br.com.atsinformatica.prestashop.model.node.Price;
import br.com.atsinformatica.prestashop.model.root.Category;
import br.com.atsinformatica.prestashop.model.root.Image;
import br.com.atsinformatica.prestashop.model.root.Product;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.apache.log4j.Logger;

/**
 *
 * @author AlexsanderPimenta
 */
public class ImageController {

    public void createImagePrestaShop() {
        try {
            Product p = new Product();
            Id id = new Id();
            Name name = new Name();
            id.setContent("3");
            name.getLanguage().add(new Language("MacBook Air"));
            Price price = new Price();
            price.setContent("1880.23");
            LinkRewrite linkRewrite = new LinkRewrite();
            linkRewrite.getLanguage().add(new Language("MacBook Air"));
            p.setName(name);
            p.setPrice(price);
            p.setLinkRewrite(linkRewrite);
            Image im = new Image();          
           // im.setProduct(p);
          //  im.setImage(extractBytes("C:\\chuteira-nike1.jpg"));
            Logger.getLogger(ImageController.class).info("Upload Realizado com sucesso");
            ImagePrestashopDAO dao = new ImagePrestashopDAO();
            dao.post(Category.URLCATEGORY, im);
        } catch (Exception e) {
            Logger.getLogger(ImageController.class).error("Erro ao realizar upload de imagem: " + e);            
        }

    }
    
    
    public void getImage(){
        try{
            ImagePrestashopDAO dao = new ImagePrestashopDAO();
            dao.getImage(Image.URLIMAGE);
        }catch(Exception e){
            
        }
    }
    
    public List<Image> getImages(){
        try{
           List<Image> images = new ImagePrestashopDAO().get("");
           Logger.getLogger(ImageController.class).info("Imagens retornada com sucesso.");
           return images;          
        }catch(Exception e){
           Logger.getLogger(ImageController.class).error("Erro ao retornar imagens: "+e);
           return null;
            
        }
    }

    private byte[] extractBytes(String ImagePath) throws IOException {
        // open image
        BufferedImage originalImage = ImageIO.read(new File(ImagePath));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write( originalImage, "jpg", baos );
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        // get DataBufferBytes from Raster
        return imageInByte;
    }
}
