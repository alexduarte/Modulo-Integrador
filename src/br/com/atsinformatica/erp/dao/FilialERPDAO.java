/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.FilialERPBean;
import br.com.atsinformatica.midler.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ricardosilva
 */
public class FilialERPDAO{
    
    Connection dbConnection = null;
    PreparedStatement preparedStatementInsert = null;
    PreparedStatement preparedStatementUpdate = null;

    PreparedStatement preparedStatementDelete = null;
    PreparedStatement preparedStatementList = null;

    /**
     * Salva os produtos criados
     *
     * @param filial
     * @throws SQLException
     */
    public void salvaFilialERP(FilialERPBean filial) throws SQLException {
        try {
            //cria a conexao com o Banco de dados e desabilita o autocommit
            dbConnection = ConnectionFactory.getDBConnection();
            dbConnection.setAutoCommit(false);

            //prepara a execução da SQL
            String SQL_SALVAR = "";
            preparedStatementInsert = dbConnection.prepareStatement(SQL_SALVAR);

            //Atribui os valores no lugar das interrogações e executa a SQL
            preparedStatementInsert.setInt(1, 999);
            preparedStatementInsert.setString(2, "mkyong101");
            preparedStatementInsert.executeUpdate();

            //Commita a operação ou faz rollback
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
     * @param filial 
     * @throws SQLException
     */
    public void atualizarFilialERP(FilialERPBean filial) throws SQLException {
        try {
            //cria a conexao com o Banco de dados e desabilita o autocommit
            dbConnection = ConnectionFactory.getDBConnection();
            dbConnection.setAutoCommit(false);

            //prepara a execução da SQL
            String SQL_UPDATE = "";
            preparedStatementUpdate = dbConnection.prepareStatement(SQL_UPDATE);

            //Atribui os valores no lugar das interrogações e executa a SQL
            preparedStatementUpdate.setInt(1, 999);
            preparedStatementUpdate.setString(2, "mkyong101");
            preparedStatementUpdate.executeUpdate();

            //Commita a operação ou faz rollback
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

    /**
     * Deletar item
     * @param filial
     * @throws SQLException
     */
    public void deleteFilialERP(FilialERPBean filial) throws SQLException {
        try {
            //cria a conexao com o Banco de dados e desabilita o autocommit
            dbConnection = ConnectionFactory.getDBConnection();
            dbConnection.setAutoCommit(false);

            //prepara a execução da SQL
            String SQL_DELETE = "DELETE produto WHERE id = ?";
            preparedStatementDelete = dbConnection.prepareStatement(SQL_DELETE);

            //Atribui os valores no lugar das interrogações e executa a SQL
            preparedStatementDelete.setInt(1, 999);
            preparedStatementDelete.executeUpdate();

            //Commita a operação ou faz rollback
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

    public void listPedidoERP() throws SQLException {
        try {
            //cria a conexao com o Banco de dados e desabilita o autocommit
            dbConnection = ConnectionFactory.getDBConnection();
            dbConnection.setAutoCommit(false);

            //prepara a execução da SQL
            String SQL_LIST = "";
            preparedStatementList = dbConnection.prepareStatement(SQL_LIST);

            //Recebe os valores no lugar das interrogações e executa a SQL
            ResultSet rs = preparedStatementList.executeQuery();
            while (rs.next()) {
                String userid = rs.getString("USER_ID");
                String username = rs.getString("USERNAME");

                System.out.println("userid : " + userid);
                System.out.println("username : " + username);
            }

            //Commita a operação ou faz rollback
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
