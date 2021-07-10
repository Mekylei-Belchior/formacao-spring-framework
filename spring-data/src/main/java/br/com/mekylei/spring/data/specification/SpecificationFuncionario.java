package br.com.mekylei.spring.data.specification;

import java.time.LocalDate;

/**
 * 
 * @author mekylei
 * 
 * Esta classe será utilizada para abstrair os recursos do JPA Criteria (root, criteriaQuery, criteriaBuilder) para buscas dinâmicas.
 * 
 */

import org.springframework.data.jpa.domain.Specification;

import br.com.mekylei.spring.data.orm.Funcionario;

public class SpecificationFuncionario {

	public static Specification<Funcionario> nome(String nome) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
	}
	
	public static Specification<Funcionario> cpf(String cpf) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("cpf"), cpf);
	}
	
	public static Specification<Funcionario> salario(Double salario) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("salario"), salario);
	}
	
	public static Specification<Funcionario> data(LocalDate data) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("dataContratacao"), data);
	}
}
