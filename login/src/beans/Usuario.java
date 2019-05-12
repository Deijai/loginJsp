package beans;

public class Usuario {
	
	private String usuario;
	private String senha;
	
	
	
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public boolean validaLogin(String usuario, String senha) {
		
		if(usuario.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {
			return true;
		} else {
			return false;
		}		
		
	}
	

}
