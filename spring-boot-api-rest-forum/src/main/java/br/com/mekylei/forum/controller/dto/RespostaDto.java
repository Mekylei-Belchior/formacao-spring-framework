package br.com.mekylei.forum.controller.dto;

import java.time.LocalDateTime;

import br.com.mekylei.forum.modelo.Resposta;

public class RespostaDto {

	private Long id;
	private String textoResposta;
	private String autor;
	private LocalDateTime dataCriacao;

	public RespostaDto(Resposta resposta) {
		this.id = resposta.getId();
		this.textoResposta = resposta.getMensagem();
		this.autor = resposta.getAutor().getNome();
		this.dataCriacao = resposta.getDataCriacao();
	}

	public Long getId() {
		return id;
	}

	public String getTextoResposta() {
		return textoResposta;
	}

	public String getAutor() {
		return autor;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

}
