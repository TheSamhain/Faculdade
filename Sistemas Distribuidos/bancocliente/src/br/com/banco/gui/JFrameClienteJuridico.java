package br.com.banco.gui;

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
import br.com.banco.controller.ClienteJuridicoController;
import br.com.banco.controller.ClienteJuridicoController;
import br.com.banco.gui.document.NumberDocument;
import br.com.banco.gui.document.NumberDocumentMax;
import br.com.banco.gui.tablemodel.TableModelClienteJuridico;
import br.com.banco.gui.tablemodel.TableModelClienteJuridico;
import br.com.banco.model.ClienteJuridico;
import br.com.banco.model.Conta;
import br.com.banco.model.Endereco;
import br.com.banco.model.ClienteJuridico;
import br.com.banco.model.ClienteJuridico;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JButton;

public class JFrameClienteJuridico extends JFrame {
	private JLabel lblClientesJuridicos;
	private JLabel lblCnpj;
	private JFormattedTextField txtCnpj;

	public JPanelButton pnlButton;
	public JPanelPessoa pnlPessoa;
	public JPanelCliente pnlCliente;

	private JScrollPane scrollPane;
	private JTable tblClienteJuridico;
	private List<ClienteJuridico> list = new ArrayList<ClienteJuridico>();
	private TableModelClienteJuridico tblModelClienteJuridico = new TableModelClienteJuridico(list);

	private ClienteJuridicoController cjc = new ClienteJuridicoController();
	private Transporte tr = new Transporte();

	private static String envio = "";

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdfdb = new SimpleDateFormat("yyyy-MM-dd");

	public JFrameClienteJuridico() {
		getContentPane().setLayout(null);
		getContentPane().add(getLblCnpj());
		getContentPane().add(getTxtCnpj());

		getContentPane().add(getPnlButton());
		getContentPane().add(getPnlPessoa());
		getContentPane().add(getPnlCliente());
		getContentPane().add(getLblClientesJuridicos());

		getContentPane().add(getScrollPane());

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1016, 587);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private JLabel getLblClientesJuridicos() {
		if (lblClientesJuridicos == null) {
			lblClientesJuridicos = new JLabel("CLIENTES JURÍDICOS");
			lblClientesJuridicos.setBounds(389, 11, 151, 15);
		}
		return lblClientesJuridicos;
	}

	private JLabel getLblCnpj() {
		if (lblCnpj == null) {
			lblCnpj = new JLabel("Cnpj:");
			lblCnpj.setBounds(366, 289, 65, 15);
		}
		return lblCnpj;
	}

	private JFormattedTextField getTxtCnpj() {
		if (txtCnpj == null) {
			txtCnpj = new JFormattedTextField(Mascara.mascarar("##.###.###/####-##"));
			txtCnpj.setBounds(428, 287, 164, 19);
			txtCnpj.setColumns(10);
		}
		return txtCnpj;
	}

