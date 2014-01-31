/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.utils;

import java.awt.AWTKeyStroke;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.MaskFormatter;
import org.codehaus.plexus.util.Base64;
import sun.misc.BASE64Decoder;

/**
 *
 * @author AlexsanderPimenta
 */
public class Funcoes {

    // private static Logger logger = Logger.getLogger(Funcoes.class.getName());
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int MOEDA = 1;
    public static final int DATA = 2;
    public static final String CNPJ = "##.###.###/####-##";
    public static final String CPF = "###.###.###-##";
    public static final String CEP = "#####-###";
    private static final String EMAIL_REGEX = "^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$";
    private static final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

//    public static List<GridGradeComposta> removeDuplicateWithOrder(List<GridGradeComposta> lista) {
    //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    // }
    private Funcoes() {
    }

    public static Funcoes getInstance() {
        return FuncoesHolder.INSTANCE;
    }

    private static class FuncoesHolder {

        private static final Funcoes INSTANCE = new Funcoes();
    }

    /*
     * Limpa todos campos do painel
     * @param panel - Painel contendo os campos que devem ser limpados 
     */
    public static void limpaTela(JPanel panel) {

        for (int i = 0; i < panel.getComponentCount(); i++) {
            //varre todos os componentes       
            Component c = panel.getComponent(i);
            if (c instanceof JTextField) {
                JTextField field = (JTextField) c;
                field.setText("");
            }
            if (c instanceof JTextArea) {
                JTextArea field = (JTextArea) c;
                field.setText("");
            }
//            if(c instanceof JXDatePicker){
//                JXDatePicker date = (JXDatePicker)c;
//                date.setDate(null);
//            }
        }
    }

    /*
     * Habilita todos botões em uma toolbar
     * @param bar - Toolbar
     */
    public static void habilitaBotoes(JToolBar bar) {
        for (int i = 0; i < bar.getComponentCount(); i++) {
            //varre todos componentes
            Component c = bar.getComponent(i);
            //se botão, habilita todos botões
            if (c instanceof JButton) {
                JButton button = (JButton) c;
                button.setEnabled(true);

            }
        }
    }

