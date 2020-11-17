
package br.com.SistemasOperacionais;


public class Main {
    public static void main(String[] args) {
        TesteThread t1 = new TesteThread();
        TesteThread t2 = new TesteThread();
        TesteThread t3 = new TesteThread();
        TesteThread t4 = new TesteThread();
        TesteThread t5 = new TesteThread();
        TesteThread t6 = new TesteThread();
        
        t1.setNome("Um");
        t2.setNome("Dois");
        t3.setNome("Tres");
        t4.setNome("Quatro");
        t5.setNome("Cinco");
        t6.setNome("Seis");
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
