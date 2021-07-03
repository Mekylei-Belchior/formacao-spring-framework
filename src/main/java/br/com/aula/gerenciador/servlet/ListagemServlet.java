package br.com.aula.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aula.gerenciador.modelo.Banco;
import br.com.aula.gerenciador.modelo.Empresa;

/**
 * 
 * @author mekylei
 * 
 *         Servlet para mapear a funcionalidade de listar as empresas
 *         cadastradas na base de dados
 * 
 */
@WebServlet("/listagem")
public class ListagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();

		request.setAttribute("empresas", empresas);

		RequestDispatcher rd = request.getRequestDispatcher("/listagem.jsp");
		rd.forward(request, response);

	}

}
