/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.CategoriaEcomErpBean;
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
public class CategoriaEcomDAO implements IGenericDAO<CategoriaEcomErpBean> {
    private Connection conn;
    private static Logger logger = Logger.getLogger(CategoriaEcomDAO.class);
    @Override
    public void gravar(CategoriaEcomErpBean object) throws SQLException {
       
    }

    @Override
    public void alterar(CategoriaEcomErpBean object) throws SQLException {
         PreparedStatement pstmt = null;        
        try{
            conn = ConexaoATS.conectaERP();
            String querie = "UPDATE CATEGORIASECOM " +
                            "SET DESCRICAO = ?, " +
                            "    PRINCIPAL = ?, " +
                            "    CODCATEGORIASUPERIOR = ?, " +
                            "    DESCRICAODETALHADA = ?, " +
                            "    DESCRICAOCOMPLETA = ?, " +
                            "    IDCATEGORIAECOM = ? " +
                            "WHERE (CODCATEGORIA = ?) ";
            pstmt = conn.prepareStatement(querie);
            pstmt.setString(1, object.getDescricao());
            pstmt.setString(2, object.getPrincipal());
            pstmt.setString(3, object.getCodCategoriaSuperior());
            pstmt.setString(4, object.getDescricaoDetalhada());
            pstmt.setString(5, object.getDescricaoCompleta());
            pstmt.setInt(6, object.getIdCategoriaEcom());
            pstmt.setString(7, object.getCodCategoria());
            pstmt.executeUpdate();
            logger.info("Categoria alterada com sucesso.");
        }catch(Exception e){
            logger.error("Erro ao altera categoria: "+e);
            
        }finally{
            pstmt.close();
            conn.close();
        }
    }
     
    public void alteraIdEcom(CategoriaEcomErpBean object) throws SQLException {
         PreparedStatement pstmt = null;        
        try{
            conn = ConexaoATS.conectaERP();
            String querie = "UPDATE CATEGORIASECOM " +
                            "SET IDCATEGORIAECOM = ? " +
                            "WHERE (CODCATEGORIA = ?) ";
            pstmt = conn.prepareStatement(querie);
            pstmt.setInt(1, object.getIdCategoriaEcom());
            pstmt.setString(2, object.getCodCategoria());
            pstmt.executeUpdate();
            logger.info("Id da categoria da loja virtual gravado com sucesso.");
        }catch(Exception e){
            logger.error("Erro ao gravar id da categoria da loja virtual: "+e);
            
        }finally{
            pstmt.close();
            conn.close();
        }
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
    public CategoriaEcomErpBean abrir(String id) throws SQLException {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try{
            conn = ConexaoATS.conectaERP();
            String sql = "SELECT * FROM CATEGORIASECOM "
                    + "WHERE CODCATEGORIA = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            CategoriaEcomErpBean categoria = null;
            while(rs.next()){
                categoria = new CategoriaEcomErpBean();
                categoria.setCodCategoria(rs.getString("CODCATEGORIA").trim());
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
    public List<CategoriaEcomErpBean> listaTodos() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = ConexaoATS.conectaERP();
            String sql = "select * from categoriasecom";
            List<CategoriaEcomErpBean> listaCategorias = new ArrayList<>();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            CategoriaEcomErpBean categoria = null;
            while(rs.next()){
                categoria = new CategoriaEcomErpBean();
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
