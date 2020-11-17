package emprestimo;

import java.awt.Dimension;

public class JanelaPrincipal extends javax.swing.JFrame {

    double salarioBruto,descontos,emprestimo,valorParcela,salarioLiquido,porcentagemSalario;
    int parcelas;

    
    
    public JanelaPrincipal() {
        initComponents();
	setMinimumSize(new Dimension(340,360));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_salarioBruto = new javax.swing.JTextField();
        lbl_salarioBruto = new javax.swing.JLabel();
        lbl_desconto = new javax.swing.JLabel();
        txt_desconto = new javax.swing.JTextField();
        lbl_valorEmprestimo = new javax.swing.JLabel();
        txt_valorEmprestimo = new javax.swing.JTextField();
        btn_verificar = new javax.swing.JButton();
        lbl_resultado = new javax.swing.JLabel();
        lbl_parcelas = new javax.swing.JLabel();
        txt_parcelas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(340, 345));
        getContentPane().setLayout(null);
        getContentPane().add(txt_salarioBruto);
        txt_salarioBruto.setBounds(90, 30, 140, 30);

        lbl_salarioBruto.setText("Salário Bruto");
        getContentPane().add(lbl_salarioBruto);
        lbl_salarioBruto.setBounds(90, 10, 150, 15);

        lbl_desconto.setText("Descontos do Salário");
        getContentPane().add(lbl_desconto);
        lbl_desconto.setBounds(90, 70, 151, 15);
        getContentPane().add(txt_desconto);
        txt_desconto.setBounds(90, 90, 140, 30);

        lbl_valorEmprestimo.setText("Valor do empréstimo");
        getContentPane().add(lbl_valorEmprestimo);
        lbl_valorEmprestimo.setBounds(90, 130, 150, 15);
        getContentPane().add(txt_valorEmprestimo);
        txt_valorEmprestimo.setBounds(90, 150, 140, 30);

        btn_verificar.setText("Verificar");
        btn_verificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verificarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_verificar);
        btn_verificar.setBounds(110, 260, 93, 25);

        lbl_resultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_resultado.setToolTipText("");
        getContentPane().add(lbl_resultado);
        lbl_resultado.setBounds(20, 300, 290, 20);

        lbl_parcelas.setText("Parelas");
        getContentPane().add(lbl_parcelas);
        lbl_parcelas.setBounds(90, 190, 150, 15);
        getContentPane().add(txt_parcelas);
        txt_parcelas.setBounds(90, 210, 140, 30);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_verificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verificarActionPerformed
        salarioBruto = Double.valueOf(txt_salarioBruto.getText());
        descontos = Double.valueOf(txt_desconto.getText());
        emprestimo = Double.valueOf(txt_valorEmprestimo.getText());
        parcelas = Integer.valueOf(txt_parcelas.getText());
        
        valorParcela = emprestimo / parcelas;
        salarioLiquido = salarioBruto - descontos;
        porcentagemSalario = salarioLiquido * 0.3;
        
        if(porcentagemSalario > valorParcela){
            lbl_resultado.setText("Empréstimo aprovado");
        }else{
            lbl_resultado.setText("Empréstimo não aprovado");
        }
    }//GEN-LAST:event_btn_verificarActionPerformed
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
    private javax.swing.JButton btn_verificar;
    private javax.swing.JLabel lbl_desconto;
    private javax.swing.JLabel lbl_parcelas;
    private javax.swing.JLabel lbl_resultado;
    private javax.swing.JLabel lbl_salarioBruto;
    private javax.swing.JLabel lbl_valorEmprestimo;
    private javax.swing.JTextField txt_desconto;
    private javax.swing.JTextField txt_parcelas;
    private javax.swing.JTextField txt_salarioBruto;
    private javax.swing.JTextField txt_valorEmprestimo;
    // End of variables declaration//GEN-END:variables
}
