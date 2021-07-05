package br.com.aula.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroForm implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

		return "forward:cadastro.jsp";
	}

}
