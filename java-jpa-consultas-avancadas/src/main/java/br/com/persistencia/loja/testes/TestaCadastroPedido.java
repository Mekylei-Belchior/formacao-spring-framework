package br.com.persistencia.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.persistencia.loja.dao.CategoriaDao;
import br.com.persistencia.loja.dao.ClienteDao;
import br.com.persistencia.loja.dao.PedidoDao;
import br.com.persistencia.loja.dao.ProdutoDao;
import br.com.persistencia.loja.modelo.Categoria;
import br.com.persistencia.loja.modelo.Cliente;
import br.com.persistencia.loja.modelo.ItemPedido;
import br.com.persistencia.loja.modelo.Pedido;
import br.com.persistencia.loja.modelo.Produto;
import br.com.persistencia.loja.util.JPAUtil;

public class TestaCadastroPedido {

	public static void main(String[] args) {

		popularBancoDeDados();

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);

		Produto produto1 = produtoDao.buscarPorId(1l);
		Produto produto2 = produtoDao.buscarPorId(2l);
		Cliente cliente = clienteDao.buscarPorId(1l);

		em.getTransaction().begin();

		Pedido pedido = new Pedido(cliente);
		pedido.adicionaItem(new ItemPedido(12l, pedido, produto1));
		pedido.adicionaItem(new ItemPedido(1l, pedido, produto2));
		
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);

		em.getTransaction().commit();

		List<Produto> todos = produtoDao.buscarPorNomeCategoria("Informatica");
		todos.forEach(nomeProduto -> System.out.println(nomeProduto.getNome()));

		BigDecimal precoProduto = produtoDao.buscarPrecoDoProduto("Corsa");
		System.out.println("Preço do Produto: " + precoProduto);
		System.out.println("Valor Total: " + pedidoDao.valorTotal());

	}

	private static void popularBancoDeDados() {
		Categoria veiculo = new Categoria("Veiculo");
		Categoria informatica = new Categoria("Informatica");
		
		Produto carro = new Produto("Corsa", "Corsa Hatch 2012 1.4", new BigDecimal(23500.00), veiculo);
		Produto computador = new Produto("Desktop", "PC Gamer X", new BigDecimal(10300.00), informatica);
		Produto impressora = new Produto("Impressora", "Impressora HP XYZ", new BigDecimal(1290.00), informatica);
		
		Cliente cliente = new Cliente("Fulano", "654.132.741.56");

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);

		em.getTransaction().begin();
		
		categoriaDao.cadastrar(veiculo);
		categoriaDao.cadastrar(informatica);
		produtoDao.cadastrar(carro);
		produtoDao.cadastrar(computador);
		produtoDao.cadastrar(impressora);
		clienteDao.cadastrar(cliente);

		em.getTransaction().commit();
		em.close();
	}
}
