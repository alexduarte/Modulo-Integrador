/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.ui.util;

import java.awt.AWTKeyStroke;
import java.awt.Component;
import java.awt.DefaultKeyboardFocusManager;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

/**
 * KeyboardFocusManager adaptados às teclas de navegação padrão da ATS
 * (ENTER para focar o próximo controle, CIMA para focar o controle anterior
 * se o controle atual não fizer uso da seta para cima).
 * Implementado na forma de um KeyboardFocusManager porque o método
 * {@link java.awt.Container#setFocusTraversalKeys(id,keystrokes)}
 * não resolve o problema; isto porque as teclas associadas valem para quaisquer
 * controles, e aqui nós desejamos que certos controles não sejam afetados pelas
 * teclas especiais.
 *
 * TODO: As funções de bloqueio de teclado e navegação com {@see ENTER}
 * estão misturadas: dá para dividir em duas ou três classes.
 *
 * @author Haroldo de Oliveira Pinheiro
 */
public class AtsKeyboardFocusManager extends DefaultKeyboardFocusManager {
    
     private static final String[] NAVEGACAO_FRENTE = new String[]{"ENTER"};
     
     private static final String[] NAVEGACAO_TRAS = new String[]{"UP"};
     
     private static final String[] NAVEGACAO_BAIXO = new String[]{"DOWN"};
    
     private static final Set<Class<?>> IGNORAM_ENTER = new HashSet<Class<?>>(Arrays.asList(new Class<?>[]{
        JEditorPane.class, JButton.class, JTextArea.class
    }));
    
     private static final Set<Class<?>> IGNORAM_CIMA = new HashSet<Class<?>>(Arrays.asList(new Class<?>[]{
        JEditorPane.class, JTable.class, JTextArea.class, JList.class
    }));
    
    private static final Set<Class<?>> IGNORAM_BAIXO = new HashSet<Class<?>>(Arrays.asList(new Class<?>[]{
        JEditorPane.class, JTable.class, JTextArea.class, JList.class
    }));

    private final Set<AWTKeyStroke> strokesFrente;
    private final Set<AWTKeyStroke> strokesTras;
    
    private final Set<AWTKeyStroke> strokesBaixo;

    private final Map<Component,Object> componentesIgnorados;
    private final Map<Component,Date> componentesTecladoNaoBloqueado;

    private boolean consumeNextKeyTyped;
    private boolean enterPressionado;

    private boolean tecladoAtivo;
    private Date timestampAtivacaoTeclado;

    public AtsKeyboardFocusManager() {
        this.strokesFrente = new HashSet<AWTKeyStroke>();
        for (String s : NAVEGACAO_FRENTE) {
            this.strokesFrente.add(KeyStroke.getAWTKeyStroke(s));
        }

        this.strokesTras = new HashSet<AWTKeyStroke>();
        for (String s : NAVEGACAO_TRAS) {
            this.strokesTras.add(KeyStroke.getAWTKeyStroke(s));
        }
        
        this.strokesBaixo = new HashSet<AWTKeyStroke>();
        for (String s : NAVEGACAO_BAIXO) {
            this.strokesBaixo.add(KeyStroke.getAWTKeyStroke(s));
        }

        this.componentesIgnorados = new WeakHashMap<Component, Object>();
        this.componentesTecladoNaoBloqueado = new WeakHashMap<Component, Date>();

        this.tecladoAtivo = true;
    }

    public static void install() {
        KeyboardFocusManager current = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        if (!(current instanceof AtsKeyboardFocusManager)) {
            AtsKeyboardFocusManager novo = new AtsKeyboardFocusManager();
            KeyboardFocusManager.setCurrentKeyboardFocusManager(novo);
        }
    }

    public static boolean isInstalled() {
        return KeyboardFocusManager.getCurrentKeyboardFocusManager() instanceof AtsKeyboardFocusManager;
    }

    public static void limpaEnterSeInstalado() {
        if (!isInstalled()) {
            return;
        }
        getCurrentKeyboardFocusManager().limpaEnter();
    }

    public static void habilitaTeclado() {
        if (!isInstalled()) {
            return;
        }
        getCurrentKeyboardFocusManager().setTecladoAtivo(true);
    }

    public static void desabilitaTeclado() {
        if (!isInstalled()) {
            return;
        }
        getCurrentKeyboardFocusManager().setTecladoAtivo(false);
    }

    public static AtsKeyboardFocusManager getCurrentKeyboardFocusManager() {
        KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        if (!(kfm instanceof AtsKeyboardFocusManager)) {
            return null;
        }
        return (AtsKeyboardFocusManager)kfm;
    }

    public void ignorarComponente(Component ... componentes) {
        for (Component component : componentes) {
            this.componentesIgnorados.put(component, this);
        }
    }

    public boolean isEnterPressionado() {
       
        return this.enterPressionado;
    }

    public void limpaEnter() {
        this.enterPressionado = false;
    }

    private void trataEnter(KeyEvent e) {
        if (e.getID() != KeyEvent.KEY_TYPED && e.getKeyCode() == KeyEvent.VK_ENTER && !(e.isAltDown() || e.isAltGraphDown() || e.isControlDown() || e.isMetaDown() || e.isShiftDown())) {
            this.enterPressionado = e.getID() == KeyEvent.KEY_PRESSED;
        }
    }

