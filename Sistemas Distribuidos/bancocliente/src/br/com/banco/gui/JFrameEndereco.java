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

import br.com.banco.Transporte;
import br.com.banco.controller.ContaController;
import br.com.banco.controller.EnderecoController;
import br.com.banco.gui.document.NumberDocument;
import br.com.banco.gui.document.NumberDocumentMax;
import br.com.banco.gui.document.TextDocument;
import br.com.banco.gui.tablemodel.TableModelConta;
import br.com.banco.gui.tablemodel.TableModelEndereco;
import br.com.banco.model.Conta;
import br.com.banco.model.Endereco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

public class JFrameEndereco extends JFrame {
	private JLabel lblEnderecos;
	private JLabel lblId;
	private JTextField txtId;
	private JLabel lblLogradouro;
	private JTextField txtLogradouro;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JLabel lblComplemento;
	private JTextField txtComplemento;
	private JLabel lblBairro;
	private JTextField txtBairro;
	private JLabel lblCidade;
	private JTextField txtCidade;
	private JLabel lblUf;
	private JComboBox cmbUf;
	public JPanelButton pnlButton;

	private JScrollPane scrollPane;
	private JTable tblEndereco;
	private List<Endereco> list = new ArrayList<Endereco>();
	private TableModelEndereco tblModelEndereco = new TableModelEndereco(list);

	private EnderecoController ee = new EnderecoController();
	private Transporte tr = new Transporte();

	private static String envio = "";

