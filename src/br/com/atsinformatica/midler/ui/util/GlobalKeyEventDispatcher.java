/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.ui.util;
import java.awt.KeyEventDispatcher;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Action;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/**
 * Implementação de KeyEventDispatcher especializada em atalhos globais.
 * Baseado no código encontrado em
 * {@link http://stackoverflow.com/questions/100123/application-wide-keyboard-shortcut-java-swing}
 *
 * @author HaroldoOliveira
 */
public class GlobalKeyEventDispatcher implements KeyEventDispatcher {

    private Map<KeyStroke, Action> actionMap = new HashMap<KeyStroke, Action>();

    public void put(KeyStroke keyStroke, Action action) {
        this.actionMap.put(keyStroke, action);
    }

    public void put(String keyStroke, Action action) {
        this.put(KeyStroke.getKeyStroke(keyStroke), action);
    }

    public boolean dispatchKeyEvent(KeyEvent e) {
        KeyStroke keyStroke = KeyStroke.getKeyStrokeForEvent(e);

        if (this.actionMap.containsKey(keyStroke)) {
            final Action a = this.actionMap.get(keyStroke);
            final ActionEvent ae = new ActionEvent(e.getSource(), e.getID(), null);

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    a.actionPerformed(ae);
                }
            });

            return true;
        }

        return false;
    }
    
}
