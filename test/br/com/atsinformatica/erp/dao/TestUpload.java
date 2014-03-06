package br.com.atsinformatica.erp.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author niwrodrigues
 */
public class TestUpload {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nmpagina = "http://lojaprestashop/api/images/products/9";
        HttpURLConnection conexao = null;
        try {
            URL url = new URL(nmpagina);         
            conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestProperty("Request-Method", "GET");
            conexao.setDoInput(true);
            conexao.setDoOutput(false);
            conexao.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            StringBuffer newData = new StringBuffer(10000);
            String s = "";            
            while (null != ((s = br.readLine()))) {
                newData.append(s);
            }
            br.close();
            System.out.println(new String(newData));
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
}
