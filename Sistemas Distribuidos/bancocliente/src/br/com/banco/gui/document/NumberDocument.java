package br.com.banco.gui.document;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumberDocument extends PlainDocument {
	public void insertString(int offs, String str, AttributeSet att) throws BadLocationException{
		try{
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return;
		}
		
		super.insertString(offs, str, att);
	}
}