    @Override
    public void processKeyEvent(Component focusedComponent, KeyEvent e) {
        if (!this.aceitaEventoTecla(focusedComponent, e)) {
            e.consume();
            return;
        }

        this.trataEnter(e);

        if (this.consumeProcessedKeyEvent(e)) {
            return;
        }

        if (e.getID() == KeyEvent.KEY_TYPED) {
            return;
        }

        if (focusedComponent.getFocusTraversalKeysEnabled()
                && !e.isConsumed()) {
            AWTKeyStroke stroke = AWTKeyStroke.getAWTKeyStrokeForEvent(e);
            AWTKeyStroke oppStroke = AWTKeyStroke.getAWTKeyStroke(stroke.getKeyCode(),
                    stroke.getModifiers(),
                    !stroke.isOnKeyRelease());

            Set<AWTKeyStroke> toTest;
            boolean contains, containsOpp;

            // ** Para a frente ** //
            toTest = this.strokesFrente;
            contains = toTest.contains(stroke);
            containsOpp = toTest.contains(oppStroke);

            if ((contains || containsOpp)
                    && this.isNavegaComEnter(focusedComponent)) {
                this.consumeTraversalKey(e);
                if (contains) {
                    this.focusNextComponent(focusedComponent);
                }
                return;
            }

            // ** Para trás ** //
            toTest = this.strokesTras;
            contains = toTest.contains(stroke);
            containsOpp = toTest.contains(oppStroke);

            if ((contains || containsOpp)
                    && this.isNavegaComCima(focusedComponent)) {
                this.consumeTraversalKey(e);
                if (contains) {
                    this.focusPreviousComponent(focusedComponent);
                }
                return;
            }
            
            //**Para baixo**//
             toTest = this.strokesBaixo;
            contains = toTest.contains(stroke);
            containsOpp = toTest.contains(oppStroke);

            if ((contains || containsOpp)
                    && this.isNavegaComBaixo(focusedComponent)) {
                this.consumeTraversalKey(e);
                if (contains) {
                    this.focusPreviousComponent(focusedComponent);
                }
                return;
            }
        }

        super.processKeyEvent(focusedComponent, e);
    }

    public boolean isTecladoAtivo() {
        return tecladoAtivo;
    }
    public synchronized void setTecladoAtivo(boolean tecladoAtivo) {
        if (tecladoAtivo && !this.tecladoAtivo) {
            /* Acaba de reativar;
             * seta o timestamp para descartar eventos
             * anteriores à ativação.
             */
            this.timestampAtivacaoTeclado = new Date();
        }

        this.tecladoAtivo = tecladoAtivo;

        if (!tecladoAtivo) {
            this.limpaEnter();
        }
    }

    public void naoBloquearTecladoComponente(Component ... componentes) {
        for (Component component : componentes) {
            this.componentesTecladoNaoBloqueado.put(component, new Date());
        }
    }

    private boolean consumeProcessedKeyEvent(KeyEvent e) {
        if ((e.getID() == KeyEvent.KEY_TYPED) && consumeNextKeyTyped) {
            e.consume();
            consumeNextKeyTyped = false;
            return true;
        }
        return false;
    }

    private void consumeTraversalKey(KeyEvent e) {
        e.consume();
        consumeNextKeyTyped = (e.getID() == KeyEvent.KEY_PRESSED) &&
                              !e.isActionKey();
    }

    private boolean isNavegaComEnter(Component focusedComponent) {
        if (this.componentesIgnorados.containsKey(focusedComponent)) {
            return false;
        }

        for (Class<?> clazz : IGNORAM_ENTER) {
            if (clazz.isAssignableFrom(focusedComponent.getClass())) {
                return false;
            }
        }
        return true;
    }
    
     private boolean isNavegaComBaixo(Component focusedComponent) {
        if (this.componentesIgnorados.containsKey(focusedComponent)) {
            return false;
        }

        for (Class<?> clazz : IGNORAM_BAIXO) {
            if (clazz.isAssignableFrom(focusedComponent.getClass())) {
                return false;
            }
        }
        return true;
    }

    private boolean isNavegaComCima(Component focusedComponent) {
        if (this.componentesIgnorados.containsKey(focusedComponent)) {
            return false;
        }
        if (focusedComponent instanceof JComboBox
                && ((JComboBox)focusedComponent).isPopupVisible()) {
            return false;
        }

        for (Class<?> clazz : IGNORAM_CIMA) {
            if (clazz.isAssignableFrom(focusedComponent.getClass())) {
                return false;
            }
        }
        return true;
    }

    private boolean aceitaEventoTecla(Component focusedComponent, KeyEvent e) {
        if (this.isTecladoAtivo()) { // Teclado está ativo
            if (this.timestampAtivacaoTeclado != null
                    && this.timestampAtivacaoTeclado.getTime() > e.getWhen()) {
                // Evento ocorreu antes da ativação mais recente.
                return false;
            }
        } else {
            /*
             * Teclado desabilitado;
             * Olha se não é um dos componentes excepcionais e,
             * se for, compara o momento do evento com o momento
             * em que o componente entrou na lista.
             */
            Date ts = this.componentesTecladoNaoBloqueado.get(e.getComponent());
            if (ts == null) {
                ts = this.componentesTecladoNaoBloqueado.get(WindowUtil.achaJanela(e.getComponent()));
            }
            if (ts != null
                    && ts.getTime() > e.getWhen()) {
                // Descarta eventos anteriores à inclusão do componente.
                return false;
            }
        }
        return true;
    }
    
}
