package threads;

public class Thread extends java.lang.Thread {
    private String nome;
    public void setNome(String n){
        nome = n;
    }

    public void run() {
        for(int i =0;i<1000;i++){
            System.out.println("Thread "+nome+": "+i);
        }
    }
}
