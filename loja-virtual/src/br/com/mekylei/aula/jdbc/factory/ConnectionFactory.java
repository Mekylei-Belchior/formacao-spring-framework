package br.com.mekylei.aula.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private DataSource dataSource;

	public ConnectionFactory() {

		String url = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String pwd = "123456";

		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl(url);
		cpds.setUser(user);
		cpds.setPassword(pwd);
		
		cpds.setMaxPoolSize(20);

		this.dataSource = cpds;

	}

	public Connection conecta() throws SQLException {

		return this.dataSource.getConnection();
	}
}
