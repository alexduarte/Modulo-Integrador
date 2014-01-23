/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.dao;

import br.com.atsinformatica.midler.domainmodel.bean.ProdutoBean;
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
public class ProdutoDAO implements IGenericDAO<ProdutoBean> {
    
    private Logger logger = Logger.getLogger(ProdutoBean.class);
    
    private Connection conn;

    @Override
    public void gravar(ProdutoBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(ProdutoBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProdutoBean abrir(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProdutoBean> listaTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<ProdutoBean> listaASincronizar() throws SQLException{
        List<ProdutoBean> listaProdutos = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = ConexaoATS.conectaERP();
            String sql = "SELECT produto.codprod, "
                    + "(compprod.estoque - compprod.quantbloqueada) AS estoquedisponivel, "
                    + "produto.descricao, produto.descricao2, produto.descricao3, "
                    + "produto.referencia, produto.reffabricante, produto.unidadeent, "
                    + "produto.unidadesaida, produto.preco, produto.preco2, "
                    + "produto.preco3, produto.preco4, compprod.precocusto, "
                    + "produto.grade, compprod.codgrade "
                    + "FROM produto INNER JOIN compprod ON produto.codprod = compprod.codprod "
                    + "WHERE produto.importaproduto = 1 "; 
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                ProdutoBean bean = new ProdutoBean(rs);
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
