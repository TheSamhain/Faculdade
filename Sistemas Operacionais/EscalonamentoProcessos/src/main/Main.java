package main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import telas.Principal;

public class Main {
    public static void main(String args[]){
        JFrame janela = new Principal();
        try{
            janela.setVisible(true);
            janela.setLocationRelativeTo(null);
        }catch(Exception erro){
            JOptionPane.showMessageDialog(janela, erro, "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
