/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.properties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;


/**
 *
 * Classe responsável por realizar a gerência do arquivo de configurações
 *
 * @author AlexsanderPimenta
 */
public class PropertiesManager {

    //instancia
    private static PropertiesManager instance;
    //Arquivo de log
    private static Logger logger = Logger.getLogger(PropertiesManager.class);
    //arquivo de configurações
    private static Properties config;
    //arquivo
    private static File file;

    public PropertiesManager() {
    }

    public PropertiesManager getInstance() {
        if (instance == null) {
            instance = new PropertiesManager();
        }
        return instance;

    }

    /**
     * Retorna arquivo de configuração
     *
     * @return arquivo de configuração
     */
    public static Properties getConfig() {
        config = new Properties();
        try {
            if (getFile().exists()) {
                config.load(new FileInputStream(getFile()));
            }
            return config;
        } catch (Exception e) {
            e.printStackTrace();
            
            return null;

        }
    }

    public static File getFile() {
        if (file == null) {
            file = new File("config.ini");
        }

        return file;
    }
}
