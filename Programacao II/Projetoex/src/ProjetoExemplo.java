
import java.sql.Connection;
import javax.swing.JOptionPane;


public class ProjetoExemplo {
    
    public static void main(String[]args){
        try {
            JOptionPane.showMessageDialog(null, "Tentando...");
            Connection con = new JDBC.ConnectionFactory().conecta();
            JOptionPane.showMessageDialog(null, "Conectou!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro" + e);
        }
    }
}
