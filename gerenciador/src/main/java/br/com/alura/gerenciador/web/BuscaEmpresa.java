package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet("/busca")
public class BuscaEmpresa extends HttpServlet {

    public BuscaEmpresa() {
	System.out.println("Construindo a Servlet tipo BuscaEmpresa: " + this);
    }

    @Override
    public void init() throws ServletException {
	super.init();
	System.out.println("Inicializando a Servlet tipo BuscaEmpresa: " + this);
    }

    @Override
    public void destroy() {
	super.destroy();
	System.out.println("Destruindo a Servlet tipo BuscaEmpresa: " + this);
    }

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String filtro = request.getParameter("filtro");
	Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);

	request.setAttribute("empresas", empresas);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
	dispatcher.forward(request, response);
    }

}
