package br.com.mekylei.forum.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mekylei.forum.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByNome(String string);

	Optional<Usuario> findByEmail(String email);

}
