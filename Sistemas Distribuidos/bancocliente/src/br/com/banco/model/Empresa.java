package br.com.banco.model;

import java.util.GregorianCalendar;
import java.util.List;

public class Empresa {
	private int id;
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private GregorianCalendar dataFund;
	private String telefone;
	private String email;
	private Endereco endereco;
	private List <Funcionario> listaFuncionario;
	
	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}

	public Empresa(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public GregorianCalendar getDataFund() {
		return dataFund;
	}
	
	public void setDataFund(GregorianCalendar dataFund) {
		this.dataFund = dataFund;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
