/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.CategoriaERPBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ricardosilva
 */
public class CategoriaERPDAO{

    private Connection conn;
    
    public List<CategoriaERPBean> listaTodos() throws SQLException {        
        Statement stmt = null;
        ResultSet rs = null;        
        try{
            List<CategoriaERPBean> listaCategoria = new ArrayList<>();
            conn = ConexaoATS.conectaERP();
            String sql = "Select * from GRUPROD";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                CategoriaERPBean categoria = new CategoriaERPBean();
                categoria.setDescricao(rs.getString("DESCRICAO"));
                categoria.setId(rs.getInt("CODGRUPO"));
                listaCategoria.add(categoria);
            }
            System.out.println("Lista de Categorias, retornada com sucesso!");
            return listaCategoria;
        }catch(SQLException e){
            System.out.println("Erro ao retornar lista de parametros: "+e);
            return null;            
        }finally{
            rs.close();
            stmt.close();
            conn.close();
        }
    }
}
