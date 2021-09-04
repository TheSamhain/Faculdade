package br.com.compilador.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import br.com.compilador.Regras;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class JFramePrincipal extends JFrame {
	private JButton btnAnaliseLexica;
	private JButton btnAnaliseSintatica;
	private JButton btnAnalisesemantica;
	private JTextArea txtrEntrada;
	private JTextArea txtrSaida;
	private JScrollPane spSaida;
	private JScrollPane spEntrada;

	private boolean encontrou = false;
	private boolean comentado = false;
	private int numLinha = 0;
	private int chaves = 0; // [0] = ContadorChaves, [1] Linha das Chaves
	private int colchetes = 0; // [0] = Contador de colchetes, [1] Linha dos colchetes
	private int parenteses = 0; // [0] = Contador de parenteses, [1] Linha dos parenteses
	private int posichar = 0;
	private String anterior = "";
	private boolean aspas = false;
	private int aspascont = 0;

	private Regras r = new Regras();

	private StringBuilder sbp = new StringBuilder();
	private StringBuilder sb = new StringBuilder();

	public JFramePrincipal() {
		getContentPane().setBackground(new Color(30, 30, 30));
		getContentPane().setLayout(null);
		getContentPane().add(getSpEntrada());
		getContentPane().add(getBtnAnaliseLexica());
		getContentPane().add(getBtnAnaliseSintatica());
		getContentPane().add(getBtnAnalisesemantica());
		getContentPane().add(getSpSaida());
		this.setSize(1143, 647);
		this.setBackground(new Color(30, 30, 30));

	}

	private JButton getBtnAnaliseLexica() {
		if (btnAnaliseLexica == null) {
			btnAnaliseLexica = new JButton("Anáise Lexica");
			btnAnaliseLexica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {

					analiseLexica();
				}
			});
			btnAnaliseLexica.setBounds(12, 12, 169, 25);
			btnAnaliseLexica.setBackground(new Color(56, 56, 56));
			btnAnaliseLexica.setForeground(Color.white);
			btnAnaliseLexica.setBorder(new LineBorder(new Color(56, 56, 56)));
			btnAnaliseLexica.setFocusPainted(false);

		}
		return btnAnaliseLexica;
	}

	private JButton getBtnAnaliseSintatica() {
		if (btnAnaliseSintatica == null) {
			btnAnaliseSintatica = new JButton("Análise Sintática");
			btnAnaliseSintatica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					analiseSintatica();
				}
			});
			btnAnaliseSintatica.setBounds(193, 12, 169, 25);
			btnAnaliseSintatica.setBackground(new Color(56, 56, 56));
			btnAnaliseSintatica.setForeground(Color.white);
			btnAnaliseSintatica.setBorder(new LineBorder(new Color(56, 56, 56)));
			btnAnaliseSintatica.setFocusPainted(false);
		}
		return btnAnaliseSintatica;
	}

	private JButton getBtnAnalisesemantica() {
		if (btnAnalisesemantica == null) {
			btnAnalisesemantica = new JButton("Análise Semântica");
			btnAnalisesemantica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					analiseSemantica();
				}
			});
			btnAnalisesemantica.setBounds(374, 12, 169, 25);
			btnAnalisesemantica.setBackground(new Color(56, 56, 56));
			btnAnalisesemantica.setForeground(Color.white);
			btnAnalisesemantica.setBorder(new LineBorder(new Color(56, 56, 56)));
			btnAnalisesemantica.setFocusPainted(false);
		}
		return btnAnalisesemantica;
	}

	private JTextArea getTxtrEntrada() {
		if (txtrEntrada == null) {
			txtrEntrada = new JTextArea();
			txtrEntrada.setLineWrap(true);
			txtrEntrada.setBackground(new Color(37, 37, 38));
			txtrEntrada.setForeground(Color.white);
			txtrEntrada.setCaretColor(Color.white);
			txtrEntrada.setTabSize(1);
			txtrEntrada.setFont(new Font("Monospace", 0, 12));
		}
		return txtrEntrada;
	}

	private JTextArea getTxtrSaida() {
		if (txtrSaida == null) {
			txtrSaida = new JTextArea();
			txtrSaida.setEnabled(false);
			txtrSaida.setForeground(Color.white);
			txtrSaida.setLineWrap(true);
			txtrSaida.setBackground(new Color(37, 37, 38));
			txtrSaida.setCaretColor(Color.white);
			txtrSaida.setTabSize(1);
			txtrSaida.setFont(new Font("Monospace", 0, 12));
		}
		return txtrSaida;
	}

	private JScrollPane getSpEntrada() {
		if (spEntrada == null) {
			spEntrada = new JScrollPane();
			spEntrada.setBounds(12, 49, 1113, 247);
			spEntrada.setViewportView(getTxtrEntrada());
		}
		return spEntrada;
	}

	private JScrollPane getSpSaida() {
		if (spSaida == null) {
			spSaida = new JScrollPane();
			spSaida.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			spSaida.setBounds(12, 308, 1113, 300);
			spSaida.setViewportView(getTxtrSaida());
		}
		return spSaida;
	}

	private void analiseLexica() {

		numLinha = 0;

		// LIMPA VARIÁVEIS E TELA
		txtrSaida.setText("");
		comentado = false;
		encontrou = false;

		// CRIA UM VETOR DE LINHAS
		for (String linhas : listaLinhas()) {
			numLinha++;

			// PD(PALAVRA DIVIDIDA) - DIVIDE AS LINHAS POR ESPAÇOS
			for (String pd : linhas.split(" ")) {
				encontrou = false;
				if (comentado == false) {

					// VERIFICA COMENTÁRIO DE LINHA
					if (pd.equals("//")) {
						txtrSaida.setText(txtrSaida.getText() + "//\tDelimitador na linha " + numLinha + "\n");
						break;
					}

					// VERIFICA INICIO DE COMENTÁRIO DE BLOCO
					if (pd.equals("/*")) {
						txtrSaida.setText(txtrSaida.getText() + "/*\tDelimitador na linha " + numLinha + "\n");
						comentado = true;
						continue;
					}

					// VERIFICA SE É INTEIRO
					try {
						Integer.parseInt(pd);
						txtrSaida.setText(txtrSaida.getText() + pd + "\tInteiro" + " na linha " + numLinha + "\n");
						continue;
					} catch (Exception e) {
					}

					// VERIFICA SE É FLOAT
					try {
						Float.parseFloat(pd);
						txtrSaida.setText(txtrSaida.getText() + pd + "\tFloat" + " na linha " + numLinha + "\n");
						continue;
					} catch (Exception e) {
					}

					// PR(PALAVRA RESERVADA) - PERCORRE O ARRAY DE PALAVRAS RESERVADAS
					for (String pr : r.LISTA_PALAVRAS) {
						if (pr.equals(pd)) {
							txtrSaida.setText(
									txtrSaida.getText() + pr + "\tPalavra reservada" + " na linha " + numLinha + "\n");
							encontrou = true;
							break;
						}
					}

					if (encontrou == false) {
						// DL (DELIMITADORES) - PERCORRE O ARRAY DE DELIMITADORES
						for (String dl : r.LISTA_DELIMITADORES) {
							if (dl.equals(pd)) {
								txtrSaida.setText(
										txtrSaida.getText() + dl + "\tDelimitador" + " na linha " + numLinha + "\n");
								encontrou = true;
								break;
							}
						}
					}

					if (encontrou == false) {
						// DL (DELIMITADORES) - PERCORRE O ARRAY DE DELIMITADORES
						for (String op : r.LISTA_OPERADORES[0]) {
							if (op.equals(pd)) {
								txtrSaida.setText(
										txtrSaida.getText() + op + "\tOperador" + " na linha " + numLinha + "\n");
								encontrou = true;
								break;
							}
						}
					}
					if (encontrou == false) {
						for (String op : r.LISTA_OPERADORES[1]) {
							if (op.equals(pd)) {
								txtrSaida.setText(
										txtrSaida.getText() + op + "\tOperador" + " na linha " + numLinha + "\n");
								encontrou = true;
								break;
							}
						}
					}
					if (encontrou == false) {
						if (!pd.equals(""))
							txtrSaida.setText(
									txtrSaida.getText() + pd + "\tIdentificador" + " na linha " + numLinha + "\n");
						continue;
					}
				}
				if (comentado == true) {
					// VERIFICA FIM DO COMENTÁRIO DE BLOCO
					if (pd.equals("*/")) {
						txtrSaida.setText(txtrSaida.getText() + "*/\tDelimitador na linha " + numLinha + "\n");
						comentado = false;
						continue;
					}
				}
			}
		}
	}

	private void analiseSintatica() {

		// LIMPA VARIÁVEIS E TELA
		txtrSaida.setText("");

		int linhamaiponto = 0;
		int linhamenponto = 0;

		numLinha = 0;
		colchetes = 0;
		chaves = 0;
		parenteses = 0;

		boolean quebra = false;

		ArrayList<Integer> menospontvirg = new ArrayList<Integer>();
		ArrayList<Integer> maispontvirg = new ArrayList<Integer>();

		for (String linha : listaLinhas()) {
			numLinha++;
			ArrayList<String> divEspacos = new ArrayList<String>();

			for (String pd : linha.split(" ")) {
				if (pd.equals("//")) {
					break;
				}
				divEspacos.add(pd);
			}

			for (String pd : divEspacos) {

				encontrou = false;
				if (comentado == false) {

					// VERIFICA COMENTÁRIO DE LINHA
					if (pd.equals("//")) {
						break;
					}

					// VERIFICA INICIO DE COMENTÁRIO DE BLOCO
					if (pd.equals("/*")) {
						comentado = true;
						continue;
					}

					// Contador de chaves
					if (pd.equals("{")) {
						chaves++;
						continue;
					}
					if (pd.equals("}")) {
						chaves--;
						continue;
					}

					// Contador de parenteses
					if (pd.equals("(")) {
						parenteses++;
						continue;
					}
					if (pd.equals(")")) {
						parenteses--;
						continue;
					}

					// Contador de colchetes
					if (pd.equals("[")) {
						colchetes++;
						continue;
					}
					if (pd.equals("]")) {
						colchetes--;
						continue;
					}

					// PR(PALAVRA RESERVADA) - PERCORRE O ARRAY DE PALAVRAS RESERVADAS
					for (String pr : r.LISTA_PALAVRAS) {
						if (pr.equals(pd)) {
							encontrou = true;
							break;
						}
					}

					if (encontrou == false) {
						// DL (DELIMITADORES) - PERCORRE O ARRAY DE DELIMITADORES
						for (String dl : r.LISTA_DELIMITADORES) {
							if (dl.equals(pd)) {
								encontrou = true;
								break;
							}
						}
					}

					if (encontrou == false) {
						// DL (DELIMITADORES) - PERCORRE O ARRAY DE DELIMITADORES
						for (String op : r.LISTA_OPERADORES[0]) {
							if (op.equals(pd)) {
								encontrou = true;
								break;
							}
						}
					}
					if (encontrou == false) {
						for (String op : r.LISTA_OPERADORES[1]) {
							if (op.equals(pd)) {
								encontrou = true;
								break;
							}
						}
					}

					// Verifica o Ponto e Virgula
					if (!(divEspacos.get(divEspacos.size() - 1).equals("{")
							|| divEspacos.get(divEspacos.size() - 1).equals("}")
							|| divEspacos.get(divEspacos.size() - 1).equals("("))) {
						if (!divEspacos.get(divEspacos.size() - 1).equals(";")
								&& !divEspacos.get(divEspacos.size() - 1).equals("")) {
							if (linhamenponto == 0 || numLinha != linhamenponto) {
								linhamenponto = numLinha;
								menospontvirg.add(numLinha);
							}
						}
					}
					if (divEspacos.size() > 1) {
						if (divEspacos.get(divEspacos.size() - 2).equals("{")
								|| divEspacos.get(divEspacos.size() - 2).equals("}")
								|| divEspacos.get(divEspacos.size() - 2).equals("(")) {
							if (divEspacos.get(divEspacos.size() - 1).equals(";")) {
								if (linhamaiponto == 0 || numLinha != linhamaiponto) {
									linhamaiponto = numLinha;
									maispontvirg.add(numLinha);
								}
							}
						}
					}
					if (divEspacos.get(divEspacos.size() - 1).equals(";")
							&& divEspacos.get(divEspacos.size() - 2).equals(";")) {
						maispontvirg.add(numLinha);

					}

				}
				if (comentado == true) {
					// VERIFICA FIM DO COMENTÁRIO DE BLOCO
					if (pd.equals("*/")) {
						comentado = false;
						continue;
					}
				}
			}

		}

		if (parenteses > 0)
			txtrSaida.setText(txtrSaida.getText() + "Fechar " + Math.abs(parenteses) + " parentese(s) \n");
		if (parenteses < 0)
			txtrSaida.setText(txtrSaida.getText() + "Abrir " + Math.abs(parenteses) + " parentese(s) \n");

		if (colchetes > 0)
			txtrSaida.setText(txtrSaida.getText() + "Fechar " + Math.abs(colchetes) + " colchete(s) \n");
		if (colchetes < 0)
			txtrSaida.setText(txtrSaida.getText() + "Abrir " + Math.abs(colchetes) + " colchete(s) \n");

		if (chaves > 0)
			txtrSaida.setText(txtrSaida.getText() + "Fechar " + Math.abs(chaves) + " chave(s) \n");
		if (chaves < 0)
			txtrSaida.setText(txtrSaida.getText() + "Abrir " + Math.abs(chaves) + " chave(s) \n");

		for (int menpv : menospontvirg) {
			txtrSaida.setText(txtrSaida.getText() + "Falta de ; na linha " + String.valueOf(menpv) + "\n");
		}
		for (int maipv : maispontvirg) {
			txtrSaida.setText(txtrSaida.getText() + "Excesso ou indevido ; na linha " + String.valueOf(maipv) + "\n");
		}

	}

	private void analiseSemantica() {
		// LIMPA VARIÁVEIS E TELA
		txtrSaida.setText("");

		posichar = 0;
		numLinha = 0;
		aspascont = 0;
		for (String linha : listaLinhas()) {
			numLinha++;
			linha = linha.trim();
			ArrayList<String> divEspacos = new ArrayList<String>();

			aspas = false;
			for (String pd : linha.split(" ")) {
				if (pd.equals("\"")) {
					if (aspascont == 0)
						aspascont++;
					else
						aspascont--;

					if (aspas == false) {
						aspas = true;
					} else {
						aspas = false;
					}
				} else {
					if (aspas == false) {
						if (pd.equals("//")) {
							divEspacos.add(pd);
							break;
						}
					} else {
						continue;
					}
				}
				divEspacos.add(pd);
			}

			aspas = false;
			posichar = 0;
			anterior = "";
			for (String pd : divEspacos) {
				encontrou = false;
				if (comentado == false) {
					posichar++;

					// Verifica contagem das aspas
					if (aspascont != 0)
						txtrSaida.setText(txtrSaida.getText() + "Faltou fechar aspas na linha: " + numLinha + "\n");

					// Verifica os últimos caracteres
					if (posichar == divEspacos.size()) {
						if (pd.equals(";")) {

							if (anterior.equals("if") || anterior.equals("for") || anterior.equals("do")
									|| anterior.equals("parpro") || anterior.equals("switch") || anterior.equals("case")
									|| anterior.equals("break") || anterior.equals("return") || anterior.equals("this")
									|| anterior.equals("exception") || anterior.equals("default")
									|| anterior.equals("continue")) {

								txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe em '" + anterior
										+ "' na linha: " + numLinha + "\n");
							}

							if (anterior.equals(";") || anterior.equals("}") || anterior.equals("{")
									|| anterior.equals("(") || anterior.equals("[")) {
								txtrSaida.setText(txtrSaida.getText() + "Excesso de ; na linha: " + numLinha + "\n");
							}
						} else {

							if (!pd.equals("}") && !pd.equals("{") && !pd.equals("(")) {
								if (pd.equals("if") || pd.equals("for") || pd.equals("do") || pd.equals("parpro")
										|| pd.equals("switch") || pd.equals("case") || pd.equals("break")
										|| pd.equals("return") || pd.equals("this") || pd.equals("exception")
										|| pd.equals("default") || pd.equals("continue")) {

									txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe em '" + pd + "' na linha: "
											+ numLinha + "\n");
								}
								if (divEspacos.size() > 1) {
									txtrSaida.setText(
											txtrSaida.getText() + "Faltou ; no final da linha: " + numLinha + "\n");
								}
							}
						}
						continue;
					}

					if (anterior.equals(";") && !pd.equals("") && !pd.equals(" ")) {
						txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe próximo a '" + pd + "' na linha: "
								+ numLinha + "\t Permitido apenas um comando por linha.\n");
					}

					// Verifica as aspas
					if (pd.equals("\"")) {
						if (posichar == 1) {
							txtrSaida.setText(txtrSaida.getText() + "Falta de argumentos anterior a String na linha:"
									+ numLinha + "\n");
						}
						if (aspas == false)
							aspas = true;
						else
							aspas = false;

						anterior = pd;
						continue;
					}

					// Se não tiver com aspas abertas
					if (aspas == false) {
						// VERIFICA COMENTÁRIO DE LINHA
						if (pd.equals("//")) {
							break;
						}

						// VERIFICA INICIO DE COMENTÁRIO DE BLOCO
						if (pd.equals("/*")) {
							comentado = true;
							continue;
						}

						if (pd.equals("true") || pd.equals("false")) {
							if (!anterior.equals("==") && !anterior.equals("=") && !anterior.equals("{")) {
								txtrSaida.setText(txtrSaida.getText() + "Falta de argumentos para expressão boleana '"
										+ pd + "' na linha: " + numLinha + "\n");
							}
							anterior = pd;
							continue;
						}

						if (pd.equals("else") || pd.equals("while")) {
							if (!anterior.equals("}")) {
								txtrSaida.setText(txtrSaida.getText() + "Falta de } antes do '" + pd + "' na linha: "
										+ numLinha + "\n");
							}
							anterior = pd;
							continue;
						}

						if (pd.equals("date") || pd.equals("int") || pd.equals("float") || pd.equals("boolean")
								|| pd.equals("string") || pd.equals("igor")) {
							if (!anterior.equals("public") && !anterior.equals("private")
									&& !anterior.equals("final")) {
								txtrSaida.setText(txtrSaida.getText()
										+ "Necessário modificador de acesso antes do tipo primitivo '" + pd
										+ "' na linha: " + numLinha + "\n");
							}

							anterior = pd;
							continue;
						}

						if (pd.equals("final")) {
							if (!anterior.equals("public") && !anterior.equals("private")) {
								txtrSaida.setText(txtrSaida.getText()
										+ "Necessário modificador de acesso antes de 'final' na linha: " + numLinha
										+ "\n");
							}
							anterior = pd;
							continue;
						}

						if (pd.equals("+") || pd.equals("-") || pd.equals("/") || pd.equals("*") || pd.equals("^")
								|| pd.equals("<") || pd.equals(">") || pd.equals("<=") || pd.equals(">=")) {

							try {
								Integer.parseInt(anterior);
								anterior = pd;
								continue;
							} catch (Exception e) {
								try {
									Float.parseFloat(anterior);
									anterior = pd;
									continue;
								} catch (Exception e2) {
									if (!anterior.equals(")") && !anterior.equals("]")
											&& !verificaIdentificador(anterior)) {
										txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe antes de '" + pd
												+ "' na linha: " + numLinha + "\n");
									}
									anterior = pd;
									continue;
								}
							}

						}

						if (pd.equals("==") || pd.equals("!=")) {

							try {
								Integer.parseInt(anterior);
								anterior = pd;
								continue;
							} catch (Exception e) {
								try {
									Float.parseFloat(anterior);
									anterior = pd;
									continue;
								} catch (Exception e2) {
									if (!anterior.equals(")") && !anterior.equals("]") && !anterior.equals("\"")
											&& !anterior.equals("'") && !anterior.equals("true")
											&& !anterior.equals("false") && !verificaIdentificador(anterior)) {
										txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe antes de '" + pd
												+ "' na linha: " + numLinha + "\n");
									}
									anterior = pd;
									continue;
								}
							}
						}

						if (pd.equals("%")) {
							try {
								Integer.parseInt(anterior);
								anterior = pd;
								continue;
							} catch (Exception e) {
								if (!verificaIdentificador(anterior)) {
									txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe antes de '" + pd
											+ "' na linha: " + numLinha + "\n");
									anterior = pd;
									continue;
								}
							}
						}

						if (pd.equals("=") || pd.equals("*=") || pd.equals("/=") || pd.equals("-=")
								|| pd.equals("+=")) {
							if (!verificaIdentificador(anterior) && !anterior.equals("]")) {
								txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe antes de '" + pd
										+ "' na linha: " + numLinha + "\n");
								anterior = pd;
								continue;
							}
						}

						if (pd.equals("++") || pd.equals("--")) {
							if (!verificaIdentificador(anterior)) {
								txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe antes de '" + pd
										+ "' na linha: " + numLinha + "\n");
								anterior = pd;
								continue;
							}
						}

						if (pd.equals("?")) {

							try {
								Integer.parseInt(anterior);
								anterior = pd;
								continue;
							} catch (Exception e) {
								try {
									Float.parseFloat(anterior);
									anterior = pd;
									continue;
								} catch (Exception e2) {
									if (!verificaIdentificador(anterior)) {
										txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe antes de '" + pd
												+ "' na linha: " + numLinha + "\n");
									}
									anterior = pd;
									continue;
								}
							}
						}

						if (pd.equals(";")) {
							try {
								Integer.parseInt(anterior);
								anterior = pd;
								continue;
							} catch (Exception e) {
								try {
									Float.parseFloat(anterior);
									anterior = pd;
									continue;
								} catch (Exception e2) {
									if (!verificaIdentificador(anterior) && !anterior.equals(")")
											&& !anterior.equals("]") && !anterior.equals("\"") && !anterior.equals("'")
											&& !anterior.equals("break") && !anterior.equals("continue")
											&& !anterior.equals("return") && !anterior.equals("true")
											&& !anterior.equals("false")) {

										txtrSaida.setText(txtrSaida.getText()
												+ "Erro de sintaxe antes de ponto e virgula na linha: " + numLinha
												+ "\n");
									}
									anterior = pd;
									continue;
								}
							}
						}

						if (pd.equals(".")) {
							if (!anterior.equals("this")) {
								txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe antes do ponto na linha: "
										+ numLinha + "\n");
							}
							anterior = pd;
							continue;
						}

						if (pd.equals(",")) {
							if (!verificaIdentificador(anterior)) {
								txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe antes da virgula na linha: "
										+ numLinha + "\n");
							}
							anterior = pd;
							continue;
						}

						/// Verificador das sitaxes 'depois'
						if (pd.equals("{")) {
							if (!anterior.equals("else") && !anterior.equals("do")) {
								txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe depois de " + anterior
										+ " na linha: " + numLinha + "\n");
							}
							anterior = pd;
							continue;
						}

						if (pd.equals("]")) {
							try {
								Integer.parseInt(anterior);
							} catch (Exception e) {
								txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe antes de " + pd + " na linha: "
										+ numLinha + "\n");
							}
							anterior = pd;
							continue;
						}

						if (pd.equals(")")) {
							try {
								Integer.parseInt(anterior);
								anterior = pd;
								continue;
							} catch (Exception e) {
								try {
									Float.parseFloat(anterior);
									anterior = pd;
									continue;
								} catch (Exception e1) {
									if (!anterior.equals("true") && !anterior.equals("false")) {
										txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe antes de " + pd
												+ " na linha: " + numLinha + "\n");
									}
								}
							}
							anterior = pd;
							continue;
						}

						if (pd.equals(":")) {
							if (!anterior.equals("case") && !anterior.equals("default")) {
								txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe depois de " + anterior
										+ " na linha: " + numLinha + "\n");
							}
							anterior = pd;
							continue;
						}

						if (pd.equals("'")) {
							if (!anterior.equals("return") && !anterior.equals("==") && !anterior.equals("!=")) {
								txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe depois de " + anterior
										+ " na linha: " + numLinha + "\n");
							}
							anterior = pd;
							continue;
						}

						if (pd.equals("void")) {
							if (!anterior.equals("final")) {
								txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe depois de " + anterior
										+ " na linha: " + numLinha + "\n");
							}
							anterior = pd;
							continue;
						}

						/// Verifica antes dos operadores
						encontrou = false;
						for (String op : r.LISTA_OPERADORES[0]) {
							if (op.equals(anterior)) {
								encontrou = true;
								break;
							}
						}

						if (encontrou = false) {
							for (String op : r.LISTA_OPERADORES[1]) {
								if (op.equals(anterior)) {
									encontrou = true;
									break;
								}
							}
						}

						if (encontrou == true) {
							try {
								Integer.parseInt(anterior);
								anterior = pd;
								continue;
							} catch (Exception e) {
								try {
									Float.parseFloat(anterior);
									anterior = pd;
									continue;
								} catch (Exception e1) {
									txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe depois de " + anterior
											+ " na linha: " + numLinha + "\n");
								}
							}
						}

						if (pd.equals("(")) {
							if (!anterior.equals("if") && !anterior.equals("for") && !anterior.equals("while")
									&& !anterior.equals("switch") && !anterior.equals("+") && !anterior.equals("-")
									&& !anterior.equals("/") && !anterior.equals("*") && !anterior.equals("^")
									&& !anterior.equals("<") && !anterior.equals(">") && !anterior.equals("<=")
									&& !anterior.equals(">=") && !anterior.equals("==") && !anterior.equals("!=")
									&& !anterior.equals("=") && !anterior.equals("*=") && !anterior.equals("/=")
									&& !anterior.equals("-=") && !anterior.equals("+=")) {

								txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe depois de " + anterior
										+ " na linha: " + numLinha + "\n");
							}
							anterior = pd;
							continue;
						}

						/// Verificar Inteiro e Float
						encontrou = false;
						try {
							Integer.parseInt(pd);
							if (!anterior.equals("(") && !anterior.equals("[") && !anterior.equals("return")
									&& !anterior.equals("goto")) {
								for (String op : r.LISTA_OPERADORES[0]) {
									if (!op.equals("--") && !op.equals("++")) {
										if (op.equals(anterior)) {
											encontrou = true;
											break;
										}
									}
								}

								if (encontrou == false) {
									for (String op : r.LISTA_OPERADORES[1]) {
										if (op.equals(anterior)) {
											encontrou = true;
											break;
										}
									}
								}

								if (encontrou == false) {
									txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe antes de " + pd
											+ "  na linha: " + numLinha + "\n");
								}
							}
							anterior = pd;
							continue;
						} catch (Exception e) {
							try {
								Float.parseFloat(pd);
								if (!anterior.equals("(") && !anterior.equals("return")) {
									for (String op : r.LISTA_OPERADORES[0]) {
										if (!op.equals("--") && !op.equals("++")) {
											if (op.equals(anterior)) {
												encontrou = true;
												break;
											}
										}
									}

									if (encontrou = false) {
										for (String op : r.LISTA_OPERADORES[1]) {
											if (op.equals(anterior)) {
												encontrou = true;
												break;
											}
										}
									}

									if (encontrou == false) {
										txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe antes de" + pd
												+ "  na linha: " + numLinha + "\n");
									}
								}
								anterior = pd;
								continue;
							} catch (Exception e2) {
							}
						}

						if (verificaIdentificador(pd)) {
							if (!anterior.equals("exception") && !anterior.equals("parpro") && !anterior.equals("date")
									&& !anterior.equals("int") && !anterior.equals("float")
									&& !anterior.equals("boolean") && !anterior.equals("igor")
									&& !anterior.equals("return") && !anterior.equals("+") && !anterior.equals("-")
									&& !anterior.equals("/") && !anterior.equals("*") && !anterior.equals("^")
									&& !anterior.equals("<") && !anterior.equals(">") && !anterior.equals("<=")
									&& !anterior.equals(">=") && !anterior.equals("==") && !anterior.equals("!=")
									&& !anterior.equals("%") && !anterior.equals("=") && !anterior.equals("*=")
									&& !anterior.equals("/=") && !anterior.equals("-=") && !anterior.equals("+=")
									&& !anterior.equals("++") && !anterior.equals("--") && !anterior.equals("?")
									&& !anterior.equals(".")) {

								txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe depois de " + anterior
										+ " na linha: " + numLinha + "\n");
							}
							anterior = pd;
							continue;
						}

						if ((pd.equals("if") || pd.equals("for") || pd.equals("do") || pd.equals("parpro")
								|| pd.equals("switch") || pd.equals("case") || pd.equals("break") || pd.equals("return")
								|| pd.equals("this") || pd.equals("exception") || pd.equals("default")
								|| pd.equals("continue")) && (posichar == divEspacos.size())) {

							txtrSaida.setText(txtrSaida.getText() + "Erro de sintaxe depois de " + pd + " na linha: "
									+ numLinha + "\n");
						}

						anterior = pd;
					}
				} else {
					// VERIFICA FIM DO COMENTÁRIO DE BLOCO
					if (pd.equals("*/")) {
						comentado = false;
						continue;
					}
				}
			}
		}
	}

	private ArrayList<String> listaLinhas() {
		ArrayList<String> linhas = new ArrayList<String>();

		int i = 0; // i é o número da linha
		int j = 0; // j é a posição do caracter

		// CRIA UM VETOR DE LINHAS
		for (String linha : txtrEntrada.getText().split("\n")) {
			i++;
			linha = linha.replaceAll(Pattern.quote(linha), " " + linha + " ");

			// SEPARA OS DELIMITADORES POR ESPAÇO EXCETO O PONTO
			for (String dl : r.LISTA_DELIMITADORES) {
				if (!dl.equals("."))
					linha = linha.replaceAll(Pattern.quote(dl), " " + dl + " ");
			}

			// SEPARA OS OPERADORES CONJUNTOS POR ESPAÇO
			for (String op : r.LISTA_OPERADORES[0]) {
				linha = linha.replaceAll(Pattern.quote(op), " " + op + " ");
			}

			// SEPARA OS OPERADORES ISOLADOS POR ESPAÇO
			sb = new StringBuilder();
			for (String pd : linha.split(" ")) {
				encontrou = false;
				for (String po2 : r.LISTA_OPERADORES[0]) {
					if (pd.equals(po2)) {
						encontrou = true;
						break;
					}
				}
				if (encontrou == false) {
					for (String dl : r.LISTA_DELIMITADORES) {
						if (dl.equals(pd)) {
							encontrou = true;
						}
					}
				}
				if (encontrou == false) {
					for (String pr : r.LISTA_PALAVRAS) {
						if (pr.equals(pd)) {
							encontrou = true;
						}
					}
				}
				if (encontrou == false) {
					for (String po1 : r.LISTA_OPERADORES[1]) {
						if (pd.contains(po1))
							pd = pd.replaceAll(Pattern.quote(po1), " " + po1 + " ");
					}
				}
				sb.append(" ");
				sb.append(pd);
				sb.append(" ");
			}

			linha = " " + sb.toString().replaceAll("\\s+", " ") + " ";

			sb = new StringBuilder();

			// TRATAMENTO ESPECIAL PARA SUBSTITUIR O PONTO
			for (String pd : linha.split(" ")) {
				if (pd.contains(".")) {
					String po[] = pd.split(Pattern.quote("."));
					// SE O PONTO ESTIVER SOZINHO SEPARA ELE POR ESPAÇOS
					if (po.length == 0) {
						sb.append(" . ");
						continue;
					}
					// SE ESTIVER VAZIO APÓS O PONTO VERIFICA SE É NÚMERO
					if (po.length == 1 && po[0].matches("[0-9]*")) {
						sb.append(" ");
						sb.append(pd);
						sb.append(" ");
						continue;
					} else {
						// SE NÃO FOR NÚMERO MAS ESTIVER VAZIO APÓS O PONTO ADICIONAS ESPAÇOS ENTRE ELE
						if (po.length == 1 && !po[0].matches("[0-9]*")) {
							pd = pd.replaceAll(Pattern.quote("."), " . ");
							sb.append(" ");
							sb.append(pd);
							sb.append(" ");
							continue;
						}

						sbp = new StringBuilder();

						// SE CONTER CARACTERES EM AMBOS OS LADO DO PONTO VERIFICA SE É FLOAT
						sbp.append(" ");
						sbp.append(po[0]);

						for (j = 1; j < po.length; j++) {
							// SE A POSIÇÃO ANTERIOR FOR UMA LETRA E NÂO FOR VAZIO OU A POSIÇÃO ATUAL FOR
							// UMA LETRA
							if ((!po[j - 1].matches("[0-9]*") && !po[j - 1].equals("")) || !po[j].matches("[0-9]*")) {
								pd = pd.replaceAll(Pattern.quote("."), " . ");
								sb.append(" ");
								sb.append(pd);
								sb.append(" ");
							} else {
								sbp.append(".");
								sbp.append(po[1]);
								sbp.append(" ");
								sb.append(sbp.toString());
							}
						}
					}
				} else {
					sb.append(" ");
					sb.append(pd);
					sb.append(" ");
				}
			}

			linha = sb.toString().replaceAll("\\s+", " ");

			encontrou = false;

			linhas.add(linha);
		}

		return linhas;
	}

	private boolean verificaIdentificador(String pd) {

		boolean identificador = true;

		// PR(PALAVRA RESERVADA) - PERCORRE O ARRAY DE PALAVRAS RESERVADAS
		for (String pr : r.LISTA_PALAVRAS) {
			if (pr.equals(pd)) {
				identificador = false;
				break;
			}
		}
		if (identificador == true) {
			// DL (DELIMITADORES) - PERCORRE O ARRAY DE DELIMITADORES
			for (String dl : r.LISTA_DELIMITADORES) {
				if (dl.equals(pd)) {
					identificador = false;
					break;
				}
			}
		}

		if (identificador == true) {
			// DL (DELIMITADORES) - PERCORRE O ARRAY DE DELIMITADORES
			for (String op : r.LISTA_OPERADORES[0]) {
				if (op.equals(pd)) {
					identificador = false;
					break;
				}
			}
		}
		if (identificador == true) {
			for (String op : r.LISTA_OPERADORES[1]) {
				if (op.equals(pd)) {
					identificador = false;
					break;
				}
			}
		}
		if (identificador == true) {
			if (pd.equals("")) {
				identificador = false;
			}
		}

		return identificador;
	}

}
