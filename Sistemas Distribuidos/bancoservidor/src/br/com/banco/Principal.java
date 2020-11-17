package br.com.banco;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.banco.controller.ClienteFisicoController;
import br.com.banco.controller.ClienteJuridicoController;
import br.com.banco.controller.ContaController;
import br.com.banco.controller.EnderecoController;
import br.com.banco.controller.FuncionarioController;
import br.com.banco.dao.ClienteFisicoDAO;
import br.com.banco.dao.ClienteJuridicoDAO;
import br.com.banco.dao.ContaDAO;
import br.com.banco.dao.EnderecoDAO;
import br.com.banco.dao.FuncionarioDAO;
import br.com.banco.model.ClienteFisico;
import br.com.banco.model.ClienteJuridico;
import br.com.banco.model.Conta;
import br.com.banco.model.Endereco;
import br.com.banco.model.Funcionario;

public class Principal {
	private static Transporte tr = new Transporte();
	private static ContaController cc = new ContaController();
	private static EnderecoController enc = new EnderecoController();
	private static ClienteFisicoController cfc = new ClienteFisicoController();
	private static ClienteJuridicoController cjc = new ClienteJuridicoController();
	private static FuncionarioController fc = new FuncionarioController();

	public static void main(String[] args) throws IOException {

		String[] conteudo;
		ServerSocket ss = new ServerSocket(8888);

		while (true) {

			conteudo = tr.receber(ss);
			// i == Salvar
			if (conteudo[0].equals("s")) {
				salvar(conteudo);
			}

			// e == Excluir
			if (conteudo[0].equals("e")) {
				excluir(conteudo);
			}

			if (conteudo[0].equals("p")) {
				pesquisar(conteudo);
			}
		}

	}

