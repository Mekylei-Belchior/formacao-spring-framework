package br.com.mekylei.aula.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mekylei.aula.jdbc.modelo.Categoria;
import br.com.mekylei.aula.jdbc.modelo.Produto;

public class CategoriaDao {

	private Connection connection;

	public CategoriaDao(Connection connection) {
		this.connection = connection;
	}

	public List<Categoria> listar() {
		try {
			List<Categoria> categorias = new ArrayList<>();
			String sql = "SELECT ID, NOME FROM CATEGORIAS";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));

						categorias.add(categoria);
					}
				}
			}
			return categorias;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Categoria> listarComProduto() {
		Categoria ultima = null;
		List<Categoria> categorias = new ArrayList<>();

		String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO " + 
					 "FROM CATEGORIAS C " +
					 "INNER JOIN PRODUTOS P ON C.ID = P.CATEGORIA_ID";

		try {
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						if (ultima == null || !ultima.getNome().equals(rst.getString(2))) {
							Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));

							categorias.add(categoria);
							ultima = categoria;
						}
						Produto produto = new Produto(rst.getInt(3), rst.getString(4), rst.getString(5));
						ultima.adicionar(produto);
					}
				}
				return categorias;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
