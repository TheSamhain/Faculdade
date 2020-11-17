package br.com.banco.model;

import java.math.BigDecimal;

public class Conta {
	
	public static final int TIPO_CONTA_POUPANCA = 0;
	public static final int TIPO_CONTA_CORRENTE = 1;
	public static final int TIPO_CONTA_SALARIO = 2;
	public static final int TIPO_CONTA_DIGITAL = 3;
	public static final String[] TIPO_CONTA_LIST = {"Conta poupança", "Conta corrente", "Conta salário", "Conta digital"};
	
	private int id;
	private BigDecimal taxaManutencao;
	private String agencia;
	private int tipoConta;
	
	public int getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getTaxaManutencao() {
		return taxaManutencao;
	}
	public void setTaxaManutencao(BigDecimal taxaManutencao) {
		this.taxaManutencao = taxaManutencao;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
}
