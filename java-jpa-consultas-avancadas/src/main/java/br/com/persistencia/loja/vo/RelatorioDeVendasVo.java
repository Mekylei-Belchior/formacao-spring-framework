package br.com.persistencia.loja.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVo {

	private String nomeProduto;
	private Long quantidadeVendida;
	private LocalDate dataUltimaVenda;

	public RelatorioDeVendasVo() {
	}
	
	public RelatorioDeVendasVo(String nomeProduto, Long quantidadeVendida, LocalDate dataUltimaVenda) {
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dataUltimaVenda = dataUltimaVenda;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public long getquantidadeVendida() {
		return quantidadeVendida;
	}

	public LocalDate getdataUltimaVenda() {
		return dataUltimaVenda;
	}

	@Override
	public String toString() {
		return "Relatório [nomeProduto=" + nomeProduto + ", quantidadeVendida=" + quantidadeVendida
				+ ", dataUltimaVenda=" + dataUltimaVenda + "]";
	}

}
