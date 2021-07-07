package br.com.persistencia.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.persistencia.loja.modelo.Produto;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
	public void atualizar(Produto produto) {
		this.em.merge(produto);
	}
	
	public void remover(Produto produto) {
		produto = this.em.merge(produto);
		this.em.remove(produto);
	}
	
	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
	public List<Produto> buscarTodos(){
		String jpql = "SELECT prod FROM Produto prod";
		return this.em.createQuery(jpql, Produto.class).getResultList();
	}
	
	public List<Produto> buscarPorNome(String nome){
		String jpql = "SELECT prod FROM Produto prod WHERE prod.nome = :nome";
		return this.em.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
	}
	
	public List<Produto> buscarPorNomeCategoria(String nome){
		String jpql = "SELECT prod FROM Produto prod WHERE prod.categoria.categoria = :nome";
		return this.em.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
	}
	
	public BigDecimal buscarPrecoDoProduto(String nome){
		String jpql = "SELECT prod.preco FROM Produto prod WHERE prod.nome = :nome";
		return this.em.createQuery(jpql, BigDecimal.class).setParameter("nome", nome).getSingleResult();
	}
}
