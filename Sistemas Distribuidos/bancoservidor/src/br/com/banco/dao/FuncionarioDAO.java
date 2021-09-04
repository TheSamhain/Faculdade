package br.com.banco.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.banco.model.Endereco;
import br.com.banco.model.Funcionario;

public class FuncionarioDAO {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdfdb = new SimpleDateFormat("yyyy-MM-dd");
	
	public void salvar(Funcionario obj) {
		Connection con = FabricaConexao.getConnection();
		String sql;
		if(obj.getId()>0) {
			sql = "UPDATE funcionario SET idendereco= ?, nome = ?, telefone = ?, email = ?, datanascimento = ?";
			sql += " cpf = ?, salario = ?, cargo = ?";
			sql += " WHERE id = ?";
		} else {
			sql = "INSERT INTO funcionario(idendereco, nome, telefone, email, datanascimento, ";
			sql += "cpf, salario, cargo)";
			sql += " VALUES(?,?,?,?,?,?,?,?)";
		}
		try {			
			PreparedStatement ps = con.prepareStatement(sql);
			//PESSOA
			ps.setInt(1, obj.getEndereco().getId());
			ps.setString(2, obj.getNome());
			ps.setString(3, obj.getTelefone());
			ps.setString(4, obj.getEmail());
			java.util.Date data = null;
			try {
				data = sdf.parse(obj.getDataNascimento());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			ps.setString(5, sdfdb.format(data));
			//FUNCIONARIO
			ps.setString(6, obj.getCpf());
			ps.setBigDecimal(7, obj.getSalario());
			ps.setString(8, obj.getCargo());
			
			if(obj.getId()>0) {
				ps.setInt(9, obj.getId());
			}
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		String sql = "DELETE FROM funcionario WHERE id = ?";
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
	
	public List<Funcionario> pesquisar(){
		String sql = "SELECT * FROM funcionario";
		List<Funcionario> list = new ArrayList<Funcionario>();
		Connection con = FabricaConexao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Funcionario f = new Funcionario();
				Endereco en = new Endereco();
				//PESSOA
				f.setId(rs.getInt("id"));
				en.setId(rs.getInt("idendereco"));
				f.setEndereco(en);
				f.setNome(rs.getString("nome"));
				f.setTelefone(rs.getString("telefone"));
				f.setEmail(rs.getString("email"));
				f.setDataNascimento(rs.getString("datanascimento"));
				//FUNCIONARIO
				f.setCpf(rs.getString("cpf"));
				f.setSalario(rs.getBigDecimal("salario"));
				f.setCargo(rs.getString("cargo"));
				
				list.add(f);
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

	public Funcionario pesquisar(int id) {
		String sql = "SELECT * FROM funcionario WHERE id = ?";
		Funcionario f = null;
		Endereco en = new Endereco();
		
		Connection con = FabricaConexao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			f = new Funcionario();
			//PESSOA
			f.setId(rs.getInt("id"));
			en.setId(rs.getInt("idendereco"));
			f.setEndereco(en);
			f.setNome(rs.getString("nome"));
			f.setTelefone(rs.getString("telefone"));
			f.setEmail(rs.getString("email"));
			f.setDataNascimento(rs.getString("datanascimento"));
			//FUNCIONARIO
			f.setCpf(rs.getString("cpf"));
			f.setSalario(rs.getBigDecimal("salario"));
			f.setCargo(rs.getString("cargo"));
			
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
		return f;
	}
}
