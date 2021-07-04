package br.com.aula.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aula.gerenciador.modelo.Banco;
import br.com.aula.gerenciador.modelo.Empresa;

public class CadastraEmpresas implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Banco banco = new Banco();

		String empresa = request.getParameter("nome");
		String data = request.getParameter("data");

		if (!empresa.isEmpty() && !data.isEmpty()) {
			banco.adiciona(new Empresa(empresa, data));
		} else {
			empresa = "";
		}

		request.setAttribute("empresa", empresa);
		
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
