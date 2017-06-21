package frames;

import Problema_Mochila.AplicacaoAG;
import Problema_Mochila.ConversorBinario;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author YU7
 */
public class FrmAG extends javax.swing.JFrame {

    private DefaultListModel<String> lst_model;
    private int valorObj[];
    private int pesoObj[];
    private AplicacaoAG ag;
    private ArrayList<String> populacao;

    public FrmAG() {
        initComponents();
        lst_model = new DefaultListModel<>();
        spinerGeracoes.setValue(20);
        spinerIndividuos.setValue(8);
    }

    public void populacaoInicial() {

        populacao = new ArrayList<>();

        for (int i = 0; i < listaPopulacao.getModel().getSize(); i++) {
            populacao.add(listaPopulacao.getModel().getElementAt(i));
        }

    }

    public void preencherValoresPesos() {

        String valor = tfValorObj.getText().replace(",", "").trim();
        String pesos = tfPesosObj.getText().replace(",", "").trim();

        valorObj = new int[valor.length()];
        pesoObj = new int[pesos.length()];

        for (int i = 0; i < valorObj.length; i++) {
            String aux = String.valueOf(valor.charAt(i));
            valorObj[i] = Integer.parseInt(aux);
        }

        for (int i = 0; i < pesoObj.length; i++) {
            String aux = String.valueOf(pesos.charAt(i));
            pesoObj[i] = Integer.parseInt(aux);
        }

    }

    public void iniciarAlgoritmo() {

        populacaoInicial();
        preencherValoresPesos();

        this.ag = new AplicacaoAG(valorObj, pesoObj, tfConsole);

        int ger = 1;

        while (ger <= (int) spinerGeracoes.getValue()) {

            tfConsole.append("\n============= GERAÇÂO " + ger + " =============\n");

            ag.exibePopulacao(populacao);

            populacao = ag.GeraNovaPopulacao();

            ger++;

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfConsole = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaPopulacao = new javax.swing.JList<>();
        btGerarPop = new javax.swing.JButton();
        btAdicionarPop = new javax.swing.JButton();
        tfValorObj = new javax.swing.JTextField();
        tfPesosObj = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        spinerGeracoes = new javax.swing.JSpinner();
        btIniciarAG = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        spinerIndividuos = new javax.swing.JSpinner();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algoritmo da Mochila - Knapsack Problem");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfConsole.setEditable(false);
        tfConsole.setBackground(new java.awt.Color(255, 255, 204));
        tfConsole.setColumns(20);
        tfConsole.setRows(5);
        jScrollPane1.setViewportView(tfConsole);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Valores separados por virgula");

        jLabel2.setText("Pesos separados por virgula");

        jLabel3.setText("Tipo de seleção ");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Roleta");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Torneio");

        jLabel4.setText("Quantidade de Individuos");

        listaPopulacao.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listaPopulacao);

        btGerarPop.setText("Gerar");
        btGerarPop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerarPopActionPerformed(evt);
            }
        });

        btAdicionarPop.setText("Adicionar");
        btAdicionarPop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarPopActionPerformed(evt);
            }
        });

        tfValorObj.setText("3,3,2,4,2,3,5,8");

        tfPesosObj.setText("5,4,7,8,4,4,6,8");

        jLabel5.setText("Numero de Gerações");

        btIniciarAG.setText("INICIAR ALGORITMO");
        btIniciarAG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarAGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btIniciarAG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(tfValorObj)
                    .addComponent(tfPesosObj)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btGerarPop, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAdicionarPop, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinerIndividuos)
                            .addComponent(spinerGeracoes))))
                .addContainerGap())
            .addComponent(jSeparator2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfValorObj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPesosObj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jRadioButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spinerGeracoes)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(spinerIndividuos))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGerarPop)
                    .addComponent(btAdicionarPop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btIniciarAG)
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Parâmetros", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarPopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarPopActionPerformed
        // TODO add your handling code here:

        if (listaPopulacao.getModel().getSize() < (int) spinerIndividuos.getValue()) {
            String op = JOptionPane.showInputDialog(null, "Adicione um Individuo!");
            lst_model.addElement(op);
            listaPopulacao.setModel(lst_model);
        } else {
            JOptionPane.showMessageDialog(null, "Limite de individuos da população " + spinerIndividuos.getValue());
        }

    }//GEN-LAST:event_btAdicionarPopActionPerformed

    private void btIniciarAGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarAGActionPerformed
        // TODO add your handling code here:

        tfConsole.setText("");

        if ((int) spinerGeracoes.getValue() > 0) {
            iniciarAlgoritmo();
        } else {
            JOptionPane.showMessageDialog(null, "Geração deve ser maior que 0", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_btIniciarAGActionPerformed

    private void btGerarPopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerarPopActionPerformed
        // TODO add your handling code here:

        if ((int) spinerIndividuos.getValue() < 12) {
            JOptionPane.showMessageDialog(null, "O Algoritmo de gerar população inicial\n"
                    + "utiliza numeros Randômicos para isso é indicado\n"
                    + "utilizar uma população de no minimo 12 IDVS\n"
                    + "Pode ser adicionado manualmente",
                    "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }
        
        ConversorBinario conv = new ConversorBinario();

        Random rd = new Random();
        ArrayList<Integer> srt = new ArrayList();

        while (srt.size() < (int) spinerIndividuos.getValue()) {
            int sorteio = rd.nextInt(255);
            if (sorteio > 128) {
                srt.add(sorteio);
            }
        }

        lst_model = new DefaultListModel<>();

        for (int s : srt) {
            lst_model.addElement(conv.converteDecBin(s));
        }

        listaPopulacao.setModel(lst_model);


    }//GEN-LAST:event_btGerarPopActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmAG().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarPop;
    private javax.swing.JButton btGerarPop;
    private javax.swing.JButton btIniciarAG;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> listaPopulacao;
    private javax.swing.JSpinner spinerGeracoes;
    private javax.swing.JSpinner spinerIndividuos;
    public javax.swing.JTextArea tfConsole;
    private javax.swing.JTextField tfPesosObj;
    private javax.swing.JTextField tfValorObj;
    // End of variables declaration//GEN-END:variables
}
