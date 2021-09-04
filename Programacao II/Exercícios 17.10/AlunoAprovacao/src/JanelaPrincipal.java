import javax.swing.JOptionPane;

public class JanelaPrincipal extends javax.swing.JFrame {

    public JanelaPrincipal() {
        initComponents();

    }



    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_qtdeNotas = new javax.swing.JLabel();
        txt_qtdeNotas = new javax.swing.JTextField();
        lbl_nome = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        lbl_mensagem = new javax.swing.JLabel();
        btn_inserir = new javax.swing.JButton();
        lbl_frequencia = new javax.swing.JLabel();
        txt_frequencia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(null);

        lbl_qtdeNotas.setText("Qtde. Notas: ");
        getContentPane().add(lbl_qtdeNotas);
        lbl_qtdeNotas.setBounds(12, 51, 94, 15);
        getContentPane().add(txt_qtdeNotas);
        txt_qtdeNotas.setBounds(140, 50, 80, 30);

        lbl_nome.setText("Nome: ");
        getContentPane().add(lbl_nome);
        lbl_nome.setBounds(12, 14, 94, 15);
        getContentPane().add(txt_nome);
        txt_nome.setBounds(140, 10, 200, 30);

        lbl_mensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbl_mensagem);
        lbl_mensagem.setBounds(10, 180, 306, 30);

        btn_inserir.setText("Inserir notas");
        btn_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inserirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_inserir);
        btn_inserir.setBounds(100, 140, 125, 25);

        lbl_frequencia.setText("Frequência %:");
        getContentPane().add(lbl_frequencia);
        lbl_frequencia.setBounds(12, 88, 110, 15);
        getContentPane().add(txt_frequencia);
        txt_frequencia.setBounds(140, 90, 80, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inserirActionPerformed
        int qtdeNotas;
        String nome;
        double frequencia;
    
        nome = txt_nome.getText();
        qtdeNotas = Integer.valueOf(txt_qtdeNotas.getText());
        frequencia = Double.valueOf(txt_frequencia.getText());
        
        int i = 0;
        
        double[] notas = new double[qtdeNotas];

        for(i = 0;i < qtdeNotas; i++){
            String n;
            n = JOptionPane.showInputDialog(null,"Digite a nota " + (i+1) + ": ","Notas",2);
            notas[i] = Double.valueOf(n);
        }
        
        double tot_notas = 0;
        for(i = 0;i < qtdeNotas;i++){
            tot_notas = tot_notas + notas[i];
        }
        
        double media = tot_notas/qtdeNotas;
        
        if(media >= 6 && frequencia > 70){
            lbl_mensagem.setText("Alunos aprovado com media " + media + " e " + frequencia + "% de frequencia");
        }else{
            lbl_mensagem.setText("Alunos reprovado com media " + media + " e " + frequencia + "% de frequencia");           
        }
        
        
    }//GEN-LAST:event_btn_inserirActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_inserir;
    private javax.swing.JLabel lbl_frequencia;
    private javax.swing.JLabel lbl_mensagem;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_qtdeNotas;
    private javax.swing.JTextField txt_frequencia;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_qtdeNotas;
    // End of variables declaration//GEN-END:variables
}
