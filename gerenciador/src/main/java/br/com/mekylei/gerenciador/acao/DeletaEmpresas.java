package br.com.mekylei.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mekylei.gerenciador.modelo.Banco;

public class DeletaEmpresas implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String empresaId = request.getParameter("id");
		Integer id = Integer.valueOf(empresaId);

		Banco banco = new Banco();
		banco.removeEmpresa(id);

		return "redirect:entrada?acao=ListaEmpresas";
	}

}