	private static void salvar(String[] conteudo) {
		// 1 == Conta
		if (conteudo[1].equals("c")) {
			if (conteudo[2].equals("str")) {
				Conta c = new Conta();
				c.setId(Integer.parseInt(conteudo[3]));
				c.setTaxaManutencao(new BigDecimal(conteudo[4]));
				c.setAgencia(conteudo[5]);
				c.setTipoConta(Integer.parseInt(conteudo[6]));
				String err = cc.validar(c);
				if (!err.equals("")) {
					JOptionPane.showMessageDialog(null, err);
				} else {
					new ContaDAO().salvar(c);
				}
			}
		}
		// 2 == Endereço
		if (conteudo[1].equals("en")) {
			if (conteudo[2].equals("str")) {
				Endereco en = new Endereco();
				en.setId(Integer.parseInt(conteudo[3]));
				en.setLogradouro(conteudo[4]);
				en.setNumero(conteudo[5]);
				en.setComplemento(conteudo[6]);
				en.setBairro(conteudo[7]);
				en.setCidade(conteudo[8]);
				en.setUf(Integer.parseInt(conteudo[9]));
				String err = enc.validar(en);
				if (!err.equals("")) {
					JOptionPane.showMessageDialog(null, err);
				} else {
					new EnderecoDAO().salvar(en);
				}
			}
		}
		// 3 == Cliente Fisico
		if (conteudo[1].equals("cf")) {
			if (conteudo[2].equals("str")) {
				ClienteFisico cf = new ClienteFisico();
				Endereco en = new Endereco();
				Conta c = new Conta();
				// PESSOA
				cf.setId(Integer.parseInt(conteudo[3]));
				cf.setNome(conteudo[4]);
				cf.setTelefone(conteudo[5]);
				cf.setEmail(conteudo[6]);
				cf.setDataNascimento(conteudo[7]);
				en.setId(Integer.parseInt(conteudo[8]));
				cf.setEndereco(en);
				// CLIENTE
				cf.setLimite(new BigDecimal(conteudo[9]));
				cf.setSaldo(new BigDecimal(conteudo[10]));
				cf.setDireitoCheque(conteudo[11].equals("false") ? false : true);
				cf.setCartaoCredito(conteudo[12].equals("false") ? false : true);
				c.setId(Integer.parseInt(conteudo[13]));
				cf.setConta(c);
				// CLIENTE FISICO
				cf.setCpf(conteudo[14]);
				cf.setQtdeLimiteConsultas(Integer.parseInt(conteudo[15]));
				cf.setLimitePagamento(new BigDecimal(conteudo[16]));
				String err = cfc.validar(cf);
				if (!err.equals("")) {
					JOptionPane.showMessageDialog(null, err);
				} else {
					new ClienteFisicoDAO().salvar(cf);
				}
			}
		}
		// 4 == cliente juridico
		if (conteudo[1].equals("cj")) {
			if (conteudo[2].equals("str")) {
				ClienteJuridico cj = new ClienteJuridico();
				Endereco en = new Endereco();
				Conta c = new Conta();
				// PESSOA
				cj.setId(Integer.parseInt(conteudo[3]));
				cj.setNome(conteudo[4]);
				cj.setTelefone(conteudo[5]);
				cj.setEmail(conteudo[6]);
				cj.setDataNascimento(conteudo[7]);
				en.setId(Integer.parseInt(conteudo[8]));
				cj.setEndereco(en);
				// CLIENTE
				cj.setLimite(new BigDecimal(conteudo[9]));
				cj.setSaldo(new BigDecimal(conteudo[10]));
				cj.setDireitoCheque(conteudo[11].equals("false") ? false : true);
				cj.setCartaoCredito(conteudo[12].equals("false") ? false : true);
				c.setId(Integer.parseInt(conteudo[13]));
				cj.setConta(c);
				// CLIENTE FISICO
				cj.setCnpj(conteudo[14]);
				String err = cjc.validar(cj);
				if (!err.equals("")) {
					JOptionPane.showMessageDialog(null, err);
				} else {
					new ClienteJuridicoDAO().salvar(cj);
				}
			}
		}
		// 5 == Funcionario
		if (conteudo[1].equals("f")) {
			if (conteudo[2].equals("str")) {
				Funcionario f = new Funcionario();
				Endereco en = new Endereco();
				// PESSOA
				f.setId(Integer.parseInt(conteudo[3]));
				f.setNome(conteudo[4]);
				f.setTelefone(conteudo[5]);
				f.setEmail(conteudo[6]);
				f.setDataNascimento(conteudo[7]);
				en.setId(Integer.parseInt(conteudo[8]));
				f.setEndereco(en);
				// FUNCIONARIO
				f.setCpf(conteudo[9]);
				f.setSalario(new BigDecimal(conteudo[10]));
				f.setCargo(conteudo[11]);
				String err = fc.validar(f);
				if (!err.equals("")) {
					JOptionPane.showMessageDialog(null, err);
				} else {
					new FuncionarioDAO().salvar(f);
				}
			}
		}

	}

	private static void excluir(String[] conteudo) {
		// c == Conta
		if (conteudo[1].equals("c")) {
			if (conteudo[2].equals("int")) {
				new ContaDAO().excluir(Integer.parseInt(conteudo[3]));
			}
		}
		// en == Endereço
		if (conteudo[1].equals("en")) {
			if (conteudo[2].equals("int")) {
				new EnderecoDAO().excluir(Integer.parseInt(conteudo[3]));
			}
		}
		// cf == Cliente Fisico
		if (conteudo[1].equals("cf")) {
			if (conteudo[2].equals("int")) {
				new ClienteFisicoDAO().excluir(Integer.parseInt(conteudo[3]));
			}
		}
		// cj == cliente juridico
		if (conteudo[1].equals("cj")) {
			if (conteudo[2].equals("int")) {
				new ClienteJuridicoDAO().excluir(Integer.parseInt(conteudo[3]));
			}
		}
		// cf == Funcionario
		if (conteudo[1].equals("f")) {
			if (conteudo[2].equals("int")) {
				new FuncionarioDAO().excluir(Integer.parseInt(conteudo[3]));
			}
		}
	}

