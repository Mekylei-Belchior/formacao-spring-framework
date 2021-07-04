package br.com.aula.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aula.gerenciador.modelo.Banco;
import br.com.aula.gerenciador.modelo.Empresa;

public class CarregaDadosEdicao implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String empresaId = request.getParameter("id");
		Integer id = Integer.valueOf(empresaId);

		Banco banco = new Banco();
		Empresa empresa = banco.getEmpresaPorId(id);

		request.setAttribute("empresa", empresa);

		return "forward:edicao.jsp";

	}

}
