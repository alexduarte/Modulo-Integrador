/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler;

import br.com.atsinformatica.midler.properties.PropertiesManager;
import br.com.atsinformatica.midler.ui.util.AtsKeyboardFocusManager;
import br.com.atsinformatica.midler.ui.util.LayoutUtil;
import br.com.atsinformatica.midler.ui.PanelPrincipal;
import javax.swing.JOptionPane;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author AlexsanderPimenta
 */
public class Main {

    public static void main(String args[]) {
        //instala navegação pelo teclado
        AtsKeyboardFocusManager.install();
        //configura look and feel
        LayoutUtil.configuraLookAndFeel(new NimbusLookAndFeel());
        PanelPrincipal principal = PanelPrincipal.getInstance();
        //verifica se arquivo de configuração existe, caso não exista, dispara mensagem de alerta para que o usuario possa cria-lo
        if (!PropertiesManager.getFile().exists()) {
            JOptionPane.showMessageDialog(principal, "Antes de utilizar o módulo sincronizador é necessário configurá-lo! Acesse a rotina de configurações\n"
                    + "e certifique-se de que todos os campos obrigatórios foram devidamente preenchidos.");
        }
        principal.setVisible(true);
    }
}
