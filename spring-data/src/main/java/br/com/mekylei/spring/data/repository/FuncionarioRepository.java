package br.com.mekylei.spring.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.mekylei.spring.data.orm.Funcionario;
import br.com.mekylei.spring.data.orm.FuncionarioProjecao;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>, JpaSpecificationExecutor<Funcionario> {
	// Derived query
	List<Funcionario> findByNome(String nome);

	// JPQL query
	@Query("SELECT f FROM Funcionario f JOIN f.cargo c WHERE c.descricao = :descricao")
	List<Funcionario> findByCargoPelaDescricao(String descricao);
	
	// Native query
	@Query(value="SELECT * FROM funcionarios f WHERE f.data_contratacao > :data", nativeQuery = true)
	List<Funcionario> findDataContratacaoMaior(LocalDate data);

	// Native query
	@Query(value = "SELECT f.id, f.nome, f.salario FROM funcionarios f", nativeQuery = true)
	List<FuncionarioProjecao> findFuncionarioSalario();
}
