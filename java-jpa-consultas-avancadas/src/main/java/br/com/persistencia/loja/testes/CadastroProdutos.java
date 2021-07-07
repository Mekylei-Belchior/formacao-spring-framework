package br.com.persistencia.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.persistencia.loja.dao.CategoriaDao;
import br.com.persistencia.loja.dao.ProdutoDao;
import br.com.persistencia.loja.modelo.Categoria;
import br.com.persistencia.loja.modelo.Produto;
import br.com.persistencia.loja.util.JPAUtil;

public class CadastroProdutos {

	public static void main(String[] args) {

		cadastrarProdutos();

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);

		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());

		List<Produto> todos = produtoDao.buscarPorNomeCategoria("Veiculo");
		todos.forEach(nomeProduto -> System.out.println(p.getNome()));
		
		BigDecimal precoProduto = produtoDao.buscarPrecoDoProduto("Corsa");
		System.out.println("Preço do Produto: " + precoProduto);
	}

	private static void cadastrarProdutos() {
		Categoria categoria = new Categoria("Veiculo");

		Produto carro = new Produto("Corsa", "Corsa Hatch 2012 1.4", new BigDecimal(23500.00), categoria);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();
		categoriaDao.cadastrar(categoria);
		produtoDao.cadastrar(carro);
		em.getTransaction().commit();
		em.close();
	}
}
