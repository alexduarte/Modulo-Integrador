/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.dao;

import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import java.sql.Connection;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProdutoERPBean> listaTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<ProdutoERPBean> listaASincronizar() throws SQLException{
        List<ProdutoERPBean> listaProdutos = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = ConexaoATS.conectaERP();
            String sql = " SELECT produto.codprod, (compprod.estoque - compprod.quantbloqueada) AS estoquedisponivel, produto.descricao, " +
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
                         " WHERE  produto.codgrupo = sub.codgrupo and produto.codsubgrupo = sub.codsubgrupo " +
                         " and produto.importaproduto = 1"; 
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
    
}