	public static void pesquisar(String[] conteudo) {
		String envio = "";
		// c == Conta
		if (conteudo[1].equals("c")) {
			if (conteudo[2].equals("str")) {
				envio = "p<>c<>str<>";
				if (Integer.parseInt(conteudo[3]) > 0) {
					Conta c = new Conta();
					c = new ContaDAO().pesquisar(Integer.parseInt(conteudo[3]));

					envio += c.getId() + "<>";
					envio += c.getTaxaManutencao() + "<>";
					envio += c.getAgencia() + "<>";
					envio += c.getTipoConta() + "<>";
				} else {
					List<Conta> list = new ArrayList<Conta>();
					list = new ContaDAO().pesquisar();

					for (Conta c : list) {
						envio += c.getId() + "<>";
						envio += c.getTaxaManutencao() + "<>";
						envio += c.getAgencia() + "<>";
						envio += c.getTipoConta() + "<>";
					}
				}
				tr.enviar(envio);
				return;
			}
		}

		// en == Endereco
		if (conteudo[1].equals("en")) {
			if (conteudo[2].equals("str")) {
				envio = "p<>en<>str<>";
				if (Integer.parseInt(conteudo[3]) > 0) {
					Endereco en = new Endereco();
					en = new EnderecoDAO().pesquisar(Integer.parseInt(conteudo[3]));

					envio += en.getId() + "<>";
					envio += en.getLogradouro() + "<>";
					envio += en.getNumero() + "<>";
					envio += en.getComplemento() + "<>";
					envio += en.getBairro() + "<>";
					envio += en.getCidade() + "<>";
					envio += en.getUf() + "<>";
				} else {
					List<Endereco> list = new ArrayList<Endereco>();
					list = new EnderecoDAO().pesquisar();

					for (Endereco en : list) {
						envio += en.getId() + "<>";
						envio += en.getLogradouro() + "<>";
						envio += en.getNumero() + "<>";
						envio += en.getComplemento() + "<>";
						envio += en.getBairro() + "<>";
						envio += en.getCidade() + "<>";
						envio += en.getUf() + "<>";
					}
				}
				tr.enviar(envio);
				return;
			}
		}

		// cf == Cliente Fisico
		if (conteudo[1].equals("cf")) {
			if (conteudo[2].equals("str")) {
				envio = "p<>cf<>str<>";
				if (Integer.parseInt(conteudo[3]) > 0) {
					ClienteFisico cf = new ClienteFisico();
					cf = new ClienteFisicoDAO().pesquisar(Integer.parseInt(conteudo[3]));

					// PESSOA
					envio += cf.getId() + "<>";
					envio += cf.getNome() + "<>";
					envio += cf.getTelefone() + "<>";
					envio += cf.getEmail() + "<>";
					envio += cf.getDataNascimento() + "<>";
					envio += cf.getEndereco().getId() + "<>";
					// CLIENTE
					envio += cf.getLimite() + "<>";
					envio += cf.getSaldo() + "<>";
					envio += cf.isDireitoCheque() + "<>";
					envio += cf.isCartaoCredito() + "<>";
					envio += cf.getConta().getId() + "<>";

					// CLIENTE FISICO
					envio += cf.getCpf() + "<>";
					envio += cf.getQtdeLimiteConsultas() + "<>";
					envio += cf.getLimitePagamento() + "<>";
				} else {
					List<ClienteFisico> list = new ArrayList<ClienteFisico>();
					list = new ClienteFisicoDAO().pesquisar();

					for (ClienteFisico cf : list) {
						// PESSOA
						envio += cf.getId() + "<>";
						envio += cf.getNome() + "<>";
						envio += cf.getTelefone() + "<>";
						envio += cf.getEmail() + "<>";
						envio += cf.getDataNascimento() + "<>";
						envio += cf.getEndereco().getId() + "<>";
						// CLIENTE
						envio += cf.getLimite() + "<>";
						envio += cf.getSaldo() + "<>";
						envio += cf.isDireitoCheque() + "<>";
						envio += cf.isCartaoCredito() + "<>";
						envio += cf.getConta().getId() + "<>";

						// CLIENTE FISICO
						envio += cf.getCpf() + "<>";
						envio += cf.getQtdeLimiteConsultas() + "<>";
						envio += cf.getLimitePagamento() + "<>";
					}
				}
				tr.enviar(envio);
				return;
			}
		}

		// cj == Cliente Juridico
		if (conteudo[1].equals("cj")) {
			if (conteudo[2].equals("str")) {
				envio = "p<>cj<>str<>";
				if (Integer.parseInt(conteudo[3]) > 0) {
					ClienteJuridico cj = new ClienteJuridico();
					cj = new ClienteJuridicoDAO().pesquisar(Integer.parseInt(conteudo[3]));

					// PESSOA
					envio += cj.getId() + "<>";
					envio += cj.getNome() + "<>";
					envio += cj.getTelefone() + "<>";
					envio += cj.getEmail() + "<>";
					envio += cj.getDataNascimento() + "<>";
					envio += cj.getEndereco().getId() + "<>";
					// CLIENTE
					envio += cj.getLimite() + "<>";
					envio += cj.getSaldo() + "<>";
					envio += cj.isDireitoCheque() + "<>";
					envio += cj.isCartaoCredito() + "<>";
					envio += cj.getConta().getId() + "<>";
					// CLIENTE JURIDICO
					envio += cj.getCnpj() + "<>";

				} else {
					List<ClienteJuridico> list = new ArrayList<ClienteJuridico>();
					list = new ClienteJuridicoDAO().pesquisar();

					for (ClienteJuridico cj : list) {
						// PESSOA
						envio += cj.getId() + "<>";
						envio += cj.getNome() + "<>";
						envio += cj.getTelefone() + "<>";
						envio += cj.getEmail() + "<>";
						envio += cj.getDataNascimento() + "<>";
						envio += cj.getEndereco().getId() + "<>";
						// CLIENTE
						envio += cj.getLimite() + "<>";
						envio += cj.getSaldo() + "<>";
						envio += cj.isDireitoCheque() + "<>";
						envio += cj.isCartaoCredito() + "<>";
						envio += cj.getConta().getId() + "<>";
						// CLIENTE JURIDICO
						envio += cj.getCnpj() + "<>";
					}
				}
				tr.enviar(envio);
				return;
			}
		}

		// f == Funcionario
		if (conteudo[1].equals("f")) {
			if (conteudo[2].equals("str")) {
				envio = "p<>f<>str<>";
				if (Integer.parseInt(conteudo[3]) > 0) {
					Funcionario f = new Funcionario();
					f = new FuncionarioDAO().pesquisar(Integer.parseInt(conteudo[3]));

					// PESSOA
					envio += f.getId() + "<>";
					envio += f.getNome() + "<>";
					envio += f.getTelefone() + "<>";
					envio += f.getEmail() + "<>";
					envio += f.getDataNascimento() + "<>";
					envio += f.getEndereco().getId() + "<>";
					// FUNCIONARIO
					envio += f.getCpf() + "<>";
					envio += f.getSalario() + "<>";
					envio += f.getCargo() + "<>";

				} else {
					List<Funcionario> list = new ArrayList<Funcionario>();
					list = new FuncionarioDAO().pesquisar();

					for (Funcionario f : list) {
						// PESSOA
						envio += f.getId() + "<>";
						envio += f.getNome() + "<>";
						envio += f.getTelefone() + "<>";
						envio += f.getEmail() + "<>";
						envio += f.getDataNascimento() + "<>";
						envio += f.getEndereco().getId() + "<>";
						// FUNCIONARIO
						envio += f.getCpf() + "<>";
						envio += f.getSalario() + "<>";
						envio += f.getCargo() + "<>";
					}
				}
				tr.enviar(envio);
				return;
			}
		}
	}
}