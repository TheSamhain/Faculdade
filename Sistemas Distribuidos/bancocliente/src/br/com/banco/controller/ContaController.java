package br.com.banco.controller;

import br.com.banco.model.Conta;

public class ContaController {
	public String validar(Conta c) {
		String msg = "";
		if(c.getAgencia()==null) {
			msg = msg + "Informe a agência\n";
		}
		if(c.getTaxaManutencao()==null) {
			msg = msg + "Informe a taxa de manutenção\n";
		}
		return msg;
	}
}
