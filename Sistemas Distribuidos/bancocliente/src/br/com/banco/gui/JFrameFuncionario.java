package br.com.banco.gui;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
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
import br.com.banco.controller.FuncionarioController;
import br.com.banco.gui.document.FloatDocument;
import br.com.banco.gui.document.TextDocument;
import br.com.banco.gui.tablemodel.TableModelFuncionario;
import br.com.banco.model.ClienteFisico;
import br.com.banco.model.Endereco;
import br.com.banco.model.Funcionario;

public class JFrameFuncionario extends JFrame {
	private JLabel lblFuncionario;
	private JLabel lblCpf;
	private JFormattedTextField txtCpf;
	private JLabel lblSalario;
	private JTextField txtSalario;
	private JLabel lblCargo;
	private JTextField txtCargo;

	public JPanelButton pnlButton;
	public JPanelPessoa pnlPessoa;

	private JScrollPane scrollPane;
	private JTable tblFuncionario;
	private List<Funcionario> list = new ArrayList<Funcionario>();
	private TableModelFuncionario tblModelFuncionario = new TableModelFuncionario(list);

	private FuncionarioController fc = new FuncionarioController();
	private Transporte tr = new Transporte();

	private static String envio = "";

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdfdb = new SimpleDateFormat("yyyy-MM-dd");

