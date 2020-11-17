package br.com.banco.gui;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.com.banco.Mascara;
import br.com.banco.Transporte;
import br.com.banco.controller.ClienteFisicoController;
import br.com.banco.gui.document.FloatDocument;
import br.com.banco.gui.document.NumberDocument;
import br.com.banco.gui.document.NumberDocumentMax;
import br.com.banco.gui.tablemodel.TableModelClienteFisico;
import br.com.banco.model.ClienteFisico;
import br.com.banco.model.Conta;
import br.com.banco.model.Endereco;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class JFrameClienteFisico extends JFrame {
	private JLabel lblClientesFisicos;
	private JLabel lblCpf;
	private JFormattedTextField txtCpf;
	private JLabel lblQtdeConsultas;
	private JTextField txtQtdeconsultas;
	private JLabel lblLimitePagamento;
	private JTextField txtLimitepagamento;

	public JPanelButton pnlButton;
	public JPanelPessoa pnlPessoa;
	public JPanelCliente pnlCliente;

	private JScrollPane scrollPane;
	private JTable tblClienteFisico;
	private List<ClienteFisico> list = new ArrayList<ClienteFisico>();
	private TableModelClienteFisico tblModelClienteFisico = new TableModelClienteFisico(list);

	private ClienteFisicoController cfc = new ClienteFisicoController();
	private Transporte tr = new Transporte();

	private static String envio = "";

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdfdb = new SimpleDateFormat("yyyy-MM-dd");

	public JFrameClienteFisico() {
		getContentPane().setLayout(null);
		getContentPane().add(getLblClientesFisicos());
		getContentPane().add(getLblCpf());
		getContentPane().add(getTxtCpf());
		getContentPane().add(getLblQtdeConsultas());
		getContentPane().add(getTxtQtdeconsultas());
		getContentPane().add(getLblLimitePagamento());
		getContentPane().add(getTxtLimitepagamento());

		getContentPane().add(getPnlButton());
		getContentPane().add(getPnlCliente());
		getContentPane().add(getPnlPessoa());

		getContentPane().add(getScrollPane());

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1024, 595);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	// CLIENTE FISICO
	private JLabel getLblClientesFisicos() {
		if (lblClientesFisicos == null) {
			lblClientesFisicos = new JLabel("CLIENTES FÍSICOS");
			lblClientesFisicos.setBounds(409, 12, 135, 15);
		}
		return lblClientesFisicos;
	}

	private JLabel getLblCpf() {
		if (lblCpf == null) {
			lblCpf = new JLabel("CPF:");
			lblCpf.setBounds(97, 294, 41, 15);
		}
		return lblCpf;
	}

	private JFormattedTextField getTxtCpf() {
		if (txtCpf == null) {
			txtCpf = new JFormattedTextField(Mascara.mascarar("###.###.###-##"));
			txtCpf.setBounds(136, 292, 150, 19);
			txtCpf.setColumns(10);
		}
		return txtCpf;
	}

	private JLabel getLblQtdeConsultas() {
		if (lblQtdeConsultas == null) {
			lblQtdeConsultas = new JLabel("Qtde. Consultas:");
			lblQtdeConsultas.setBounds(632, 292, 155, 15);
		}
		return lblQtdeConsultas;
	}

	private JTextField getTxtQtdeconsultas() {
		if (txtQtdeconsultas == null) {
			txtQtdeconsultas = new JTextField();
			txtQtdeconsultas.setDocument(new NumberDocument());
			txtQtdeconsultas.setBounds(792, 288, 92, 19);
			txtQtdeconsultas.setColumns(10);
		}
		return txtQtdeconsultas;
	}

	private JLabel getLblLimitePagamento() {
		if (lblLimitePagamento == null) {
			lblLimitePagamento = new JLabel("Limite Pagamento:");
			lblLimitePagamento.setBounds(304, 292, 155, 15);
		}
		return lblLimitePagamento;
	}

	private JTextField getTxtLimitepagamento() {
		if (txtLimitepagamento == null) {
			txtLimitepagamento = new JTextField();
			txtLimitepagamento.setDocument(new FloatDocument());
			txtLimitepagamento.setBounds(466, 290, 155, 19);
			txtLimitepagamento.setColumns(10);
		}
		return txtLimitepagamento;
	}

	// PANEL BUTTON
	private JPanelButton getPnlButton() {
		if (pnlButton == null) {
			pnlButton = new JPanelButton() {
				String envio = "";

				@Override
				public void salvar() {
					envio = "";
					ClienteFisico cf = preencherDados();
					String str = cfc.validar(cf);
					if (!str.equals("")) {
						JOptionPane.showMessageDialog(null, str);
					} else {

						envio = "s<>cf<>str<>";

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

						tr.enviar(envio);
						envio = "";

						if (cf.getId() > 0) {
							tblModelClienteFisico.onAdd(cf);
						} else {
							envio = "p<>cf<>str<>0<>";
							tr.enviar(envio);

							String[] conteudo = tr.receber();
							if (conteudo[0].equals("p")) {
								if (conteudo[1].equals("cf")) {
									if (conteudo[2].equals("str")) {
										cf.setId(Integer.parseInt(conteudo[conteudo.length - 15]));
									}
								}
							}
							tblModelClienteFisico.onAdd(cf);
						}
					}
					limpar();
				}

				@Override
				public void excluir() {
					if (tblClienteFisico.getSelectedRow() > -1) {
						tblModelClienteFisico.onRemove(tblClienteFisico.getSelectedRow());
						envio = "";
						envio = "e<>cf<>int<>" + pnlPessoa.txtId.getText() + "<>";
						tr.enviar(envio);
					}
				}

				@Override
				public void limpar() {
					// CLIENTE FISICO
					txtCpf.setText("");
					txtQtdeconsultas.setText("");
					txtLimitepagamento.setText("");
					// PESSOA
					pnlPessoa.txtId.setText("");
					pnlPessoa.txtNome.setText("");
					pnlPessoa.txtTelefone.setText("");
					pnlPessoa.txtEmail.setText("");
					pnlPessoa.dtcDataNascimento.setCalendar(null);
					pnlPessoa.txtIdendereco.setText("");
					// CLIENTE
					pnlCliente.txtLimite.setText("");
					pnlCliente.txtSaldo.setText("");
					pnlCliente.chckbxDireitocheque.setSelected(false);
					pnlCliente.chckbxCartaocredito.setSelected(false);
					pnlCliente.txtIdConta.setText("");
					if(tblClienteFisico.getSelectedRow() > -1) {
						tblClienteFisico.clearSelection();
					}
				}

			};
			pnlButton.setBounds(243, 321, 476, 50);
		}
		return pnlButton;
	}

	private JPanelPessoa getPnlPessoa() {
		if (pnlPessoa == null) {
			pnlPessoa = new JPanelPessoa() {
				public void editarEndereco() {
					JFrameEndereco janelaEndereco = new JFrameEndereco();
				};

			};
			pnlPessoa.setBounds(12, 38, 982, 125);
		}

		return pnlPessoa;
	}

	private JPanelCliente getPnlCliente() {
		if (pnlCliente == null) {
			pnlCliente = new JPanelCliente() {
				public void editarConta() {
					JFrameConta janelaConta = new JFrameConta();
				};

			};
			pnlCliente.setBounds(12, 175, 982, 101);
		}

		return pnlCliente;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 378, 982, 174);
			scrollPane.setViewportView(getTblClienteFisico());
		}
		return scrollPane;
	}

	private JTable getTblClienteFisico() {
		if (tblClienteFisico == null) {
			tblClienteFisico = new JTable();
			tblClienteFisico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblClienteFisico.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					if (e.getValueIsAdjusting()) {
						return;
					}
					if (tblClienteFisico.getSelectedRow() < 0) {
						return;
					}
					ClienteFisico cf = tblModelClienteFisico.getValue(tblClienteFisico.getSelectedRow());
					mostrar(cf);
				}
			});
			tblClienteFisico.setModel(tblModelClienteFisico);

			envio = "p<>cf<>str<>0<>";

			tr.enviar(envio);
			String[] conteudo = tr.receber();
			if (conteudo[0].equals("p")) {
				if (conteudo[1].equals("cf")) {
					if (conteudo[2].equals("str")) {
						for (int i = 3; i < conteudo.length - 1; i = i + 14) {
							ClienteFisico cf = new ClienteFisico();
							Endereco en = new Endereco();
							Conta c = new Conta();
							// PESSOA
							cf.setId(Integer.parseInt(conteudo[i]));
							cf.setNome(conteudo[i + 1]);
							cf.setTelefone(conteudo[i + 2]);
							cf.setEmail(conteudo[i + 3]);
							java.util.Date data = null;
							try {
								data = sdfdb.parse(conteudo[i + 4]);
							} catch (ParseException e) {
								e.printStackTrace();
							}
							cf.setDataNascimento(sdf.format(data));

							en.setId(Integer.parseInt(conteudo[i + 5]));
							cf.setEndereco(en);
							// CLIENTE
							cf.setLimite(new BigDecimal(conteudo[i + 6]));
							cf.setSaldo(new BigDecimal(conteudo[i + 7]));
							cf.setDireitoCheque(conteudo[i + 8].equals("false") ? false : true);
							cf.setCartaoCredito(conteudo[i + 9].equals("false") ? false : true);
							c.setId(Integer.parseInt(conteudo[i + 10]));
							cf.setConta(c);
							// CLIENTE FISICO
							cf.setCpf(conteudo[i + 11]);
							cf.setQtdeLimiteConsultas(Integer.parseInt(conteudo[i + 12]));
							cf.setLimitePagamento(new BigDecimal(conteudo[i + 13]));
							tblModelClienteFisico.onAdd(cf);

						}

					}
				}
			}

		}
		return tblClienteFisico;
	}

	private void mostrar(ClienteFisico cf) {
		// CLIENTE FISICO
		txtCpf.setText(String.valueOf(cf.getCpf()));
		txtQtdeconsultas.setText(String.valueOf(cf.getQtdeLimiteConsultas()));
		txtLimitepagamento.setText(String.valueOf(cf.getLimitePagamento()));
		// PESSOA
		pnlPessoa.txtId.setText(String.valueOf(cf.getId()));
		pnlPessoa.txtNome.setText(String.valueOf(cf.getNome()));
		pnlPessoa.txtTelefone.setText(String.valueOf(cf.getTelefone()));
		pnlPessoa.txtEmail.setText(String.valueOf(cf.getEmail()));
		java.util.Date data = null;
		try {
			data = sdf.parse(cf.getDataNascimento());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		pnlPessoa.dtcDataNascimento.setDate(data);
		pnlPessoa.txtIdendereco.setText(String.valueOf(cf.getEndereco().getId()));
		// CLIENTES
		pnlCliente.txtLimite.setText(String.valueOf(cf.getLimite()));
		pnlCliente.txtSaldo.setText(String.valueOf(cf.getSaldo()));
		pnlCliente.chckbxCartaocredito.setSelected(cf.isCartaoCredito());
		pnlCliente.chckbxDireitocheque.setSelected(cf.isDireitoCheque());
		pnlCliente.txtIdConta.setText(String.valueOf(cf.getConta().getId()));
	}

	private ClienteFisico preencherDados() {
		ClienteFisico cf;
		Endereco en = new Endereco();
		Conta c = new Conta();

		if (tblClienteFisico.getSelectedRow() > -1) {
			cf = tblModelClienteFisico.getValue(tblClienteFisico.getSelectedRow());
		} else {
			cf = new ClienteFisico();
		}
		// PESSOA
		cf.setId(pnlPessoa.txtId.getText().isEmpty() ? 0 : Integer.parseInt(pnlPessoa.txtId.getText()));
		cf.setNome(pnlPessoa.txtNome.getText().isEmpty() ? null : pnlPessoa.txtNome.getText());
		cf.setTelefone(
				pnlPessoa.txtTelefone.getText().equals("(  )     -    ") ? null : pnlPessoa.txtTelefone.getText());
		cf.setEmail(pnlPessoa.txtEmail.getText().isEmpty() ? null : pnlPessoa.txtEmail.getText());
		cf.setDataNascimento(pnlPessoa.dtcDataNascimento.getCalendar() == null ? null
				: new String(sdf.format(pnlPessoa.dtcDataNascimento.getDate())));
		en.setId(pnlPessoa.txtIdendereco.getText().isEmpty() ? 0 : Integer.parseInt(pnlPessoa.txtIdendereco.getText()));
		cf.setEndereco(en);
		// CLIENTE
		cf.setLimite(pnlCliente.txtLimite.getText().isEmpty() ? null
				: new BigDecimal(pnlCliente.txtLimite.getText().replace(",", ".")));
		cf.setSaldo(pnlCliente.txtSaldo.getText().isEmpty() ? null
				: new BigDecimal(pnlCliente.txtSaldo.getText().replace(",", ".")));
		cf.setDireitoCheque(pnlCliente.chckbxDireitocheque.isSelected());
		cf.setCartaoCredito(pnlCliente.chckbxCartaocredito.isSelected());
		c.setId(pnlCliente.txtIdConta.getText().isEmpty() ? 0 : Integer.parseInt(pnlCliente.txtIdConta.getText()));
		cf.setConta(c);
		// CLIENTE FISICO
		cf.setCpf(txtCpf.getText().equals("   .   .   -  ") ? null : txtCpf.getText());
		cf.setQtdeLimiteConsultas(
				txtQtdeconsultas.getText().isEmpty() ? 0 : Integer.parseInt(txtQtdeconsultas.getText()));
		cf.setLimitePagamento(txtLimitepagamento.getText().isEmpty() ? null
				: new BigDecimal(txtLimitepagamento.getText().replace(",", ".")));

		return cf;
	}
}
