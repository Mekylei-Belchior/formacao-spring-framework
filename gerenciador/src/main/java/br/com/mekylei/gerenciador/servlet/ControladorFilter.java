package br.com.mekylei.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mekylei.gerenciador.acao.Acao;

public class ControladorFilter implements Filter {

	public void doFilter(ServletRequest requestServlet, ServletResponse responseServlet, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) requestServlet;
		HttpServletResponse response = (HttpServletResponse) responseServlet;

		String paramAcao = request.getParameter("acao");
		String caminho = null;
		String nomeDaClase = "br.com.mekylei.gerenciador.acao." + paramAcao;

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
