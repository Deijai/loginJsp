package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexao.SingleConnection;


public class LoginDao {
	
	private Connection conexao;
	private String sql;
	
	public LoginDao() {
		conexao = SingleConnection.getConexao();
	}
	
	public boolean validaLogin(String login, String senha) throws Exception{
		this.sql = "SELECT * FROM usuario WHERE login = ? and senha = ?";
		PreparedStatement select = conexao.prepareStatement(this.sql);
		select.setString(1, login);
		select.setString(2, senha);
		
		ResultSet res = select.executeQuery();
		
		if(res.next()) {
			return true;
		} else {
			return false;
		}
		
		
	}

}
