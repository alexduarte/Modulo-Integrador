/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.CPFClienteBean;
import br.com.atsinformatica.erp.entity.ClienteEcomBean;
import br.com.atsinformatica.erp.entity.EnderecoEcomBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import br.com.atsinformatica.utils.Funcoes;
import br.com.atsinformatica.utils.Log;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author kennedimalheiros
 */
public class ClienteERPDAO implements IGenericDAO<ClienteEcomBean> {

    private static Logger logger = Logger.getLogger(ListaPedidoDAO.class);
    private Connection conn;

    @Override
    public void gravar(ClienteEcomBean cliente) throws SQLException {

    }

    public void gravarClienteComEndereco(ClienteEcomBean cliente, EnderecoEcomBean endereco, CPFClienteBean cpf) throws SQLException {
        PreparedStatement pstmt = null;
        try {

            conn = ConexaoATS.conectaERP();
            String sql = " INSERT INTO CLIENTE (CODCLIENTE, CODCLIENTEECOM, NOME, NOMEFANTASIA, "
                    + "                      EMAIL, DT_NASCIMENTO,ENDERECO, BAIRRO, CEP, FONE, CELULAR, "
                    + "                      CGCCPF, PESSOA_FJ, INSCEST ) "
                    + "              VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, ultimoRegistro());
            pstmt.setString(2, cliente.getId().trim());
            pstmt.setString(3, cliente.getFirstname().trim() + " " + cliente.getLastname().trim());
            pstmt.setString(4, cliente.getFirstname().trim() + " " + cliente.getLastname().trim());
            pstmt.setString(5, cliente.getEmail().trim());
            pstmt.setDate(6, new Date(cliente.getBirthday().getTime()));
            pstmt.setString(7, endereco.getAddress1());
            pstmt.setString(8, endereco.getAddress2());
            pstmt.setString(9, endereco.getPostcode());
            pstmt.setString(10, endereco.getPhone());
            pstmt.setString(11, endereco.getPhone_mobile());
            pstmt.setString(12, cpf.getCpf_Cnpj());
            pstmt.setString(13, cpf.getTipoDocumento());

            if (cpf.getTipoDocumento().equals("F")) {
                pstmt.setString(14, "");
            } else if (cpf.getTipoDocumento().equals("J")) {
                pstmt.setString(14, cpf.getRg_inscricao());
            }

            pstmt.execute();

            //Gerando log
            Log.geraLog("CLIENTE", cliente.getId(), "Inclusão", "Incluindo cliente sincronizado do Ecommercer");

        } catch (SQLException e) {
            logger.error("Erro ao soncronizar Cliente ID Ecom ( " + cliente.getId() + " ): " + e);

        } finally {
            conn.close();
            pstmt.close();
        }
    }

    @Override
    public void alterar(ClienteEcomBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClienteEcomBean abrir(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteEcomBean> listaTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select max(CODCLIENTE) cod from CLIENTE";
            stmt = ConexaoATS.conectaERP().createStatement();
            rs = stmt.executeQuery(sql);
            int cod = 0;
            while (rs.next()) {
                if (rs.getString("cod") != null) {
                    cod = Integer.valueOf(rs.getString("cod")) + 1;
                }
            }
            return Funcoes.preencheCom(Integer.toString(cod), "0", 8, Funcoes.LEFT);
        } catch (Exception e) {
            return null;
        } finally {
            stmt.close();
            rs.close();
        }
    }

    public boolean verificacaoClienteEcomExiste(String codClienteEcom) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = ConexaoATS.conectaERP();

            String sql = "  SELECT C.CODCLIENTEECOM FROM CLIENTE C "
                    + "                          WHERE CODCLIENTEECOM = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codClienteEcom);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error("Erro na Verificação de Cliente já existente: " + e);
            return false;
        } finally {
            pstmt.close();
            rs.close();
            conn.close();
        }
    }

}
