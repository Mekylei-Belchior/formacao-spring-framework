package br.com.mekylei.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.mekylei.spring.data.orm.UnidadeDeTrabalho;

@Repository
public interface UnidadeDeTrabalhoRepository extends CrudRepository<UnidadeDeTrabalho, Integer> {

}
