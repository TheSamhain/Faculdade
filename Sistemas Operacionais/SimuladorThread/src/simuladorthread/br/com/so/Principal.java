/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorthread.br.com.so;

public class Principal {
    public static void main(String[] args){
        Teste t1 = new Teste();
        Teste t2 = new Teste();
        Teste t3 = new Teste();
        Teste t4 = new Teste();
        Teste t5 = new Teste();
        Teste t6 = new Teste();
        
        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        Thread th3 = new Thread(t3);
        Thread th4 = new Thread(t1);
        Thread th5 = new Thread(t2);
        Thread th6 = new Thread(t3);
        
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start(); 
    }
}
