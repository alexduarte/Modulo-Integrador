/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.dao;

import br.com.atsinformatica.erp.entity.EnderecoERPBean;
import br.com.atsinformatica.erp.entity.EstadoERPBean;
import br.com.atsinformatica.erp.entity.PedidoCERPBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import br.com.atsinformatica.utils.Funcoes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author kennedimalheiros
 */
public class PedidoCERPDAO implements IGenericDAO<PedidoCERPBean> {

    private static Logger logger = Logger.getLogger(PedidoCERPDAO.class);
    private Connection conn;
    /*
     (connPedido): Conexão utilizada apenas para o processo de controle de 
     transação para gravar Cabeçalho do pedido, Itens do pedido, Complemento do Pedido
     Fazendo Reserva de pedido e Reserva Itens Pedido.
     Conexão aberta em (Gravar PedidoC) PedidoCERPDAO
     Transação continua em (Gravar PedidoI)PedidoIERPDAO
     Transação continua em (Gravar Complemento Pedido) PedidoCERPDAO
     Transação continua em (Gravar Cabeçalho da Reservac  Pedido) RESERVASC
     Transação é commitada em (Gravar Itens da Reserva do Pedido) PEDIDOI
     Se ocorrer algum erro e executado o rollback
     */
    public static Connection connPedido;

