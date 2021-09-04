package br.com.banco.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.banco.model.Endereco;

public class EnderecoDAO implements DAO<Endereco>{
	public void salvar(Endereco obj) {
		Connection con = FabricaConexao.getConnection();
		String sql;
		if(obj.getId()>0) {
			sql = "UPDATE endereco SET logradouro = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, uf = ? WHERE id = ?";
		} else {
			sql = "INSERT INTO endereco(logradouro,numero,complemento,bairro,cidade,uf) VALUES(?,?,?,?,?,?)";
		}
		try {			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, obj.getLogradouro());
			ps.setString(2, obj.getNumero());
			ps.setString(3, obj.getComplemento());
			ps.setString(4, obj.getBairro());
			ps.setString(5, obj.getCidade());
			ps.setInt(6, obj.getUf());
			if(obj.getId()>0) {
				ps.setInt(7, obj.getId());
			}
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		String sql = "DELETE FROM endereco WHERE id = ?";
		Connection con = FabricaConexao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Endereco> pesquisar(){
		String sql = "SELECT * FROM endereco";
		List<Endereco> list = new ArrayList<Endereco>();
		Connection con = FabricaConexao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Endereco en = new Endereco();
				en.setId(rs.getInt("id"));
				en.setLogradouro(rs.getString("logradouro"));
				en.setNumero(rs.getString("numero"));
				en.setComplemento(rs.getString("complemento"));
				en.setBairro(rs.getString("bairro"));
				en.setCidade(rs.getString("cidade"));
				en.setUf(rs.getInt("uf"));
				list.add(en);
			}
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public Endereco pesquisar(int id) {
		String sql = "SELECT * FROM endereco WHERE id = ?";
		Endereco en = null;
		Connection con = FabricaConexao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			en = new Endereco();
			en.setId(rs.getInt("id"));
			en.setLogradouro(rs.getString("logradouro"));
			en.setNumero(rs.getString("numero"));
			en.setComplemento(rs.getString("complemento"));
			en.setBairro(rs.getString("bairro"));
			en.setCidade(rs.getString("cidade"));
			en.setUf(rs.getInt("uf"));
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return en;
	}
}
