package br.com.mekylei.spring.data.orm;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "unidades_de_trabalho")
public class UnidadeDeTrabalho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private String endereco;

	@ManyToMany(mappedBy = "unidadesDeTrabalho", fetch = FetchType.EAGER)
	private List<Funcionario> funcionarios = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Funcionario funcionarios) {
		this.funcionarios.add(funcionarios);
	}

	@Override
	public String toString() {
		return "UnidadeDeTrabalho [id=" + id + ", descricao=" + descricao + ", endereco=" + endereco.replace("_", " ")+ "]";
	}

}
