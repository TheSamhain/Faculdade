package br.com.banco.gui.tablemodel;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import br.com.banco.model.Conta;


public class TableModelConta extends AbstractTableModel{
	private static final int ID = 0;
	private static final int AGENCIA = 1;
	private static final int TAXA_MANUTENCAO = 2;
	private static final int TIPO_CONTA = 3;
	private static final String[] COLUMNS = {"Cód.","Agência","Taxa Manu.","Tipo"};
	private List<Conta> lista;
	
	public TableModelConta(List<Conta> lista) {
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
			case AGENCIA:
				return String.class;
			case TAXA_MANUTENCAO:
				return BigDecimal.class;
			case TIPO_CONTA:
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
		Conta c = lista.get(row);
		switch(column) {
			case ID:
				return c.getId();
			case AGENCIA:
				return c.getAgencia();
			case TAXA_MANUTENCAO:
				return c.getTaxaManutencao();
			case TIPO_CONTA:
				return c.getTipoConta() + " - " + Conta.TIPO_CONTA_LIST[c.getTipoConta()];
			default:
				throw new IndexOutOfBoundsException("Coluna Invalida");
		}
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	 
	public Conta getValue(int row) {
		if(row < lista.size()) {
			return lista.get(row);
		}
		return null;
	}
	
	public int getRowIndex(Conta c) {
		return lista.indexOf(c);
	}
	
	public void onRemove(int row) {
		lista.remove(row);
		fireTableRowsDeleted(row,row);
	}
	
	public void onRemove(Conta c) {
		lista.remove(c);
		fireTableRowsDeleted(getRowIndex(c),getRowIndex(c));
	}
	
	public List<Conta> getLista(){
		return lista;
	}
	
	public void onAdd(Conta c) {
		boolean existe = false;
		for(Conta c1:lista) {
			if(c1==c) {
				existe = true;
				break;
			}
		}
		if(!existe) {
			lista.add(c);
		}
		fireTableDataChanged();
	}
}
