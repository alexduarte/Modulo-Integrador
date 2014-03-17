/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.erp.entity.ProdImgBean;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.log4j.Logger;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author AlexsanderPimenta
 */
public class PSMediaDAO implements IGenericPrestashopDAO<ProdImgBean> {
    
    private static Logger logger = Logger.getLogger(PSMediaDAO.class);

    @Override
    public void post(String path, ProdImgBean t) {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://TG51GQIW2EI4QW2ZIY7W6SWZBJ9N0WU7@localhost/lojaprestashop/api/images/products/9");
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            ImageIcon img = new ImageIcon(t.getFoto());
            String s = new String(t.getFoto());            
            nameValuePairs.add(new BasicNameValuePair("", s));            
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        // Execute HTTP Post Request
            HttpResponse response = client.execute(post);            
            System.out.println(response.getEntity());
        } catch (Exception e) {
            logger.info("Erro ao salvar imagem: "+e);
            
        }
    }

    @Override
    public void put(String path, ProdImgBean t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProdImgBean> get(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProdImgBean getId(String path, int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String path, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
