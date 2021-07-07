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

	public List<Categoria> lista() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();

		String sql = "select * from categorias";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					categorias.add(new Categoria(rst.getInt(1), rst.getString(2)));
				}
			}
		}

		return categorias;

	}

	public List<Categoria> listaComProduto() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		Categoria ultimaCategoria = null;

		String sql = "SELECT P.id, P.nome, P.descricao, C.id, C.nome FROM produtos P INNER JOIN categorias C ON P.categoria_id = C.id";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					if (ultimaCategoria == null || !ultimaCategoria.getNome().equals(rst.getString(5))) {
						Categoria categoria = new Categoria(rst.getInt(4), rst.getString(5));
						ultimaCategoria = categoria;
						categorias.add(categoria);
					}

					ultimaCategoria.adiciona(new Produto(rst.getInt(1), rst.getString(2), rst.getString(3)));
				}

			}
		}

		return categorias;

	}

}
