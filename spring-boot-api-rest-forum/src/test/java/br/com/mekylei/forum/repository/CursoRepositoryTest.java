package br.com.mekylei.forum.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.mekylei.forum.modelo.Curso;

@DataJpaTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CursoRepositoryTest {

	@Autowired
	private TestEntityManager em;

	@Autowired
	private CursoRepository cursoRepository;

	@Test
	public void deveriaCarregarUmCursoAoBuscaPeloSeuNome() {
		String nomeCurso = "HTML 5";

		Curso html5 = new Curso();
		html5.setNome(nomeCurso);
		html5.setCategoria("Programação");
		em.persist(html5);

		Curso curso = cursoRepository.findByNome(nomeCurso);
		Assert.assertNotNull(curso);
		Assert.assertEquals(nomeCurso, curso.getNome());

	}

	@Test
	public void naoDeveriaCarregarUmCursoCujoONomeNaoEstejaCadastrado() {
		String nomeCurso = "Spring Boot Rest";

		Curso curso = cursoRepository.findByNome(nomeCurso);
		Assert.assertNull(curso);
	}

}