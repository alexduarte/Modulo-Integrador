/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.dao;

import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.midler.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ricardosilva
 */
public class ProdutoERPDAO {
    
    Connection dbConnection = null;
    PreparedStatement preparedStatementInsert = null;
    PreparedStatement preparedStatementUpdate = null;

    PreparedStatement preparedStatementDelete = null;
    PreparedStatement preparedStatementList = null;

    /**
     * Salva os produtos criados
     *
     * @param produto
     * @throws SQLException
     */
    public void salvaProduto(ProdutoERPBean produto) throws SQLException {
        try {
            //cria a conexao com o Banco de dados e desabilita o autocommit
            dbConnection = ConnectionFactory.getDBConnection();
            dbConnection.setAutoCommit(false);

            //prepara a execu��o da SQL
            String SQL_SALVAR = "";
            preparedStatementInsert = dbConnection.prepareStatement(SQL_SALVAR);

            //Atribui os valores no lugar das interroga��es e executa a SQL
            preparedStatementInsert.setInt(1, 999);
            preparedStatementInsert.setString(2, "mkyong101");
            preparedStatementInsert.executeUpdate();

            //Commita a opera��o ou faz rollback
            preparedStatementUpdate.executeUpdate();
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            dbConnection.rollback();

        } finally {

            if (preparedStatementInsert != null) {
                preparedStatementInsert.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }

        }
    }

    /**
     * Atualiza produtos
     *
     * @param produto
     * @throws SQLException
     */
    public void atualizarProduto(ProdutoERPBean produto) throws SQLException {
        try {
            //cria a conexao com o Banco de dados e desabilita o autocommit
            dbConnection = ConnectionFactory.getDBConnection();
            dbConnection.setAutoCommit(false);

            //prepara a execu��o da SQL
            String SQL_UPDATE = "";
            preparedStatementUpdate = dbConnection.prepareStatement(SQL_UPDATE);

            //Atribui os valores no lugar das interroga��es e executa a SQL
            preparedStatementUpdate.setInt(1, 999);
            preparedStatementUpdate.setString(2, "mkyong101");
            preparedStatementUpdate.executeUpdate();

            //Commita a opera��o ou faz rollback
            preparedStatementUpdate.executeUpdate();
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            dbConnection.rollback();

        } finally {

            if (preparedStatementUpdate != null) {
                preparedStatementUpdate.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }

        }
    }

    public void deleteProduto(ProdutoERPBean produto) throws SQLException {
        try {
            //cria a conexao com o Banco de dados e desabilita o autocommit
            dbConnection = ConnectionFactory.getDBConnection();
            dbConnection.setAutoCommit(false);

            //prepara a execu��o da SQL
            String SQL_DELETE = "DELETE produto WHERE id = ?";
            preparedStatementDelete = dbConnection.prepareStatement(SQL_DELETE);

            //Atribui os valores no lugar das interroga��es e executa a SQL
            preparedStatementDelete.setInt(1, 999);
            preparedStatementDelete.executeUpdate();

            //Commita a opera��o ou faz rollback
            preparedStatementDelete.executeUpdate();
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            dbConnection.rollback();

        } finally {

            if (preparedStatementInsert != null) {
                preparedStatementInsert.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }

        }
    }

    public void listProduto(ProdutoERPBean produto) throws SQLException {
        try {
            //cria a conexao com o Banco de dados e desabilita o autocommit
            dbConnection = ConnectionFactory.getDBConnection();
            dbConnection.setAutoCommit(false);

            //prepara a execu��o da SQL
            String SQL_LIST = "";
            preparedStatementList = dbConnection.prepareStatement(SQL_LIST);

            //Recebe os valores no lugar das interroga��es e executa a SQL
            ResultSet rs = preparedStatementList.executeQuery();
            while (rs.next()) {
                String userid = rs.getString("USER_ID");
                String username = rs.getString("USERNAME");

                System.out.println("userid : " + userid);
                System.out.println("username : " + username);
            }

            //Commita a opera��o ou faz rollback
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            dbConnection.rollback();

        } finally {

            if (preparedStatementList != null) {
                preparedStatementList.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }

        }
    }
    
}
