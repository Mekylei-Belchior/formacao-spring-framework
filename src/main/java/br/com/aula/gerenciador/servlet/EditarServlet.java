package br.com.aula.gerenciador.servlet;

import java.io.IOException;

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
 *         Servlet para mapear a funcionalidade de editar uma empresa já
 *         cadastrada
 *
 */
@WebServlet("/editar")
public class EditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String empresaId = request.getParameter("id");
		Integer id = Integer.valueOf(empresaId);

		Banco banco = new Banco();
		Empresa empresa = banco.getEmpresaPorId(id);

		request.setAttribute("empresa", empresa);
		RequestDispatcher rq = request.getRequestDispatcher("/edicao.jsp");
		rq.forward(request, response);
	}

}
