/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 *
 * @author AlexsanderPimenta
 */
public class CompProdDAO {
    private Connection conn = null;
    
     public double retornaEstoqueProd(String codProd) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ParaEcomDAO paraEcom = new ParaEcomDAO();
        try {
            conn = ConexaoATS.conectaERP();
            String sql = "SELECT (compprod.estoque - compprod.quantbloqueada) AS estoquedisponivel  "
                        +"FROM compprod                                                             "
                        +"WHERE compprod.codprod = ? AND compprod.codempresa = ?                    ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codProd);
            pstmt.setString(2, paraEcom.listaTodos().get(0).getCodEmpresaEcom());
            rs = pstmt.executeQuery();
            double estoque = 0;
            while (rs.next()) {
                estoque = rs.getDouble("estoquedisponivel");
            }
            return estoque;
        } catch (Exception e) {
            Logger.getLogger(CompProdDAO.class).error("Erro ao retornar estoque do produto: " + e);
            return 0;
        } finally {
            rs.close();
            conn.close();
            pstmt.close();
        }
    }
    
}