	public JFrameEndereco() {
		getContentPane().setLayout(null);
		getContentPane().add(getLblId());
		getContentPane().add(getTxtId());
		getContentPane().add(getLblLogradouro());
		getContentPane().add(getTxtLogradouro());
		getContentPane().add(getLblNumero());
		getContentPane().add(getTxtNumero());
		getContentPane().add(getLblComplemento());
		getContentPane().add(getTxtComplemento());
		getContentPane().add(getLblBairro());
		getContentPane().add(getTxtBairro());
		getContentPane().add(getLblCidade());
		getContentPane().add(getTxtCidade());
		getContentPane().add(getLblUf());
		getContentPane().add(getCmbUf());
		getContentPane().add(getLblEnderecos());
		getContentPane().add(getPnlButton());

		getContentPane().add(getScrollPane());

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(554, 454);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private JLabel getLblEnderecos() {
		if (lblEnderecos == null) {
			lblEnderecos = new JLabel("ENDEREÇOS");
			lblEnderecos.setBounds(248, 18, 108, 15);
		}
		return lblEnderecos;
	}

	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("Código:");
			lblId.setBounds(12, 43, 62, 15);
		}
		return lblId;
	}

	private JTextField getTxtId() {
		if (txtId == null) {
			txtId = new JTextField();
			txtId.setDocument(new NumberDocument());
			txtId.setBounds(76, 41, 62, 19);
			txtId.setEditable(false);
			txtId.setColumns(10);
		}
		return txtId;
	}

	private JLabel getLblLogradouro() {
		if (lblLogradouro == null) {
			lblLogradouro = new JLabel("Logradouro:");
			lblLogradouro.setBounds(12, 72, 146, 15);
		}
		return lblLogradouro;
	}

	private JTextField getTxtLogradouro() {
		if (txtLogradouro == null) {
			txtLogradouro = new JTextField();
			txtLogradouro.setDocument(new TextDocument(50));
			txtLogradouro.setBounds(149, 70, 387, 19);
			txtLogradouro.setColumns(10);
		}
		return txtLogradouro;
	}

	private JLabel getLblNumero() {
		if (lblNumero == null) {
			lblNumero = new JLabel("Número:");
			lblNumero.setBounds(12, 100, 82, 15);
		}
		return lblNumero;
	}

	private JTextField getTxtNumero() {
		if (txtNumero == null) {
			txtNumero = new JTextField();
			txtNumero.setDocument(new NumberDocumentMax(10));
			txtNumero.setBounds(96, 98, 62, 19);
			txtNumero.setColumns(10);
		}
		return txtNumero;
	}

	private JLabel getLblComplemento() {
		if (lblComplemento == null) {
			lblComplemento = new JLabel("Complemento:");
			lblComplemento.setBounds(186, 100, 136, 15);
		}
		return lblComplemento;
	}

	private JTextField getTxtComplemento() {
		if (txtComplemento == null) {
			txtComplemento = new JTextField();
			txtComplemento.setDocument(new TextDocument(50));
			txtComplemento.setBounds(340, 98, 118, 19);
			txtComplemento.setColumns(10);
		}
		return txtComplemento;
	}

	private JLabel getLblBairro() {
		if (lblBairro == null) {
			lblBairro = new JLabel("Bairro:");
			lblBairro.setBounds(12, 127, 55, 15);
		}
		return lblBairro;
	}

	private JTextField getTxtBairro() {
		if (txtBairro == null) {
			txtBairro = new JTextField();
			txtBairro.setDocument(new TextDocument(50));
			txtBairro.setBounds(74, 127, 165, 19);
			txtBairro.setColumns(10);
		}
		return txtBairro;
	}

	private JLabel getLblCidade() {
		if (lblCidade == null) {
			lblCidade = new JLabel("Cidade:");
			lblCidade.setBounds(246, 129, 62, 15);
		}
		return lblCidade;
	}

	private JTextField getTxtCidade() {
		if (txtCidade == null) {
			txtCidade = new JTextField();
			txtCidade.setDocument(new TextDocument(50));
			txtCidade.setBounds(310, 127, 226, 19);
			txtCidade.setColumns(10);
		}
		return txtCidade;
	}

	private JLabel getLblUf() {
		if (lblUf == null) {
			lblUf = new JLabel("UF:");
			lblUf.setBounds(170, 43, 29, 15);
		}
		return lblUf;
	}

	private JComboBox getCmbUf() {
		if (cmbUf == null) {
			cmbUf = new JComboBox(Endereco.UF_LIST);
			cmbUf.setBounds(217, 38, 226, 24);
		}
		return cmbUf;
	}

	private JPanelButton getPnlButton() {
		if (pnlButton == null) {
			pnlButton = new JPanelButton() {
				@Override
				public void salvar() {
					envio = "";
					Endereco en = preencherDados();
					String str = ee.validar(en);
					if (!str.equals("")) {
						JOptionPane.showMessageDialog(null, str);
					} else {
						envio = "s<>en<>str<>";

						envio += en.getId() + "<>";
						envio += en.getLogradouro() + "<>";
						envio += en.getNumero() + "<>";
						envio += en.getComplemento() + "<>";
						envio += en.getBairro() + "<>";
						envio += en.getCidade() + "<>";
						envio += en.getUf() + "<>";
						tr.enviar(envio);
						envio = "";

						if (en.getId() > 0) {
							tblModelEndereco.onAdd(en);
						} else {
							envio = "p<>en<>str<>0<>";
							tr.enviar(envio);

							String[] conteudo = tr.receber();
							if (conteudo[0].equals("p")) {
								if (conteudo[1].equals("en")) {
									if (conteudo[2].equals("str")) {
										en.setId(Integer.parseInt(conteudo[conteudo.length - 8]));
									}
								}
							}
							tblModelEndereco.onAdd(en);
						}
					}
					limpar();
				}

				@Override
				public void excluir() {
					if (tblEndereco.getSelectedRow() > -1) {
						tblModelEndereco.onRemove(tblEndereco.getSelectedRow());
						envio = "";
						envio = "e<>en<>int<>" + txtId.getText() + "<>";
						tr.enviar(envio);
					}
				}

				@Override
				public void limpar() {
					txtId.setText("");
					txtLogradouro.setText("");
					txtNumero.setText("");
					txtComplemento.setText("");
					txtBairro.setText("");
					txtCidade.setText("");
					cmbUf.setSelectedIndex(0);
					if(tblEndereco.getSelectedRow() > -1) {
						tblEndereco.clearSelection();
					}
				}
			};
			pnlButton.setBounds(12, 160, 524, 50);
		}
		return pnlButton;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 222, 524, 185);
			scrollPane.setViewportView(getTblEndereco());
		}
		return scrollPane;
	}

	private JTable getTblEndereco() {
		if (tblEndereco == null) {
			tblEndereco = new JTable();
			tblEndereco.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblEndereco.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					if (e.getValueIsAdjusting()) {
						return;
					}
					if (tblEndereco.getSelectedRow() < 0) {
						return;
					}
					Endereco en = tblModelEndereco.getValue(tblEndereco.getSelectedRow());
					mostrar(en);
				}
			});
			tblEndereco.setModel(tblModelEndereco);

			envio = "p<>en<>str<>0<>";

			tr.enviar(envio);
			String[] conteudo = tr.receber();
			if (conteudo[0].equals("p")) {
				if (conteudo[1].equals("en")) {
					if (conteudo[2].equals("str")) {
						for (int i = 3; i < conteudo.length - 1; i = i + 7) {
							Endereco en = new Endereco();
							en.setId(Integer.parseInt(conteudo[i]));
							en.setLogradouro(conteudo[i + 1]);
							en.setNumero(conteudo[i + 2]);
							en.setComplemento(conteudo[i + 3]);
							en.setBairro(conteudo[i + 4]);
							en.setCidade(conteudo[i + 5]);
							en.setUf(Integer.parseInt(conteudo[i + 6]));
							tblModelEndereco.onAdd(en);

						}

					}
				}
			}

		}
		return tblEndereco;
	}

	private void mostrar(Endereco en) {
		txtId.setText(String.valueOf(en.getId()));
		txtLogradouro.setText(String.valueOf(en.getLogradouro()));
		txtNumero.setText(String.valueOf(en.getNumero()));
		txtComplemento.setText(String.valueOf(en.getComplemento()));
		txtBairro.setText(String.valueOf(en.getBairro()));
		txtCidade.setText(String.valueOf(en.getCidade()));
		cmbUf.setSelectedIndex(en.getUf());

	}

	private Endereco preencherDados() {
		Endereco en;

		if (tblEndereco.getSelectedRow() > -1) {
			en = tblModelEndereco.getValue(tblEndereco.getSelectedRow());
		} else {
			en = new Endereco();
		}

		en.setId(txtId.getText().isEmpty() ? 0 : Integer.parseInt(txtId.getText()));
		en.setLogradouro(txtLogradouro.getText().isEmpty() ? null : txtLogradouro.getText());
		en.setNumero(txtNumero.getText().isEmpty() ? null : txtNumero.getText());
		en.setComplemento(txtComplemento.getText().isEmpty() ? null : txtComplemento.getText());
		en.setBairro(txtBairro.getText().isEmpty() ? null : txtBairro.getText());
		en.setCidade(txtCidade.getText().isEmpty() ? null : txtCidade.getText());
		en.setUf(cmbUf.getSelectedIndex());

		return en;
	}

}
