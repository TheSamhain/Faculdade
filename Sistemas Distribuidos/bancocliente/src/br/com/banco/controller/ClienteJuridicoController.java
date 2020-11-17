package br.com.banco.controller;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

import br.com.banco.model.ClienteFisico;
import br.com.banco.model.ClienteJuridico;

public class ClienteJuridicoController {
	public String validar(ClienteJuridico cj) {
		String msg = "";

		//CLIENTE JURIDICO
		// VALIDAÇÃO DE CNPJ
		// Código tirado de
		// https://www.devmedia.com.br/validando-o-cnpj-em-uma-aplicacao-java/22374
		if (cj.getCnpj() != null) {

			if (cj.getCnpj().replace(".", "").replace("/", "").replace("-", "").equals("00000000000000")
					|| cj.getCnpj().replace(".", "").replace("/", "").replace("-", "").equals("11111111111111")
					|| cj.getCnpj().replace(".", "").replace("/", "").replace("-", "").equals("22222222222222")
					|| cj.getCnpj().replace(".", "").replace("/", "").replace("-", "").equals("33333333333333")
					|| cj.getCnpj().replace(".", "").replace("/", "").replace("-", "").equals("44444444444444")
					|| cj.getCnpj().replace(".", "").replace("/", "").replace("-", "").equals("55555555555555")
					|| cj.getCnpj().replace(".", "").replace("/", "").replace("-", "").equals("66666666666666")
					|| cj.getCnpj().replace(".", "").replace("/", "").replace("-", "").equals("77777777777777")
					|| cj.getCnpj().replace(".", "").replace("/", "").replace("-", "").equals("88888888888888")
					|| cj.getCnpj().replace(".", "").replace("/", "").replace("-", "").equals("99999999999999")) {
				msg = msg + "CNPJ inválido\n";
			} else {
				char dig13, dig14;
				int sm, i, r, num, peso;

				try {
					sm = 0;
					peso = 2;
					for (i = 11; i >= 0; i--) {
						num = (int) (cj.getCnpj().replace(".", "").replace("/", "").replace("-", "").charAt(i) - 48);
						sm = sm + (num * peso);
						peso = peso + 1;
						if (peso == 10)
							peso = 2;
					}

					r = sm % 11;
					if ((r == 0) || (r == 1))
						dig13 = '0';
					else
						dig13 = (char) ((11 - r) + 48);

					sm = 0;
					peso = 2;
					for (i = 12; i >= 0; i--) {
						num = (int) (cj.getCnpj().replace(".", "").replace("/", "").replace("-", "").charAt(i) - 48);
						sm = sm + (num * peso);
						peso = peso + 1;
						if (peso == 10)
							peso = 2;
					}

					r = sm % 11;
					if ((r == 0) || (r == 1))
						dig14 = '0';
					else
						dig14 = (char) ((11 - r) + 48);

					if ((dig13 != cj.getCnpj().replace(".", "").replace("/", "").replace("-", "").charAt(12))
							|| (dig14 != cj.getCnpj().replace(".", "").replace("/", "").replace("-", "").charAt(13)))
						msg = msg + "CNPJ inválido\n";
				} catch (InputMismatchException erro) {
					JOptionPane.showMessageDialog(null, erro);
				}
			}
		}

		// Fim da Validação

		if (cj.getCnpj() == null) {
			msg = msg + "Informe o CPF\n";
		}
		//PESSOA
		if (cj.getNome() == null) {
			msg = msg + "Informe o Nome\n";
		}
		if (cj.getTelefone() == null) {
			msg = msg + "Informe o Telefone\n";
		}
		if (cj.getEmail() == null) {
			msg = msg + "Informe o Email\n";
		}
		if (cj.getDataNascimento() == null) {
			msg = msg + "Informe a Data de Nascimento\n";
		}
		//CLIENTE
		if (cj.getLimite() == null) {
			msg = msg + "Informe o Limite\n";
		}
		if (cj.getSaldo() == null) {
			msg = msg + "Informe o Saldo\n";
		}
		return msg;
	}
}
