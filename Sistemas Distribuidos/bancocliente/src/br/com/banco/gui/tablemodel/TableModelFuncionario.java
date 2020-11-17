package br.com.banco.gui.tablemodel;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.banco.model.ClienteFisico;
import br.com.banco.model.Funcionario;

public class TableModelFuncionario extends AbstractTableModel{
	//PESSOA
	private static final int ID = 0;
	private static final int NOME = 1;
	private static final int TELEFONE = 2;
	private static final int EMAIL = 3;
	private static final int DATANASCIMENTO = 4;
	//FUNCIONARIO
	private static final int CPF = 5;
	private static final int SALARIO = 6;
	private static final int CARGO = 7;
	
	private static final String[] COLUMNS = {"Cód.","Nome", "Telefone", "Email", "Nascimento", "CPF", "Salario", "Cargo"};
	private List<Funcionario> lista;
	
	public TableModelFuncionario(List<Funcionario> lista) {
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
			//FUNCIONARIO
			case CPF:
				return String.class;
			case SALARIO:
				return BigDecimal.class;
			case CARGO:
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
		Funcionario f = lista.get(row);
		switch(column) {
			//PESSOA
			case ID:
				return f.getId();
			case NOME:
				return f.getNome();
			case TELEFONE:
				return f.getTelefone();
			case EMAIL:
				return f.getEmail();
			case DATANASCIMENTO:
				return f.getDataNascimento();
			//FUNCIONARIO
			case CPF:
				return f.getCpf();
			case SALARIO:
				return f.getSalario();
			case CARGO:
				return f.getCargo();
				
			default:
				throw new IndexOutOfBoundsException("Coluna Invalida");
		}
	}
	
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	 
	public Funcionario getValue(int row) {
		if(row < lista.size()) {
			return lista.get(row);
		}
		return null;
	}
	
	public int getRowIndex(Funcionario f) {
		return lista.indexOf(f);
	}
	
	public void onRemove(int row) {
		lista.remove(row);
		fireTableRowsDeleted(row,row);
	}
	
	public void onRemove(Funcionario f) {
		lista.remove(f);
		fireTableRowsDeleted(getRowIndex(f),getRowIndex(f));
	}
	
	public List<Funcionario> getLista(){
		return lista;
	}
	
	public void onAdd(Funcionario f) {
		boolean existe = false;
		for(Funcionario f1:lista) {
			if(f1==f) {
				existe = true;
				break;
			}
		}
		if(!existe) {
			lista.add(f);
		}
		fireTableDataChanged();
	}
}
