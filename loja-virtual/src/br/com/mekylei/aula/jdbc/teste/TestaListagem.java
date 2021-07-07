package br.com.mekylei.aula.jdbc.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mekylei.aula.jdbc.factory.ConnectionFactory;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {

		Connection con = new ConnectionFactory().conecta();

		PreparedStatement pstm = con.prepareStatement("select * from produtos");
		pstm.execute();

		ResultSet rst = pstm.getResultSet();

		while (rst.next()) {
			Integer id = rst.getInt("id");
			System.out.println(id);
			String nome = rst.getString("nome");
			System.out.println(nome);
			String desc = rst.getString("descricao");
			System.out.println(desc);

		}

		pstm.close();
		rst.close();
		con.close();
	}
}
