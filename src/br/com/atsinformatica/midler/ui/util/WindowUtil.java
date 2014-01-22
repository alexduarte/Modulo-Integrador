/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.ui.util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author AlexsanderPimenta
 */
public class WindowUtil {
    
    public static final String NOME_ACAO_FECHA_JANELA = "janela.fecha";

    /**
     * Fecha a janela como se o usuário houvesse clicado no "X" da janela ou
     * dado Alt+F4, inclusive disparando os eventos relevantes.
     */
    public static void fecha(Window w) {
        WindowEvent evt = new WindowEvent(w, WindowEvent.WINDOW_CLOSING);
        w.dispatchEvent(evt);
    }

    public static void fecha(JInternalFrame w) {
        try {
            w.setClosed(true);
        } catch (PropertyVetoException ex) {
            // TODO: Criar exceção apropriada.
            throw new RuntimeException("Erro ao fechar o JInternalFrame.", ex);
        }
    }

    public static void fecha(Component c) {
        while (c != null
                && !(c instanceof Window)
                && !(c instanceof JInternalFrame)) {
            c = c.getParent();
        }
        if (c instanceof Window) {
            fecha((Window)c);
        } else if (c instanceof JInternalFrame) {
            fecha((JInternalFrame)c);
        }
    }

    public static void fechaComEsc(final JFrame w) {
        TeclaAtalhoUtil.associaTeclaAtalho(w, new FechaJanelaAction(w), NOME_ACAO_FECHA_JANELA, "ESCAPE");
    }

    public static void fechaComEsc(final JDialog w) {
        TeclaAtalhoUtil.associaTeclaAtalho(w, new FechaJanelaAction(w), NOME_ACAO_FECHA_JANELA, "ESCAPE");
    }

    public static void fechaComEsc(final JInternalFrame w) {
        TeclaAtalhoUtil.associaTeclaAtalho(w, new FechaInternalFrameAction(w), NOME_ACAO_FECHA_JANELA, "ESCAPE");
    }

    public static void maximiza(final JDialog w) {
        w.setLocation(0,0);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        w.setSize(screenSize.width, screenSize.height);
    }

    public static void maximiza(final JFrame w) {
        w.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void centraliza(final JInternalFrame w) {
        Dimension deskSize = w.getDesktopPane().getSize();
        Dimension frameSize = w.getSize();
        w.reshape(
                (deskSize.width - frameSize.width) / 2,
                (deskSize.height - frameSize.height) / 2,
                frameSize.width, frameSize.height);
    }

    public static void trazParaFrente(final Window w) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                w.toFront();
                w.repaint();
            }
        });
    }

    public static void trazParaFrente(final Component c) {
        trazParaFrente(achaJanela(c));
    }

    public static void trazParaFrente() {
        trazParaFrente(achaJanelaAtiva());
    }

    public static void trazParaFrenteAoAbrir(final Window w) {
        w.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                trazParaFrente(w);
            }
        });
    }

    public static Window achaJanela(Component c) {
        if (c == null || c instanceof Window) {
            return (Window)c;
        }
        return achaJanela(c.getParent());
    }

    public static Window achaJanelaAtiva() {
        return achaJanelaAtiva(Window.getWindows());
    }

    private static Window achaJanelaAtiva(Window[] windows) {
        for (Window window : windows) {
            if (window.isActive()) {
                // Esta janela está ativa.
                return window;
            } else {
                Window[] ownedWindows = window.getOwnedWindows();
                if (ownedWindows != null) {
                    Window result = achaJanelaAtiva(ownedWindows);
                    if (result != null) {
                        // Uma das janelas filha está ativa.
                        return result;
                    }
                }
            }
        }
        // Não achou nenhuma janela ativa.
        return null;
    }

    public static class FechaJanelaAction extends AbstractAction {

        private Window w;

        public FechaJanelaAction(Window w) {
            super(NOME_ACAO_FECHA_JANELA);
            this.w = w;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            fecha(this.w);
        }

    }

    public static class FechaInternalFrameAction extends AbstractAction {

        private JInternalFrame w;

        public FechaInternalFrameAction(JInternalFrame w) {
            super(NOME_ACAO_FECHA_JANELA);
            this.w = w;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            fecha(this.w);
        }

    }
    
}
