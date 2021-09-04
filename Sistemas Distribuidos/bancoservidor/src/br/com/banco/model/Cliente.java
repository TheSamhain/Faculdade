package br.com.banco.model;

import java.math.BigDecimal;

public abstract class Cliente extends Pessoa {
	private BigDecimal limite;
	private boolean direitoCheque;
	private boolean cartaoCredito;
	private Conta conta;
	private BigDecimal saldo;
	
	public static final int OPCAO_LIST_SIM = 0;
	public static final int OPCAO_LIST_NAO = 1;
	public static final String[] OPCAO_LIST = {"Sim","Não"};
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	public BigDecimal getLimite() {
		return limite;
	}
	
	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}
	
	public boolean isDireitoCheque() {
		return direitoCheque;
	}
	
	public void setDireitoCheque(boolean direitoCheque) {
		this.direitoCheque = direitoCheque;
	}
	
	public boolean isCartaoCredito() {
		return cartaoCredito;
	}
	
	public void setCartaoCredito(boolean cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}
}
