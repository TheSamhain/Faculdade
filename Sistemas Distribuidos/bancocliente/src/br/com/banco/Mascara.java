package br.com.banco;

import javax.swing.text.MaskFormatter;

public class Mascara{
	public static MaskFormatter mascarar(String mascara){
        MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(mascara); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento 
        }
        catch (Exception e) {
        	e.printStackTrace();
        } 
        return F_Mascara;
 }
}
