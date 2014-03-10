/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.erp.entity;

import com.towel.el.annotation.Resolvable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Bean de Listar Pedidos ERP
 * @author kennedimalheiros
 */
public class ListaPedidoERPBean {
    @Resolvable(colName = "Cód. Pedido Resulth")
    private int codPedidoResulth;
    @Resolvable(colName = "Cód. Pedido")
    private int codPedidoEcom;
    @Resolvable(colName = "Cliente")
    private String cliente;
    @Resolvable(colName = "Valor")
    private Double valor;
    @Resolvable(colName = "Status")
    private String status;
    @Resolvable(colName = "Data do pedido")
    private Date dataPedido;
    @Resolvable(colName = "Forma de Pagamento")
    private String formaPagamento;
    @Resolvable(colName = "Hora integração")
    private Date horaIntegracao;

    private Date dataFinalizacaoPedido;
    
    public ListaPedidoERPBean(ResultSet rs) throws SQLException{
        this.codPedidoResulth = rs.getInt("CODPEDIDO");       
        this.codPedidoEcom    = rs.getInt("IDPEDIDOECOM");    
        this.cliente          = rs.getString("NOME");         
        this.valor            = rs.getDouble("TOTALPEDIDO");  
        this.status           = rs.getString("STATUSPEDIDOECOM"); 
        this.dataPedido       = rs.getDate("DATAPEDIDO");
        this.formaPagamento   = rs.getString("OBSERVACAO1");       
        this.horaIntegracao   = rs.getDate("DTSINCECOM");
    }

    public ListaPedidoERPBean() {
    }
    
    

    public int getCodPedidoResulth() {
        return codPedidoResulth;
    }

    public void setCodPedidoResulth(int codPedidoResulth) {
        this.codPedidoResulth = codPedidoResulth;
    }

    public int getCodPedidoEcom() {
        return codPedidoEcom;
    }

    public void setCodPedidoEcom(int codPedidoEcom) {
        this.codPedidoEcom = codPedidoEcom;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Date getHoraIntegracao() {
        return horaIntegracao;
    }

    public void setHoraIntegracao(Date horaIntegracao) {
        this.horaIntegracao = horaIntegracao;
    }

    public Date getDataFinalizacaoPedido() {
        return dataFinalizacaoPedido;
    }

    public void setDataFinalizacaoPedido(Date dataFinalizacaoPedido) {
        this.dataFinalizacaoPedido = dataFinalizacaoPedido;
    }
    
    
    
    
    
}
