package br.com.banco.gui.document;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextDocument extends PlainDocument{
	private int max;
	public TextDocument(int max) {
		super();
		this.max = max;
	}
	
	public void insertString(int offs, String str, AttributeSet att) throws BadLocationException{
		if(str==null)return;
		int free = max-getLength();
		if(free > 0) {
			int strLength = str.length();
			if(strLength > free) {
				strLength = free;
			}
			super.insertString(offs,str.substring(0, strLength),att);
		}
	}
}
