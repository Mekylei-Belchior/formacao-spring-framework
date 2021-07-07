package br.com.mekylei.aula.jdbc.teste;

import java.sql.SQLException;

import br.com.mekylei.aula.jdbc.factory.ConnectionFactory;

public class TestaPoolConexao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory con = new ConnectionFactory();

		for (int i = 0; i < 100; i++) {
			con.conecta();
			System.out.println("Conexão : " + i);
		}
	}

}
