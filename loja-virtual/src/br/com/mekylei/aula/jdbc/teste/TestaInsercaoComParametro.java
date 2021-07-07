package br.com.mekylei.aula.jdbc.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mekylei.aula.jdbc.factory.ConnectionFactory;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		try (Connection con = new ConnectionFactory().conecta()) {
			con.setAutoCommit(false);

			try (PreparedStatement pstm = con.prepareStatement("insert into produtos (nome, descricao) values (?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS)) {

				adicionaProduto(con, "Roteador", "Roteador TPLink", pstm);
				adicionaProduto(con, "Pen Drive", "Sandisk 16GB", pstm);

				con.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
			}
		}
	}

	private static void adicionaProduto(Connection con, String nome, String descricao, PreparedStatement pstm)
			throws SQLException {
		pstm.setString(1, nome);
		pstm.setString(2, descricao);

		pstm.execute();

		try (ResultSet rst = pstm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("Novo ID: " + id);
			}
		}

	}

}
