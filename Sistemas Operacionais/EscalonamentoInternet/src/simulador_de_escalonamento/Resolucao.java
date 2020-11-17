package simulador_de_escalonamento;
 
import java.awt.Dimension;
import java.awt.Toolkit;
 
public class Resolucao {
 
    public static double resolucao(int tipo) {
        //1=x; 2=y
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        double x = dim.getWidth();//largura
        double y = dim.getHeight();//altura
        if (tipo == 1) {
            return x;
        } else {
            return y;
        }
    }
}