package br.com.banco.gui.tablemodel;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.banco.model.Conta;
import br.com.banco.model.Endereco;

public class TableModelEndereco  extends AbstractTableModel{
	private static final int ID = 0;
	private static final int LOGRADOURO = 1;
	private static final int NUMERO = 2;
	private static final int COMPLEMENTO = 3;
	private static final int BAIRRO = 4;
	private static final int CIDADE = 5;
	private static final int UF = 6;
	private static final String[] COLUMNS = {"Cód.","Logradouro","Num.","Complemento","Bairro","Cidade","Uf"}; 
	private List<Endereco> lista; 
	
	public TableModelEndereco(List<Endereco> lista) {
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
			case LOGRADOURO:
				return String.class;
			case NUMERO:
				return String.class;
			case COMPLEMENTO:
				return String.class;
			case BAIRRO:
				return String.class;
			case CIDADE:
				return String.class;
			case UF:
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
		Endereco en = lista.get(row);
		switch(column) {
			case ID:
				return en.getId();
			case LOGRADOURO:
				return en.getLogradouro();
			case NUMERO:
				return en.getNumero();
			case COMPLEMENTO:
				return en.getComplemento();
			case BAIRRO:
				return en.getBairro();
			case CIDADE:
				return en.getCidade();
			case UF:
				return Endereco.UF_LIST[en.getUf()];
			default:
				throw new IndexOutOfBoundsException("Coluna Invalida");
		}
	}
	
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	public Endereco getValue(int row) {
		if(row < lista.size()) {
			return lista.get(row);
		}
		return null;
	}
	
	public int getRowIndex(Endereco en) {
		return lista.indexOf(en);
	}
	
	public void onRemove(int row) {
		lista.remove(row);
		fireTableRowsDeleted(row,row);
	}
	
	public void onRemove(Endereco en) {
		lista.remove(en);
		fireTableRowsDeleted(getRowIndex(en),getRowIndex(en));
	}
	
	public List<Endereco> getLista(){
		return lista;
	}
	
	public void onAdd(Endereco en) {
		boolean existe = false;
		for(Endereco e1:lista) {
			if(e1==en) {
				existe = true;
				break;
			}
		}
		if(!existe) {
			lista.add(en);
		}
		fireTableDataChanged();
	}
}
