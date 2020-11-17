/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal;

import JDBC.ConnectionFactory;
import java.awt.HeadlessException;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author samhain
 */
public class Main {
    
    public static void main(String[] args){
        
        try{
            //Testando a conexão
            JOptionPane.showMessageDialog(null,"Testando a conexão");
            Connection con = new ConnectionFactory().conecta();
            JOptionPane.showMessageDialog(null,"Está conectado");
        
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null,"Erro: "+e);
        }
    }
}