	private JPanelButton getPnlButton() {
		if (pnlButton == null) {
			pnlButton = new JPanelButton() {
				String envio = "";

				@Override
				public void salvar() {
					envio = "";
					ClienteJuridico cj = preencherDados();
					String str = cjc.validar(cj);
					if (!str.equals("")) {
						JOptionPane.showMessageDialog(null, str);
					} else {

						envio = "s<>cj<>str<>";

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

						tr.enviar(envio);
						envio = "";

						if (cj.getId() > 0) {
							tblModelClienteJuridico.onAdd(cj);
						} else {
							envio = "p<>cj<>str<>0<>";
							tr.enviar(envio);

							String[] conteudo = tr.receber();
							if (conteudo[0].equals("p")) {
								if (conteudo[1].equals("cj")) {
									if (conteudo[2].equals("str")) {
										cj.setId(Integer.parseInt(conteudo[conteudo.length - 13]));
									}
								}
							}
							tblModelClienteJuridico.onAdd(cj);
						}
					}
					limpar();
				}

				@Override
				public void excluir() {
					if (tblClienteJuridico.getSelectedRow() > -1) {
						tblModelClienteJuridico.onRemove(tblClienteJuridico.getSelectedRow());
						envio = "";
						envio = "e<>cj<>int<>" + pnlPessoa.txtId.getText() + "<>";
						tr.enviar(envio);
					}
				}

				@Override
				public void limpar() {
					// CLIENTE JURIDICO
					txtCnpj.setText("");
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
					if(tblClienteJuridico.getSelectedRow() > -1) {
						tblClienteJuridico.clearSelection();
					}
				}

			};
			pnlButton.setBounds(229, 316, 476, 50);
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
			pnlPessoa.setBounds(12, 38, 982, 123);
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
			pnlCliente.setBounds(12, 173, 982, 104);
		}

		return pnlCliente;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 374, 982, 174);
			scrollPane.setViewportView(getTblClienteJuridico());
		}
		return scrollPane;
	}

	private JTable getTblClienteJuridico() {
		if (tblClienteJuridico == null) {
			tblClienteJuridico = new JTable();
			tblClienteJuridico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblClienteJuridico.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					if (e.getValueIsAdjusting()) {
						return;
					}
					if (tblClienteJuridico.getSelectedRow() < 0) {
						return;
					}
					ClienteJuridico cj = tblModelClienteJuridico.getValue(tblClienteJuridico.getSelectedRow());
					mostrar(cj);
				}
			});
			tblClienteJuridico.setModel(tblModelClienteJuridico);

			envio = "p<>cj<>str<>0<>";

			tr.enviar(envio);
			String[] conteudo = tr.receber();
			if (conteudo[0].equals("p")) {
				if (conteudo[1].equals("cj")) {
					if (conteudo[2].equals("str")) {
						for (int i = 3; i < conteudo.length - 1; i = i + 12) {
							ClienteJuridico cj = new ClienteJuridico();
							Endereco en = new Endereco();
							Conta c = new Conta();
							// PESSOA
							cj.setId(Integer.parseInt(conteudo[i]));
							cj.setNome(conteudo[i + 1]);
							cj.setTelefone(conteudo[i + 2]);
							cj.setEmail(conteudo[i + 3]);
							java.util.Date data = null;
							try {
								data = sdfdb.parse(conteudo[i + 4]);
							} catch (ParseException e) {
								e.printStackTrace();
							}
							cj.setDataNascimento(sdf.format(data));
							en.setId(Integer.parseInt(conteudo[i + 5]));
							cj.setEndereco(en);
							// CLIENTE
							cj.setLimite(new BigDecimal(conteudo[i + 6]));
							cj.setSaldo(new BigDecimal(conteudo[i + 7]));
							cj.setDireitoCheque(conteudo[i + 8].equals("false") ? false : true);
							cj.setCartaoCredito(conteudo[i + 9].equals("false") ? false : true);
							c.setId(Integer.parseInt(conteudo[i + 10]));
							cj.setConta(c);
							// CLIENTE FISICO
							cj.setCnpj(conteudo[i + 11]);
							tblModelClienteJuridico.onAdd(cj);

						}

					}
				}
			}

		}
		return tblClienteJuridico;
	}

	private void mostrar(ClienteJuridico cj) {
		// CLIENTE JURIDICO
		txtCnpj.setText(String.valueOf(cj.getCnpj()));
		// PESSOA
		pnlPessoa.txtId.setText(String.valueOf(cj.getId()));
		pnlPessoa.txtNome.setText(String.valueOf(cj.getNome()));
		pnlPessoa.txtTelefone.setText(String.valueOf(cj.getTelefone()));
		pnlPessoa.txtEmail.setText(String.valueOf(cj.getEmail()));
		java.util.Date data = null;
		try {
			data = sdf.parse(cj.getDataNascimento());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		pnlPessoa.dtcDataNascimento.setDate(data);
		pnlPessoa.txtIdendereco.setText(String.valueOf(cj.getEndereco().getId()));
		// CLIENTE
		pnlCliente.txtLimite.setText(String.valueOf(cj.getLimite()));
		pnlCliente.txtSaldo.setText(String.valueOf(cj.getSaldo()));
		pnlCliente.chckbxCartaocredito.setSelected(cj.isCartaoCredito());
		pnlCliente.chckbxDireitocheque.setSelected(cj.isDireitoCheque());
		pnlCliente.txtIdConta.setText(String.valueOf(cj.getConta().getId()));

	}

	private ClienteJuridico preencherDados() {
		ClienteJuridico cj;
		Endereco en = new Endereco();
		Conta c = new Conta();

		if (tblClienteJuridico.getSelectedRow() > -1) {
			cj = tblModelClienteJuridico.getValue(tblClienteJuridico.getSelectedRow());
		} else {
			cj = new ClienteJuridico();
		}
		// CLIENTE JURIDICO
		cj.setCnpj(txtCnpj.getText().equals("  .   .   /    -  ") ? null : txtCnpj.getText());
		// PESSOA
		cj.setId(pnlPessoa.txtId.getText().isEmpty() ? 0 : Integer.parseInt(pnlPessoa.txtId.getText()));
		cj.setNome(pnlPessoa.txtNome.getText().isEmpty() ? null : pnlPessoa.txtNome.getText());
		cj.setTelefone(
				pnlPessoa.txtTelefone.getText().replace("(", "").replace(")", "").replace("-", "").isEmpty() ? null
						: pnlPessoa.txtTelefone.getText());
		cj.setEmail(pnlPessoa.txtEmail.getText().isEmpty() ? null : pnlPessoa.txtEmail.getText());
		cj.setDataNascimento(pnlPessoa.dtcDataNascimento.getCalendar() == null ? null
				: new String(sdf.format(pnlPessoa.dtcDataNascimento.getDate())));
		en.setId(pnlPessoa.txtIdendereco.getText().isEmpty() ? 0 : Integer.parseInt(pnlPessoa.txtIdendereco.getText()));
		cj.setEndereco(en);
		// CLIENTE
		cj.setLimite(pnlCliente.txtLimite.getText().isEmpty() ? null
				: new BigDecimal(pnlCliente.txtLimite.getText().replace(",", ".")));
		cj.setSaldo(pnlCliente.txtSaldo.getText().isEmpty() ? null
				: new BigDecimal(pnlCliente.txtSaldo.getText().replace(",", ".")));
		cj.setDireitoCheque(pnlCliente.chckbxDireitocheque.isSelected());
		cj.setCartaoCredito(pnlCliente.chckbxCartaocredito.isSelected());
		c.setId(pnlCliente.txtIdConta.getText().isEmpty() ? 0 : Integer.parseInt(pnlCliente.txtIdConta.getText()));
		cj.setConta(c);

		return cj;
	}

}
