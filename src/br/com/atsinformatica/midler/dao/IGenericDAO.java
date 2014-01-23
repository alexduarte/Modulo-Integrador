/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AlexsanderPimenta
 */
public interface IGenericDAO<T> {
    
    void gravar(T object) throws SQLException;
    void alterar(T object) throws SQLException;
    void deletar(String id) throws SQLException;
    T abrir(String id) throws SQLException;
    List<T> listaTodos() throws SQLException;
    String ultimoRegistro() throws SQLException;
}
