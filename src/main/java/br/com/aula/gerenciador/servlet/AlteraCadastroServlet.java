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
 *          Servlet para mapear a funcionalidade de alteração de cadastro
 *
 */
@WebServlet("/alteraCadastro")
public class AlteraCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String data = request.getParameter("data");
		String empresaId = request.getParameter("id");
		Integer id = Integer.valueOf(empresaId);

		try {

			System.out.println("Nome: " + nome + " - " + "Data: " + data);

			if (!nome.isEmpty() && !data.isEmpty()) {
				Banco banco = new Banco();
				banco.editaEmpresa(id, nome, data);

				response.sendRedirect("listagem");
			} else {
				throw new ServletException("Os campos de 'Nome' e 'Data' devem ser preenchidos.");
			}

		} catch (ServletException e) {
			System.out.println(e);
		}

	}
}
