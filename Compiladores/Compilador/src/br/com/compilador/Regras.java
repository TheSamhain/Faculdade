package br.com.compilador;

public class Regras {
	public static final String[] LISTA_PALAVRAS = { "int","float","void","boolean","string",
													"for","while","do","if","else","break",
													"continue","return","switch","case","default",
													"final","this","date","exception","parpro",
													"igor","goto","public","private"}; 
	
	public static final String[][] LISTA_OPERADORES = {{"++","+=","--","-=","/=","*=","==",">=","<=","!=","&&","||"},
													   {"+",	  "-",      "/", "*", "=", ">", "<", "!", "%","^","?"}};
	
	public static final String[] LISTA_DELIMITADORES = {";","(",")","[","]","{","}",":","#","\"","'","@","//","*/","/*","."};
	
	
}
