
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.ui;

import br.com.atsinformatica.erp.dao.CategoriaEcomDAO;
import br.com.atsinformatica.prestashop.controller.CategoriaController;
import br.com.atsinformatica.midler.components.renderer.DateCellRenderer;
import br.com.atsinformatica.erp.dao.HistoricoIntegraDAO;
import br.com.atsinformatica.erp.dao.ParaEcomDAO;
import br.com.atsinformatica.erp.entity.HistoricoIntegraERPBean;
import br.com.atsinformatica.erp.entity.ParaEcomBean;
import br.com.atsinformatica.erp.entity.CategoriaEcomBean;
import br.com.atsinformatica.prestashop.controller.ImageController;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
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

    private AnnotationResolver resolverSinc = new AnnotationResolver(HistoricoIntegraERPBean.class);
    private String fields = "id,entidade,codEntidade,dataEnt,dataInteg,tipoOperacao";
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

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        title_historico.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        title_historico.setText("Histórico de sincronização ");

        jTbSincronizar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Entidade", "XML", "Data entrada", "Tipo da operação", "Data importacao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title_historico)
                        .addGap(556, 556, 556)
                        .addComponent(jBtRefresh)))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title_historico)
                .addGap(16, 16, 16)
                .addComponent(jBtRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    ///Timer para movimentações
    private void timerMovOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerMovOnTime
        return;
    }//GEN-LAST:event_timerMovOnTime

    ///Timer para cadastro 
    private void timerCadastroOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerCadastroOnTime
        refreshSincCad();
    }//GEN-LAST:event_timerCadastroOnTime

    //Botão de atualizar
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
        //TableColumn colInt = jTbSincronizar.getColumnModel().getColumn(4);   
        //colInt.setCellRenderer(new DateCellRenderer());
        jTbSincronizar.setModel(modelSincronizar);
        //
        jTbSincronizar.setAutoCreateRowSorter(true);
        modelSincronizar.clear();
        for (int i = 0; i < 19; i++) {
            modelSincronizar.add(null);
        }
        TableColumn colSinc = jTbSincronizar.getColumnModel().getColumn(0);
        TableColumn colEnt = jTbSincronizar.getColumnModel().getColumn(3);
        TableColumn colInt = jTbSincronizar.getColumnModel().getColumn(4);
        colSinc.setPreferredWidth(10);
        colEnt.setCellRenderer(new DateCellRenderer());
        colInt.setCellRenderer(new DateCellRenderer());

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
     * Inicia processo de preparação de ítens para sincronização
     */
    private void refreshSincCad() {
        List<HistoricoIntegraERPBean> listaPend = null;
        List<HistoricoIntegraERPBean> listaUltimos = null;
        try {
            modelSincronizar.clear();
            ///lista de itens pendentes de sincronização
            listaPend = new HistoricoIntegraDAO().listaPendentes();
            //lista de ultimos itens sincronizados na loja virtual
            listaUltimos = new HistoricoIntegraDAO().listaUltimosInteg();
            //Lista de itens a sincronizar na loja virtual
            List itensPost = new ArrayList();
            List itensPut = new ArrayList();
            List itensDelete = new ArrayList();
            List itensGet = new ArrayList();
            //sincPost(itensPost);
            if (listaPend.isEmpty() && !listaUltimos.isEmpty()) {
                modelSincronizar.addAll(listaUltimos);
            } else {
                for (HistoricoIntegraERPBean bean : listaPend) {
                    if (bean.getTipoOperacao().equals("insert")) {
                        itensPost.add(bean);
                    }
                    if (bean.getTipoOperacao().equals("update")) {
                        itensPut.add(bean);
                    }
                    if (bean.getTipoOperacao().equals("delete")) {
                        itensDelete.add(bean);
                    }
                    modelSincronizar.add(bean);
                }
                sincPost(itensPost);
                sincPut(itensPut);
                sincDelete(itensDelete);
                modelSincronizar.addAll(new HistoricoIntegraDAO().listaUltimosInteg());
            }
            
            sincImage();
        } catch (Exception e) {
            logger.error("Erro ao atualizar lista de ítens a serem sincronizados: " + e);
        }
    }


    /**
     * Recebe lista de itens a serem sincronizados e inicia processo de
     * sincronização
     *
     * @param lista Lista de itens a serem sincronizados no ERP ou na loja
     * virtual
     */
    private void sincPost(List lista) {
        CategoriaController catController = null;
        try {
            if (lista.isEmpty()) {
                return;
            }
           // ImageController imgCtrl = new ImageController();
           // imgCtrl.createImagePrestaShop();
            for (HistoricoIntegraERPBean obj : (List<HistoricoIntegraERPBean>) lista) {
                if (obj.getObjectSinc().getClass().equals(CategoriaEcomBean.class)) {
                    CategoriaEcomBean catEcom = (CategoriaEcomBean) obj.getObjectSinc();
                    //faz o post das categorias pendentes de sincronização
                    catController = new CategoriaController();
                    int cod = catController.createCategoryPrestashop(catEcom);
                    if(cod!=0){
                      catEcom.setIdCategoriaEcom(cod);
                        CategoriaEcomDAO dao = new CategoriaEcomDAO();
                      //salvando código da categoria cadastrada 
                      dao.alteraIdEcom(catEcom);
                      atualizaDataInt(obj); 
                    }                    
                }
            }
            logger.info("Sincronização na loja virtual, efetuada com sucesso!");
        } catch (Exception e) {
            logger.error("Erro ao efetuar sincronização na loja virtual: " + e);
        }
    }

    private void sincPut(List lista) {
        try {
            if (lista.isEmpty()) {
                return;
            }
            for (HistoricoIntegraERPBean obj : (List<HistoricoIntegraERPBean>) lista) {
                if (obj.getObjectSinc().getClass().equals(CategoriaEcomBean.class)) {
                    CategoriaEcomBean catEcom = (CategoriaEcomBean) obj.getObjectSinc();
                    //faz o put das categorias pendentes de sincronização
                    CategoriaController catController = new CategoriaController();
                    if(catController.updateCategoryPrestashop(catEcom))atualizaDataInt(obj);
                }
            }
            logger.info("Sincronização na loja virtual, efetuada com sucesso!");
        } catch (Exception e) {
            logger.error("Erro ao efetuar sincronização na loja virtual: " + e);
        }
    }

    private void sincDelete(List lista) {
        try {
            if (lista.isEmpty()) {
                return;
            }
             for (HistoricoIntegraERPBean obj : (List<HistoricoIntegraERPBean>) lista) {
                if (obj.getEntidade().equals("categoria")) {
                    //faz o delete das categorias pendentes de sincronização
                    CategoriaController catController = new CategoriaController();
                    if(catController.deleteCategoryPrestashop(obj.getCodEntidade()))atualizaDataInt(obj);
                }
            }
            logger.info("Sincronização na loja virtual, efetuada com sucesso!");
        } catch (Exception e) {
            logger.error("Erro ao efetuar sincronização na loja virtual: " + e);
        }
    }

    /**
     * Atualiza data de integração de itens pendentes na tabela de historico de
     * sincronizacao
     *
     * @param lista lista de itens
     */
    private void atualizaDataInt(HistoricoIntegraERPBean obj) throws SQLException {
        HistoricoIntegraDAO dao = new HistoricoIntegraDAO();
        modelSincronizar.clear();
        dao.alteraDataInt(obj.getId());       
    }

    private void sincImage() {
        ImageController controller = new ImageController();
        controller.getImages();
    }
}
