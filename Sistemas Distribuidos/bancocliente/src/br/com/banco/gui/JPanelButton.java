package br.com.banco.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class JPanelButton extends JPanel {
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnLimpar;

	public JPanelButton() {
		setLayout(new GridLayout(0, 3, 5, 0));
		add(getBtnSalvar());
		add(getBtnExcluir());
		add(getBtnLimpar());
	}

	private JButton getBtnSalvar() {
		if (btnSalvar == null) {
			btnSalvar = new JButton("Salvar");
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salvar();
				}
			});
		}
		return btnSalvar;
	}

	private JButton getBtnExcluir() {
		if (btnExcluir == null) {
			btnExcluir = new JButton("Excluir");
			btnExcluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					excluir();
				}
			});
		}
		return btnExcluir;
	}

	private JButton getBtnLimpar() {
		if (btnLimpar == null) {
			btnLimpar = new JButton("Limpar");
			btnLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpar();
				}
			});
		}
		return btnLimpar;
	}
	
	public abstract void salvar();
	public abstract void excluir();
	public abstract void limpar();
}
