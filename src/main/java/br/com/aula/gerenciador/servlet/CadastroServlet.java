package br.com.aula.gerenciador.servlet;

import java.io.IOException;

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
 * @version
 * 
 *          Servlet para mapear a funcionalidade de cadastro de nova empresas
 * 
 * 
 */
@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();

		String empresa = request.getParameter("nome");
		String data = request.getParameter("data");

		if (!empresa.isEmpty() && !data.isEmpty()) {
			banco.adiciona(new Empresa(empresa, data));
		} else {
			empresa = "";
		}

		request.setAttribute("empresa", empresa);
		response.sendRedirect("listagem");

	}

}
