package br.com.banco.controller;

import javax.swing.JTextField;

import br.com.banco.model.Conta;
import br.com.banco.model.Endereco;

public class EnderecoController {
	public String validar(Endereco en) {
		String msg = "";
		if(en.getLogradouro()==null) {
			msg = msg + "Informe o Logradouro\n";
		}
		if(en.getNumero()==null) {
			msg = msg + "Informe o Número\n";
		}
		if(en.getComplemento()==null) {
			msg = msg + "Informe o Complemento\n";
		}
		if(en.getBairro()==null) {
			msg = msg + "Informe o Bairro\n";
		}
		if(en.getCidade()==null) {
			msg = msg + "Informe a Cidade\n";
		}
		
		return msg;
	}
}