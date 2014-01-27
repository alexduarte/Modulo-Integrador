/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.ui;

import br.com.atsinformatica.erp.dao.ParaEcomDAO;
import br.com.atsinformatica.erp.entity.ParaEcomBean;
import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import br.com.atsinformatica.midler.dao.ProdutoDAO;
import br.com.atsinformatica.midler.tablemodel.bean.SincronizarModel;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.table.TableColumn;
import org.apache.log4j.Logger;

/**
 *
 * @author AlexsanderPimenta
 */
public class PanelHistorico extends javax.swing.JPanel {
    //Resolver para grid sincronizar

    private AnnotationResolver resolverSinc = new AnnotationResolver(SincronizarModel.class);
    private String fields = "entidade,itemDescricao,origem,sincronizado";
    //model para grid  sincronizar
    private ObjectTableModel modelSincronizar = new ObjectTableModel(resolverSinc, fields);
    private static Logger logger = Logger.getLogger(PanelHistorico.class);

    /**
     * Creates new form PanelHistorico
     */
    public PanelHistorico() {
        initComponents();
        carregaGridSincronizar();
        setaTimer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timerCadastro = new org.netbeans.examples.lib.timerbean.Timer();
        timerMov = new org.netbeans.examples.lib.timerbean.Timer();
        title_historico = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbSincronizar = new javax.swing.JTable();
        jBtRefresh = new javax.swing.JButton();

        timerCadastro.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timerCadastroOnTime(evt);
            }
        });

        timerMov.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timerMovOnTime(evt);
            }
        });

        setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        title_historico.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        title_historico.setText("Histórico de sincronização ");

        jTbSincronizar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Entidade", "Descrição", "Origem", "Sincronizado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTbSincronizar);

        jBtRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/refresh.png"))); // NOI18N
        jBtRefresh.setToolTipText("Atualizar");
        jBtRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title_historico)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(880, 880, 880)
                        .addComponent(jBtRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title_historico)
                .addGap(18, 18, 18)
                .addComponent(jBtRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void timerMovOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerMovOnTime
        // TODO add your handling code here:
    }//GEN-LAST:event_timerMovOnTime

    private void timerCadastroOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerCadastroOnTime
       iniciaSincronizacao(refreshSincCad());
    }//GEN-LAST:event_timerCadastroOnTime

    private void jBtRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRefreshActionPerformed
        refreshSincCad();
    }//GEN-LAST:event_jBtRefreshActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbSincronizar;
    private org.netbeans.examples.lib.timerbean.Timer timerCadastro;
    private org.netbeans.examples.lib.timerbean.Timer timerMov;
    private javax.swing.JLabel title_historico;
    // End of variables declaration//GEN-END:variables

    private void carregaGridSincronizar() {
        jTbSincronizar.setModel(modelSincronizar);
        modelSincronizar.clear();
        for (int i = 0; i < 19; i++) {
            modelSincronizar.add(null);
        }
        TableColumn colSinc = jTbSincronizar.getColumnModel().getColumn(3);
        colSinc.setPreferredWidth(10);

    }

    /**
     * Seta timer de sincronização
     */
    private void setaTimer() {
        ParaEcomDAO dao = new ParaEcomDAO();
        try {
            ParaEcomBean bean = dao.listaTodos().get(0);
            if (bean != null) {
                //cadastro
                if (bean.getAtivaSincronizacao() == 1) {
                    long minutesCad = TimeUnit.SECONDS.toMillis(bean.getMinutoscadastrados()) * 60;
                    timerCadastro.setDelay(minutesCad);
                    timerCadastro.start();
                    //movimentação
                    long minutesMov = TimeUnit.SECONDS.toMillis(bean.getMinutosmov()) * 60;
                    timerMov.setDelay(minutesMov);
                    timerMov.start();
                }
            }
        } catch (Exception e) {
            logger.error("Erro ao setar timer de sincronização: " + e);
        }
    }

    /**
     * Recebe lista de itens a serem sincronizados e inicia processo de
     * sincronização
     *
     * @param lista Lista de itens a serem sincronizados no ERP ou na loja
     * virtual
     */
    private void iniciaSincronizacao(List lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Inicia processo de preparação de ítens para sincronização
     */
    private List<ProdutoERPBean> refreshSincCad() {
        ProdutoDAO prodDao = new ProdutoDAO();
        try {
            List<ProdutoERPBean> listaProd = prodDao.listaASincronizar();
            ParaEcomBean paraEcom = new ParaEcomDAO().listaTodos().get(0);
            modelSincronizar.clear();
            //verifica numero de itens sincronizados que devem ser mantidos
            for (ProdutoERPBean bean : listaProd) {
                //verifica se numero de itens a serem sincronizados ultrapassa itens informados no parametro
                if (modelSincronizar.getRowCount() != paraEcom.getQtdeRegistros()) {
                    SincronizarModel modelBean = new SincronizarModel();
                    modelBean.setEntidade("produto");
                    modelBean.setItemDescricao(bean.getDescricao());
                    modelBean.setOrigem("ERP");
                    modelBean.setSincronizado(false);
                    modelSincronizar.add(modelBean);
                } else {
                    break;
                }
            }
            return listaProd;
        } catch (Exception e) {
            return null;
        }
    }
    
    
}
