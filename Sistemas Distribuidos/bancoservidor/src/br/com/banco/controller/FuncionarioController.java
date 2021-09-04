package br.com.banco.controller;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

import br.com.banco.model.Funcionario;

public class FuncionarioController {
	public String validar(Funcionario f) {
		String msg = "";
		
		//FUNCIONARIO
		if (f.getCpf() != null) {
			// VALIDAÇÂO DE CPF
			// Código retirado de
			// https://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097

			if (f.getCpf().replace(".", "").replace("-", "").equals("00000000000")
					|| f.getCpf().replace(".", "").replace("-", "").equals("11111111111")
					|| f.getCpf().replace(".", "").replace("-", "").equals("22222222222")
					|| f.getCpf().replace(".", "").replace("-", "").equals("33333333333")
					|| f.getCpf().replace(".", "").replace("-", "").equals("44444444444")
					|| f.getCpf().replace(".", "").replace("-", "").equals("55555555555")
					|| f.getCpf().replace(".", "").replace("-", "").equals("66666666666")
					|| f.getCpf().replace(".", "").replace("-", "").equals("77777777777")
					|| f.getCpf().replace(".", "").replace("-", "").equals("88888888888")
					|| f.getCpf().replace(".", "").replace("-", "").equals("99999999999")) {
				msg = msg + "CPF Inválido\n";
			} else {

				char dig10, dig11;
				int sm, i, r, num, peso;

				try {
					sm = 0;
					peso = 10;
					for (i = 0; i < 9; i++) {
						num = (int) (f.getCpf().replace(".", "").replace("-", "").charAt(i) - 48);
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
						num = (int) (f.getCpf().replace(".", "").replace("-", "").charAt(i) - 48);
						sm = sm + (num * peso);
						peso = peso - 1;
					}

					r = 11 - (sm % 11);
					if ((r == 10) || (r == 11))
						dig11 = '0';
					else
						dig11 = (char) (r + 48);

					if ((dig10 != f.getCpf().replace(".", "").replace("-", "").charAt(9))
							|| (dig11 != f.getCpf().replace(".", "").replace("-", "").charAt(10)))
						msg = msg + "CPF inválido\n";
				} catch (InputMismatchException erro) {
					JOptionPane.showMessageDialog(null, erro);
				}
			}
		}
		// Fim da validacao
		if (f.getCpf() == null) {
			msg = msg + "Informe o CPF\n";
		}
		if (f.getSalario() == null) {
			msg = msg + "Informe o CPF\n";
		}
		if (f.getCargo() == null) {
			msg = msg + "Informe o CPF\n";
		}
		//PESSOA
		if (f.getNome() == null) {
			msg = msg + "Informe o Nome\n";
		}
		if (f.getTelefone() == null) {
			msg = msg + "Informe o Telefone\n";
		}
		if (f.getEmail() == null) {
			msg = msg + "Informe o Email\n";
		}
		if (f.getDataNascimento() == null) {
			msg = msg + "Informe a Data de Nascimento\n";
		}
		return msg;
	}
}
