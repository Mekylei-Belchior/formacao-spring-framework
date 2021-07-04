package br.com.aula.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aula.gerenciador.acao.Acao;

/**
 * 
 * @author mekylei
 * 
 *         Servlet (Controller) para mapear os fluxos das requisições
 *
 */
@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		String caminho = null;

		String nomeDaClase = "br.com.aula.gerenciador.acao." + paramAcao;

		try {
			Class<?> classe = Class.forName(nomeDaClase);
			Acao acao = (Acao) classe.newInstance();
			caminho = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

		String[] tipoDestino = caminho.split(":");

		if (tipoDestino[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoDestino[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoDestino[1]);
		}

	}

}
