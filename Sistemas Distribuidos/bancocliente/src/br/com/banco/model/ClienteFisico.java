package br.com.banco.model;

import java.math.BigDecimal;

public class ClienteFisico extends Cliente {
	private String cpf;
	private Integer qtdeLimiteConsultas;
	private BigDecimal limitePagamento;
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Integer getQtdeLimiteConsultas() {
		return qtdeLimiteConsultas;
	}
	
	public void setQtdeLimiteConsultas(Integer qtdeLimiteConsultas) {
		this.qtdeLimiteConsultas = qtdeLimiteConsultas;
	}
	
	public BigDecimal getLimitePagamento() {
		return limitePagamento;
	}
	
	public void setLimitePagamento(BigDecimal limitePagamento) {
		this.limitePagamento = limitePagamento;
	}
}