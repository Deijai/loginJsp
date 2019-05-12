package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
