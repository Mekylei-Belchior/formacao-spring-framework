package br.com.persistencia.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "preco_unitario")
	private BigDecimal precoUnitario;

	private Long quantidade;

	@ManyToOne (fetch = FetchType.LAZY)
	private Pedido pedido;

	@ManyToOne (fetch = FetchType.LAZY)
	private Produto produto;

	public ItemPedido() {
	}

	public ItemPedido(Long quantidade, Pedido pedido, Produto produto) {
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
		this.precoUnitario = produto.getPreco();
	}

	public long getId() {
		return id;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public BigDecimal getValorTotalItem() {
		return this.precoUnitario.multiply(new BigDecimal(this.quantidade));
	}

}
