package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Usuario;
import conexao.SingleConnection;

public class UsuarioDao {
	
	private Connection conexao;
	private String sql;
	

	
	public UsuarioDao() {
		conexao = SingleConnection.getConexao();
	}
	
	public List<Usuario> listAll() throws SQLException{
		List<Usuario> list = new ArrayList<Usuario>();
		
		this.sql = "SELECT * FROM usuario";
		PreparedStatement listAll = conexao.prepareStatement(this.sql);
		
		ResultSet res = listAll.executeQuery();

		
		while (res.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(res.getInt("id"));
			usuario.setUsuario(res.getString("login"));
			usuario.setSenha(res.getString("senha"));
			list.add(usuario);
			
			
		}
		
		
		return list;
	}
	
	public Usuario listOne(int id) throws SQLException {
		this.sql = "SELECT * FROM usuario WHERE id =?";
		PreparedStatement listOne = conexao.prepareStatement(this.sql);
		listOne.setInt(1, id);
		
		ResultSet res = listOne.executeQuery();
		
		if (res.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(res.getInt("id"));
			usuario.setUsuario(res.getString("login"));
			usuario.setSenha(res.getString("senha"));
			
			return usuario;
		}
		
		return null;
	}
	
	public Usuario insert(Usuario usuario) throws SQLException{

		this.sql = "INSERT INTO usuario (login, senha) VALUES(?, ?)";
		PreparedStatement insert = conexao.prepareStatement(this.sql);
		insert.setString(1, usuario.getUsuario());
		insert.setString(2, usuario.getSenha());
		insert.execute();
		conexao.commit();
		
		return usuario;
	}
	
	public boolean verificaUsuario(String usuario) throws SQLException {
		this.sql = "SELECT login FROM usuario WHERE login = ?";
		PreparedStatement select  = conexao.prepareStatement(this.sql);
		select.setString(1, usuario);
		
		
		ResultSet res = select.executeQuery();
		if (res.next()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void delete(int id) throws SQLException {
		this.sql = "DELETE FROM usuario WHERE id = ?";
		PreparedStatement delete = conexao.prepareStatement(this.sql);
		delete.setInt(1, id);
		delete.execute();
	}
	
	
	public void update(Usuario usuario, int id) throws SQLException {
		this.sql = "UPDATE usuario SET login = ?, senha = ? WHERE id = ?";
		PreparedStatement update = conexao.prepareStatement(this.sql);
		update.setString(1, usuario.getUsuario());
		update.setString(2, usuario.getSenha());
		update.setInt(3, id);
		update.execute();
		conexao.commit();
	}
}
