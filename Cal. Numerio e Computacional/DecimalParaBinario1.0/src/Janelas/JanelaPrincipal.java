package Janelas;

import Main.Motor;

public class JanelaPrincipal extends javax.swing.JFrame {

    public JanelaPrincipal() {
        initComponents();
        System.out.print("Teste de mesa\n"
                + "Decimal: 873334661 Binário: 110100000011100000011110000101 Octal: 6403403605 Hexadecimal: 340E0785\n\n"
                + "Decimal: 69486912 Binário: 100001001000100100101000000 Octal: 411044500 Hexadecimal: 4244940\n\n"
                + "Decimal: 63278679 Binário: 11110001011000111001010111 Octal: 361307127 Hexadecimal: 3C58E57\n\n"
                + "Decimal: 4913287 Binário: 10010101111100010000111 Octal: 22574207 Hexadecimal: 4AF887\n\n"
                + "Decimal: 7915468 Binário: 11110001100011111001100 Octal: 36143714 Hexadecimal: 78C7CC\n\n"
                + "Decimal: 871245 Binário: 11010100101101001101 Octal: 3245515 Hexadecimal: D4B4D\n\n"
                + "Decimal: 32658 Binário: 111111110010010 Octal: 77622 Hexadecimal: 7F92\n\n"
                + "Decimal: 6512 Binário: 1100101110000 Octal: 14560 Hexadecimal: 1970\n\n"
                + "Decimal: 461 Binário: 111001101 Octal: 715 Hexadecimal: 1CD\n\n"
                + "Decimal: 85 Binário: 1010101 Octal: 125 Hexadecimal: 55\n\n"
                + "Decimal: 4 Binário: 100 Octal: 4 Hexadecimal: 4 ");
    }

    Motor eng = new Motor();

    long valor;
    String de, para;
    String resultado;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txfValorInserido = new javax.swing.JTextField();
        lblValorInserido = new javax.swing.JLabel();
        txfResultado = new javax.swing.JTextField();
        lblDe = new javax.swing.JLabel();
        dpdPara = new javax.swing.JComboBox<>();
        lblPara = new javax.swing.JLabel();
        dpdDe = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(406, 193));
        setMinimumSize(new java.awt.Dimension(406, 193));
        setPreferredSize(new java.awt.Dimension(406, 193));
        getContentPane().setLayout(null);

        txfValorInserido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfValorInseridoKeyReleased(evt);
            }
        });
        getContentPane().add(txfValorInserido);
        txfValorInserido.setBounds(180, 10, 213, 19);

        lblValorInserido.setText("Valor para converter:");
        getContentPane().add(lblValorInserido);
        lblValorInserido.setBounds(10, 10, 151, 15);

        txfResultado.setEditable(false);
        getContentPane().add(txfResultado);
        txfResultado.setBounds(10, 130, 376, 19);

        lblDe.setText("De:");
        getContentPane().add(lblDe);
        lblDe.setBounds(10, 50, 24, 15);

        dpdPara.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Decimal", "Binário", "Octal", "Hexadecimal" }));
        getContentPane().add(dpdPara);
        dpdPara.setBounds(80, 90, 120, 24);

        lblPara.setText("Para:");
        getContentPane().add(lblPara);
        lblPara.setBounds(10, 90, 38, 15);

        dpdDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Decimal", "Binário", "Octal", "Hexadecimal" }));
        getContentPane().add(dpdDe);
        dpdDe.setBounds(80, 50, 120, 24);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfValorInseridoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfValorInseridoKeyReleased
        if((txfValorInserido.getText()).equals("")) {
            txfResultado.setText("Insira um valor para converter!");
        } else {
            valor = Integer.valueOf(txfValorInserido.getText());
            de = String.valueOf(dpdDe.getSelectedItem());
            para = String.valueOf(dpdPara.getSelectedItem());

            resultado = eng.Converter(valor, de, para);
            txfResultado.setText(resultado);
        }
    }//GEN-LAST:event_txfValorInseridoKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> dpdDe;
    private javax.swing.JComboBox<String> dpdPara;
    private javax.swing.JLabel lblDe;
    private javax.swing.JLabel lblPara;
    private javax.swing.JLabel lblValorInserido;
    private javax.swing.JTextField txfResultado;
    private javax.swing.JTextField txfValorInserido;
    // End of variables declaration//GEN-END:variables
}
