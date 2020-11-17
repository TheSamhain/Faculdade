package br.com.banco.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class JFrameNavegador extends JFrame {
	private JLabel lblNavegador;
	private JButton btnEditarContas;
	private JButton btnEditarEnderecos;
	private JButton btnEditarClientesFisicos;
	private JButton btnEditarClientesJuridicos;
	private JButton btnEditarFuncionarios;
	private JLabel lblTema;
	private JComboBox cmbTema;

	public static final String[] TEMA_LIST = { "Aero", "Aluminium", "Bernstein", "Fast", "HiFi",
			"McWin", "Mint", "Noire", "Smart", "Luna" };

	public JFrameNavegador() {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		getContentPane().setLayout(null);
		getContentPane().add(getLblNavegador());
		getContentPane().add(getBtnEditarContas());
		getContentPane().add(getBtnEditarEnderecos());
		getContentPane().add(getBtnEditarClientesFisicos());
		getContentPane().add(getBtnEditarClientesJuridicos());
		getContentPane().add(getLblTema());
		getContentPane().add(getCmbTema());
		getContentPane().add(getBtnEditarFuncionarios());

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(379, 321);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private JLabel getLblNavegador() {
		if (lblNavegador == null) {
			lblNavegador = new JLabel("NAVEGADOR");
			lblNavegador.setBounds(142, 12, 104, 27);
		}
		return lblNavegador;
	}

	private JButton getBtnEditarContas() {
		if (btnEditarContas == null) {
			btnEditarContas = new JButton("EDITAR CONTAS");
			btnEditarContas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFrameConta janelaConta = new JFrameConta();
				}
			});
			btnEditarContas.setBounds(12, 51, 337, 25);
		}
		return btnEditarContas;
	}

	private JButton getBtnEditarEnderecos() {
		if (btnEditarEnderecos == null) {
			btnEditarEnderecos = new JButton("EDITAR ENDEREÇOS");
			btnEditarEnderecos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFrameEndereco janelaEndereco = new JFrameEndereco();
				}
			});
			btnEditarEnderecos.setBounds(12, 88, 337, 25);
		}
		return btnEditarEnderecos;
	}

	private JButton getBtnEditarClientesFisicos() {
		if (btnEditarClientesFisicos == null) {
			btnEditarClientesFisicos = new JButton("EDITAR CLIENTES FÍSICOS");
			btnEditarClientesFisicos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFrameClienteFisico janelaClienteFisico = new JFrameClienteFisico();
				}
			});
			btnEditarClientesFisicos.setBounds(12, 125, 337, 25);
		}
		return btnEditarClientesFisicos;
	}

	private JButton getBtnEditarClientesJuridicos() {
		if (btnEditarClientesJuridicos == null) {
			btnEditarClientesJuridicos = new JButton("EDITAR CLIENTES JURÍDICOS");
			btnEditarClientesJuridicos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFrameClienteJuridico janelaClienteJuridico = new JFrameClienteJuridico();
				}
			});
			btnEditarClientesJuridicos.setBounds(12, 162, 337, 25);
		}
		return btnEditarClientesJuridicos;
	}

	private JButton getBtnEditarFuncionarios() {
		if (btnEditarFuncionarios == null) {
			btnEditarFuncionarios = new JButton("EDITAR FUNCIONÁRIOS");
			btnEditarFuncionarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFrameFuncionario janelaFuncionario = new JFrameFuncionario();
				}
			});
			btnEditarFuncionarios.setBounds(12, 199, 337, 25);
		}
		return btnEditarFuncionarios;
	}

	private JLabel getLblTema() {
		if (lblTema == null) {
			lblTema = new JLabel("Tema:");
			lblTema.setBounds(46, 246, 63, 15);
		}
		return lblTema;
	}

	private JComboBox getCmbTema() {
		if (cmbTema == null) {
			cmbTema = new JComboBox(TEMA_LIST);
			cmbTema.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					atualizaTema(cmbTema.getSelectedIndex());
				}
			});
			cmbTema.setBounds(140, 241, 125, 24);
		}
		return cmbTema;
	}

	public void atualizaTema(int opcao) {
		String tema;
		switch (opcao) {
		case 0:
			tema = "com.jtattoo.plaf.aero.AeroLookAndFeel";
			break;
		case 1:
			tema = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
			break;
		case 2:
			tema = "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel";
			break;
		case 3:
			tema = "com.jtattoo.plaf.fast.FastLookAndFeel";
			break;
		case 4:
			tema = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";
			break;
		case 5:
			tema = "com.jtattoo.plaf.mcwin.McWinLookAndFeel";
			break;
		case 6:
			tema = "com.jtattoo.plaf.mint.MintLookAndFeel";
			break;
		case 7:
			tema = "com.jtattoo.plaf.noire.NoireLookAndFeel";
			break;
		case 8:
			tema = "com.jtattoo.plaf.smart.SmartLookAndFeel";
			break;
		case 9:
			tema = "com.jtattoo.plaf.luna.LunaLookAndFeel";
			break;
		default:
			tema = "com.jtattoo.plaf.aero.AeroLookAndFeel";
			break;
		}

		try {
			UIManager.setLookAndFeel(tema);
			for( Frame f : Frame.getFrames() ) {
				SwingUtilities.updateComponentTreeUI(f);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
