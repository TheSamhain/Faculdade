package br.com.banco.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.banco.model.Conta;

public class ContaDAO implements DAO<Conta>{
	public void salvar(Conta obj) {
		Connection con = FabricaConexao.getConnection();
		String sql;
		if(obj.getId()>0) {
			sql = "UPDATE conta SET taxamanu = ?, agencia = ?, tipoconta = ? WHERE id = ?";
		} else {
			sql = "INSERT INTO conta(taxamanu,agencia,tipoconta) VALUES(?,?,?)";
		}
		try {			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBigDecimal(1, obj.getTaxaManutencao());
			ps.setString(2, obj.getAgencia());
			ps.setInt(3, obj.getTipoConta());
			if(obj.getId()>0) {
				ps.setInt(4, obj.getId());
			}
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		String sql = "DELETE FROM conta WHERE id = ?";
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
	
	public List<Conta> pesquisar(){
		String sql = "SELECT * FROM conta";
		List<Conta> list = new ArrayList<Conta>();
		Connection con = FabricaConexao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Conta c = new Conta();
				c.setId(rs.getInt("id"));
				c.setAgencia(rs.getString("agencia"));
				c.setTaxaManutencao(rs.getBigDecimal("taxamanu"));
				c.setTipoConta(rs.getInt("tipoconta"));
				list.add(c);
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

	public Conta pesquisar(int id) {
		String sql = "SELECT * FROM conta WHERE id = ?";
		Conta c = null;
		Connection con = FabricaConexao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			c = new Conta();
			c.setId(rs.getInt("id"));
			c.setAgencia(rs.getString("agencia"));
			c.setTaxaManutencao(rs.getBigDecimal("taxamanu"));
			c.setTipoConta(rs.getInt("tipoconta"));
			
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
		return c;
	}
}
