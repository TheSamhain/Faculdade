package br.com.banco.dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.banco.model.ClienteFisico;
import br.com.banco.model.Conta;
import br.com.banco.model.Endereco;;

public class ClienteFisicoDAO implements DAO<ClienteFisico>{
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdfdb = new SimpleDateFormat("yyyy-MM-dd");
	
	public void salvar(ClienteFisico obj) {
		Connection con = FabricaConexao.getConnection();
		String sql;
		if(obj.getId()>0) {
			sql = "UPDATE clientefisico SET idendereco= ?, nome = ?, telefone = ?, email = ?, datanascimento = ?, limite = ?,";
			sql += " direitocheque = ?, cartaocredito = ?, idconta = ?,saldo = ?, cpf = ?, qtdelimiteconsultas = ?, limitepagamento = ?";
			sql += " WHERE id = ?";
		} else {
			sql = "INSERT INTO clientefisico(idendereco, nome, telefone, email, datanascimento, limite,";
			sql += "direitocheque, cartaocredito, idconta, saldo, cpf, qtdelimiteconsultas, limitepagamento)";
			sql += " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			//CLIENTE
			ps.setBigDecimal(6 , obj.getLimite());
			ps.setBoolean(7, obj.isDireitoCheque());
			ps.setBoolean(8, obj.isCartaoCredito());
			ps.setInt(9, obj.getConta().getId());
			ps.setBigDecimal(10, obj.getSaldo());
			//CLIENTE FISICO
			ps.setString(11, obj.getCpf());
			ps.setInt(12, obj.getQtdeLimiteConsultas());
			ps.setBigDecimal(13, obj.getLimitePagamento());
			
			if(obj.getId()>0) {
				ps.setInt(14, obj.getId());
			}
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		String sql = "DELETE FROM clientefisico WHERE id = ?";
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
	
	public List<ClienteFisico> pesquisar(){
		String sql = "SELECT * FROM clientefisico";
		List<ClienteFisico> list = new ArrayList<ClienteFisico>();
		Connection con = FabricaConexao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ClienteFisico cf = new ClienteFisico();
				Endereco en = new Endereco();
				Conta c = new Conta();
				//PESSOA
				cf.setId(rs.getInt("id"));
				en.setId(rs.getInt("idendereco"));
				cf.setEndereco(en);
				cf.setNome(rs.getString("nome"));
				cf.setTelefone(rs.getString("telefone"));
				cf.setEmail(rs.getString("email"));
				cf.setDataNascimento(rs.getString("datanascimento"));
				//CLIENTE
				cf.setLimite(rs.getBigDecimal("limite"));
				cf.setDireitoCheque(rs.getBoolean("direitocheque"));
				cf.setCartaoCredito(rs.getBoolean("cartaocredito"));
				c.setId(rs.getInt("idconta"));
				cf.setConta(c);
				cf.setSaldo(rs.getBigDecimal("saldo"));
				//CLIENTE FISICO
				cf.setCpf(rs.getString("cpf"));
				cf.setQtdeLimiteConsultas(rs.getInt("qtdelimiteconsultas"));
				cf.setLimitePagamento(rs.getBigDecimal("limitepagamento"));
				
				list.add(cf);
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

	public ClienteFisico pesquisar(int id) {
		String sql = "SELECT * FROM clientefisico WHERE id = ?";
		ClienteFisico cf = null;
		Endereco en = new Endereco();
		Conta c = new Conta();
		
		Connection con = FabricaConexao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			cf = new ClienteFisico();
			//PESSOA
			cf.setId(rs.getInt("id"));
			en.setId(rs.getInt("idendereco"));
			cf.setEndereco(en);
			cf.setNome(rs.getString("nome"));
			cf.setTelefone(rs.getString("telefone"));
			cf.setEmail(rs.getString("email"));
			cf.setDataNascimento(rs.getString("datanascimento"));
			//CLIENTE
			cf.setLimite(rs.getBigDecimal("limite"));
			cf.setDireitoCheque(rs.getBoolean("direitocheque"));
			cf.setCartaoCredito(rs.getBoolean("cartaocredito"));
			c.setId(rs.getInt("idconta"));
			cf.setConta(c);
			cf.setSaldo(rs.getBigDecimal("saldo"));
			//CLIENTE FISICO
			cf.setCpf(rs.getString("cpf"));
			cf.setQtdeLimiteConsultas(rs.getInt("qtdelimiteconsultas"));
			cf.setLimitePagamento(rs.getBigDecimal("limitepagamento"));
			
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
		return cf;
	}
}
