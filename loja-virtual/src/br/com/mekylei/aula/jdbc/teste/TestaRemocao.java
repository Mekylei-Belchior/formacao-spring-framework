package br.com.mekylei.aula.jdbc.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mekylei.aula.jdbc.factory.ConnectionFactory;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().conecta();

		PreparedStatement pstm = con.prepareStatement("delete from produtos where id > ?");
		pstm.setInt(1, 3);
		pstm.execute();

		Integer linhasRemovidas = pstm.getUpdateCount();
		System.out.println("Total de linhas removidas: " + linhasRemovidas);

		pstm.close();
		con.close();
	}

}