	public JFrameFuncionario() {
		getContentPane().setLayout(null);
		getContentPane().add(getLblFuncionario());
		getContentPane().add(getLblCpf());
		getContentPane().add(getTxtCpf());
		getContentPane().add(getLblSalario());
		getContentPane().add(getTxtSalario());
		getContentPane().add(getLblCargo());
		getContentPane().add(getTxtCargo());

		getContentPane().add(getPnlButton());
		getContentPane().add(getPnlPessoa());
		getContentPane().add(getScrollPane());

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1024, 502);
		setVisible(true);
		setLocationRelativeTo(null);

	}

	private JLabel getLblFuncionario() {
		if (lblFuncionario == null) {
			lblFuncionario = new JLabel("Funcionario");
			lblFuncionario.setBounds(468, 12, 95, 15);
		}
		return lblFuncionario;
	}

	private JLabel getLblCpf() {
		if (lblCpf == null) {
			lblCpf = new JLabel("Cpf:");
			lblCpf.setBounds(125, 177, 66, 15);
		}
		return lblCpf;
	}

	private JFormattedTextField getTxtCpf() {
		if (txtCpf == null) {
			txtCpf = new JFormattedTextField(Mascara.mascarar("###.###.###-##"));
			txtCpf.setBounds(196, 175, 158, 19);
			txtCpf.setColumns(10);
		}
		return txtCpf;
	}

	private JLabel getLblSalario() {
		if (lblSalario == null) {
			lblSalario = new JLabel("Salario:");
			lblSalario.setBounds(382, 177, 66, 15);
		}
		return lblSalario;
	}

	private JTextField getTxtSalario() {
		if (txtSalario == null) {
			txtSalario = new JTextField();
			txtSalario.setBounds(455, 175, 124, 19);
			txtSalario.setColumns(10);
			txtSalario.setDocument(new FloatDocument());
		}
		return txtSalario;
	}

	private JLabel getLblCargo() {
		if (lblCargo == null) {
			lblCargo = new JLabel("Cargo:");
			lblCargo.setBounds(598, 177, 66, 15);
		}
		return lblCargo;
	}

	private JTextField getTxtCargo() {
		if (txtCargo == null) {
			txtCargo = new JTextField();
			txtCargo.setBounds(670, 175, 192, 19);
			txtCargo.setColumns(10);
			txtCargo.setDocument(new TextDocument(50));
		}
		return txtCargo;
	}

	// PANEL BUTTON
	private JPanelButton getPnlButton() {
		if (pnlButton == null) {
			pnlButton = new JPanelButton() {
				String envio = "";

				@Override
				public void salvar() {
					envio = "";
					Funcionario f = preencherDados();
					String str = fc.validar(f);
					if (!str.equals("")) {
						JOptionPane.showMessageDialog(null, str);
					} else {
						envio = "s<>f<>str<>";

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

						tr.enviar(envio);
						envio = "";

						if (f.getId() > 0) {
							tblModelFuncionario.onAdd(f);
						} else {
							envio = "p<>f<>str<>0<>";
							tr.enviar(envio);

							String[] conteudo = tr.receber();
							if (conteudo[0].equals("p")) {
								if (conteudo[1].equals("f")) {
									if (conteudo[2].equals("str")) {
										f.setId(Integer.parseInt(conteudo[conteudo.length - 10]));
									}
								}
							}
							tblModelFuncionario.onAdd(f);
						}
					}
					limpar();
				}

				@Override
				public void excluir() {
					if (tblFuncionario.getSelectedRow() > -1) {
						tblModelFuncionario.onRemove(tblFuncionario.getSelectedRow());
						envio = "";
						envio = "e<>f<>int<>" + pnlPessoa.txtId.getText() + "<>";
						tr.enviar(envio);
					}
				}

				@Override
				public void limpar() {
					// CLIENTE FISICO
					txtCpf.setText("");
					txtSalario.setText("");
					txtCargo.setText("");
					// PESSOA
					pnlPessoa.txtId.setText("");
					pnlPessoa.txtNome.setText("");
					pnlPessoa.txtTelefone.setText("");
					pnlPessoa.txtEmail.setText("");
					pnlPessoa.dtcDataNascimento.setCalendar(null);
					pnlPessoa.txtIdendereco.setText("");
					if(tblFuncionario.getSelectedRow() > -1) {
						tblFuncionario.clearSelection();
					}
				}

			};
			pnlButton.setBounds(243, 215, 476, 50);
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

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 272, 982, 174);
			scrollPane.setViewportView(getTblFuncionario());
		}
		return scrollPane;
	}

	private JTable getTblFuncionario() {
		if (tblFuncionario == null) {
			tblFuncionario = new JTable();
			tblFuncionario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblFuncionario.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					if (e.getValueIsAdjusting()) {
						return;
					}
					if (tblFuncionario.getSelectedRow() < 0) {
						return;
					}
					Funcionario f = tblModelFuncionario.getValue(tblFuncionario.getSelectedRow());
					mostrar(f);
				}
			});
			tblFuncionario.setModel(tblModelFuncionario);

			envio = "p<>f<>str<>0<>";

			tr.enviar(envio);
			String[] conteudo = tr.receber();
			if (conteudo[0].equals("p")) {
				if (conteudo[1].equals("f")) {
					if (conteudo[2].equals("str")) {
						for (int i = 3; i < conteudo.length - 1; i = i + 9) {
							Funcionario f = new Funcionario();
							Endereco en = new Endereco();
							// PESSOA
							f.setId(Integer.parseInt(conteudo[i]));
							f.setNome(conteudo[i + 1]);
							f.setTelefone(conteudo[i + 2]);
							f.setEmail(conteudo[i + 3]);
							java.util.Date data = null;
							try {
								data = sdfdb.parse(conteudo[i + 4]);
							} catch (ParseException e) {
								e.printStackTrace();
							}
							f.setDataNascimento(sdf.format(data));
							en.setId(Integer.parseInt(conteudo[i + 5]));
							f.setEndereco(en);
							// FUNCIONARIO
							f.setCpf(conteudo[i + 6]);
							f.setSalario(new BigDecimal(conteudo[i + 7]));
							f.setCargo(conteudo[i + 8]);
							tblModelFuncionario.onAdd(f);

						}

					}
				}
			}
		}
		return tblFuncionario;
	}

	private void mostrar(Funcionario f) {
		// CLIENTE FISICO
		txtCpf.setText(String.valueOf(f.getCpf()));
		txtSalario.setText(String.valueOf(f.getSalario()));
		txtCargo.setText(String.valueOf(f.getCargo()));
		// PESSOA
		pnlPessoa.txtId.setText(String.valueOf(f.getId()));
		pnlPessoa.txtNome.setText(String.valueOf(f.getNome()));
		pnlPessoa.txtTelefone.setText(String.valueOf(f.getTelefone()));
		pnlPessoa.txtEmail.setText(String.valueOf(f.getEmail()));
		java.util.Date data = null;
		try {
			data = sdf.parse(f.getDataNascimento());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		pnlPessoa.dtcDataNascimento.setDate(data);
		pnlPessoa.txtIdendereco.setText(String.valueOf(f.getEndereco().getId()));
	}

	private Funcionario preencherDados() {
		Funcionario f;
		Endereco en = new Endereco();

		if (tblFuncionario.getSelectedRow() > -1) {
			f = tblModelFuncionario.getValue(tblFuncionario.getSelectedRow());
		} else {
			f = new Funcionario();
		}
		// FUNCIONARIO
		f.setCpf(txtCpf.getText().equals("   .   .   -  ") ? null : txtCpf.getText());
		f.setSalario(txtSalario.getText().isEmpty() ? null : new BigDecimal(txtSalario.getText().replace(",", ".")));
		f.setCargo(txtCargo.getText().isEmpty() ? null : txtCargo.getText());
		// PESSOA
		f.setId(pnlPessoa.txtId.getText().isEmpty() ? 0 : Integer.parseInt(pnlPessoa.txtId.getText()));
		f.setNome(pnlPessoa.txtNome.getText().isEmpty() ? null : pnlPessoa.txtNome.getText());
		f.setTelefone(
				pnlPessoa.txtTelefone.getText().equals("(  )     -    ") ? null : pnlPessoa.txtTelefone.getText());
		f.setEmail(pnlPessoa.txtEmail.getText().isEmpty() ? null : pnlPessoa.txtEmail.getText());
		f.setDataNascimento(pnlPessoa.dtcDataNascimento.getCalendar() == null ? null
				: new String(sdf.format(pnlPessoa.dtcDataNascimento.getDate())));
		en.setId(pnlPessoa.txtIdendereco.getText().isEmpty() ? 0 : Integer.parseInt(pnlPessoa.txtIdendereco.getText()));
		f.setEndereco(en);

		return f;
	}

}
