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
    
    public ClientesDAO(){
        this.conecta = new ConnectionFactory().conecta(); 
    }
    
    //Metodo Cadastrar cliente
    public void cadastrarCliente(Clientes obj){
        try {
            //criar comando SQL
            String cmdsql = "insert into clientes(nome,telefone,email) values (?,?,?)";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getTelefone());
            stmt.setString(3,obj.getEmail());
            
            stmt.execute();
            
            stmt.close();
            
        } catch (SQLException erro) {
         throw new RuntimeException(erro);
        }
    }
    
    
    public List<Clientes> ListarClientesPorNome(String nome){
        
        try{
            
            //  comando criar o vetor que vai armazenar os registros do banco
            List<Clientes> lista = new ArrayList<Clientes>();
            
            // criar o comando sql
            String cmdsql = "select * from clientes where nome like ?";
        
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1,nome);
            
            // guardar o resultado do select dentro do objeto RS (resultSet)            
            ResultSet rs = stmt.executeQuery();
        
            //Enquanto houve registros (resultados do select) guarda o registro na lista
            while(rs.next()){
                Clientes c = new Clientes();
                c.setIdcliente(rs.getInt("idcliente"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
            
                lista.add(c);
            }
            return lista;   
        
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    
    }
    
       public List<Clientes> ListarClientes(){
        
        try{
            
            //  comando criar o vetor que vai armazenar os registros do banco
            List<Clientes> lista = new ArrayList<Clientes>();
            
            // criar o comando sql
            String cmdsql = "select * from clientes";
        
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            // guardar o resultado do select dentro do objeto RS (resultSet)            
            ResultSet rs = stmt.executeQuery();
        
            //Enquanto houve registros (resultados do select) guarda o registro na lista
            while(rs.next()){
                Clientes c = new Clientes();
                c.setIdcliente(rs.getInt("idcliente"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
            
                lista.add(c);
            }
            return lista;   
        
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    
    }

 public void alterarCliente(Clientes obj){
        try {
            //criar comando SQL
            String cmdsql = "update clientes set nome=?, telefone=?, email=? where idcliente=?";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getTelefone());
            stmt.setString(3,obj.getEmail());
            stmt.setInt(4,obj.getIdcliente());
            
            stmt.execute();
            
            stmt.close();
            
        } catch (SQLException erro) {
         throw new RuntimeException(erro);
        }
    }
 
  public void excluirCliente(Clientes obj){
        try {
            //criar comando SQL
            String cmdsql = "delete from clientes where idcliente=?";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setInt(1,obj.getIdcliente());
            
            stmt.execute();
            
            stmt.close();
            
        } catch (SQLException erro) {
         throw new RuntimeException(erro);
        }
    }
}
