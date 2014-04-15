/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.ui;

import br.com.atsinformatica.erp.dao.ListaPedidoDAO;
import br.com.atsinformatica.erp.entity.ListaPedidoERPBean;
import br.com.atsinformatica.prestashop.controller.OrderController;
import br.com.atsinformatica.prestashop.controller.OrderHistoryController;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author kennedimalheiros
 */
public class ConfirmacaoEntrega extends javax.swing.JDialog {

    /**
     * Creates new form ConfirmacaoEntrega
     */
    public ConfirmacaoEntrega(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public ConfirmacaoEntrega(java.awt.Frame parent, boolean modal, String codPedidoResulth, String codPedidoEcom) {
        super(parent, modal);
        initComponents();
        this.codPedidoEcom = codPedidoEcom;
        this.codPedidoResulth = codPedidoResulth;

    }

    private String codPedidoResulth;
    private String codPedidoEcom;
    private static Logger logger = Logger.getLogger(PanelListaPedidos.class);

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tNumDocumetoEntrega = new javax.swing.JTextField();
        btConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informações da entrega.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nº Documento:");

        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tNumDocumetoEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btConfirmar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tNumDocumetoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btConfirmar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed

        int yes;
        yes = JOptionPane.showConfirmDialog(null, "Deseja alterar o status do pedido para (Entregue)?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (yes == JOptionPane.YES_OPTION) {
            statusEntregue(codPedidoEcom, codPedidoResulth, tNumDocumetoEntrega.getText());
        }
        //Fechando a janela.
        this.dispose();

    }//GEN-LAST:event_btConfirmarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConfirmacaoEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmacaoEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmacaoEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmacaoEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfirmacaoEntrega dialog = new ConfirmacaoEntrega(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tNumDocumetoEntrega;
    // End of variables declaration//GEN-END:variables

    public void statusEntregue(String codPedidoEcom, String codPedidoResulth, String numDocumetoEntrega) {
        try {
            ListaPedidoERPBean listaPedidoERPBean = new ListaPedidoERPBean();
            listaPedidoERPBean.setCodPedidoResulth(Integer.valueOf(codPedidoResulth));
            listaPedidoERPBean.setCodPedidoEcom(Integer.valueOf(codPedidoEcom));
            listaPedidoERPBean.setNumDocumetoEntrega(numDocumetoEntrega);

            ListaPedidoDAO listaPedidoDAO = new ListaPedidoDAO();
            if (listaPedidoDAO.validacaoStatusEntregue(listaPedidoERPBean)) {
                if (listaPedidoDAO.StatusEntregue(listaPedidoERPBean)) {
                    //Iniciando - Alterando Status na loja prestashop
                    OrderController orderController = new OrderController();
                    orderController.updateStatusOrder(Integer.valueOf(codPedidoEcom), 5);
                    //Fim - Alterando Status na loja prestashop                  
                    //Iniciando - Gravar Alteração de status na tabela de Historico do pedido
                    OrderHistoryController historyController = new OrderHistoryController();
                    historyController.insertOrderHistory(Integer.valueOf(codPedidoEcom), 5);
                    //Fim - Gravar Alteração de status na tabela de Historico do pedido                      

                    JOptionPane.showMessageDialog(null, "Status (Entregue) do pedido alterado com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Esse pedido não pode ser alterado o status!");
            }

        } catch (Exception e) {
            logger.error("Erro ao mudar status do pedidos para (Entregue): " + e);
        }
    }

}
