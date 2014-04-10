/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.ProdGradeERPBean;
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
public class ProdGradeERPDAO implements IGenericDAO<ProdGradeERPBean>{
    
    private Connection conn;
    
    public List<ProdGradeERPBean> searchGradeComumByCodProd(String codProd) throws SQLException {
        List<ProdGradeERPBean> grades = new ArrayList<ProdGradeERPBean>();
        PreparedStatement pstmt = null;
        ResultSet rs  = null;
        try{                       
            conn = ConexaoATS.conectaERP();            
            String sql = "SELECT grade.codgrade, prodgrade.idprodgradeecom,                   " +
                       "grade.descricao, prodgrade.codprod,                                   " +
                       "(compprod.estoque - compprod.quantbloqueada) AS estoque,              " +
                       "prodgrade.precograde                                                  " +
                       "FROM grade INNER JOIN compprod  ON grade.codgrade = compprod.codgrade " +
                       "INNER JOIN prodgrade ON prodgrade.codgrade = compprod.codgrade        " +
                       "AND prodgrade.codprod  = compprod.codprod                             " +
                       "WHERE prodgrade.ativa = 'S'                                           " +
                       "AND compprod.codprod = ?                                              " +
                       "AND compprod.codempresa = ?                                           ";                       
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codProd);             
            pstmt.setString(2, new ParaEcomDAO().listaTodos().get(0).getCodEmpresaEcom());                             
            rs = pstmt.executeQuery();
            ProdGradeERPBean grade = null;
            //List<RelacionamentoGrade> listRelGrades = new ArrayList<RelacionamentoGrade>();
            while (rs.next()) {               
                grade = new ProdGradeERPBean();
                grade.setCodGrade(rs.getString("codgrade"));
                grade.setDescricaoGrade(rs.getString("descricao"));
                grade.setEstoque(rs.getDouble("estoque")); 
                grade.setPrecoGrade(rs.getDouble("precograde"));
                grade.setCodProd(rs.getString("codprod"));
                grade.setIdProdGradeEcom(rs.getInt("idprodgradeecom"));
                grades.add(grade);              
            }
            Logger.getLogger(ProdGradeERPDAO.class).info("Grade do produto retornado com sucesso!");
            return grades;
        }catch(Exception e){
            Logger.getLogger(ProdGradeERPDAO.class).error("Erro ao retornar grade do produto: "+e);           
            return null;          
        }finally{
            conn.close();
            //rs.close();
            pstmt.close();
        }
    }
    
    /**
     * Retorna lista de grades do produto
     * @param codProd Código do produto
     * @return List<ProdGradeERPBean>
     */
    public List<ProdGradeERPBean> searchByCodProd(String codProd) throws SQLException{
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<ProdGradeERPBean> listaProdGrade = new ArrayList<>();
        try{
            conn = ConexaoATS.conectaERP();
            String sql = "select * from prodgrade where prodgrade.codprod = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codProd);
            rs = pstmt.executeQuery();
            ProdGradeERPBean prodGrade = null;
            while(rs.next()){
                prodGrade = new ProdGradeERPBean();
                prodGrade.setCodProd(rs.getString("codprod"));
                prodGrade.setCodGrade(rs.getString("codgrade"));
                prodGrade.setIdProdGradeEcom(rs.getInt("idprodgradeecom"));
                listaProdGrade.add(prodGrade);
            }
            Logger.getLogger(ProdGradeERPDAO.class).info("Lista de grades do produto retornada com sucesso.");
            return listaProdGrade;
        }catch(Exception e){
            Logger.getLogger(ProdGradeERPDAO.class).error("Erro ao retornar lista de grades do produto: "+e);
            return null;            
        }finally{
            conn.close();
            rs.close();
            pstmt.close();
        }
    }
    
    
    public List<ProdGradeERPBean> searchGradeCompostaByCodProd(String codProd) throws SQLException {
         List<ProdGradeERPBean> grades = new ArrayList<ProdGradeERPBean>();
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try{                       
            conn = ConexaoATS.conectaERP();            
            String sql ="SELECT compprod.codgrade,                                                                                         " +
                                  "SG1.descsubgrade|| ' ' ||SG2.descsubgrade AS descricao,                                                 " +
                                  "(compprod.estoque - compprod.quantbloqueada) AS estoque,                                                " +
                                  "prodgrade.ativa, prodgrade.codprod, prodgrade.idprodgradeecom,                                          " +
                                  "prodgrade.precograde                                                                                    " +
                                  "FROM SUBGRADE SG1, SUBGRADE SG2, compprod INNER JOIN prodgrade ON compprod.codprod  = prodgrade.codprod " +
                                  "AND compprod.codgrade = prodgrade.codgrade                                                              " +
                                  "WHERE(SG1.CODSUBGRADE = SUBSTRING(compprod.codgrade FROM 1 FOR 2))                                      " +
                                  "AND(SG1.TIPODIVISAO = 1)                                                                                " +
                                  "AND(SG2.CODSUBGRADE = SUBSTRING(compprod.codgrade FROM 3 FOR 2))                                        " +
                                  "AND(SG2.TIPODIVISAO = 2)                                                                                " +
                                  "AND prodgrade.ativa = 'S'                                                                               " +
                                  "AND prodgrade.codprod = ?                                                                               " +                                              
                                  "AND compprod.codempresa = ?                                                                             ";
            pstmt = ConexaoATS.getConnection().prepareStatement(sql);
            pstmt.setString(1, codProd);
            pstmt.setString(2, new ParaEcomDAO().listaTodos().get(0).getCodEmpresaEcom());            
            rs = pstmt.executeQuery();
            ProdGradeERPBean grade = null;
            while (rs.next()) {               
                grade = new ProdGradeERPBean();
                grade.setPrecoGrade(rs.getDouble("precograde"));
                grade.setCodGrade(rs.getString("codgrade"));
                grade.setDescricaoGrade(rs.getString("descricao"));
                grade.setCodProd(rs.getString("codprod"));
                grade.setEstoque(rs.getDouble("estoque")); 
                grade.setIdProdGradeEcom(rs.getInt("idprodgradeecom"));
                grades.add(grade);              
            }
            ConexaoATS.fechaConexao();
            Logger.getLogger(ProdGradeERPDAO.class).info("Grade do produto retornado com sucesso!");
            return grades;
        }catch(Exception e){
            Logger.getLogger(ProdGradeERPDAO.class).error("Erro ao retornar grade do produto: "+e);          
            return null;         
        }finally{
             rs.close();
             pstmt.close();
             conn.close();
         }
    }

    @Override
    public void gravar(ProdGradeERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(ProdGradeERPBean object) throws SQLException {
        PreparedStatement pstmt = null;        
        try{
            conn = ConexaoATS.conectaERP();
            String querie = "UPDATE PRODGRADE                        " +
                            " SET IDPRODGRADEECOM = ?                " +
                            "WHERE CODPROD = ? AND CODGRADE = ?      ";
            pstmt = conn.prepareStatement(querie);
            pstmt.setInt(1, object.getIdProdGradeEcom());
            pstmt.setString(2, object.getCodProd());
            pstmt.setString(3, object.getCodGrade());
            pstmt.executeUpdate();
            Logger.getLogger(ProdGradeERPDAO.class).info("Prodgrade alterada com sucesso!");
        }catch(Exception e){
            Logger.getLogger(ProdGradeERPDAO.class).error("Erro ao alterar prodgrade: "+e);            
        }finally{
            conn.close();
            pstmt.close();
        }
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProdGradeERPBean abrir(String id) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = ConexaoATS.conectaERP();
            String sql = "Select * from prodgrade where     "
                        +"IDPRODGRADEECOM = ?               ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(id));
            rs = pstmt.executeQuery();
            ProdGradeERPBean prodGrade = null;
            while(rs.next()){
                prodGrade = new ProdGradeERPBean();
                prodGrade.setCodBarra(rs.getString("codbarra"));
                prodGrade.setCodGrade(rs.getString("codgrade"));
                prodGrade.setCodProd(rs.getString("codprod"));
                prodGrade.setPrecoGrade(rs.getDouble("precograde"));
                prodGrade.setIdProdGradeEcom(rs.getInt("idprodgradeecom"));
            }
            Logger.getLogger(ProdGradeERPDAO.class).info("Prodgrade retornada com sucesso!");
            return prodGrade;
        }catch(Exception e){
            Logger.getLogger(ProdGradeERPDAO.class).error("Erro ao retornar prodgrade: "+e);
            return null;            
        }finally{
            rs.close();
            pstmt.close();
        }
    }

    @Override
    public List<ProdGradeERPBean> listaTodos() throws SQLException {
        List<ProdGradeERPBean> lista = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = ConexaoATS.conectaERP();
            String sql = "Select * from prodgrade";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            ProdGradeERPBean prodGrade = null;
            while(rs.next()){
                prodGrade = new ProdGradeERPBean();
                prodGrade.setCodBarra(rs.getString("codbarra"));
                prodGrade.setCodGrade(rs.getString("codgrade"));
                prodGrade.setCodProd(rs.getString("codprod"));
                prodGrade.setPrecoGrade(rs.getDouble("precograde"));
                prodGrade.setIdProdGradeEcom(rs.getInt("idprodgradeecom"));
                lista.add(prodGrade);
            }
            Logger.getLogger(ProdGradeERPDAO.class).info("Lista de prograde retornada com sucesso!");
            return lista;
        }catch(Exception e){
            Logger.getLogger(ProdGradeERPBean.class).error("Erro ao retornar lista de prodgrade: "+e);
            return null;            
        }finally{
            conn.close();
            stmt.close();
            rs.close();
        }
    }
   

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
