/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.CategoriaEcomBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author AlexsanderPimenta
 */
public class CategoriaEcomDAO implements IGenericDAO<CategoriaEcomBean> {
    private Connection conn;
    private static Logger logger = Logger.getLogger(CategoriaEcomDAO.class);
    @Override
    public void gravar(CategoriaEcomBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(CategoriaEcomBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Retorna uma categoria através do codigo da mesma
     * @param id
     * @return categoria
     * @throws SQLException 
     */
    @Override
    public CategoriaEcomBean abrir(String id) throws SQLException {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try{
            conn = ConexaoATS.conectaERP();
            String sql = "SELECT * FROM CATEGORIASECOM "
                    + "WHERE CODCATEGORIA = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            CategoriaEcomBean categoria = null;
            while(rs.next()){
                categoria = new CategoriaEcomBean();
                categoria.setCodCategoria(rs.getString("CODCATEGORIA"));
                categoria.setCodCategoriaSuperior(rs.getString("CODCATEGORIASUPERIOR"));
                categoria.setDescricao(rs.getString("DESCRICAO"));
                categoria.setPrincipal(rs.getString("PRINCIPAL"));
                categoria.setDescricaoDetalhada(rs.getString("DESCRICAODETALHADA"));
                categoria.setDescricaoCompleta(rs.getString("DESCRICAOCOMPLETA"));
                categoria.setIdCategoriaEcom(rs.getInt("IDCATEGORIAECOM"));                
            }
            logger.info("Categoria retornada com sucesso.");
            return categoria;
        }catch(Exception e){
            logger.error("Erro ao retornar categoria: "+e);
            return null;            
        }finally{
            conn.close();
            rs.close();
            pstmt.close();
        }
    }

    /**
     * Lista todas categorias cadastrados
     * @return lista de categorias
     * @throws SQLException 
     */
    @Override
    public List<CategoriaEcomBean> listaTodos() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = ConexaoATS.conectaERP();
            String sql = "select * from categoriasecom";
            List<CategoriaEcomBean> listaCategorias = new ArrayList<>();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            CategoriaEcomBean categoria = null;
            while(rs.next()){
                categoria = new CategoriaEcomBean();
                categoria.setCodCategoria(rs.getString("CODCATEGORIA"));
                categoria.setCodCategoriaSuperior(rs.getString("CODCATEGORIASUPERIOR"));
                categoria.setDescricao(rs.getString("DESCRICAO"));
                categoria.setPrincipal(rs.getString("PRINCIPAL"));
                categoria.setDescricaoDetalhada(rs.getString("DESCRICAODETALHADA"));
                categoria.setDescricaoCompleta(rs.getString("DESCRICAOCOMPLETA"));
                categoria.setIdCategoriaEcom(rs.getInt("IDCATEGORIAECOM"));
                listaCategorias.add(categoria);                
            }
            logger.info("Categorias retornadas com sucesso.");
            return listaCategorias;
        }catch(Exception e){
            logger.error("Erro ao retornar categorias: "+e);
            return null;            
        }finally{
            conn.close();
            rs.close();
            stmt.close();
        }
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
