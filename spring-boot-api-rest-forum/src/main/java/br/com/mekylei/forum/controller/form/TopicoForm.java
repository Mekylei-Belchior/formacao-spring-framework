package br.com.mekylei.forum.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.mekylei.forum.modelo.Curso;
import br.com.mekylei.forum.modelo.Topico;
import br.com.mekylei.forum.modelo.Usuario;
import br.com.mekylei.forum.repository.CursoRepository;
import br.com.mekylei.forum.repository.UsuarioRepository;

public class TopicoForm {

	@NotBlank
	private String titulo;
	@NotBlank
	private String mensagem;
	@NotBlank
	private String nomeCurso;
	@NotBlank
	private String nomeAutor;

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

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public Topico toTopico(CursoRepository cursoRepository, UsuarioRepository usuarioRepository) {
		Curso curso = cursoRepository.findByNome(this.nomeCurso);
		Usuario autor = usuarioRepository.findByNome(this.nomeAutor);

		return new Topico(titulo, mensagem, curso, autor);

	}

}
