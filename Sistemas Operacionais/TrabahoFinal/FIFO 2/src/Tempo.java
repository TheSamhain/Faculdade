
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tempo extends Thread{
    private int j = 0;
    private int tempoTotal;
    
    public void setTempo (int t){
        tempoTotal = t;
    }
    
    public void run(){

        try {
            System.out.println("---------------------------------");
            
            for(j = 0; j < tempoTotal;j++){
             //   txfSegundos.setText(String.valueOf(j));
                sleep(1000);
            }
        } catch (InterruptedException ex) {}
    }
}


