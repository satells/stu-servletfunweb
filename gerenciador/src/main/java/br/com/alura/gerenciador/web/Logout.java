package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();

	PrintWriter writer = resp.getWriter();
	if (cookie == null) {
	    writer.print("<html><body>Usuário não estava logado!</body></html>");
	} else {
	    cookie.setMaxAge(0);
	    resp.addCookie(cookie);
	    writer.print("<html><body>Usuário deslogado com sucesso.</body></html>");

	}

    }
}
