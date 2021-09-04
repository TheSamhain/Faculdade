package br.com.banco.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.banco.Mascara;
import br.com.banco.Transporte;
import br.com.banco.controller.ContaController;
import br.com.banco.gui.document.FloatDocument;
import br.com.banco.gui.tablemodel.TableModelConta;
import br.com.banco.model.Conta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class JFrameConta extends JFrame {
	private JLabel lblContas;
	private JLabel lblId;
	private JTextField txtId;
	private JLabel lblAgencia;
	private JFormattedTextField txtAgencia;
	private JScrollPane scrollPane;
	private JTable tblConta;
	private List<Conta> list = new ArrayList<Conta>();
	private TableModelConta tblModelConta = new TableModelConta(list);

	private JLabel lblTaxManu;
	private JTextField txtTaxManu;
	private JLabel lblTipo;
	private JComboBox<?> cmbTipoConta;
	public JPanelButton pnlButton;

	private ContaController cc = new ContaController();
	private Transporte tr = new Transporte();

	private static String envio = "";

	public JFrameConta() {
		getContentPane().setLayout(null);
		getContentPane().add(getLblId());
		getContentPane().add(getTxtId());
		getContentPane().add(getLblAgencia());
		getContentPane().add(getTxtAgencia());
		getContentPane().add(getPnlButton());

		getContentPane().add(getScrollPane());

		getContentPane().add(getLblTaxManu());
		getContentPane().add(getTxtTaxManu());
		getContentPane().add(getLblTipo());
		getContentPane().add(cmbTipoConta());
		getContentPane().add(getLblContas());

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(450, 395);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private JLabel getLblContas() {
		if (lblContas == null) {
			lblContas = new JLabel("CONTAS");
			lblContas.setBounds(186, 12, 66, 15);
		}
		return lblContas;
	}

	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("Código:");
			lblId.setBounds(12, 46, 66, 15);
		}
		return lblId;
	}

	private JTextField getTxtId() {
		if (txtId == null) {
			txtId = new JTextField();
			txtId.setEnabled(false);
			txtId.setBounds(84, 44, 54, 19);
			txtId.setColumns(10);
		}
		return txtId;
	}

	private JLabel getLblAgencia() {
		if (lblAgencia == null) {
			lblAgencia = new JLabel("Agência:");
			lblAgencia.setBounds(12, 73, 82, 15);
		}
		return lblAgencia;
	}

	private JFormattedTextField getTxtAgencia() {
		if (txtAgencia == null) {
			txtAgencia = new JFormattedTextField(Mascara.mascarar("####-#"));
			txtAgencia.setBounds(107, 71, 90, 19);
			txtAgencia.setColumns(10);
		}
		return txtAgencia;
	}

	private JLabel getLblTaxManu() {
		if (lblTaxManu == null) {
			lblTaxManu = new JLabel("Taxa Manutenção");
			lblTaxManu.setBounds(151, 47, 148, 13);
		}
		return lblTaxManu;
	}

	private JTextField getTxtTaxManu() {
		if (txtTaxManu == null) {
			txtTaxManu = new JTextField();
			txtTaxManu.setDocument(new FloatDocument());
			txtTaxManu.setColumns(10);
			txtTaxManu.setBounds(308, 42, 124, 19);
			txtTaxManu.setHorizontalAlignment(JFormattedTextField.RIGHT);
		}
		return txtTaxManu;
	}

	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Tipo:");
			lblTipo.setBounds(215, 73, 48, 15);
		}
		return lblTipo;
	}

	private JComboBox cmbTipoConta() {
		if (cmbTipoConta == null) {
			cmbTipoConta = new JComboBox(Conta.TIPO_CONTA_LIST);
			cmbTipoConta.setBounds(268, 68, 164, 24);
		}
		return cmbTipoConta;
	}

	private JPanelButton getPnlButton() {
		if (pnlButton == null) {
			pnlButton = new JPanelButton() {
				@Override
				public void salvar() {
					envio = "";
					Conta c = preencherDados();
					String str = cc.validar(c);
					if (!str.equals("")) {
						JOptionPane.showMessageDialog(null, str);
					} else {
						envio = "s<>c<>str<>";

						envio += c.getId() + "<>";
						envio += c.getTaxaManutencao() + "<>";
						envio += c.getAgencia() + "<>";
						envio += c.getTipoConta() + "<>";

						tr.enviar(envio);
						envio = "";

						if (c.getId() > 0) {
							tblModelConta.onAdd(c);
						} else {
							envio = "p<>c<>str<>0<>";
							tr.enviar(envio);

							String[] conteudo = tr.receber();
							if (conteudo[0].equals("p")) {
								if (conteudo[1].equals("c")) {
									if (conteudo[2].equals("str")) {
										c.setId(Integer.parseInt(conteudo[conteudo.length - 5]));
									}
								}
							}
							tblModelConta.onAdd(c);
						}
					}
					limpar();
				}

				@Override
				public void excluir() {
					if (tblConta.getSelectedRow() > -1) {
						tblModelConta.onRemove(tblConta.getSelectedRow());
						envio = "";
						envio = "e<>c<>int<>" + txtId.getText() + "<>";
						tr.enviar(envio);
					}
				}

				@Override
				public void limpar() {
					txtId.setText("");
					txtAgencia.setText("");
					txtTaxManu.setText("");
					cmbTipoConta.setSelectedIndex(0);
					if(tblConta.getSelectedRow() > -1) {
						tblConta.clearSelection();
					}
				}
			};
			pnlButton.setBounds(12, 111, 420, 50);
		}
		return pnlButton;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 173, 420, 174);
			scrollPane.setViewportView(getTblConta());
		}
		return scrollPane;
	}

	private JTable getTblConta() {
		if (tblConta == null) {
			tblConta = new JTable();
			tblConta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblConta.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					if (e.getValueIsAdjusting()) {
						return;
					}
					if (tblConta.getSelectedRow() < 0) {
						return;
					}
					Conta c = tblModelConta.getValue(tblConta.getSelectedRow());
					mostrar(c);
				}
			});
			tblConta.setModel(tblModelConta);

			envio = "p<>c<>str<>0<>";

			tr.enviar(envio);
			String[] conteudo = tr.receber();
			if (conteudo[0].equals("p")) {
				if (conteudo[1].equals("c")) {
					if (conteudo[2].equals("str")) {
						for (int i = 3; i < conteudo.length - 1; i = i + 4) {
							Conta c = new Conta();
							c.setId(Integer.parseInt(conteudo[i]));
							c.setTaxaManutencao(new BigDecimal(conteudo[i + 1]));
							c.setAgencia(conteudo[i + 2]);
							c.setTipoConta(Integer.parseInt(conteudo[i + 3]));
							tblModelConta.onAdd(c);

						}

					}
				}
			}
		}
		return tblConta;

	}

	private void mostrar(Conta c) {
		txtId.setText(String.valueOf(c.getId()));
		txtAgencia.setText(String.valueOf(c.getAgencia()));
		cmbTipoConta.setSelectedIndex(c.getTipoConta());
		txtTaxManu.setText(String.valueOf(c.getTaxaManutencao()));
	}

	private Conta preencherDados() {
		Conta c;

		if (tblConta.getSelectedRow() > -1) {
			c = tblModelConta.getValue(tblConta.getSelectedRow());
		} else {
			c = new Conta();
		}

		c.setId(txtId.getText().isEmpty() ? 0 : Integer.parseInt(txtId.getText()));
		c.setAgencia(txtAgencia.getText().equals("    - ") ? null : txtAgencia.getText());
		c.setTaxaManutencao(
				txtTaxManu.getText().isEmpty() ? null : new BigDecimal(txtTaxManu.getText().replace(",", ".")));
		c.setTipoConta(cmbTipoConta().getSelectedIndex());

		return c;
	}
}
