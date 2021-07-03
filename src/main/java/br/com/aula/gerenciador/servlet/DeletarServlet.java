package br.com.aula.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aula.gerenciador.modelo.Banco;

/**
 * 
 * @author mekylei
 * @version 1.0
 * 
 *          Servlet para mapear a funcionalidade de remover uma empresa da base
 *          de dados
 * 
 */

@WebServlet("/deletar")
public class DeletarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String empresaId = request.getParameter("id");
		Integer id = Integer.valueOf(empresaId);

		Banco banco = new Banco();
		banco.removeEmpresa(id);

		response.sendRedirect("listagem");
	}

}
