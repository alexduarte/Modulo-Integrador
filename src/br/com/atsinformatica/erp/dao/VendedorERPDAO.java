/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.VendedorERPBean;
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
public class VendedorERPDAO implements IGenericDAO<VendedorERPBean> {
    private Connection conn = null;
    private Logger logger = Logger.getLogger(VendedorERPDAO.class);

    @Override
    public void gravar(VendedorERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(VendedorERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VendedorERPBean abrir(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<VendedorERPBean> listaTodos() throws SQLException {
        List<VendedorERPBean> vendedores = new ArrayList<>();
        Statement  stmt = null;
        ResultSet rs = null;         
         try{             
             if(ConexaoATS.getConnection().isClosed())ConexaoATS.conectaERP();
             conn = ConexaoATS.getConnection();
             String sql = " SELECT codvendedor, nome FROM VENDEND "
                        + " ORDER BY nome asc";
             stmt = conn.createStatement();
             rs = stmt.executeQuery(sql);
             while(rs.next()){
                 VendedorERPBean vendedor = new VendedorERPBean();
                 vendedor.setCodVendedor(rs.getString("codvendedor"));
                 vendedor.setNomeVendedor(rs.getString("nome"));
                 vendedores.add(vendedor);
             }
            logger.info("Vendedores retornado com sucesso!");
            return vendedores;
        }catch(Exception e){
            logger.error("Erro ao retornar vendedores: "+e);
            return null;            
        }finally{
             rs.close();
             stmt.close();
         }
    }
    
    
}
