package br.com.banco.gui.tablemodel;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.banco.model.ClienteJuridico;

public class TableModelClienteJuridico extends AbstractTableModel {
	private static final int ID = 0;
	private static final int NOME = 1;
	private static final int TELEFONE = 2;
	private static final int EMAIL = 3;
	private static final int DATANASCIMENTO = 4;
	
	private static final int LIMITE = 5;
	private static final int SALDO = 6;
	
	private static final int CNPJ = 7;
	
	private static final String[] COLUMNS = {"Cód.","Nome", "Telefone", "Email", "Nascimento", "Limite", "Saldo", "CNPJ"};
	private List<ClienteJuridico> lista;
	
	
	public TableModelClienteJuridico(List<ClienteJuridico> lista) {
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
			case ID:
				return Integer.class;
			case NOME:
				return String.class;
			case TELEFONE:
				return String.class;
			case EMAIL:
				return String.class;
			case DATANASCIMENTO:
				return GregorianCalendar.class;
				
			case LIMITE:
				return BigDecimal.class;
			case SALDO:
				return BigDecimal.class;
				
			case CNPJ:
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
		ClienteJuridico cj = lista.get(row);
		switch(column) {
			case ID:
				return cj.getId();
			case NOME:
				return cj.getNome();
			case TELEFONE:
				return cj.getTelefone();
			case EMAIL:
				return cj.getEmail();
			case DATANASCIMENTO:
				return cj.getDataNascimento();
				
			case LIMITE:
				return cj.getLimite();
			case SALDO:
				return cj.getSaldo();
				
			case CNPJ:
				return cj.getCnpj();			
				
			default:
				throw new IndexOutOfBoundsException("Coluna Invalida");
		}
	}
	
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	 
	public ClienteJuridico getValue(int row) {
		if(row < lista.size()) {
			return lista.get(row);
		}
		return null;
	}
	
	public int getRowIndex(ClienteJuridico cj) {
		return lista.indexOf(cj);
	}
	
	public void onRemove(int row) {
		lista.remove(row);
		fireTableRowsDeleted(row,row);
	}
	
	public void onRemove(ClienteJuridico cj) {
		lista.remove(cj);
		fireTableRowsDeleted(getRowIndex(cj),getRowIndex(cj));
	}
	
	public List<ClienteJuridico> getLista(){
		return lista;
	}
	
	public void onAdd(ClienteJuridico cj) {
		boolean existe = false;
		for(ClienteJuridico cj1:lista) {
			if(cj1==cj) {
				existe = true;
				break;
			}
		}
		if(!existe) {
			lista.add(cj);
		}
		fireTableDataChanged();
	}
	
}
