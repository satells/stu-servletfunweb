package br.com.alura.gerenciador.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	public FiltroDeAuditoria() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();

		String usuario = getUsuario(req);

		System.out.println("Usuário " + usuario + " acessando a URI: " + uri);
		chain.doFilter(request, response);

	}

	private String getUsuario(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

		// Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();

//	if (cookie == null)
//	    return "<deslogado>";

		if (usuario == null)
			return "<deslogado>";

		return usuario.getEmail();
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}
}
