/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.ui;


import br.com.atsinformatica.erp.dao.ParaEcomDAO;
import br.com.atsinformatica.erp.dao.ParaUrlDAO;
import br.com.atsinformatica.erp.entity.ParaEcomBean;
import br.com.atsinformatica.erp.entity.ParaUrlWsdlBean;
import br.com.atsinformatica.midler.entity.ERPBean;
import br.com.atsinformatica.midler.entity.FileERPBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import br.com.atsinformatica.midler.properties.OrderedProperties;
import br.com.atsinformatica.midler.properties.PropertiesManager;
import br.com.atsinformatica.utils.Funcoes;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import org.jasypt.util.text.BasicTextEncryptor;
//import org.apache.log4j.Logger;

/**
 *
 * @author AlexsanderPimenta
 */
public class PanelConfiguracao extends javax.swing.JPanel {

    private PanelPrincipal principal = PanelPrincipal.getInstance();
    private BasicTextEncryptor bt;
    private AnnotationResolver resolver = new AnnotationResolver(ParaUrlWsdlBean.class);
    private String fieldResolver = "codParaUrlWsdl,urlWSDL,urlKey";
    private ObjectTableModel urlModel = new ObjectTableModel(resolver, fieldResolver);
    private String codParaEcom;

    /**
     * Creates new form PanelConfiguracao
     */
    public PanelConfiguracao() {
        initComponents();
        jToolBar1.setFloatable(false);
        bt = new BasicTextEncryptor();
        bt.setPassword("senha001");
        //iniciando painel de configurações
        //desabilita campos       
        habDesabCampos(false);
        //carrega arquivo de configurações
        carregaArquivoConfig();
        //verifica se banco foi criado em diretorio especificado
        if (jBincluir.isEnabled()) {
            jBincluir.requestFocus();
        }
        if (jBalterar.isEnabled()) {
            jBalterar.requestFocus();
        }

    }

    /**
     * Carrega arquivo de configurações
     */
    private void carregaArquivoConfig() {
        try {
            //verifica se arquivo existe
            if (PropertiesManager.getFile().exists()) {
                ParaEcomDAO dao = new ParaEcomDAO();
                ParaEcomBean bean = dao.listaTodos().get(0);
                // jBfechar.setEnabled(true);
                Properties config = PropertiesManager.getConfig();
                //carrega arquivo de configurações
                jTdiretorioERP1.setText(config.getProperty("erp.diretorio"));
                jTUsuarioERP1.setText(config.getProperty("erp.usuario"));
                jTsenhaERP1.setText(bt.decrypt(config.getProperty("erp.senha")));
                jTMinCad1.setText(String.valueOf(bean.getMinutoscadastrados()));
                jTMinMov1.setText(String.valueOf(bean.getMinutosmov()));
                setCodParaEcom(bean.getCodparaecom());
                jtQtdereg.setText(String.valueOf(bean.getQtdeRegistros()));
                jtQtdemant.setText(String.valueOf(bean.getQtdMantido()));
                jRSim2.setSelected(bean.getAtivaSincronizacao() == 1);
                jRNao2.setSelected(bean.getAtivaSincronizacao() == 0);
                jBalterar.setEnabled(true);
                jBincluir.setEnabled(false);
                jBfechar.setEnabled(true);
            }
            carregaGrid();

        } catch (Exception e) {
            System.out.println("Erro : " + e);
            //logger.error("Erro ao carregar arquivo de configuração: " + e.getMessage());
        }

    }
    /*
     * Seta parametros do arquivo de configuração
     * Caso o arquivo de configuração não exista, cria novo
     * @param erpBean - Bean do ERP
     */

