package br.com.mekylei.aula.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.mekylei.aula.jdbc.dao.CategoriaDao;
import br.com.mekylei.aula.jdbc.factory.ConnectionFactory;
import br.com.mekylei.aula.jdbc.modelo.Categoria;
import br.com.mekylei.aula.jdbc.modelo.Produto;

public class TestaCategoriaProduto {

	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().conecta()) {
			CategoriaDao categoriaDao = new CategoriaDao(connection);
			List<Categoria> categorias = categoriaDao.listaComProduto();

			categorias.stream().forEach(categoria -> {
				System.out.println("Categoria -> " + categoria.getNome());
				for (Produto produto : categoria.getProdutos()) {
					System.out.println(" " + produto.getId() + " - " + produto.getNome());
				}

			});

		}

	}

}
