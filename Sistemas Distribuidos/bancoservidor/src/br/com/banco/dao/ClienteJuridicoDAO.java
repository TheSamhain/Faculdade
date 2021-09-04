package br.com.banco.dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.banco.model.ClienteJuridico;
import br.com.banco.model.Conta;
import br.com.banco.model.Endereco;;

public class ClienteJuridicoDAO implements DAO<ClienteJuridico>{
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdfdb = new SimpleDateFormat("yyyy-MM-dd");
	
	public void salvar(ClienteJuridico obj) {
		Connection con = FabricaConexao.getConnection();
		String sql;
		if(obj.getId()>0) {
			sql = "UPDATE clientejuridico SET idendereco= ?, nome = ?, telefone = ?, email = ?, datanascimento = ?, limite = ?,";
			sql += " direitocheque = ?, cartaocredito = ?, idconta = ?,saldo = ?, cnpj = ?";
			sql += " WHERE id = ?";
		} else {
			sql = "INSERT INTO clientejuridico(idendereco, nome, telefone, email, datanascimento, limite,";
			sql += "direitocheque, cartaocredito, idconta, saldo, cnpj)";
			sql += " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
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
			ps.setString(11, obj.getCnpj());
			
			if(obj.getId()>0) {
				ps.setInt(12, obj.getId());
			}
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		String sql = "DELETE FROM clientejuridico WHERE id = ?";
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
	
	public List<ClienteJuridico> pesquisar(){
		String sql = "SELECT * FROM clientejuridico";
		List<ClienteJuridico> list = new ArrayList<ClienteJuridico>();
		Connection con = FabricaConexao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ClienteJuridico cj = new ClienteJuridico();
				Endereco en = new Endereco();
				Conta c = new Conta();
				
				//PESSOA
				cj.setId(rs.getInt("id"));
				en.setId(rs.getInt("idendereco"));
				cj.setEndereco(en);
				cj.setNome(rs.getString("nome"));
				cj.setTelefone(rs.getString("telefone"));
				cj.setEmail(rs.getString("email"));
				cj.setDataNascimento(rs.getString("datanascimento"));
				//CLIENTE
				cj.setLimite(rs.getBigDecimal("limite"));
				cj.setDireitoCheque(rs.getBoolean("direitocheque"));
				cj.setCartaoCredito(rs.getBoolean("cartaocredito"));
				c.setId(rs.getInt("idconta"));
				cj.setConta(c);
				cj.setSaldo(rs.getBigDecimal("saldo"));
				//CLIENTE JURIDICO
				cj.setCnpj(rs.getString("cnpj"));
				
				list.add(cj);
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

	public ClienteJuridico pesquisar(int id) {
		String sql = "SELECT * FROM clientejuridico WHERE id = ?";
		ClienteJuridico cj = null;
		Endereco en = new Endereco();
		Conta c = new Conta();
		
		Connection con = FabricaConexao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			cj = new ClienteJuridico();
			//PESSOA
			cj.setId(rs.getInt("id"));
			en.setId(rs.getInt("idendereco"));
			cj.setEndereco(en);
			cj.setNome(rs.getString("nome"));
			cj.setTelefone(rs.getString("telefone"));
			cj.setEmail(rs.getString("email"));
			cj.setDataNascimento(rs.getString("datanascimento"));
			//CLIENTE
			cj.setLimite(rs.getBigDecimal("limite"));
			cj.setDireitoCheque(rs.getBoolean("direitocheque"));
			cj.setCartaoCredito(rs.getBoolean("cartaocredito"));
			c.setId(rs.getInt("idconta"));
			cj.setConta(c);
			cj.setSaldo(rs.getBigDecimal("saldo"));
			//CLIENTE FISICO
			cj.setCnpj(rs.getString("cnpj"));
			
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
		return cj;
	}
}
