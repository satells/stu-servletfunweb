package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = -3796313427747926879L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscaPorEmailESenha(email, senha);

		PrintWriter writer = resp.getWriter();
		String message = "Usuário não encontrado!";
		if (usuario != null) {

			HttpSession session = req.getSession();

			session.setAttribute("usuarioLogado", usuario);

			message = usuario.getEmail();

//	    Cookie cookie = new Cookie("usuario.logado", usuario.getEmail());
//	    cookie.setMaxAge(120);
//	    resp.addCookie(cookie);
		}
		writer.print("<html><body>" + message + "</body></html>");

	}

}
