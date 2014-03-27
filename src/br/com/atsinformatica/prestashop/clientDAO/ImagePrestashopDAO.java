/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.prestashop.model.list.prestashop.AccessXMLAttribute;
import br.com.atsinformatica.prestashop.model.list.prestashop.PrestashopItens;
import br.com.atsinformatica.prestashop.model.node.Legend;
import br.com.atsinformatica.prestashop.model.root.Image;
import br.com.atsinformatica.prestashop.model.root.Prestashop;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.multipart.FormDataMultiPart;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import javax.imageio.ImageIO;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author AlexsanderPimenta
 */
public class ImagePrestashopDAO extends GenericPrestashopDAO<Image> implements IGenericPrestashopDAO<Image>{

    @Override
    public void post(String path, Image t) {
         Prestashop prestashop = new Prestashop();
        //prestashop.se      
        try {
            //byte[] image = extractBytes("C:\\chuteira-nike1.jpg");
           // t.setImage(b);
            t.setCover(0);
            t.setIdProduct(3);
            t.setLegend(new Legend("testeeeeeee"));
            File image = new File("C:\\chuteira-nike1.jpg");
            MediaType imageType = new MediaType("image", "jpeg");
            FormDataMultiPart part = new FormDataMultiPart();
            FormDataMultiPart bodyPart = part.field("image", image,
            imageType);
            //Content content = new Content();
           // prestashop.setImage(t);
            //content.setContent(image);
            //prestashop.setContent(image);
            String xml = createTOXML(prestashop);
           // Base64.encode(image)
            //FileInputStream image = new FileInputStream("C:\\chuteira-nike1.jpg");
            ClientResponse response = getWebResource().path("images/products/3").type(MediaType.MULTIPART_FORM_DATA_TYPE)
                    .post(ClientResponse.class, bodyPart);
            System.out.println("Resposta: "+response.getStatus());
        } catch (Exception ex) {
            Logger.getLogger(ImagePrestashopDAO.class).error("Erro: "+ex);
        }
        
    }
    
    private byte[] extractBytes(String ImagePath) throws IOException {
        // open image
        BufferedImage originalImage = ImageIO.read(new File(ImagePath));
        BufferedImage img = ImageIO.read(new FileInputStream(new File(ImagePath)));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write( originalImage, "jpg", baos );
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        //baos.close();
        // get DataBufferBytes from Raster
        return imageInByte;
    }

    @Override
    public void put(String path, Image t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Image> get(String path) {
        PrestashopItens getListItens = getWebResource().path("images/products").type(MediaType.APPLICATION_XML).get(PrestashopItens.class);
        List<Image> listImages = new ArrayList<>();
        for (AccessXMLAttribute accessXMLAttribute : getListItens.getImages().getImage()) {
            String retorno = getWebResource().path("images/products").path(accessXMLAttribute.getId()).type(MediaType.APPLICATION_XML).get(String.class);
            Prestashop prestashop = new Prestashop();
            listImages.add(prestashop.getImage());  
        }
        return listImages;
    }
    
   
    public Image getImage(String path){
        Image image = getWebResource().path("images/products/3/27").type(MediaType.APPLICATION_XML).get(Image.class);
        return image;
    }

    @Override
    public Image getId(String path, int key) {
        Prestashop prestashop = getWebResource().path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).get(Prestashop.class);
        return prestashop.getImage();
    }

    @Override
    public void delete(String path, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
