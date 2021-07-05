package br.com.mekylei.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mekylei.gerenciador.modelo.Banco;

public class EditaEmpresas implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String nome = request.getParameter("nome");
		String data = request.getParameter("data");
		String empresaId = request.getParameter("id");
		Integer id = Integer.valueOf(empresaId);

		try {

			if (!nome.isEmpty() && !data.isEmpty()) {
				Banco banco = new Banco();
				banco.editaEmpresa(id, nome, data);

				return "redirect:entrada?acao=ListaEmpresas";
			} else {
				throw new ServletException("Os campos de 'Nome' e 'Data' devem ser preenchidos.");
			}

		} catch (ServletException e) {
			System.out.println(e);
		}
		return "redirect:entrada?acao=EditaEmpresas";
	}

}
