/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.components.renderer;

import br.com.atsinformatica.utils.Funcoes;
import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.apache.log4j.Logger;

/**
 * Renderer para padronizar formato de Valor R$ 00.00
 *
 * @author kennedimalheiros
 */
public class MoneyCellRenderer extends DefaultTableCellRenderer {

    private static Logger logger = Logger.getLogger(MoneyCellRenderer.class);

    public MoneyCellRenderer() {
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

            label.setText(Funcoes.formataCampoMoeda((Double) value));
        } catch (Exception e) {
            logger.error("Erro ao executar função MoneyCellRenderer: " + e);
            return null;
        }

        return this;
    }

}
