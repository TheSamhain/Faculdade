package br.com.banco.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancocliente","bancousr","Abc.12345");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
