package br.com.banco;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Transporte {
	private static String[] conteudo;
	private static String str = "";

	public void enviar(String envio) {
		try {
			Socket s = new Socket("localhost", 8888);
			s.getOutputStream().write(envio.getBytes());
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] receber() {
		
		byte[] b = new byte[1024];// Array de bytes

		try {
			ServerSocket ss = new ServerSocket(8889);
			Socket s = ss.accept();
	
			// aceita a conexao e recebe a requisição
			s.getInputStream().read(b);// lê a requisição
			ss.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		str = "";
		for (byte x : b) {
			str += (char) x;
		}
		conteudo = str.split("<>");
		return conteudo;
	}
}
