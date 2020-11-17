package br.com.banco.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.banco.Mascara;
import br.com.banco.gui.document.NumberDocument;
import br.com.banco.gui.document.TextDocument;
import br.com.banco.model.Conta;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public abstract class JPanelPessoa extends JPanel {
	public JLabel lblId;
	public JTextField txtId;
	public JLabel lblNome;
	public JTextField txtNome;
	public JLabel lblTelefone;
	public JFormattedTextField txtTelefone;
	public JLabel lblEmail;
	public JTextField txtEmail;
	public JLabel lblDataNascimento;
	public JDateChooser dtcDataNascimento;
	public JLabel lblIdEndereco;
	public JTextField txtIdendereco;
	
	public JPanelPessoa() {
		setLayout(null);
		
		add(getLblId());
		add(getTxtId());
		add(getLblNome());
		add(getTxtNome());
		add(getLblTelefone());
		add(getTxtTelefone());
		add(getLblEmail());
		add(getTxtEmail());
		add(getLblDataNascimento());
		add(getDtcDataNascimento());
		add(getLblIdEndereco());
		add(getTxtIdendereco());

	}
	
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("Código:");
			lblId.setBounds(172, 2, 80, 15);
		}
		return lblId;
	}
	private JTextField getTxtId() {
		if (txtId == null) {
			txtId = new JTextField();
			txtId.setBounds(254, 0, 63, 19);
			txtId.setColumns(10);
			txtId.setEditable(false);
		}
		return txtId;
	}

	private JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel("Nome:");
			lblNome.setBounds(340, 4, 57, 15);
		}
		return lblNome;
	}
	private JTextField getTxtNome() {
		if (txtNome == null) {
			txtNome = new JTextField();
			txtNome.setDocument(new TextDocument(45));
			txtNome.setText("");
			txtNome.setBounds(395, 2, 386, 19);
			txtNome.setColumns(10);
		}
		return txtNome;
	}
	private JLabel getLblTelefone() {
		if (lblTelefone == null) {
			lblTelefone = new JLabel("Telefone:");
			lblTelefone.setBounds(172, 55, 93, 15);
		}
		return lblTelefone;
	}
	private JFormattedTextField getTxtTelefone() {
		if (txtTelefone == null) {
			txtTelefone = new JFormattedTextField(Mascara.mascarar("(##)#####-####"));
			txtTelefone.setBounds(271, 53, 189, 19);
			txtTelefone.setColumns(10);
		}
		return txtTelefone;
	}
	
	private JLabel getLblDataNascimento() {
		if (lblDataNascimento == null) {
			lblDataNascimento = new JLabel("Data Nascimento:");
			lblDataNascimento.setBounds(472, 53, 143, 15);
		}
		return lblDataNascimento;
	}
	
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email:");
			lblEmail.setBounds(172, 28, 57, 15);
		}
		return lblEmail;
	}
	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setText("");
			txtEmail.setBounds(229, 26, 552, 19);
			txtEmail.setDocument(new TextDocument(100));
			txtEmail.setColumns(10);
		}
		return txtEmail;
	}
	
	private JDateChooser getDtcDataNascimento() {
		if (dtcDataNascimento == null) {
			dtcDataNascimento = new JDateChooser();
			dtcDataNascimento.setBounds(638, 51, 143, 19);
			JTextFieldDateEditor editor = (JTextFieldDateEditor) dtcDataNascimento.getDateEditor();
			editor.setEditable(false);
			dtcDataNascimento.setDateFormatString("dd/MM/yyyy");
		}
		return dtcDataNascimento;
	}
	private JLabel getLblIdEndereco() {
		if (lblIdEndereco == null) {
			lblIdEndereco = new JLabel("Código Endereço:");
			lblIdEndereco.setBounds(281, 84, 162, 15);
		}
		return lblIdEndereco;
	}
	private JTextField getTxtIdendereco() {
		if (txtIdendereco == null) {
			txtIdendereco = new JTextField();
			txtIdendereco.setDocument(new NumberDocument());
			txtIdendereco.setBounds(440, 84, 178, 19);
			txtIdendereco.setColumns(10);
		}
		return txtIdendereco;
	}
}
