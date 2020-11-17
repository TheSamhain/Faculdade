package DAO;

import JDBC.ConnectionFactory;
import Javabeans.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {

    private Connection conecta;

    public ClientesDAO() {
        this.conecta = new ConnectionFactory().conecta();
    }

    public void cadastrarCliente(Clientes obj) {
        try {
            String cmdsql = "insert into clientes(nome,tel,email) values(?,?,?)";

            //organizar e executar
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getTelefone());
            stmt.setString(3, obj.getEmail());

            //executa
            stmt.execute();

            //fecharconnection
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    //listar

    public List<Clientes> listarClientes() {
        try {
            List<Clientes> lista = new ArrayList<Clientes>();

            String cmdSql = "select* from clientes";
            PreparedStatement stmt = conecta.prepareStatement(cmdSql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes v = new Clientes();
                v.setId(rs.getInt("idcliente"));
                v.setNome(rs.getString("nome"));
                v.setTelefone(rs.getString("tel"));
                v.setEmail(rs.getString("email"));

                lista.add(v);
            }
            return lista;
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
    }

    public void alterarCliente(Clientes obj) {
        try {
            String cmdsql = "update clientes set nome = ?, tel = ?, email = ? where idcliente = ?";

            //organizar e executar
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getTelefone());
            stmt.setString(3, obj.getEmail());
            stmt.setInt(4, obj.getId());

            //executa
            stmt.execute();

            //fecharconnection
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public void excluirCliente(Clientes obj) {
        try {
            String cmdsql = "delete from clientes where idcliente = ?";

            //organizar e executar
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);

            stmt.setInt(1, obj.getId());

            //executa
            stmt.execute();

            //fecharconnection
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public List<Clientes> listarClientesnome(String nome) {
        try {
            List<Clientes> lista = new ArrayList<Clientes>();

            String cmdSql = "select* from clientes where nome like ?";
            PreparedStatement stmt = conecta.prepareStatement(cmdSql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes v = new Clientes();
                v.setId(rs.getInt("idcliente"));
                v.setNome(rs.getString("nome"));
                v.setTelefone(rs.getString("tel"));
                v.setEmail(rs.getString("email"));

                lista.add(v);
            }
            return lista;
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
    }

}
