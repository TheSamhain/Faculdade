package br.com.banco.controller;

import java.text.SimpleDateFormat;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

import br.com.banco.model.ClienteFisico;
import br.com.banco.model.Conta;

public class ClienteFisicoController {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public String validar(ClienteFisico cf) {
		String msg = "";
		//CLIENTE FISICO
		if (cf.getCpf() != null) {
			// VALIDAÇÂO DE CPF
			// Código retirado de
			// https://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097

			if (cf.getCpf().replace(".", "").replace("-", "").equals("00000000000")
					|| cf.getCpf().replace(".", "").replace("-", "").equals("11111111111")
					|| cf.getCpf().replace(".", "").replace("-", "").equals("22222222222")
					|| cf.getCpf().replace(".", "").replace("-", "").equals("33333333333")
					|| cf.getCpf().replace(".", "").replace("-", "").equals("44444444444")
					|| cf.getCpf().replace(".", "").replace("-", "").equals("55555555555")
					|| cf.getCpf().replace(".", "").replace("-", "").equals("66666666666")
					|| cf.getCpf().replace(".", "").replace("-", "").equals("77777777777")
					|| cf.getCpf().replace(".", "").replace("-", "").equals("88888888888")
					|| cf.getCpf().replace(".", "").replace("-", "").equals("99999999999")) {
				msg = msg + "CPF Inválido\n";
			} else {

				char dig10, dig11;
				int sm, i, r, num, peso;

				try {
					sm = 0;
					peso = 10;
					for (i = 0; i < 9; i++) {
						num = (int) (cf.getCpf().replace(".", "").replace("-", "").charAt(i) - 48);
						sm = sm + (num * peso);
						peso = peso - 1;
					}

					r = 11 - (sm % 11);
					if ((r == 10) || (r == 11))
						dig10 = '0';
					else
						dig10 = (char) (r + 48);
					sm = 0;
					peso = 11;
					for (i = 0; i < 10; i++) {
						num = (int) (cf.getCpf().replace(".", "").replace("-", "").charAt(i) - 48);
						sm = sm + (num * peso);
						peso = peso - 1;
					}

					r = 11 - (sm % 11);
					if ((r == 10) || (r == 11))
						dig11 = '0';
					else
						dig11 = (char) (r + 48);

					if ((dig10 != cf.getCpf().replace(".", "").replace("-", "").charAt(9))
							|| (dig11 != cf.getCpf().replace(".", "").replace("-", "").charAt(10)))
						msg = msg + "CPF inválido\n";
				} catch (InputMismatchException erro) {
					JOptionPane.showMessageDialog(null, erro);
				}
			}
		}
		// Fim da validacao

		if (cf.getCpf() == null) {
			msg = msg + "Informe o CPF\n";
		}

		if (cf.getQtdeLimiteConsultas() == null) {
			msg = msg + "Informe a quantidade limite de consultas\n";
		}
		if (cf.getLimitePagamento() == null) {
			msg = msg + "Informe o Limite de Pagamento\n";
		}
		//PESSOA
		if (cf.getNome() == null) {
			msg = msg + "Informe o Nome\n";
		}
		if (cf.getTelefone() == null) {
			msg = msg + "Informe o Telefone\n";
		}
		if (cf.getEmail() == null) {
			msg = msg + "Informe o Email\n";
		}
		if (cf.getDataNascimento() == null) {
			msg = msg + "Informe a Data de Nascimento\n";
		}
		//CLIENTE
		if (cf.getLimite() == null) {
			msg = msg + "Informe o Limite\n";
		}
		if (cf.getSaldo() == null) {
			msg = msg + "Informe o Saldo\n";
		}
		return msg;
	}
}