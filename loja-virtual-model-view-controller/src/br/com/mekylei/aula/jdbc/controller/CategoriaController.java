package br.com.mekylei.aula.jdbc.controller;

import java.sql.Connection;
import java.util.List;

import br.com.mekylei.aula.jdbc.dao.CategoriaDao;
import br.com.mekylei.aula.jdbc.factory.ConnectionFactory;
import br.com.mekylei.aula.jdbc.modelo.Categoria;

public class CategoriaController {

	private CategoriaDao categoriaDao;

	public CategoriaController() {
		Connection connection = new ConnectionFactory().conecta();
		this.categoriaDao = new CategoriaDao(connection);
	}

	public List<Categoria> listar() {
		return categoriaDao.listar();
	}
}
