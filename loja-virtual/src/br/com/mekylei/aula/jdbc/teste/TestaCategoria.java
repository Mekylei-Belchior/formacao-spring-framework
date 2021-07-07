package br.com.mekylei.aula.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mekylei.aula.jdbc.dao.CategoriaDao;
import br.com.mekylei.aula.jdbc.factory.ConnectionFactory;
import br.com.mekylei.aula.jdbc.modelo.Categoria;

public class TestaCategoria {

	public static void main(String[] args) throws SQLException {
		List<Categoria> categorias = new ArrayList<>();

		try (Connection connection = new ConnectionFactory().conecta()) {
			CategoriaDao categoriaDao = new CategoriaDao(connection);

			categorias = categoriaDao.lista();

			categorias.stream().forEach(
					categoria -> System.out.println("Id: " + categoria.getId() + " - Categoria: " + categoria.getNome()));
		}

	}

}
