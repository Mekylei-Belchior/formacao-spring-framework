package br.com.mekylei.forum.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.mekylei.forum.modelo.Topico;
import br.com.mekylei.forum.repository.TopicoRepository;

public class AtualizaTopicoForm {

	@NotBlank
	private String titulo;
	@NotBlank
	private String mensagem;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Topico toTopico(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getById(id);
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);

		return topico;
	}

}
