/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.ui.util;

import com.sun.java.swing.Painter;
import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.swing.InputMap;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author AlexsanderPimenta
 */
public class LayoutUtil {
    
    

    private LayoutUtil() {
        // Para evitar instanciação indevida.
    }

    /**
     * Modo de contornar problemas com componentes que insistem em alterar
     * seus tamanhos quando seu conteúdo é esvaziado.
     * Basicamente, todos os componentes passados como parâmetro terão seu
     * tamanho fixado.
     *
     * @param componentes
     */
    public static void fixaTamanho(Component ... componentes) {
        fixaTamanho(0, 0, componentes);
    }

    /**
     * Modo de contornar problemas com componentes que insistem em alterar
     * seus tamanhos quando seu conteúdo é esvaziado.
     * Basicamente, todos os componentes passados como parâmetro terão seu
     * tamanho fixado.
     *
     * @param dx
     *      ajuste no eixo x: este valor será somado à largura dos componentes.
     * @param dy
     *      ajuste no eixo y: este valor será somado à altura dos componentes.
     * @param componentes
     */
    public static void fixaTamanho(int dx, int dy, Component ... componentes) {
        for (Component c : componentes) {
            Dimension ps = c.getPreferredSize();
            Dimension d = new Dimension(ps.width + dx, ps.height + dy);
            c.setPreferredSize(d); // Certifica-se de que o PreferredSize seja uma instância diferente da existente.
            c.setMaximumSize(d);
            c.setMinimumSize(d);
            c.setSize(d);
        }
    }

    public static void ajustaFonte(Component componente, float tamanho) {
        componente.setFont(componente.getFont().deriveFont(tamanho));
        if (componente instanceof Container) {
            for (Component filho : ((Container)componente).getComponents()) {
                ajustaFonte(filho, tamanho);
            }
        }
    }

    public static void configuraLookAndFeel(LookAndFeel laf) {
        try {
            UIManager.setLookAndFeel(laf);
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);

        InputMap im = (InputMap) UIManager.getDefaults().get("Button.focusInputMap");
  
    }

    public static void configuraNimbusLookAndFeel() {
        configuraLookAndFeel(new NimbusLookAndFeel());

        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.put("nimbusOrange", new Color(173, 44, 48));

        defaults.put("ScrollPane[Enabled].borderPainter", new Painter(){

            public void paint(Graphics2D g, Object object, int width, int height) {
                // Sem bordas, por favor.
            }
        });

        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
    }
    
}
