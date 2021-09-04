package br.com.banco.gui.document;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter.FilterBypass;
import javax.swing.text.PlainDocument;

public class FloatDocument extends PlainDocument {
	
	public void insertString(int offs, String str, AttributeSet att) throws BadLocationException {
		String texto = getText(0,getLength());   
		if (!str.equals(",")) {
			try {
				str = str.replace(",", ".");
				Float.parseFloat(str);
				str = str.replace(".", ",");
			} catch (NumberFormatException e) {
				return;
			}
		} else if(str.equals(",")) {
			if(texto.indexOf(",") > -1) {
				return;
			}
		}

		super.insertString(offs, str, att);
	}	
}
