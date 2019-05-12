package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import beans.Usuario;
import conexao.SingleConnection;

public class UsuarioDao {
	
	private Connection conexao;
	private String sql;

	
	public UsuarioDao() {
		conexao = SingleConnection.getConexao();
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
}
