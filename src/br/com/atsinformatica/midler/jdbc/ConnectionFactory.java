/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ricardosilva
 */
public class ConnectionFactory {

    private static final String DB_DRIVER = "org.firebirdsql.jdbc.FBDriver";
    private static final String DB_CONNECTION = "jdbc:firebirdsql:localhost/3050:C:/Users/ricardosilva/Documents/NetBeansProjects/ecommerce/bd/ECOMMERCEATS.FDB";
    private static final String DB_USER = "SYSDBA";
    private static final String DB_PASSWORD = "masterkey"; 

    /**
     * Instancia uma conexão com o banco de dados
     *
     * @return
     */
    public static Connection getDBConnection() {
        Connection dbConnection = null;

        try {
            Class.forName(DB_DRIVER);
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

}
