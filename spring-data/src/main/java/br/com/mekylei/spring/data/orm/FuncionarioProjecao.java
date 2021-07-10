package br.com.mekylei.spring.data.orm;
/**
 * 
 * @author mekylei
 * 
 * Interface (Interface based Projection) para ser utilizada com a Native Query do método ( findFuncionarioSalario )
 */
public interface FuncionarioProjecao {
	Integer getId();
	String getNome();
	Double getSalario();
}
