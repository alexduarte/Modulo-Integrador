/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.jdbc;

import br.com.atsinformatica.midler.properties.PropertiesManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;
import org.jasypt.util.text.BasicTextEncryptor;


/**
 * Classe de conexão com erp ATS
 *
 * @author AlexsanderPimenta
 */
//import org.apache.log4j.Logger;

public class ConexaoATS {

    private static Connection connection;
    private static Statement stmt;
    private static Logger logger = Logger.getLogger(ConexaoATS.class.getName());

    public static ConexaoATS getInstance() {
        return ConexaoATSHolder.INSTANCE;
    }

    private static class ConexaoATSHolder {

        private static final ConexaoATS INSTANCE = new ConexaoATS();
    }

    /**
     * Metodo de conexão com o banco erp
     *
     * @param diretorio o diretório do banco
     * @param usuario o usuário do banco
     * @param senha a senha do bando
     * @return String com mensagem de sucesso ou falha
     * @throws InstantiationException
     */
    public static String conectaERP(String diretorio, String usuario, String senha) throws InstantiationException {
        try {
            logger.info("Conectando...");
            //controle criado para o caso do usuário digitar "/"
            //    diretorio = diretorio.replace("/", "\\");
            Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance();
            setConnection(DriverManager.getConnection("jdbc:firebirdsql://" + diretorio, usuario, senha));
            setStmt(getConnection().createStatement());
            logger.info("Conectado com sucesso!");
            return "Conectado com sucesso!";
        } catch (ClassNotFoundException ex) {
            logger.info("Erro de acesso ao driver de conexão.");
            return "Erro de acesso ao driver de conexão.";
        } catch (SQLException e) {
            if (e.getMessage().contains("GDS Exception. 335544344")) {
                logger.error("Não foi possível conectar ao banco de dados. Verifique o caminho informado e tente novamente.");
                return "Não foi possível conectar ao banco de dados. Verifique o caminho informado e tente novamente.";
            }
            if (e.getMessage().contains("GDS Exception. 335544472")) {
                logger.error("Usuário ou senha inválidos");
                return "Usuário ou senha inválidos";
            }
            logger.error("Não foi possível conectar ao banco de dados. Verifique o caminho informado e tente novamente.");
            return "Não foi possível conectar ao banco de dados. Verifique o caminho informado e tente novamente.";
        } catch (IllegalAccessException ex) {
            logger.error("Não foi possível conectar ao banco de dados. Verifique o caminho informado e tente novamente.");
            return "Não foi possível conectar ao banco de dados. Verifique o caminho informado e tente novamente.";
        }
    }
    
    
    /**
     * Método responsável por realizar a 
     * conexão com o banco de dados do erp
     * @return a conexão 
     */
    public static Connection conectaERP(){
        BasicTextEncryptor bt = new BasicTextEncryptor();
        try{
            String diretorio = PropertiesManager.getConfig().getProperty("erp.diretorio");
            String usuario = PropertiesManager.getConfig().getProperty("erp.usuario");
            bt.setPassword("senha001");
            String senhaDecrypt = bt.decrypt(PropertiesManager.getConfig().getProperty("erp.senha"));
            logger.info("Conectando...");
            Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance();
            setConnection(DriverManager.getConnection("jdbc:firebirdsql://" + diretorio+"?encoding=ISO8859_1", usuario, senhaDecrypt));
            setStmt(getConnection().createStatement());
            logger.info("Conectado com sucesso!");
            return getConnection();
        }catch(Exception e){
            logger.error("Erro ao conectar: "+e);
            return null;          
        }
    }

    public static void fechaConexao() throws SQLException {
        connection.close();
        System.out.println("Conexão fechada!");
    }

    /**
     * @return the connection
     */
    public static Connection getConnection() {        
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public static void setConnection(Connection aConnection) {
        connection = aConnection;
    }

    public static Statement getStmt() {
        return stmt;
    }

    public static void setStmt(Statement stmt) {
        ConexaoATS.stmt = stmt;
    }
}
