package trabalho;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import telas.JanelaPrincipal;

public class Main {

    public static void main(String[] args) {
        JFrame janela = new JanelaPrincipal();
        try {
            janela.setVisible(true);
            janela.setLocationRelativeTo(null);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

}
