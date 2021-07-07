package br.com.mekylei.aula.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.mekylei.aula.jdbc.factory.ConnectionFactory;

public class TestaConecao {
	public static void main(String[] args) throws SQLException {

		Connection con = new ConnectionFactory().conecta();

		System.out.println("Conexão realizada. Finalizando...");

		con.close();

	}
}
