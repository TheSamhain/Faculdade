public class JanelaPrincipal extends javax.swing.JFrame {

    public JanelaPrincipal() {
        initComponents();
    }
    
    String[] nome = new String[2];
    int[] mes = new int[2],dia = new int[2];
    int valido = 0;
    int diaFinal1,diaFinal2;
    
    void verificaMes(){
        switch(mes[0]){
            case  1: diaFinal1 = 31;
                     break;
            case  2: diaFinal1 = 28;
                     break;
            case  3: diaFinal1 = 31;
                     break;
            case  4: diaFinal1 = 30;
                     break;
            case  5: diaFinal1 = 31;
                     break;
            case  6: diaFinal1 = 30;
                     break;
            case  7: diaFinal1 = 31;
                     break;
            case  8: diaFinal1 = 31;
                     break;
            case  9: diaFinal1 = 30;
                     break;
            case 10: diaFinal1 = 31;
                     break;
            case 11: diaFinal1 = 30;
                     break;
            case 12: diaFinal1 = 31;
                     break;
        } 
        
           switch(mes[1]){
            case  1: diaFinal2 = 31;
                     break;
            case  2: diaFinal2 = 28;
                     break;
            case  3: diaFinal2 = 31;
                     break;
            case  4: diaFinal2 = 30;
                     break;
            case  5: diaFinal2 = 31;
                     break;
            case  6: diaFinal2 = 30;
                     break;
            case  7: diaFinal2 = 31;
                     break;
            case  8: diaFinal2 = 31;
                     break;
            case  9: diaFinal2 = 30;
                     break;
            case 10: diaFinal2 = 31;
                     break;
            case 11: diaFinal2 = 30;
                     break;
            case 12: diaFinal2 = 31;
                     break;
        }         
    }
    
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_nome1 = new javax.swing.JLabel();
        txt_nome1 = new javax.swing.JTextField();
        lbl_aniver1 = new javax.swing.JLabel();
        txt_dia1 = new javax.swing.JTextField();
        btn_verificar = new javax.swing.JButton();
        lbl_mensagem = new javax.swing.JLabel();
        lbl_dia1 = new javax.swing.JLabel();
        lbl_mes1 = new javax.swing.JLabel();
        txt_mes1 = new javax.swing.JTextField();
        txt_nome2 = new javax.swing.JTextField();
        txt_mes2 = new javax.swing.JTextField();
        lbl_aniver3 = new javax.swing.JLabel();
        txt_dia2 = new javax.swing.JTextField();
        lbl_dia2 = new javax.swing.JLabel();
        lbl_nome3 = new javax.swing.JLabel();
        lbl_mes2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_nome1.setText("Nome 1:");

        lbl_aniver1.setText("Aniversário 1");

        btn_verificar.setText("Verificar");
        btn_verificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verificarActionPerformed(evt);
            }
        });

        lbl_mensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbl_dia1.setText("Dia: ");

        lbl_mes1.setText("Mês:");

        lbl_aniver3.setText("Aniversário 2");

        lbl_dia2.setText("Dia: ");

        lbl_nome3.setText("Nome 2:");

        lbl_mes2.setText("Mês:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_verificar)
                                    .addGap(110, 110, 110))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(lbl_mensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_nome3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_dia2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_dia2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl_mes2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_mes2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_nome2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbl_dia1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_nome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_aniver1)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt_dia1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbl_mes1)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_mes1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(lbl_aniver3)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nome1)
                    .addComponent(txt_nome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_aniver1)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_dia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_dia1)
                    .addComponent(lbl_mes1)
                    .addComponent(txt_mes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nome3)
                    .addComponent(txt_nome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(lbl_aniver3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_dia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_dia2)
                    .addComponent(lbl_mes2)
                    .addComponent(txt_mes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btn_verificar)
                .addGap(18, 18, 18)
                .addComponent(lbl_mensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_verificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verificarActionPerformed
        nome[0] = txt_nome1.getText();
        nome[1] = txt_nome2.getText();
        
        mes[0] = Integer.valueOf(txt_mes1.getText());
        mes[1] = Integer.valueOf(txt_mes2.getText());
        
        dia[0] = Integer.valueOf(txt_dia1.getText());
        dia[1] = Integer.valueOf(txt_dia2.getText());
        
        verificaMes();
        
        if((dia[0] < 1 || dia[0] > diaFinal1) || (dia[1] < 1 || dia[1] > diaFinal2) || (mes[0] < 1 || mes[0] > 12) || (mes[1] < 1 || mes[1] > 12)){
            lbl_mensagem.setText("Alguma data está invalida");
        }else{
            if(mes[0] < mes[1]){
                lbl_mensagem.setText(nome[0] + " faz aniversário primeiro");
            }else{
                lbl_mensagem.setText(nome[1] + " faz aniversário primeiro");
            }
        
            if(mes[0] == mes[1]){
                if(dia[0] < dia[1]){
                    lbl_mensagem.setText(nome[0] + " faz aniversário primeiro");
                }else{
                    lbl_mensagem.setText(nome[1] + " faz aniversário primeiro");
                }
                if(dia[0] == dia[1]){
                    lbl_mensagem.setText(nome[0] + " e " + nome[1] + " fazem aniversário no mesmo dia e mês");                
                }
            }
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
    private javax.swing.JLabel lbl_aniver1;
    private javax.swing.JLabel lbl_aniver3;
    private javax.swing.JLabel lbl_dia1;
    private javax.swing.JLabel lbl_dia2;
    private javax.swing.JLabel lbl_mensagem;
    private javax.swing.JLabel lbl_mes1;
    private javax.swing.JLabel lbl_mes2;
    private javax.swing.JLabel lbl_nome1;
    private javax.swing.JLabel lbl_nome3;
    private javax.swing.JTextField txt_dia1;
    private javax.swing.JTextField txt_dia2;
    private javax.swing.JTextField txt_mes1;
    private javax.swing.JTextField txt_mes2;
    private javax.swing.JTextField txt_nome1;
    private javax.swing.JTextField txt_nome2;
    // End of variables declaration//GEN-END:variables
}
