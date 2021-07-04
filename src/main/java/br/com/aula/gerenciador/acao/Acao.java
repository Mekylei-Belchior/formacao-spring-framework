package br.com.aula.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author mekylei
 *
 *         Interface para encapsular a execu��o das a��es do Controller
 *
 */
public interface Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

}
