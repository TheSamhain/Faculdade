package menu.navegacaojanelas;

import javax.swing.JFrame;

public class Menu {

    public static void main(String[] args) {
        JFrame janela = new JanelaPrincipal();
        janela.setVisible(true);
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
}
