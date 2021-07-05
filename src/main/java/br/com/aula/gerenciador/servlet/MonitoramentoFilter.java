package br.com.aula.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		long tempoInicial = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");
		chain.doFilter(request, response);
		
		long tempoFinal = System.currentTimeMillis();
		
		System.out.println("Tempo de execução para [ " + acao + " ] -> " + (tempoFinal - tempoInicial) + " milissegundos\n");

	}

}
