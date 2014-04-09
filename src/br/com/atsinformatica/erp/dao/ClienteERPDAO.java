/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.CPFClienteBean;
import br.com.atsinformatica.erp.entity.ClienteERPBean;
import br.com.atsinformatica.erp.entity.EnderecoERPBean;
import br.com.atsinformatica.erp.entity.EstadoERPBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import br.com.atsinformatica.utils.Funcoes;
import br.com.atsinformatica.utils.LogERP;
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
public class ClienteERPDAO implements IGenericDAO<ClienteERPBean> {

    private static Logger logger = Logger.getLogger(ClienteERPDAO.class);
    private Connection conn;

    @Override
    public void gravar(ClienteERPBean cliente) throws SQLException {

    }

    public boolean gravarClienteComEndereco(ClienteERPBean cliente, EnderecoERPBean endereco, CPFClienteBean cpf, EstadoERPBean estadoERPBean) throws SQLException {
        PreparedStatement pstmt = null;
        String codClienteERP = ultimoRegistro();
        try {

            conn = ConexaoATS.conectaERP();
            String sql = " INSERT INTO CLIENTE (CODCLIENTE, CODCLIENTEECOM, NOME, NOMEFANTASIA, "
                    + "                      EMAIL, DT_NASCIMENTO,ENDERECO, BAIRRO, CEP, CODCIDADE, FONE, CELULAR, "
                    + "                      CGCCPF, PESSOA_FJ, INSCEST, ESTADO, ENDERECOCOB, BAIRROCOB, "
                    + "                      CODCIDADECOB, ESTADOCOB, CEPCOB ) "
                    + "              VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, codClienteERP);
            pstmt.setString(2, cliente.getId().trim());
            pstmt.setString(3, cliente.getFirstname().trim() + " " + cliente.getLastname().trim());
            pstmt.setString(4, cliente.getFirstname().trim() + " " + cliente.getLastname().trim());
            pstmt.setString(5, cliente.getEmail().trim());
            pstmt.setDate(6, new Date(cliente.getBirthday().getTime()));
            pstmt.setString(7, endereco.getAddress1() + ", " + endereco.getNumero());
            pstmt.setString(8, endereco.getAddress2());
            pstmt.setString(9, endereco.getPostcode());
            pstmt.setString(10, endereco.getCodCity());       
            pstmt.setString(11, endereco.getPhone());
            pstmt.setString(12, endereco.getPhone_mobile());
            pstmt.setString(13, cpf.getCpf_Cnpj());
            pstmt.setString(14, cpf.getTipoDocumento());

            if (cpf.getTipoDocumento().equals("F")) {
                pstmt.setString(15, "");
            } else if (cpf.getTipoDocumento().equals("J")) {
                pstmt.setString(15, cpf.getRg_inscricao());
            }

            pstmt.setString(16, estadoERPBean.getSigla());
            pstmt.setString(17, endereco.getEnderecoCob());
            pstmt.setString(18, endereco.getBairroCob());
            pstmt.setString(19, endereco.getCodCity());
            pstmt.setString(20, estadoERPBean.getSigla());
            pstmt.setString(21, endereco.getCepCob());

            pstmt.execute();

            //Gerando log
            LogERP.geraLog("CLIENTE", cliente.getId(), "Inclusão", "Incluindo cliente sincronizado do Ecommercer");
            logger.info("Cliente ERP:(" + codClienteERP + "), ID ECOM:(" + cliente.getId().trim() + ") gravado com sucesso.");
            return true;
        } catch (SQLException e) {
            logger.error("ERRO ao Gravar cliente ERP:(" + codClienteERP + "), ID ECOM:(" + cliente.getId().trim() + "): " + e);
            return false;
        } finally {
            conn.close();
            pstmt.close();
        }
    }

