/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.midler.components.renderer;

import br.com.atsinformatica.utils.Funcoes;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Renderer Para alterar o códido do status por seu nome,
 * tem dependencia da classe Funcoes com o metodo Funcoes.getOrderStatus
 * @author kennedimalheiros
 */
public class StatusPedidoCellRenderer extends DefaultTableCellRenderer {

    public StatusPedidoCellRenderer() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {        
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        label.setText(Funcoes.getOrderStatus((String) value));        
        
        return this;
    }
    
}
