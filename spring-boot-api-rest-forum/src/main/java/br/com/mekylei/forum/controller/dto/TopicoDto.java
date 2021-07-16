package br.com.mekylei.forum.controller.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.mekylei.forum.modelo.Topico;

public class TopicoDto {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;

	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static Page<TopicoDto> toTopicoDto(Page<Topico> topico) {
		return topico.map(TopicoDto::new);
	}

}