    public boolean atualizarClienteComEndereco(ClienteERPBean cliente, EnderecoERPBean endereco, CPFClienteBean cpf, EstadoERPBean estadoERPBean) throws SQLException {
        PreparedStatement pstmt = null;
        try {

            conn = ConexaoATS.conectaERP();
            String sql = " UPDATE CLIENTE SET NOME=?, NOMEFANTASIA=?, "
                    + "                      EMAIL=?, DT_NASCIMENTO=?,ENDERECO=?, BAIRRO=?, CEP=?, FONE=?, CELULAR=?, "
                    + "                      CGCCPF=?, PESSOA_FJ=?, INSCEST=?, ESTADO=?, "
                    + "                      ENDERECOCOB=?, BAIRROCOB=?, CODCIDADECOB=?, "
                    + "                      ESTADOCOB=?, CEPCOB=? WHERE CODCLIENTEECOM=?  ";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, cliente.getFirstname().trim() + " " + cliente.getLastname().trim());
            pstmt.setString(2, cliente.getFirstname().trim() + " " + cliente.getLastname().trim());
            pstmt.setString(3, cliente.getEmail().trim());
            pstmt.setDate(4, new Date(cliente.getBirthday().getTime()));
            pstmt.setString(5, endereco.getAddress1());
            pstmt.setString(6, endereco.getAddress2());
            pstmt.setString(7, endereco.getPostcode());
            pstmt.setString(8, endereco.getPhone());
            pstmt.setString(9, endereco.getPhone_mobile());
            pstmt.setString(10, cpf.getCpf_Cnpj());
            pstmt.setString(11, cpf.getTipoDocumento());

            if (cpf.getTipoDocumento().equals("F")) {
                pstmt.setString(12, "");
            } else if (cpf.getTipoDocumento().equals("J")) {
                pstmt.setString(12, cpf.getRg_inscricao());
            }
            pstmt.setString(13, estadoERPBean.getSigla());

            pstmt.setString(14, endereco.getEnderecoCob() + ", " + endereco.getNumeroCob());
            pstmt.setString(15, endereco.getBairroCob());
            pstmt.setString(16, retornaCodCidade(endereco.getCity()));
            pstmt.setString(17, estadoERPBean.getSiglaCobracao());
            pstmt.setString(18, endereco.getCepCob());

            pstmt.setString(19, cliente.getId().trim());

            pstmt.execute();

            //Gerando log
            LogERP.geraLog("CLIENTE", cliente.getId(), "Alteração", "Alteração de cliente sincronizado do Ecommercer");
            logger.info("Cliente ID ECOM:(" + cliente.getId().trim() + ") Atualizado com sucesso.");
            return true;
        } catch (SQLException e) {
            logger.error("ERRO ao Atualizar cliente ID ECOM:(" + cliente.getId().trim() + "): " + e);
            return false;
        } finally {
            conn.close();
            pstmt.close();
        }
    }

    @Override
    public void alterar(ClienteERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClienteERPBean abrir(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteERPBean> listaTodos() throws SQLException {
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
            logger.error("ERRO ao Consultar ID ERP do ultimo cliente Cadastrado: " + e);
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
            logger.error("Erro na Verificação de Cliente ID ECOM" + codClienteEcom + " já existente: " + e);
            return false;
        } finally {
            pstmt.close();
            rs.close();
            conn.close();
        }
    }

    public String retornaCodClienteERP(String codClienteEcom) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String codClienteERP = null;
        try {
            conn = ConexaoATS.conectaERP();

            String sql = "SELECT C.CODCLIENTE FROM CLIENTE  C "
                    + "                       WHERE C.CODCLIENTEECOM = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codClienteEcom);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                if (rs.getString("CODCLIENTE") != null) {
                    codClienteERP = rs.getString("CODCLIENTE");
                }
            }
            return Funcoes.preencheCom(codClienteERP, "0", 8, Funcoes.LEFT);
        } catch (Exception e) {
            logger.error("Erro ao retornar codigo do ClienteERP, Cliente ID Ecom (retornaCodClienteERP): " + e);
            return null;
        } finally {
            pstmt.close();
            rs.close();
        }
    }

    public String retornaCodCidade(String nomeCidade) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String codCidadeERP = null;
        try {
            conn = ConexaoATS.conectaERP();

            String sql = "SELECT C.CODCIDADE FROM CIDADES  C "
                    + "                       WHERE C.CIDADE = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nomeCidade.toUpperCase());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                if (rs.getString("CODCIDADE") != null) {
                    codCidadeERP = rs.getString("CODCIDADE");
                }
            }
            return Funcoes.preencheCom(codCidadeERP, "0", 5, Funcoes.LEFT);
        } catch (Exception e) {
            logger.error("Erro ao retornar codigo da cidade, Cidade Ecom (" + nomeCidade + "): " + e);
            return null;
        } finally {
            pstmt.close();
            rs.close();
        }
    }
}
