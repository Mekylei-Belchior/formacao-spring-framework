package br.com.aula.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * 
 * @author mekylei
 * @version 1.0
 * 
 *          Servlet para mapear a página inicial
 * 
 *          A página foi criada na própria funcionalidade utilizando o
 *          PrintWriter.
 * 
 */
@WebServlet(urlPatterns = "/bem-vindo")
public class BemVindo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		PrintWriter saida = response.getWriter();
		saida.print("<html>");
		saida.print("<body>");
		saida.print("Seja bem vindo a formação Spring Framework.");
		saida.print("</body>");
		saida.print("</html>");

	}

}
