package br.com.persistencia.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.persistencia.loja.dao.CategoriaDao;
import br.com.persistencia.loja.dao.ProdutoDao;
import br.com.persistencia.loja.modelo.Categoria;
import br.com.persistencia.loja.modelo.Produto;
import br.com.persistencia.loja.util.JPAUtil;

public class TestaCadastroProdutosCriteria {

	public static void main(String[] args) {

		cadastrarProdutos();

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);

		List<Produto> produtos = produtoDao.buscarPorParametrosComCriteria("Notebook", null, null);
		produtos.forEach(p -> System.out.println(p.getNome()));

	}

	private static void cadastrarProdutos() {
		Categoria eletronico = new Categoria("Eletronico");
		Categoria veiculo = new Categoria("Veiculo");

		Produto carro = new Produto("Corsa", "Corsa Hatch 2012 1.4", new BigDecimal(23500.00), veiculo);
		Produto notebook = new Produto("Notebook", "Notebook Accer V3-571-6654", new BigDecimal(2750.00), eletronico);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();
		categoriaDao.cadastrar(veiculo);
		categoriaDao.cadastrar(eletronico);
		produtoDao.cadastrar(carro);
		produtoDao.cadastrar(notebook);
		em.getTransaction().commit();
		em.close();
	}
}
