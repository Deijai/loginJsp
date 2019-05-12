package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String url = "jdbc:mysql://localhost:3306/cursojsp?useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String password = "";
	private static Connection conexao = null;
	
	
	static {
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}
	
	private static void conectar() {
		
		try {
			if (conexao == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexao = DriverManager.getConnection(url, user, password);
				conexao.setAutoCommit(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConexao() {
		return conexao;
	} 
	
	

}