    /*
     * Habilita e desabilita campos do painel
     * @param panel - Painel contendo os campos que devem ser habilitados ou desabilitados
     * @param habDesab - Habilita ou desabilita
     */
    public static void habilitaDesabCampos(JPanel panel, Boolean habDesab) {

        for (int i = 0; i < panel.getComponentCount(); i++) {
            //varre todos componentes
            Component c = panel.getComponent(i);
            //se JTextField, habilita ou desabilita todos campos
            if (c instanceof JTextField) {
                JTextField field = (JTextField) c;
                field.setFocusable(habDesab);
            }
            //se JComboBox, habilita ou desabilita combobox
            if (c instanceof JComboBox) {
                JComboBox combo = (JComboBox) c;
                combo.setEnabled(habDesab);
            }
            //se JRadioButton, habilita ou desabilita radio button
            if (c instanceof JRadioButton) {
                JRadioButton jradio = (JRadioButton) c;
                jradio.setEnabled(habDesab);
                jradio.setFocusable(habDesab);
            }
            //JTextArea 
            if (c instanceof JTextArea) {
                JTextArea field = (JTextArea) c;
                field.setFocusable(habDesab);
            }
            /**
             * if(c instanceof com.jidesoft.swing.CheckBoxList){ CheckBoxList
             * checkBox = (com.jidesoft.swing.CheckBoxList)c;
             *
             * checkBox.setEnabled(habDesab); checkBox.setFocusable(habDesab);
             * checkBox.setCheckBoxEnabled(habDesab);
            }*
             */
            if (c instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) c;
                checkBox.setEnabled(habDesab);
            }
//            if(c instanceof HTMLEditorPane){
//                HTMLEditorPane html = (HTMLEditorPane)c;
//                html.setEnabled(habDesab);
//                
//            }
//            if(c instanceof JTable){
//                JTable table = (JTable)c;
//                table.setEnabled(habDesab);
//            }
            if (c instanceof JButton) {
                JButton button = (JButton) c;
                button.setEnabled(habDesab);
            }
//            if(c instanceof JXDatePicker){
//                JXDatePicker dateP = (JXDatePicker)c;
//                dateP.setEnabled(habDesab);
//            }

        }

    }

    //criptografa a senha
    public static String criptografaSenha(String senha) {
        try {
            //tipo de criptografia
            byte[] encoded = Base64.encodeBase64(senha.getBytes());
            //logger.info("Senha criptografada com sucesso!");
            return new String(encoded);
        } catch (Exception e) {
            //logger.error("Erro ao criptografar senha: " + e.getMessage());
            return null;
        }
    }

    //descriptografa a senha
    public static String descriptografaSenha(String senha) {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] str = decoder.decodeBuffer(senha);
            //recebe senha descriptografada
            String strDecoded = new String(str, "UTF-8");
            //logger.info("Senha descriptografada com sucesso!");
            return strDecoded;
        } catch (Exception e) {
            //logger.error("Erro ao descriptografar senha: " + e.getMessage());
            return null;
        }
    }

    public static void verificaCamposVazio(JPanel panel) {

        Component components[] = panel.getComponents();
        //Para cada componente  
        for (int i = 0; i < components.length; i++) {
            //É campo de texto?  
            if (components[i] instanceof JTextField) {
                //Está preenchido?  
                if (((JTextField) components[i]).getText().isEmpty()) {
                    //Não, então exibe mensagem de erro  
                    JOptionPane.showMessageDialog(null,
                            "Preencher todos os campos");
                    break;
                }
            }
        }

    }

    public static void reiniciaAplicacao() {

        String comando = "java -jar" + new File(" ").getAbsolutePath() + "\\Sincronizador.jar";

        try {
            Process Processo = Runtime.getRuntime().exec(comando);
        } catch (IOException MensagemdeErro) {
            System.out.println(MensagemdeErro);
        }
        System.exit(0);
    }

    public static void passaCamposComEnterPanel(JPanel panel) {

        HashSet conj = new HashSet(panel.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));

        for (int i = 0; i < panel.getComponentCount(); i++) {

            Component c = panel.getComponent(i);
            if (c instanceof JTextField) {
                // if(){
                JOptionPane.showMessageDialog(null, "Focado");
                //conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
                //panel.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);

                //}
            }

        }

    }

    public static void passaCamposComEnter(JFrame frame) {

        // Colocando enter para pular de campo  
        HashSet conj = new HashSet(frame.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        //setando a chave de foco em um frame, para ENTER
        frame.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);

    }

    public static Short retornaValorNum(Boolean value) {
        if (value) {
            return 1;
        }
        return 0;

    }

    public static String retornaStrBol(Boolean value) {
        if (value) {
            return "Sim";
        }
        return "Nao";
    }

    public static Boolean retornaBool(Short value) {
        if (value == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static String criaDiretorio(String novoDiretorio) {
        String nomeDiretorio = null;
        String separador = java.io.File.separator;
        try {
            nomeDiretorio = "C:" + separador + novoDiretorio;
            if (!new File(nomeDiretorio).exists()) { // Verifica se o diretório existe.   
                (new File(nomeDiretorio)).mkdir();   // Cria o diretório   
            }
            //logger.info("Diretorio criado em: " + nomeDiretorio);
            return nomeDiretorio;
        } catch (Exception ex) {
            //logger.error("Erro ao criar o diretório" + ex);
            return "";

        }
    }

    public static void setaAcaoBotao(JButton btn) {
        btn.registerKeyboardAction(
                btn.getActionForKeyStroke(
                        KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
                JComponent.WHEN_FOCUSED);

        btn.registerKeyboardAction(
                btn.getActionForKeyStroke(
                        KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
                JComponent.WHEN_FOCUSED);

    }

    /**
     * Remove todos espaços em branco no inicio, meio e fim
     *
     * @param texto
     * @return texto formatado
     */
    public static String removeEspacosEmBranco(String texto) {

        return texto.replace(" ", "");

    }

    /**
     * Quebra string e retorna uma string em uma determinada posição
     *
     * @param diretorio diretório
     * @param i posição
     * @return a string em uma determinada posição
     */
    /**
     * public static FileName retornaStrDir(String diretorio) { FileName file =
     * new FileName(diretorio, '/', '.'); return file;
    }*
     */
//    
//    public static String retornaNomeEcom(String diretorio){
//        String str = diretorio;
//        String tx[]
//    }
    public static String formataCampoMoeda(String valor) {
        DecimalFormat decimalFormat = new DecimalFormat("R$ #,##0.00");

        return decimalFormat.format(valor);

    }

    /**
     * Preenche com valor informado em parametro
     *
     * @param txt string a ser preenchida
     * @param letra letra do preenchimento
     * @param tamanho tamanho da string
     * @param direcao direção em que será preenchida
     * @return
     */
    public static String preencheCom(String txt, String letra, int tamanho, int direcao) {

        //Checa se Linha a preencher é nula ou branco
        if (txt == null || txt.trim() == "") {
            txt = "";
        }

        //Enquanto Linha a preencher possuir 2 espaços em branco seguidos, substitui por 1 espaço apenas
        while (txt.contains(" ")) {
            txt = txt.replaceAll(" ", " ").trim();
        }

        StringBuffer sb = new StringBuffer(txt);

        if (direcao == 1) { //a Esquerda

            for (int i = sb.length(); i < tamanho; i++) {

                sb.insert(0, letra);

            }

        } else if (direcao == 2) {//a Direita

            for (int i = sb.length(); i < tamanho; i++) {

                sb.append(letra);
            }
        }
        return sb.toString();

    }

    public static MaskFormatter installFormatter(JFormattedTextField textField, int tipo) {
        try {
            MaskFormatter formatter = null;
            switch (tipo) {
                case MOEDA:
                    formatter = new MaskFormatter("#,##0.###");
                    formatter.setValidCharacters("0123456789");
                    break;
                case DATA:
                    formatter = new MaskFormatter("##/##/####");
                    break;

            }
            textField.setColumns(20);

            formatter.install(textField);
            return formatter;

        } catch (ParseException e) {
            return null;
        }
    }

    public static String removeVirgula(String str) {
        String strFomatada = str.replaceAll(",", ".");

        return strFomatada;
    }

    public static void bloqueiaChar(KeyEvent evt, JTextField field) {
        String caracteres = "0123456789";
        String s = field.getText();
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }

    public static String retornaExtensao(File f) {
        String ext = null;
        String s = f.getName();
        //ultimo ponto
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    public static boolean validaEmail(String email) {
        boolean isEmailValid = false;
        if (!email.equals("")) {

            Pattern p = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
            Matcher matcher = p.matcher(email);
            if (matcher.matches()) {
                isEmailValid = true;
            }

        }
        return isEmailValid;

    }

    /**
     * Remove itens duplicados em lista
     *
     * @param arlList lista
     */
    public static List removeValoresDuplicados(List arlList) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = arlList.iterator(); iter.hasNext();) {
            Object element = iter.next();
            if (set.add(element)) {
                newList.add(element);
            }
        }
        arlList.clear();
        arlList.addAll(newList);

        return newList;
    }

    /**
     * Verifica se intervalo de inteiros é incompativel
     *
     * @param ini intervalo inicial
     * @param fim intervalo final
     * @return se verdadeiro ou falso
     */
    public static boolean intervaloIncorreto(int ini, int fim) {
        if (ini > fim) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Compara duas datas a verifica se a data inicial é maior que a data final
     *
     * @param dataini data inicial
     * @param dataFim data final
     * @return se verdadeiro ou falso
     */
    public static boolean comparaDatas(Date dataini, Date dataFim) {
        if (dataini.compareTo(dataFim) > 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Redimensiona o tamanho da imagem original
     *
     * @param width largura
     * @param height altura
     * @param icon imagem
     * @return ImageIcon
     */
    public static ImageIcon resizeImage(int width, int height, ImageIcon icon) {
        if (icon != null) {
            Image img = icon.getImage();
            Image imgResized = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            icon = new ImageIcon(imgResized);
            return icon;
        } else {
            return null;
        }

    }

    /**
     * Retorna uma string com o tamanho de um arquivo
     *
     * @param caminho caminho do arquivo
     * @return String com tamanho com arquivo
     * @throws IOException
     */
    public static String retornaTamanhoArquivo(String caminho) throws IOException {
        //arquivo
        Path path = Paths.get(caminho);
        //bytes
        double b = 1;
        //kbytes
        double kb = 1024 * b;
        //megabytes
        double mb = 1024 * kb;
        //String com tamanho e extensão do arquivo
        String strLen = "";
        //se o arquivo existe
        if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            //tamanho do arquivo        
            double tamanho = (double) Files.size(path);
            if (tamanho > mb) {
                strLen = Math.round(tamanho / mb) + " MB";
            } else if (tamanho > kb) {
                strLen = Math.floor(tamanho / kb) + " KB";
            } else {
                strLen = tamanho + " bytes";
            }
        }
        return strLen;
    }

    public static String retornaTamanhoArquivoByte(byte[] bt) throws IOException {
        //arquivo
        // Path path = Paths.get(caminho);
        //bytes
        double b = 1;
        //kbytes
        double kb = 1024 * b;
        //megabytes
        double mb = 1024 * kb;
        //String com tamanho e extensão do arquivo
        String strLen = "";
        //se o arquivo existe
        // if(Files.exists(path, LinkOption.NOFOLLOW_LINKS)){
        //tamanho do arquivo        
        double tamanho = (double) bt.length;
        if (tamanho > mb) {
            strLen = Math.round(tamanho / mb) + " MB";
        } else if (tamanho > kb) {
            strLen = Math.floor(tamanho / kb) + " KB";
        } else {
            strLen = tamanho + " bytes";
        }

        return strLen;
    }

    /**
     * Instala mascara de campos
     *
     * @param pattern String com padrão de formatação
     * @param txt
     * @return
     */
    public static String installMask(String pattern, String txt) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(txt);
        } catch (Exception e) {
            return null;

        }
    }
//---------------------------------------------------------------------------------------------//

    public static BufferedImage resizeImg(BufferedImage img, int width, int height) {

        if ((width > 0 && height == 0) || (width == 0 && height > 0)) {
            int size = (width > 0) ? width : height;
            width = img.getWidth();
            height = img.getHeight();
            float fRatio = (float) img.getWidth() / (float) img.getHeight();
            if (width > size) {
                width = size;
                height = (int) ((float) size / fRatio);
            }
            if (height > size) {
                height = size;
                width = (int) ((float) size * fRatio);
            }
        }
        BufferedImage imgNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D grapImg = imgNew.createGraphics();
        grapImg.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        AffineTransform xform = AffineTransform.getScaleInstance((double) width / img.getWidth(), (double) height / img.getHeight());
        grapImg.drawRenderedImage(img, xform);
        grapImg.dispose();
        return imgNew;
    }

    /**
     * Converte uma imagem em byteArray
     *
     * @return
     */
    public static byte[] convertImgToByteArrayJPGAndOthers(String imgPath) throws Exception {

        File f = new File(imgPath);
        String[] strReg = imgPath.split("\\.");
        //converte o objeto file em array de bytes
        if (f.exists()) {
            InputStream is = new FileInputStream(f);
            byte[] bytes = new byte[(int) f.length()];
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length
                    && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }
            return bytes;
        }
        return null;

    }

//    public static byte[] convertImgToByteArray(String imgPath) {
//        //byte[] base64 = null;
//        try {
//            ByteArrayOutputStream bOs = null;
//            if (!imgPath.equals("")) {
//                //quebra a string para retornar a extensão da mesma
//                String[] strReg = imgPath.split("\\.");
//                File file = new File(imgPath);
//                
//                bOs = new ByteArrayOutputStream();
//                if (file.exists()) {
//                    InputStream input = new FileInputStream(file);
//                    com.sun.image.codec.jpeg.JPEGImageDecoder decoder = com.sun.image.codec.jpeg.JPEGCodec.createJPEGDecoder(input);
//                    BufferedImage buffer = decoder.decodeAsBufferedImage();
//                    buffer = resizeImg(buffer,800,0);
//                    ImageIO.write(buffer, strReg[1], bOs);            
//                    bOs.flush();
//                    // base64 = Base64.encodeBase64(bOs.toByteArray());
//                    bOs.close();
//                }
//            }
//            logger.info("Imagem convertida em ByteArray com sucesso.");
//
//
//            return bOs.toByteArray();
//        } catch (Exception e) {
//            logger.error("Erro ao converter imagem em ByteArray: " + e);
//            return null;
//
//        }
//
//    }
    //CORREÇÃO DOS ACENTOS
    public static String ReplaceAcento(String acentos) {

        //String acentos = "À,Â,È,É,Ê,Ë,Ï,Î,Ô,Û,Ù,à,â,è,é,ê,ë,ï,î,ô,û,ù";
        acentos = acentos.replaceAll("[ãâàáä]", "a")
                .replaceAll("[êèéë&]", "e")
                .replaceAll("[îìíï]", "i")
                .replaceAll("[õôòóö]", "o")
                .replaceAll("[ûúùü]", "u")
                .replaceAll("[ÃÂÀÁÄ]", "A")
                .replaceAll("[ÊÈÉË]", "E")
                .replaceAll("[ÎÌÍÏ]", "I")
                .replaceAll("[ÕÔÒÓÖ]", "O")
                .replaceAll("[ÛÙÚÜ]", "U")
                .replace('ç', 'c')
                .replace('Ç', 'C')
                .replace('ñ', 'n')
                .replace('Ñ', 'N')
                .replaceAll("[^a-zA-Z0-9]", " ");

        return acentos;
    }

    /**
     * Redimensiona e plota nova imagem
     *
     * @param filePath caminho
     * @param width largura
     * @param heigh altura
     * @param typeImage tipo da imagem
     */
//    public static void redimensionaImagem(FileBean file, int width, int height, int typeImage) {
//        try {
//            Path origem = Paths.get((String) file.getCaminho());
//            Path destino = Paths.get((String) file.getCaminho());
//            //imagem original
//            BufferedImage imgOriginal = ImageIO.read(new File((String) file.getCaminho()));
//            //imagem redimensiona
//            BufferedImage resizedImage = new BufferedImage(width, height, typeImage);
//            //Biblioteca grafica que recebe a imagem redimensionada
//            Graphics2D g2d = resizedImage.createGraphics();
//            //Plota a imagem
//            g2d.drawImage(imgOriginal, 0, 0, width, height, null);
//            g2d.dispose();
//            //grava nova imagem redimensionada
//            ImageIO.write(resizedImage, file.getExtensao(), new File((String) file.getCaminho()));
//            logger.info("Imagem redimensionada com sucesso.");
//        } catch (Exception e) {
//            logger.error("Erro ao redimensionar imagem: " + e);
//
//        }
    ///  }
    public static void validaData(String dateStr) {
        try {
            Date data = df.parse(dateStr);
            // return data;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de data incorreto, redigite novamente");
            return;
        }
    }
}
