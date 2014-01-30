/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.components.renderer;

import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author AlexsanderPimenta
 */
public class DateCellRenderer extends DefaultTableCellRenderer {

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public DateCellRenderer() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {
        if (value != null) {
            Calendar dateValue = (Calendar) value;
            setText(dateFormat.format(dateValue.getTime()));
        }
        return this;
    }
}
