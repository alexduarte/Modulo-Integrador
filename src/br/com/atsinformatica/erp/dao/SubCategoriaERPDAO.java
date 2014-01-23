/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.CategoriaERPBean;
import br.com.atsinformatica.erp.entity.SubCategoriaERPBean;
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
public class SubCategoriaERPDAO {

    private Connection conn;

    public List<SubCategoriaERPBean> listaTodos() throws SQLException {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            List<SubCategoriaERPBean> listaSubCategoria = new ArrayList<>();
            conn = ConexaoATS.conectaERP();
            String sql = "Select subgrup.codgrupo as fkcat, gruprod.descricao as catdesc,subgrup.codsubgrupo as idsubcat, subgrup.descricao as descsubcat from subgrup\n"
                    + "  join gruprod on gruprod.codgrupo = subgrup.codgrupo\n"
                    + "where subgrup.codgrupo = gruprod.codgrupo";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                SubCategoriaERPBean subCategoria = new SubCategoriaERPBean();
                subCategoria.setDescrição(rs.getString("descsubcat"));
                subCategoria.setId(Integer.valueOf(rs.getString("idsubcat")));
                CategoriaERPBean categoria = new CategoriaERPBean();
                categoria.setDescricao(rs.getString("catdesc"));
                categoria.setId(Integer.valueOf(rs.getString("fkcat")) );
                subCategoria.setFkCategoria(categoria);
                listaSubCategoria.add(subCategoria);
            }
            System.out.println("Lista de Categorias, retornada com sucesso!");
            return listaSubCategoria;
        } catch (SQLException e) {
            System.out.println("Erro ao retornar lista de parametros: " + e);
            return null;
        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }
    }
}
