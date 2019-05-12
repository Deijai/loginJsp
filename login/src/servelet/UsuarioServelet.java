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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario user = new Usuario();
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		
		user.setUsuario(usuario);
		user.setSenha(senha);
		
		try {
			usuariodao.insert(user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroUsuario.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
