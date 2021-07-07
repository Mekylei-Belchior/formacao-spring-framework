package br.com.mekylei.aula.jdbc.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.mekylei.aula.jdbc.factory.ConnectionFactory;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().conecta();

		PreparedStatement pstm = con.prepareStatement(
				"insert into produtos (nome, descricao) values ('Roteador', 'Roteador TPLink')",
				Statement.RETURN_GENERATED_KEYS);

		pstm.execute();

		ResultSet rst = pstm.getGeneratedKeys();

		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("Novo ID: " + id);

		}

		pstm.close();
		rst.close();
		con.close();

	}

}
