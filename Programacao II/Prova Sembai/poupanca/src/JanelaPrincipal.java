public class JanelaPrincipal extends javax.swing.JFrame {

    public JanelaPrincipal() {
        initComponents();
    }

    int num_pagamentos = 0;
    double total = 0;
    double juros = 0;
    int anos = 0;
    double deposito_mensal;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_juros = new javax.swing.JLabel();
        lb_anos = new javax.swing.JLabel();
        lb_deposito = new javax.swing.JLabel();
        lb_total = new javax.swing.JLabel();
        txt_juros = new javax.swing.JTextField();
        txt_anos = new javax.swing.JTextField();
        txt_deposito = new javax.swing.JTextField();
        bt_resultado = new javax.swing.JButton();
        lb_valortotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lb_juros.setText("Juros ao Mês %:");

        lb_anos.setText("Num. de anos:");

        lb_deposito.setText("Depósito mensal R$:");

        lb_total.setText("Total poupado R$:");

        bt_resultado.setText("OK");
        bt_resultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_resultadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_juros)
                    .addComponent(lb_anos)
                    .addComponent(lb_deposito)
                    .addComponent(lb_total))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_resultado, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(txt_juros)
                    .addComponent(txt_anos)
                    .addComponent(txt_deposito)
                    .addComponent(lb_valortotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_juros)
                    .addComponent(txt_juros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_anos)
                    .addComponent(txt_anos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_deposito)
                    .addComponent(txt_deposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_valortotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(bt_resultado)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_resultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resultadoActionPerformed
        anos = 0;
        num_pagamentos = 0;
        juros = 0;
        deposito_mensal = 0;
        total = 0;
        
        anos = Integer.valueOf(txt_anos.getText());
        num_pagamentos = anos * 12;
        juros = Double.valueOf(txt_juros.getText());
        juros = juros / 100;
        deposito_mensal = Double.valueOf(txt_deposito.getText());
        
        for(int i =0; i< num_pagamentos;i++){
            total = total + deposito_mensal;
            total = total + (total * juros);
        }
        lb_valortotal.setText(String.valueOf(total));
    }//GEN-LAST:event_bt_resultadoActionPerformed


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


  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_resultado;
    private javax.swing.JLabel lb_anos;
    private javax.swing.JLabel lb_deposito;
    private javax.swing.JLabel lb_juros;
    private javax.swing.JLabel lb_total;
    private javax.swing.JLabel lb_valortotal;
    private javax.swing.JTextField txt_anos;
    private javax.swing.JTextField txt_deposito;
    private javax.swing.JTextField txt_juros;
    // End of variables declaration//GEN-END:variables
}