    @Override
    public void gravar(PedidoCERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(PedidoCERPBean object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PedidoCERPBean abrir(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PedidoCERPBean> listaTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        return null;
    }

    /**
     * Verificar se numero do pedido informado ja existe no banco do ERP
     *
     * @param codPedidoEcom : Codigo do pedido gerado pelo Ecom
     * @return True se Existir, False se não existir.
     * @throws SQLException
     */
    public boolean verificarPedidoEcomExisteERP(String codPedidoEcom) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = ConexaoATS.conectaERP();

            String sql = "  SELECT P.IDPEDIDOECOM FROM PEDIDOC P "
                    + "                          WHERE IDPEDIDOECOM = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codPedidoEcom);
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

    public String gravarPedido(PedidoCERPBean pedidoERPBean, String codClienteERP) throws SQLException {
        String codPedido = null;
        codPedido = gerarCodPedido();
        PreparedStatement pstmt = null;
        String codEmpresa = new ParaEcomDAO().listaTodos().get(0).getCodEmpresaEcom();
        try {
            connPedido = ConexaoATS.conectaERP();
            if (connPedido.isClosed()) {
                connPedido = ConexaoATS.conectaERP();
            }
            connPedido.setAutoCommit(false);

            String sql = " INSERT INTO PEDIDOC "
                    + "                    (CODPEDIDO, IDPEDIDOECOM, CODEMPRESA, "
                    + "                     TIPOPEDIDO, DESCONTOVLR, "
                    + "                     CODCLIENTE, DATAPEDIDO, HORA, FRETE,"
                    + "                     OBSERVACAO, STATUSPEDIDOECOM) "
                    + "              VALUES(?,?,?,?,?,?,?,?,?,?,?)";

            pstmt = connPedido.prepareStatement(sql);
            pstmt.setString(1, codPedido);
            pstmt.setString(2, pedidoERPBean.getId_ecom());
            pstmt.setString(3, codEmpresa);
            pstmt.setString(4, "55");
            pstmt.setDouble(5, Double.valueOf(pedidoERPBean.getTotal_discounts()));
            pstmt.setString(6, codClienteERP);
            pstmt.setDate(7, new Date(pedidoERPBean.getDate_add().getTime()));
            pstmt.setString(8, pedidoERPBean.getHora());
            pstmt.setDouble(9, Double.valueOf(pedidoERPBean.getTotal_shipping()));
            pstmt.setString(10, "FORMA DE PAGAMENTO: " + pedidoERPBean.getModule()
                    + ", FORMA DE ENVIO: " + pedidoERPBean.getObservacao()
                    + ", CÓDIGO DO PEDIDO NA LOJA VIRTUAL: " + pedidoERPBean.getReference());
            pstmt.setString(11, pedidoERPBean.getCurrent_state());

            pstmt.executeUpdate();

            logger.info("ID Pedido ERP:(" + codPedido + ") ID ECOM:(" + pedidoERPBean.getId_ecom() + "), Referência:(" + pedidoERPBean.getReference() + ")  gravado com sucesso.");
            return codPedido;
        } catch (Exception e) {
            logger.error("Erro ao soncronizar Pedido(ID Pedido ERP:(" + codPedido + ") ID ECOM:(" + pedidoERPBean.getId_ecom() + "), Referência:(" + pedidoERPBean.getReference() + ")): " + e);
            connPedido.rollback();
            connPedido.close();
            return null;
        } finally {

            pstmt.close();
        }
    }

    public boolean gravarPedidoCompl(String codPedidoERP, String codClienteERP, EnderecoERPBean enderecoERPBean, EstadoERPBean estadoERPBean) throws SQLException {

        PreparedStatement pstmt = null;
        String codEmpresa = new ParaEcomDAO().listaTodos().get(0).getCodEmpresaEcom();
        try {

            String sql = "INSERT INTO PEDIDOCCOMPL "
                    + "    (CODEMPRESA, TIPOPEDIDO, CODPEDIDO, CODCLIENTE, "
                    + "     ENDERECOENT, BAIRROENT, CODCIDADEENT, ESTADOENT, CEPENT) "
                    + "    VALUES "
                    + "    (?, ?, ?, ?, ?, ?, ?, ?, ?);";

            pstmt = connPedido.prepareStatement(sql);

            pstmt.setString(1, codEmpresa);
            pstmt.setString(2, "55");
            pstmt.setString(3, codPedidoERP);
            pstmt.setString(4, codClienteERP);

            pstmt.setString(5, enderecoERPBean.getEnderecoEnt() + "," + enderecoERPBean.getNumeroEnt());
            pstmt.setString(6, enderecoERPBean.getBairroEnt());
            pstmt.setString(7, enderecoERPBean.getCodCidadeEnt());
            pstmt.setString(8, estadoERPBean.getSigla());
            pstmt.setString(9, enderecoERPBean.getCepEnt());

            pstmt.executeUpdate();

            logger.info("Complemento do Pedido ERP:(" + codPedidoERP + ") gravado com sucesso.");
            return true;
        } catch (Exception e) {
            logger.error("Erro ao Gravar complemento do Pedido(ID Pedido ERP:(" + codPedidoERP + "): " + e);
            connPedido.rollback();
            connPedido.close();
            return false;
        } finally {
            pstmt.close();
        }
    }

    public String parametroUsaDAVPDV(String codEmpresa) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String retorno = null;
        try {
            conn = ConexaoATS.conectaERP();

            String sql = " Select IMPORTAPEDIDO from PARAMECF "
                    + "                        WHERE CODEMPRESA = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codEmpresa);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                if (rs.getString("IMPORTAPEDIDO") != null) {
                    retorno = rs.getString("IMPORTAPEDIDO");
                }
            }
            return retorno;
        } catch (Exception e) {
            logger.error("Erro na Verificação de parametro UsaDavPDV: " + e);
            return null;
        } finally {
            pstmt.close();
            rs.close();
        }
    }

    /**
     *
     * @return True se utiliza UsarGenPDV
     * @throws SQLException
     */
    public boolean parametroParaCadUsarGenPDV() throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean retorno = false;
        try {
            conn = ConexaoATS.conectaERP();

            String sql = " SELECT USARGENPDV FROM PARACAD ";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                if (rs.getString("USARGENPDV") != null) {
                    retorno = rs.getString("USARGENPDV").equals("S");
                }
            }
            return retorno;
        } catch (Exception e) {
            logger.error("Erro na Verificação de parametro UsarGenPDV: " + e);
            return false;
        } finally {
            pstmt.close();
            rs.close();
        }
    }

    public String parametroParaFat(String campoRetorno) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String retorno = null;
        try {
            conn = ConexaoATS.conectaERP();

            String sql = " SELECT " + campoRetorno + " FROM PARAFAT ";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                if (rs.getString(campoRetorno) != null) {
                    retorno = rs.getString(campoRetorno);
                }
            }
            return retorno;
        } catch (Exception e) {
            logger.error("Erro na Verificação de Parametro ParaFat do campo " + campoRetorno + ": " + e);
            return null;
        } finally {
            pstmt.close();
            rs.close();
        }
    }

    public int erpProximoCodGenPDV(String codEmpresa) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int retorno = 0;
        try {
            conn = ConexaoATS.conectaERP();

            String sql = " Select Gen_ID(GENPDV" + codEmpresa + ",1) as CodPedido from RDB$DATABASE ";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                if (rs.getString("CODPEDIDO") != null) {
                    retorno = rs.getInt("CODPEDIDO");
                }
            }
            return retorno;
        } catch (Exception e) {
            logger.error("Erro na executar função erpProximoCodGenPDV: " + e);
            return 0;
        } finally {
            pstmt.close();
            rs.close();
        }
    }

    public int erpGenCodPedido() throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int retorno = 0;
        try {
            conn = ConexaoATS.conectaERP();

            String sql = " select Gen_ID(G_CodPedido_PDV, 1) as Cod from RDB$DATABASE ";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                if (rs.getString("COD") != null) {
                    retorno = rs.getInt("COD");
                }
            }
            return retorno;
        } catch (Exception e) {
            logger.error("Erro na executar função erpGenCodPedido: " + e);
            return 0;
        } finally {
            pstmt.close();
            rs.close();
        }
    }

    /**
     * Se existir pedido com o mesmo codigo TRUE Se não existir pedido com o
     * mesmo codigo FALSE
     *
     * @param codEmpresa
     * @param tipoPedido
     * @param codPedido Maximo 8 digitos
     * @return
     * @throws SQLException
     */
    public boolean erpPedidoCExiste(String codEmpresa, String tipoPedido, String codPedido) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean retorno = false;
        /**
         * Passando para 8 digitos para verificar na tabela PEDICOC codPedido =
         * Funcoes.preencheCom(codPedido, "0", 8, Funcoes.LEFT);
         */
        codPedido = Funcoes.preencheCom(codPedido, "0", 8, Funcoes.LEFT);

        try {
            conn = ConexaoATS.conectaERP();

            String sql = " SELECT DISTINCT CODPEDIDO                 "
                    + "                 FROM PEDIDOC                 "
                    + "                   WHERE                      "
                    + "                       CODEMPRESA = ?   AND   "
                    + "                       TIPOPEDIDO  = ?  AND   "
                    + "                       CODPEDIDO   = ?        ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codEmpresa);
            pstmt.setString(2, tipoPedido);
            pstmt.setString(3, codPedido);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = rs.getString("CODPEDIDO").equals(codPedido);
            }
            return retorno;
        } catch (Exception e) {
            logger.error("Erro na executar função erpPedidoCExiste: " + e);
            return false;
        } finally {
            pstmt.close();
            rs.close();
        }
    }

    //Se não utiliza UsarGenPDV.
    public int erpMaxNpdv(String codEmpresa) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int retorno = 0;
        try {
            conn = ConexaoATS.conectaERP();

            String sql = "  SELECT NUMEROPDV FROM NPDV "
                    + "           WHERE CODEMPRESA = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codEmpresa);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                if (rs.getString("NUMEROPDV") != null) {
                    retorno = rs.getInt("NUMEROPDV");
                }
            }
            return retorno;
        } catch (Exception e) {
            logger.error("Erro na executar função erpMaxNpdv: " + e);
            return 0;
        } finally {
            pstmt.close();
            rs.close();
        }
    }

    /**
     * Verificar se utiliza ECF Vai verificar se tem registro na tabela PDVFisc
     * se não tiver é porque não utiliza.
     *
     * @param codEmpresa
     * @return True se utilizar ECF
     * @throws SQLException
     */
    public boolean erpUtilizaECF(String codEmpresa) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean retorno = false;
        try {
            conn = ConexaoATS.conectaERP();

            String sql = " SELECT * FROM PDVFISC P WHERE P.CODEMPRESA = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codEmpresa);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = true;
            }
            return retorno;
        } catch (Exception e) {
            logger.error("Erro na executar função erpSysECF: " + e);
            return false;
        } finally {
            pstmt.close();
            rs.close();
        }
    }

    /**
     * Função vai validar todo os parametros para verificar qual a rotina é
     * utilizada para gerado o Código de pedido na tabela PedidoC
     *
     * @return Novo código de pedido com 8 digitos.
     * @throws SQLException
     */
    public String gerarCodPedido() throws SQLException {
        int codPedido = 0;
        String codEmpresa = new ParaEcomDAO().listaTodos().get(0).getCodEmpresaEcom();
        if (parametroParaFat("NUMERARPDVAUTO").equals("S")) {

            //Verifica se utiliza ECF
            if (erpUtilizaECF(codEmpresa)) {
                codPedido = erpProximoCodGenPDV(codEmpresa);

            } else if (parametroParaCadUsarGenPDV()) { // parametroParaCadUsarGenPDV = S
                codPedido = erpGenCodPedido();

                //Verificando se o pedido existe
                if (erpPedidoCExiste(codEmpresa, "55", String.valueOf(codPedido))) {
                    //Se pedido existe, entra no loop que vai incrementar +1 ate que erpPedidoCExiste seja FALSE
                    while (!erpPedidoCExiste(codEmpresa, "55", String.valueOf(codPedido))) {
                        codPedido += 1;
                    }
                }
            } else { //parametroParaCadUsarGenPDV = N
                codPedido = erpMaxNpdv(codEmpresa);

                //Se codPedido for 0, Adiciona o primeiro cod.
                if (codPedido == 0) {
                    codPedido += 1;
                }
            }
        }
        return Funcoes.preencheCom(String.valueOf(codPedido), "0", 8, Funcoes.LEFT);
    }

}
