package br.com.mekylei.aula.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.mekylei.aula.jdbc.dao.ProdutoDao;
import br.com.mekylei.aula.jdbc.factory.ConnectionFactory;
import br.com.mekylei.aula.jdbc.modelo.Produto;

public class TestaInsercaoEListagemProduto {

	public static void main(String[] args) throws SQLException {

		Produto monitor = new Produto("Monitor", "Monitor LG 25' Ultra Widescreen");

		try (Connection connection = new ConnectionFactory().conecta()) {
			ProdutoDao produtoDao = new ProdutoDao(connection);
			produtoDao.salva(monitor);

			List<Produto> produtos = produtoDao.lista();

			produtos.stream().forEach(produto -> System.out.println(produto));
		}
	}

}
