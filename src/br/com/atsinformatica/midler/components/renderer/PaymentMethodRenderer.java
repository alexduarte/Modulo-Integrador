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
import org.apache.log4j.Logger;

/**
 * Metodo para corta apenas o Tipo de pagamento de uma string que tem varios
 * valores
 *
 * @author kennedimalheiros
 */
public class PaymentMethodRenderer extends DefaultTableCellRenderer {

    private static Logger logger = Logger.getLogger(PaymentMethodRenderer.class);

    public PaymentMethodRenderer() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {
        try {
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String valor = (String) value;
            String formaPagamento[] = valor.split(",");
            label.setText(formaPagamento[0].substring(19));

        } catch (Exception e) {
            logger.error("Erro ao executar função PaymentMethodRenderer: " + e);
            return null;
        }
        return this;
    }

}
