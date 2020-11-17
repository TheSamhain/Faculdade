package br.com.banco.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.banco.gui.document.FloatDocument;
import br.com.banco.gui.document.NumberDocument;

import javax.swing.JCheckBox;

public abstract class JPanelCliente extends JPanel {
	public JLabel lblLimite;
	public JTextField txtLimite;
	public JLabel lblSaldo;
	public JTextField txtSaldo;
	public JCheckBox chckbxDireitocheque;
	public JCheckBox chckbxCartaocredito;
	public JLabel lblIdConta;
	public JTextField txtIdConta;
	
	
	
	public JPanelCliente() {
		setLayout(null);
		
		add(getLblLimite());
		add(getTxtLimite());
		add(getLblSaldo());
		add(getTxtSaldo());
		add(getChckbxDireitocheque());
		add(getChckbxCartaocredito());
		add(getLblIdConta());
		add(getTxtIdConta());
		
	}
	
	private JLabel getLblLimite() {
		if (lblLimite == null) {
			lblLimite = new JLabel("Limite:");
			lblLimite.setBounds(215, 4, 57, 15);
		}
		return lblLimite;
	}
	private JTextField getTxtLimite() {
		if (txtLimite == null) {
			txtLimite = new JTextField();
			txtLimite.setDocument(new FloatDocument());
			txtLimite.setBounds(278, 2, 144, 19);
			txtLimite.setColumns(10);
		}
		return txtLimite;
	}
	private JLabel getLblSaldo() {
		if (lblSaldo == null) {
			lblSaldo = new JLabel("Saldo:");
			lblSaldo.setBounds(215, 33, 57, 15);
		}
		return lblSaldo;
	}
	private JTextField getTxtSaldo() {
		if (txtSaldo == null) {
			txtSaldo = new JTextField();
			txtSaldo.setDocument(new FloatDocument());
			txtSaldo.setBounds(278, 33, 144, 19);
			txtSaldo.setColumns(10);
		}
		return txtSaldo;
	}
	private JCheckBox getChckbxDireitocheque() {
		if (chckbxDireitocheque == null) {
			chckbxDireitocheque = new JCheckBox("Direito a Cheque");
			chckbxDireitocheque.setBounds(452, 0, 197, 23);
		}
		return chckbxDireitocheque;
	}
	private JCheckBox getChckbxCartaocredito() {
		if (chckbxCartaocredito == null) {
			chckbxCartaocredito = new JCheckBox("Direto a Cartão de Crédito");
			chckbxCartaocredito.setBounds(452, 29, 279, 23);
		}
		return chckbxCartaocredito;
	}
	private JLabel getLblIdConta() {
		if (lblIdConta == null) {
			lblIdConta = new JLabel("Código Conta:");
			lblIdConta.setBounds(278, 62, 158, 15);
		}
		return lblIdConta;
	}
	private JTextField getTxtIdConta() {
		if (txtIdConta == null) {
			txtIdConta = new JTextField();
			txtIdConta.setDocument(new NumberDocument());
			txtIdConta.setBounds(454, 60, 124, 19);
			txtIdConta.setColumns(10);
		}
		return txtIdConta;
	}
}
