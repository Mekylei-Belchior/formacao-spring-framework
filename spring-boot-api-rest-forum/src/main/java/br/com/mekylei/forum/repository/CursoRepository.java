package br.com.mekylei.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mekylei.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nomeCurso);

}
