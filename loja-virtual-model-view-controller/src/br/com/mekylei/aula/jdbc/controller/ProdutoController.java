package br.com.mekylei.aula.jdbc.controller;

import java.sql.Connection;
import java.util.List;

import br.com.mekylei.aula.jdbc.dao.ProdutoDao;
import br.com.mekylei.aula.jdbc.factory.ConnectionFactory;
import br.com.mekylei.aula.jdbc.modelo.Produto;

public class ProdutoController {

	private ProdutoDao produtoDao;

	public ProdutoController() {
		Connection connection = new ConnectionFactory().conecta();
		this.produtoDao = new ProdutoDao(connection);

	}

	public void deletar(Integer id) {
		produtoDao.deletar(id);
	}

	public void salvar(Produto produto) {
		produtoDao.salvar(produto);
	}

	public List<Produto> listar() {
		return produtoDao.listar();
	}

	public void alterar(String nome, String descricao, Integer id) {
		produtoDao.alterar(nome, descricao, id);
	}
}
