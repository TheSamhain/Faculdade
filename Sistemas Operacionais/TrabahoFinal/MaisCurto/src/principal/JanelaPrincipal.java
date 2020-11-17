package principal;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JanelaPrincipal extends javax.swing.JFrame {

    public JanelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblTempo = new javax.swing.JLabel();
        txfTempo = new javax.swing.JTextField();
        lblThread = new javax.swing.JLabel();
        txfThread = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        btnExecutar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTempo.setText("Tempo de Execução (segundos):");
        getContentPane().add(lblTempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 230, -1));

        txfTempo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txfTempoMouseClicked(evt);
            }
        });
        getContentPane().add(txfTempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 71, -1));

        lblThread.setText("Thread:");
        getContentPane().add(lblThread, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txfThread.setEditable(false);
        getContentPane().add(txfThread, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 42, -1));

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });
        getContentPane().add(btnInserir, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        btnExecutar.setText("Executar Threads");
        btnExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecutarActionPerformed(evt);
            }
        });
        getContentPane().add(btnExecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    int i = 0, j = 0;
    int tempoTotal = 0;
    int posicao = 1;
    int registros = 0;
    int menorTempo = 9999999;
    int maiorPosicao = 1;
    int altera;

    ArrayList<String> listaNomes = new ArrayList();
    ArrayList<Integer> listaTempo = new ArrayList();
    ArrayList<Integer> listaPosicao = new ArrayList();
    ArrayList<Integer> listaPosicaoSaida = new ArrayList();

    private void txfTempoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfTempoMouseClicked
        txfThread.setText("P" + posicao);
    }//GEN-LAST:event_txfTempoMouseClicked

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        if (txfTempo.getText() == null || txfTempo.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Tempo de execução não pode ser vazio!", "Alerta", 1);
        } else {
            listaTempo.add(Integer.valueOf(txfTempo.getText()));
            listaNomes.add("P" + posicao);
            listaPosicao.add(posicao);


            if (registros == 0) {
                listaPosicaoSaida.add(maiorPosicao);
                maiorPosicao++;
            } else {
                for (i = 0; i < registros; i++) {
                    if (listaTempo.get(i) > listaTempo.get(registros) && listaTempo.get(i) <= menorTempo && listaPosicaoSaida.get(i) < maiorPosicao) {
                        menorTempo = listaTempo.get(i);
                        maiorPosicao = listaPosicaoSaida.get(i);
                    }
                }
                listaPosicaoSaida.add(maiorPosicao);
                for (i = 0; i < registros; i++) {
                    if (listaTempo.get(i) > listaTempo.get(registros)) {
                        listaPosicaoSaida.set(i, listaPosicaoSaida.get(i) + 1);
                    }
                    if(listaPosicaoSaida.get(i) >= maiorPosicao){
                        maiorPosicao = listaPosicaoSaida.get(i); 
                    }
                }
                maiorPosicao++;
            }
            
            posicao++;
            tempoTotal = tempoTotal + listaTempo.get(registros);

            System.out.println("|Nome\t|Tempo\t|Posição|Posição Saída");
            for (i = 0; i <= registros; i++) {
                System.out.println("|" + listaNomes.get(i) + "\t|" + listaTempo.get(i) + "\t|" + listaPosicao.get(i) + "\t|" + listaPosicaoSaida.get(i));
            }
            System.out.println("----------------------------------------------");
                    
            //System.out.println("|" + listaNomes.get(registros) + "\t|" + listaTempo.get(registros) + "\t|" + listaPosicao.get(registros) + "\t|" + listaPosicaoSaida.get(registros));
            registros++;
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        System.out.println("|Nome\t|Tempo\t|Posição|Posição Saída");
        System.out.println("----------------------------------------------");
    }//GEN-LAST:event_formWindowOpened

    private void btnExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecutarActionPerformed
        btnInserir.setEnabled(false);
        try {
            System.out.println("----------------------------------------------");

            maiorPosicao = 1;
            while (registros >= 0) {
                if (registros > 0) {
                    Thread.sleep(1000);
                }

                System.out.println("|Nome\t|Tempo\t|Posição|Posição Saída");
                for (i = 0; i < registros; i++) {
                    System.out.println("|" + listaNomes.get(i) + "\t|" + listaTempo.get(i) + "\t|" + listaPosicao.get(i) + "\t|" + listaPosicaoSaida.get(i));
                }
                System.out.println("----------------------------------------------");

                if (registros != 0) {
                    for (i = 0; i < registros; i++) {
                        if (listaPosicaoSaida.get(i) == maiorPosicao) {
                            listaNomes.remove(i);
                            listaTempo.remove(i);
                            listaPosicao.remove(i);
                            listaPosicaoSaida.remove(i);
                            break;
                        }
                    }
                    maiorPosicao++;
                }
                registros = registros - 1;
            }
        } catch (InterruptedException erro) {
            JOptionPane.showMessageDialog(null, erro, "Thread interrompida.", 2);
        }
    }//GEN-LAST:event_btnExecutarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExecutar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTempo;
    private javax.swing.JLabel lblThread;
    private javax.swing.JTextField txfTempo;
    private javax.swing.JTextField txfThread;
    // End of variables declaration//GEN-END:variables
}
