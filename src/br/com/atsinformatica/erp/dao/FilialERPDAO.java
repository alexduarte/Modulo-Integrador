/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.FilialERPBean;
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
public class FilialERPDAO implements IGenericDAO<FilialERPBean>{
    
    private Connection conn;
    private Logger logger = Logger.getLogger(FilialERPDAO.class);

    @Override
    public void gravar(FilialERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(FilialERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FilialERPBean abrir(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Lista todas filiaias cadastradas no ERP
     * @param diretorio diretorio do banco 
     * @param usuario usuário do banco 
     * @param senha senha do banco 
     * @return lista de filiais cadastradas
     * @throws SQLException 
     */
    @Override
    public List<FilialERPBean> listaTodos() throws SQLException {
        List<FilialERPBean> filiais = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try{
            //se nao existir conexao, cria nova
            if(ConexaoATS.getConnection().isClosed())ConexaoATS.conectaERP();
            conn = ConexaoATS.getConnection();            
            String sql = " select codempresa, nomeempresa "
                       + " from filiais order by nomeempresa asc ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                FilialERPBean bean = new FilialERPBean();
                bean.setCodEmpresa(rs.getString("codempresa"));
                bean.setNomeEmpresa(rs.getString("nomeempresa"));
                filiais.add(bean);
            }
            logger.info("Filiais retornada com sucesso.");           
            return filiais ;           
        }catch(Exception e){
            logger.error("Erro ao retornar filiais: "+e);
           return null;           
        }finally{
            stmt.close();
            rs.close();
        }       
    }
    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
}
