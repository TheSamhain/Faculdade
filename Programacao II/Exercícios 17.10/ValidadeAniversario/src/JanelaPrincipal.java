public class JanelaPrincipal extends javax.swing.JFrame {
    public JanelaPrincipal() {
        initComponents();
    }

    int dia,mes,diaFinal;
    
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_dia = new javax.swing.JLabel();
        txt_dia = new javax.swing.JTextField();
        lbl_mes = new javax.swing.JLabel();
        txt_mes = new javax.swing.JTextField();
        btn_validar = new javax.swing.JButton();
        lbl_msg_data = new javax.swing.JLabel();
        lbl_msg_validar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(235, 217));

        lbl_dia.setText("Dia:");

        lbl_mes.setText("Mês:");

        btn_validar.setText("Validar");
        btn_validar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_validarActionPerformed(evt);
            }
        });

        lbl_msg_data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_msg_data.setToolTipText("");

        lbl_msg_validar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_msg_data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_msg_validar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btn_validar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_mes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_dia)
                            .addComponent(txt_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_dia)
                    .addComponent(txt_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_mes)
                    .addComponent(txt_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_validar)
                .addGap(18, 18, 18)
                .addComponent(lbl_msg_data, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_msg_validar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_validarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_validarActionPerformed
        dia = Integer.valueOf(txt_dia.getText());
        mes = Integer.valueOf(txt_mes.getText());
        
        switch(mes){
            case  1: lbl_msg_data.setText(dia + " de Janeiro");
                     diaFinal = 31;
                     break;
            case  2: lbl_msg_data.setText(dia + " de Fevereiro");
                     diaFinal = 28;
                     break;
            case  3: lbl_msg_data.setText(dia + " de Março");
                     diaFinal = 31;
                     break;
            case  4: lbl_msg_data.setText(dia + " de Abril");
                     diaFinal = 30;
                     break;
            case  5: lbl_msg_data.setText(dia + " de Maio");
                     diaFinal = 31;
                     break;
            case  6: lbl_msg_data.setText(dia + " de Junho");
                     diaFinal = 30;
                     break;
            case  7: lbl_msg_data.setText(dia + " de Julho");
                     diaFinal = 31;
                     break;
            case  8: lbl_msg_data.setText(dia + " de Agosto");
                     diaFinal = 31;
                     break;
            case  9: lbl_msg_data.setText(dia + " de Setembro");
                     diaFinal = 30;
                     break;
            case 10: lbl_msg_data.setText(dia + " de Outubro");
                     diaFinal = 31;
                     break;
            case 11: lbl_msg_data.setText(dia + " de Novembro");
                     diaFinal = 30;
                     break;
            case 12: lbl_msg_data.setText(dia + " de Dezembro");
                     diaFinal = 31;
                     break;
            default: lbl_msg_data.setText("Dia " + dia + " e mês inexistente");
                     break;        
        }
        
        if((dia > diaFinal || dia < 1) || (mes < 1 || mes > 12)){
            lbl_msg_validar.setText("Data inválida");
        }else{
            lbl_msg_validar.setText("Data válida");
        }
    }//GEN-LAST:event_btn_validarActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_validar;
    private javax.swing.JLabel lbl_dia;
    private javax.swing.JLabel lbl_mes;
    private javax.swing.JLabel lbl_msg_data;
    private javax.swing.JLabel lbl_msg_validar;
    private javax.swing.JTextField txt_dia;
    private javax.swing.JTextField txt_mes;
    // End of variables declaration//GEN-END:variables
}