    private void setaArquivoConfiguracao(ERPBean erpBean) throws IOException {
        OrderedProperties config = new OrderedProperties();
        FileOutputStream fileos = new FileOutputStream("config.ini");
        try {
            config.setProperty("erp.diretorio", erpBean.getCaminho());
            config.setProperty("erp.usuario", erpBean.getUsuario());
            //Encripta senha
            config.setProperty("erp.senha", bt.encrypt(erpBean.getSenha()));
            //grava alterações
            config.store(fileos, "Arquivo de configurações do Midler");
            //fecha arquivo
            fileos.close();
            JOptionPane.showMessageDialog(null, "Configurações salva com sucesso!");
            //logger.info("Arquivo de configurações salvo com sucesso!");
        } catch (Exception e) {
            //logger.error("Erro ao criar arquivo de configurações :" + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jTUsuarioERP1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtQtdereg = new javax.swing.JTextField();
        jtQtdemant = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jBConexao = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jRSim2 = new javax.swing.JRadioButton();
        jRNao2 = new javax.swing.JRadioButton();
        jTsenhaERP1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jTdiretorioERP1 = new javax.swing.JTextField();
        jPIntervaloSinc1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTMinCad1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTMinMov1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jBTSelecionaDirErp1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTURL = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTbUrl = new javax.swing.JTable();
        jTUrlKey = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jBfechar = new javax.swing.JButton();
        jBcancelar = new javax.swing.JButton();
        jBgravar = new javax.swing.JButton();
        jBalterar = new javax.swing.JButton();
        jBincluir = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel14.setText("Senha:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel13.setText("Usuário:");

        jToolBar1.setBorder(null);
        jToolBar1.setRollover(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setText("Qtde. registros:");

        jtQtdereg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtQtderegFocusLost(evt);
            }
        });

        jtQtdemant.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtQtdemantFocusLost(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel12.setText("Informe o caminho completo do banco de dados: (exemplo: \"localhost/3050:C/Banco/ResulthERP.fdb\")");

        jBConexao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/connect.png"))); // NOI18N
        jBConexao.setText("Testar conexão");
        jBConexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConexaoActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Ativar sincronização:"));

        buttonGroup1.add(jRSim2);
        jRSim2.setText("Sim");
        jRSim2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRSim2jRSimActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRNao2);
        jRNao2.setText("Não");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRSim2)
                    .addComponent(jRNao2))
                .addGap(0, 90, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jRSim2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRNao2))
        );

        jTsenhaERP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTsenhaERP1FocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel4.setText("Qtde. registros mantidos:");

        jTdiretorioERP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTdiretorioERP1FocusLost(evt);
            }
        });

        jPIntervaloSinc1.setBorder(javax.swing.BorderFactory.createTitledBorder("Intervalo de sincronização:"));
        jPIntervaloSinc1.setEnabled(false);
        jPIntervaloSinc1.setFocusCycleRoot(true);
        jPIntervaloSinc1.setFocusable(false);

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel8.setText("Cadastro:");

        jTMinCad1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTMinCad1FocusLost(evt);
            }
        });
        jTMinCad1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTMinCad1KeyTyped(evt);
            }
        });

        jLabel17.setText("minutos.");

        jLabel18.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel18.setText("Movimentações:");

        jTMinMov1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTMinMov1FocusLost(evt);
            }
        });
        jTMinMov1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTMinMov1KeyTyped(evt);
            }
        });

        jLabel19.setText("minutos.");

        javax.swing.GroupLayout jPIntervaloSinc1Layout = new javax.swing.GroupLayout(jPIntervaloSinc1);
        jPIntervaloSinc1.setLayout(jPIntervaloSinc1Layout);
        jPIntervaloSinc1Layout.setHorizontalGroup(
            jPIntervaloSinc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPIntervaloSinc1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPIntervaloSinc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPIntervaloSinc1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTMinCad1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17))
                    .addGroup(jPIntervaloSinc1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTMinMov1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );
        jPIntervaloSinc1Layout.setVerticalGroup(
            jPIntervaloSinc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIntervaloSinc1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPIntervaloSinc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTMinCad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(jPIntervaloSinc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTMinMov1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(15, 15, 15))
        );

        jBTSelecionaDirErp1.setText("Selecionar");
        jBTSelecionaDirErp1.setEnabled(false);
        jBTSelecionaDirErp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTSelecionaDirErp1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPIntervaloSinc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jtQtdereg, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jtQtdemant, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(342, 342, 342)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jTUsuarioERP1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel14))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTsenhaERP1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBConexao))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTdiretorioERP1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBTSelecionaDirErp1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPIntervaloSinc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtQtdereg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtQtdemant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTdiretorioERP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBTSelecionaDirErp1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTUsuarioERP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBConexao)
                    .addComponent(jTsenhaERP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(235, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ERP", jPanel3);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("Informe WSDL ou URL do WebService:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/arrow_down.png"))); // NOI18N
        jButton1.setText("Adcionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTbUrl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cod.", "Url/WSDL", "Chave"
            }
        ));
        jTbUrl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTbUrlKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTbUrl);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel5.setText("Informe chave do WebService (caso necessário)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTURL, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jTUrlKey, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButton1)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jTUrlKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("WebService", jPanel5);

        jBfechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/door_out.png"))); // NOI18N
        jBfechar.setText("Fechar");
        jBfechar.setToolTipText("Fechar");
        jBfechar.setFocusable(false);
        jBfechar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBfechar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBfechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBfecharActionPerformed(evt);
            }
        });

        jBcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/cancel.png"))); // NOI18N
        jBcancelar.setText("Cancelar");
        jBcancelar.setToolTipText("Cancelar");
        jBcancelar.setEnabled(false);
        jBcancelar.setFocusable(false);
        jBcancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBcancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarActionPerformed(evt);
            }
        });

        jBgravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/save.png"))); // NOI18N
        jBgravar.setText("Gravar");
        jBgravar.setToolTipText("Gravar");
        jBgravar.setEnabled(false);
        jBgravar.setFocusable(false);
        jBgravar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBgravar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBgravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBgravarActionPerformed(evt);
            }
        });

        jBalterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/pencil3 (2).png"))); // NOI18N
        jBalterar.setText("Alterar");
        jBalterar.setToolTipText("Alterar");
        jBalterar.setEnabled(false);
        jBalterar.setFocusable(false);
        jBalterar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBalterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBalterarActionPerformed(evt);
            }
        });

        jBincluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/add.png"))); // NOI18N
        jBincluir.setText("Incluir");
        jBincluir.setToolTipText("Incluir");
        jBincluir.setFocusable(false);
        jBincluir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBincluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBincluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBincluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBincluir)
                        .addGap(0, 0, 0)
                        .addComponent(jBalterar)
                        .addGap(0, 0, 0)
                        .addComponent(jBgravar)
                        .addGap(0, 0, 0)
                        .addComponent(jBcancelar)
                        .addGap(0, 0, 0)
                        .addComponent(jBfechar)
                        .addGap(0, 351, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBincluir)
                    .addComponent(jBalterar)
                    .addComponent(jBgravar)
                    .addComponent(jBcancelar)
                    .addComponent(jBfechar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCbLFiliaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCbLFiliaisMouseClicked
    }//GEN-LAST:event_jCbLFiliaisMouseClicked

    private void jCbLFiliaisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCbLFiliaisMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbLFiliaisMousePressed

    private void jBincluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBincluirActionPerformed
        habDesabCampos(true);
        principal.setjOperacao("Inclusão");
        Funcoes.limpaTela(jPanel3);
        jBcancelar.setEnabled(true);
        jBgravar.setEnabled(true);
        jBalterar.setEnabled(false);
        jBincluir.setEnabled(false);
        jTMinCad1.requestFocus();
        jBTSelecionaDirErp1.setEnabled(true);
    }//GEN-LAST:event_jBincluirActionPerformed

    private void jBalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBalterarActionPerformed
        habDesabCampos(true);
        principal.setjOperacao("Alteração");
        jBcancelar.setEnabled(true);
        jBgravar.setEnabled(true);
        jBalterar.setEnabled(false);
        jBincluir.setEnabled(false);
        jTdiretorioERP1.requestFocus();
        jBTSelecionaDirErp1.setEnabled(true);
    }//GEN-LAST:event_jBalterarActionPerformed

    private void jBgravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBgravarActionPerformed
        ERPBean erp = new ERPBean();
        try {
            erp.setCaminho(jTdiretorioERP1.getText());
            erp.setUsuario(jTUsuarioERP1.getText());
            erp.setSenha(String.copyValueOf(jTsenhaERP1.getPassword()));
            if (!verificaCamposActionPerformed()) {
                return;
            }
            setaArquivoConfiguracao(erp);
            cadastraParaEcom();
            cadastraParaUrl();
            habDesabCampos(false);
            jBincluir.setEnabled(false);
            jBcancelar.setEnabled(false);
            jBgravar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "A aplicação será encerrada para que as configurações sejam efetivadas.");
            Funcoes.reiniciaAplicacao();
        } catch (Exception e) {
            // logger.error("Erro ao gravar: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao gravar: " + e.getMessage());
            PropertiesManager.getConfig().clear();
        }
    }//GEN-LAST:event_jBgravarActionPerformed

    private void jBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "Deseja cancelar a operação", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (ok == JOptionPane.YES_OPTION) {
            principal.setjOperacao("");
            if (!PropertiesManager.getFile().exists()) {
                jBincluir.setEnabled(true);
                jBalterar.setEnabled(false);
                Funcoes.limpaTela(jPanel3);
                Funcoes.limpaTela(jPanel5);
            } else {
                carregaArquivoConfig();
            }
            habDesabCampos(false);
            
            //urlModel.clear();
            jBConexao.setEnabled(false);
            jBcancelar.setEnabled(false);
            jBgravar.setEnabled(false);
            jBTSelecionaDirErp1.setEnabled(false);
            jBfechar.setEnabled(true);
            jTabbedPane1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jBcancelarActionPerformed

    private void jBfecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBfecharActionPerformed
        principal.setjOperacao("");
        principal.setjStatus("");
        //fecha tudo
        this.removeAll();
        //atualiza ui
        this.updateUI();

        setBorder(null);


    }//GEN-LAST:event_jBfecharActionPerformed

    private void jBConexaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConexaoActionPerformed
        File file = new File("config.ini");
        try {
            String senha = jTsenhaERP1.getText();
            if (file.exists()) {
                Properties config = getProperties();
                //se arquivo de configuração não esta vazio
                if (!config.isEmpty()) {
                    //se senha digitada é diferente da senha do arquivo de configurações, criptografa nova senha
                    if (!config.getProperty("erp.senha").equals(jTsenhaERP1.getText())) {
                        senha = jTsenhaERP1.getText();
                    }
                    JOptionPane.showMessageDialog(null, ConexaoATS.conectarERP(jTdiretorioERP1.getText(), jTUsuarioERP1.getText(), senha));
                } else {
                    JOptionPane.showMessageDialog(null, ConexaoATS.conectarERP(jTdiretorioERP1.getText(), jTUsuarioERP1.getText(), senha));
                }
            } else {
                JOptionPane.showMessageDialog(null, ConexaoATS.conectarERP(jTdiretorioERP1.getText(), jTUsuarioERP1.getText(), senha));
            }
            ConexaoATS.fechaConexao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBConexaoActionPerformed

    private void jRSim2jRSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRSim2jRSimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRSim2jRSimActionPerformed

    private void jTsenhaERP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTsenhaERP1FocusLost
        if (jTsenhaERP1.getPassword().length > 1 && jTsenhaERP1.getPassword().length < 5) {
            JOptionPane.showMessageDialog(null, "Informe no mínimo 5 caracteres para a senha.");
            jTsenhaERP1.requestFocus();
        }
    }//GEN-LAST:event_jTsenhaERP1FocusLost

    private void jTdiretorioERP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTdiretorioERP1FocusLost
        String str = Funcoes.removeEspacosEmBranco(jTdiretorioERP1.getText());
        jTdiretorioERP1.setText(str);
    }//GEN-LAST:event_jTdiretorioERP1FocusLost

    private void jTMinCad1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTMinCad1KeyTyped
        String caracteres = "0123456789";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTMinCad1KeyTyped

    private void jTMinMov1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTMinMov1KeyTyped
        String caracteres = "0123456789";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTMinMov1KeyTyped

    private void jBTSelecionaDirErp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTSelecionaDirErp1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            FileERPBean file = new FileERPBean();
            file.setCaminho(chooser.getSelectedFile().getAbsolutePath());
            file.setNomeArquivo(chooser.getSelectedFile().getName());
            jTdiretorioERP1.setText((String) file.getCaminho());
        }
    }//GEN-LAST:event_jBTSelecionaDirErp1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ParaUrlWsdlBean paraUrl = new ParaUrlWsdlBean();
        paraUrl.setUrlWSDL(jTURL.getText());
        paraUrl.setUrlKey(jTUrlKey.getText());
        urlModel.add(paraUrl);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTbUrlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTbUrlKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            urlModel.remove(jTbUrl.getSelectedRow());
        }
    }//GEN-LAST:event_jTbUrlKeyReleased

    private void jTMinCad1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTMinCad1FocusLost
        if (jTMinCad1.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "Informe um intervalo de sincronização de cadastro, acima de 0");
            jTMinCad1.requestFocus();
        }
    }//GEN-LAST:event_jTMinCad1FocusLost

    private void jTMinMov1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTMinMov1FocusLost
        if (jTMinMov1.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "Informe um intervalo de sincronização de movimentações, acima de 0");
            jTMinMov1.requestFocus();
        }
    }//GEN-LAST:event_jTMinMov1FocusLost

    private void jtQtderegFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtQtderegFocusLost
        if (jtQtdereg.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "Informe uma quantidade de registros a serem sincronizados, acima de 0");
            jtQtdereg.requestFocus();
        }
    }//GEN-LAST:event_jtQtderegFocusLost

    private void jtQtdemantFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtQtdemantFocusLost
        if (jtQtdemant.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "Informe uma quantidade de registros a serem mantidos, acima de 0");
            jtQtdemant.requestFocus();
        }
    }//GEN-LAST:event_jtQtdemantFocusLost
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBConexao;
    private javax.swing.JButton jBTSelecionaDirErp1;
    private javax.swing.JButton jBalterar;
    private javax.swing.JButton jBcancelar;
    private javax.swing.JButton jBfechar;
    private javax.swing.JButton jBgravar;
    private javax.swing.JButton jBincluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPIntervaloSinc1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRNao2;
    private javax.swing.JRadioButton jRSim2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTMinCad1;
    private javax.swing.JTextField jTMinMov1;
    private javax.swing.JTextField jTURL;
    private javax.swing.JTextField jTUrlKey;
    private javax.swing.JTextField jTUsuarioERP1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTbUrl;
    private javax.swing.JTextField jTdiretorioERP1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPasswordField jTsenhaERP1;
    private javax.swing.JTextField jtQtdemant;
    private javax.swing.JTextField jtQtdereg;
    // End of variables declaration//GEN-END:variables

    /**
     * Retorna arquivo de configuração
     *
     * @return arquivo de configuração
     */
    public Properties getProperties() throws IOException {
        Properties properties = new Properties();
        File file = new File("config.ini");
        FileInputStream fileis = new FileInputStream(file);
        if (file.exists()) {
            properties.load(fileis);
        }
        return properties;
    }

    private void carregaGrid() {
        ParaUrlDAO dao = new ParaUrlDAO();
        try {
            jTbUrl.setModel(urlModel);
            jTbUrl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            urlModel.setEditableDefault(false);
            urlModel.setColEditable(1, true);
            urlModel.setColEditable(2, true);
            TableColumn colCod = jTbUrl.getColumnModel().getColumn(0);
            colCod.setPreferredWidth(70);
            TableColumn colUrl = jTbUrl.getColumnModel().getColumn(1);
            colUrl.setPreferredWidth(311);
            TableColumn colUrlKey = jTbUrl.getColumnModel().getColumn(2);
            colUrlKey.setPreferredWidth(311);          
            List<ParaUrlWsdlBean> listaParaUrl = dao.listaTodos();
            if (!listaParaUrl.isEmpty()) {
                for (ParaUrlWsdlBean bean : listaParaUrl) {
                    urlModel.add(bean);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao preencher grid: " + e);
        }
    }

    /**
     * Cadastra registro na tabela ParaECOM
     */
    private void cadastraParaEcom() {
        try {
            ParaEcomBean paraEcom = new ParaEcomBean();
            ParaEcomDAO dao = new ParaEcomDAO();
            paraEcom.setMinutoscadastrados(Integer.parseInt(jTMinCad1.getText()));
            paraEcom.setMinutosmov(Integer.parseInt(jTMinMov1.getText()));
            paraEcom.setQtdeRegistros(Integer.parseInt(jtQtdereg.getText()));
            paraEcom.setQtdMantido(Integer.parseInt(jtQtdemant.getText()));
            paraEcom.setAtivaSincronizacao(Funcoes.retornaValorNum(jRSim2.isSelected()));
            paraEcom.setCodparaecom(getCodParaEcom());
            if (principal.getjOperacao().equals("Inclusão")) {
                dao.gravar(paraEcom);
            } else if (principal.getjOperacao().equals("Alteração")) {
                dao.alterar(paraEcom);
            }
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar parametros: " + e);
        }
    }

    private void cadastraParaUrl() {
        try {
            List<ParaUrlWsdlBean> listaParaUrl = urlModel.getData();
            ParaUrlDAO dao = new ParaUrlDAO();
            for (ParaUrlWsdlBean paraUrl : listaParaUrl) {
                if (principal.getjOperacao().equals("Inclusão")) {
                    dao.gravar(paraUrl);
                }
                if (principal.getjOperacao().equals("Alteração")) {
                    dao.alterar(paraUrl);
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * @return the codParaEcom
     */
    public String getCodParaEcom() {
        return codParaEcom;
    }

    /**
     * @param codParaEcom the codParaEcom to set
     */
    public void setCodParaEcom(String codParaEcom) {
        this.codParaEcom = codParaEcom;
    }

    /**
     * Verifica se campos obrigatorios estão vazios
     */
    public boolean verificaCamposActionPerformed() {
        if (jTdiretorioERP1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe o diretório do banco ERP.");
            jTabbedPane1.setSelectedIndex(0);
            jTdiretorioERP1.requestFocus();
            return false;
        } else if (jTUsuarioERP1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe usuário do banco ERP");
            jTabbedPane1.setSelectedIndex(0);
            jTUsuarioERP1.requestFocus();
            return false;
        } else if (jTsenhaERP1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe senha do banco ERP");
            jTabbedPane1.setSelectedIndex(0);
            jTsenhaERP1.requestFocus();
            return false;
        } else if (jTMinCad1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe intervalo de sincronização de cadastros.");
            jTabbedPane1.setSelectedIndex(0);
            jTMinCad1.requestFocus();
            return false;
        } else if (jTMinMov1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe intervalo de sincronização de movimentações.");
            jTabbedPane1.setSelectedIndex(0);
            jTMinMov1.requestFocus();
            return false;
        } else if (jtQtdereg.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe quantidade de registros que serão sincronizados.");
            jTabbedPane1.setSelectedIndex(0);
            jtQtdereg.requestFocus();
            return false;
        } else if (urlModel.getData().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe ao menos um WSDL ou URL do WebService.");
            jTabbedPane1.setSelectedIndex(1);
            jTURL.requestFocus();
            return false;
        }
        return true;
    }
    
    
    
    private void habDesabCampos(boolean hab){
        Funcoes.habilitaDesabCampos(jPIntervaloSinc1, hab);
        Funcoes.habilitaDesabCampos(jPanel3, hab);
        Funcoes.habilitaDesabCampos(jPanel4, hab);
        Funcoes.habilitaDesabCampos(jPanel5, hab);
        
    }
}
