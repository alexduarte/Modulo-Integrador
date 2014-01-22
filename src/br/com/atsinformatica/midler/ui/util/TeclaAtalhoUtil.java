/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.ui.util;

import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

/**
 *
 * @author AlexsanderPimenta
 */
public class TeclaAtalhoUtil {
    
     private static GlobalKeyEventDispatcher atalhoGlobal;

    public static void associaTeclaAtalho(JComponent component, Action action, String nomeAcao, String ... atalhos) {
        final InputMap inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        final ActionMap actionMap = component.getActionMap();
        for (String atalho : atalhos) {
            KeyStroke keyStroke = KeyStroke.getKeyStroke(atalho);
            inputMap.put(keyStroke, nomeAcao);
            actionMap.put(nomeAcao, action);
        }
    }

    public static void associaTeclaAtalho(JFrame frame, Action action, String nomeAcao, String ... atalhos) {
        associaTeclaAtalho(frame.getRootPane(), action, nomeAcao, atalhos);
    }

    public static void associaTeclaAtalho(JDialog dialog, Action action, String nomeAcao, String ... atalhos) {
        associaTeclaAtalho(dialog.getRootPane(), action, nomeAcao, atalhos);
    }

    public static void associaTeclaAtalho(final AbstractButton button, String nomeAcao, String ... atalhos) {
        Action action = new AbstractAction(nomeAcao) {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ActionListener listener : button.getActionListeners()) {
                    listener.actionPerformed(e);
                }
            }
        };
        associaTeclaAtalho(button, action, nomeAcao, atalhos);
    }

    public static void teclaAtalhoRequestFocus(JComponent pai, final Component component, String nomeAcao, String ... atalhos) {
        associaTeclaAtalho(pai, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                component.requestFocusInWindow();
            }
        }, nomeAcao, atalhos);
    }

    public static void teclaAtalhoGlobal(Action action, String ... atalhos) {
        GlobalKeyEventDispatcher ed = new GlobalKeyEventDispatcher();

        for (String atalho : atalhos) {
            ed.put(atalho, action);
        }

        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher(ed);
    }

    public static void teclaAtalhoGlobal(final AbstractButton button, String ... atalhos) {
        Action action = new AbstractAction("Button " + button.getName() + " " + atalhos[0]) {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ActionListener listener : button.getActionListeners()) {
                    listener.actionPerformed(e);
                }
            }
        };
        teclaAtalhoGlobal(action, atalhos);
    }
    
}
