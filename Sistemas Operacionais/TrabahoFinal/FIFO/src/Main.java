import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args){
        try{
            JFrame janela = new JanelaPrincipal();
            janela.setVisible(true);
            janela.setLocationRelativeTo(null);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro, "Erro ao abrir janela: ", 0);
        }
    }
}
