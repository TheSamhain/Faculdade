package br.com.banco.model;

public class Endereco {
	
	public static final int UF_ACRE = 0;
	public static final int UF_ALAGOAS = 1;
	public static final int UF_AMAPA = 2;
	public static final int UF_AMAZONAS = 3;
	public static final int UF_BAHIA = 4;
	public static final int UF_CEARA = 5;
	public static final int UF_DISTRITO_FEDERAL = 6;
	public static final int UF_ESPIRITO_SANTO = 7;
	public static final int UF_GOIAS = 8;
	public static final int UF_MARANHAO = 9;
	public static final int UF_MATO_GROSSO = 10;
	public static final int UF_MATO_GROSSO_DO_SUL = 11;
	public static final int UF_MINAS_GERAIS = 12;
	public static final int UF_PARA = 13;
	public static final int UF_PARAIBA = 14;
	public static final int UF_PARANA = 15;
	public static final int UF_PERNAMBUCO = 16;
	public static final int UF_PIAUI = 17;
	public static final int UF_RIO_DE_JANEIRO = 18;
	public static final int UF_RIO_GRANDE_DO_NORTE = 19;
	public static final int UF_RIO_GRANDE_DO_SUL = 20;
	public static final int UF_RONDONIA = 21;
	public static final int UF_RORAIMA = 22;
	public static final int UF_SANTA_CATARINA = 23;
	public static final int UF_SAO_PAULO = 24;
	public static final int UF_SERGIPE = 25;
	public static final int UF_TOCANTINS = 26;
	
	public static final String[] UF_LIST = {"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"};
	
	private int id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private int uf;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getUf() {
		return uf;
	}

	public void setUf(int uf) {
		this.uf = uf;
	}
}
