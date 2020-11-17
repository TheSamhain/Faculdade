package br.com.banco.model;

import java.math.BigDecimal;

public class Deposito {
	private Cliente c;
	private int diaBase;
	private BigDecimal valor;
	
	public Cliente getC() {
		return c;
	}
	public void setC(Cliente c) {
		this.c = c;
	}
	public int getDiaBase() {
		return diaBase;
	}
	public void setDiaBase(int diaBase) {
		this.diaBase = diaBase;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
