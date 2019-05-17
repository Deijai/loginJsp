package servelet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Usuario;
import dao.UsuarioDao;


@WebServlet("/UsuarioServelet")
public class UsuarioServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDao usuariodao = new UsuarioDao();
       
    public UsuarioServelet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		
		//excluir
		if (acao.equalsIgnoreCase("excluir")) {
			try {
				
				usuariodao.delete(id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", usuariodao.listAll());
				dispatcher.forward(request, response);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//editar
		if (acao.equalsIgnoreCase("editar")) {
			Usuario usuario;
			try {
				
				usuario = usuariodao.listOne(id);
				System.out.println(usuario.getUsuario());
				usuariodao.update(usuario, id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("user", usuario);
				dispatcher.forward(request, response);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Usuario user = new Usuario();
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		
		
		user.setUsuario(usuario);
		user.setSenha(senha);
		
		try {
			
			if (usuariodao.verificaUsuario(usuario)) {
				System.out.println("Ja existe um usuario com esse login.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroUsuario.jsp");
				dispatcher.forward(request, response);
			} 	//editar
			else if (acao.equalsIgnoreCase("editar") && id != null) {

					
					user = usuariodao.listOne(id);
					System.out.println(user.getUsuario());
					usuariodao.update(user, id);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroUsuario.jsp");
					request.setAttribute("user", usuario);
					dispatcher.forward(request, response);
					

			}
			else {
				usuariodao.insert(user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroUsuario.jsp");
				request.setAttribute("usuarios", usuariodao.listAll());
				dispatcher.forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
