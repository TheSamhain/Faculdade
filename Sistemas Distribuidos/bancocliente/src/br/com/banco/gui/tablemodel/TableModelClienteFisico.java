package br.com.banco.gui.tablemodel;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.banco.model.ClienteFisico;
import br.com.banco.model.Conta;

public class TableModelClienteFisico extends AbstractTableModel {
	//PESSOA
	private static final int ID = 0;
	private static final int NOME = 1;
	private static final int TELEFONE = 2;
	private static final int EMAIL = 3;
	private static final int DATANASCIMENTO = 4;
	//CLIENTE
	private static final int LIMITE = 5;
	private static final int SALDO = 6;
	//CLIENTE FISICO
	private static final int CPF = 7;
	private static final int LIMITEPAGAMENTO = 8;
	private static final int QTDECONSULTA = 9;
	
	private static final String[] COLUMNS = {"Cód.","Nome", "Telefone", "Email", "Nascimento", "Limite", "Saldo", "CPF", "Lim. Pagamento", "Qtde. Consultas"};
	private List<ClienteFisico> lista;
	
	public TableModelClienteFisico(List<ClienteFisico> lista) {
		this.lista = lista;
	}
	public int getColumnCount() {
		return COLUMNS.length;
	}
	public int getRowCount() {
		return lista.size();
	}
	
	public Class<?> getColumnClass(int columnIndex){
		switch(columnIndex) {
			//PESSOA
			case ID:
				return Integer.class;
			case NOME:
				return String.class;
			case TELEFONE:
				return String.class;
			case EMAIL:
				return String.class;
			case DATANASCIMENTO:
				return String.class;
			//CLIENTE
			case LIMITE:
				return BigDecimal.class;
			case SALDO:
				return BigDecimal.class;
			//CLIENTE FISICO
			case CPF:
				return String.class;
			case QTDECONSULTA:
				return String.class;
			case LIMITEPAGAMENTO:
				return String.class;
			default:
				throw new IndexOutOfBoundsException("Coluna Inválida");
		}

}
	
	public String getColumnName(int column) {
		return COLUMNS[column];
	}
	
	public Object getValueAt(int row, int column) {
		if(lista.isEmpty()) {
			return null;
		}
		ClienteFisico cf = lista.get(row);
		switch(column) {
			//PESSOA
			case ID:
				return cf.getId();
			case NOME:
				return cf.getNome();
			case TELEFONE:
				return cf.getTelefone();
			case EMAIL:
				return cf.getEmail();
			case DATANASCIMENTO:
				return cf.getDataNascimento();
			//CLIENTE
			case LIMITE:
				return cf.getLimite();
			case SALDO:
				return cf.getSaldo();
			//CLIENTE FISICO
			case CPF:
				return cf.getCpf();
			case QTDECONSULTA:
				return cf.getQtdeLimiteConsultas();
			case LIMITEPAGAMENTO:
				return cf.getLimitePagamento();
				
			default:
				throw new IndexOutOfBoundsException("Coluna Invalida");
		}
	}
	
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	 
	public ClienteFisico getValue(int row) {
		if(row < lista.size()) {
			return lista.get(row);
		}
		return null;
	}
	
	public int getRowIndex(ClienteFisico cf) {
		return lista.indexOf(cf);
	}
	
	public void onRemove(int row) {
		lista.remove(row);
		fireTableRowsDeleted(row,row);
	}
	
	public void onRemove(ClienteFisico cf) {
		lista.remove(cf);
		fireTableRowsDeleted(getRowIndex(cf),getRowIndex(cf));
	}
	
	public List<ClienteFisico> getLista(){
		return lista;
	}
	
	public void onAdd(ClienteFisico cf) {
		boolean existe = false;
		for(ClienteFisico cf1:lista) {
			if(cf1==cf) {
				existe = true;
				break;
			}
		}
		if(!existe) {
			lista.add(cf);
		}
		fireTableDataChanged();
	}
	
}
