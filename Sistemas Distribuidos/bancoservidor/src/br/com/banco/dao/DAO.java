package br.com.banco.dao;

import java.util.List;

public interface DAO<T> {
	public void salvar(T obj);
	public void excluir (int id);
	public List<T> pesquisar();
	public T pesquisar(int id);
}
