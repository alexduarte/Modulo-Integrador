/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.ParaEcomBean;
import br.com.atsinformatica.erp.entity.ProdutoERPBean;
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
public class ProdutoDAO implements IGenericDAO<ProdutoERPBean> {
    
    private Logger logger = Logger.getLogger(ProdutoERPBean.class);
    
    private Connection conn;

    @Override
    public void gravar(ProdutoERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(ProdutoERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProdutoERPBean abrir(String id) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = ConexaoATS.conectaERP();
            String sql = "SELECT produto.codprod, (compprod.estoque - compprod.quantbloqueada) AS estoquedisponivel, produto.descricao, " +
                         "produto.descricao2, produto.descricao3, sub.descgrupo, sub.descsub, " +
                         "produto.referencia, produto.reffabricante, " +
                         "produto.unidadeent, produto.unidadesaida, produto.preco, produto.preco2, " +
                         "produto.preco3, produto.preco4, compprod.precocusto, produto.grade,compprod.codgrade " +
                         "FROM produto, " +
                         "( " +
                         "   select gruprod.codgrupo codgrupo, subgrup.codsubgrupo codsubgrupo,  gruprod.descricao descgrupo, " +
                         "   subgrup.descricao descsub from subgrup " +
                         "   join gruprod on gruprod.codgrupo = subgrup.codgrupo " +
                         ") sub " +
                         "JOIN compprod ON produto.codprod = compprod.codprod " +
                         "WHERE  produto.codgrupo = sub.codgrupo and produto.codsubgrupo = sub.codsubgrupo " +
                         "and produto.codprod = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            ProdutoERPBean prodBean = null;
            while(rs.next()){
                prodBean = new ProdutoERPBean(rs);
                //media do produto
//                ProdImgBean media = new ProdImgDAO().abrir(id);
//                if(media!=null)prodBean.setMedia(media);
            }
            logger.info("Produto retornado com sucesso.");
            return prodBean;
        }catch(Exception e){
            logger.error("Erro ao retornar produto: "+e);
            return null;         
        }finally{
            conn.close();
            rs.close();
        }
    }

    @Override
    public List<ProdutoERPBean> listaTodos() throws SQLException {
         List<ProdutoERPBean> listaProdutos = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try{
            ParaEcomBean paraBean = new ParaEcomDAO().listaTodos().get(0);
            conn = ConexaoATS.conectaERP();            
            String sql = " SELECT FIRST "+paraBean.getQtdeRegistros()+"  produto.codprod, (compprod.estoque - compprod.quantbloqueada) AS estoquedisponivel, produto.descricao, " +
                         " produto.descricao2, produto.descricao3, sub.descgrupo, sub.descsub, " +
                         " produto.referencia, produto.reffabricante, " +
                         "        produto.unidadeent, produto.unidadesaida, produto.preco, produto.preco2, " +
                         "        produto.preco3, produto.preco4, compprod.precocusto, produto.grade,compprod.codgrade " +
                         " FROM produto, " +
                         " ( " +
                         "    select gruprod.codgrupo codgrupo, subgrup.codsubgrupo codsubgrupo,  gruprod.descricao descgrupo, " +
                         "    subgrup.descricao descsub from subgrup " +
                         "    join gruprod on gruprod.codgrupo = subgrup.codgrupo " +
                         " ) sub " +
                         " JOIN compprod ON produto.codprod = compprod.codprod " +
                         " WHERE  produto.codgrupo = sub.codgrupo and produto.codsubgrupo = sub.codsubgrupo "; 
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                ProdutoERPBean bean = new ProdutoERPBean(rs);
                listaProdutos.add(bean);                
            }
            logger.info("Lista de produtos a serem sincronizados, retornada com sucesso!");
            return listaProdutos;
        }catch(Exception e){
            logger.error("Erro ao retornar lista de produtos a serem sincronizados: "+e);
            return null;          
        }
        finally{
            conn.close();
            rs.close();
            stmt.close();           
        }
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    /**
     * Atualiza status de importação do produto
     * @param codProd código do produto
     * @param codStatus código do status do produto
     */
    public void atualizaStatusImportacao(String codProd, int codStatus) throws SQLException{
        PreparedStatement pstmt = null;        
        try{
            conn = ConexaoATS.conectaERP();
            conn.setAutoCommit(false);
            String querie = "update produto set importaproduto =? where codprod = ?";
            pstmt = conn.prepareStatement(querie);
            pstmt.setInt(1, codStatus);
            pstmt.setString(2, codProd);
            pstmt.executeUpdate();
            conn.commit();            
            logger.info("Status de importação do produto, atualizado com sucesso!");
        }catch(Exception e){
            logger.error("Erro ao atualizar status de importação do produto: "+e);        
        }finally{
            conn.close();
            pstmt.close();
        }
        
    }
}
