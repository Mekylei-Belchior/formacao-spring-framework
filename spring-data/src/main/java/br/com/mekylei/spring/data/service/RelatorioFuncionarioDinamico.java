package br.com.mekylei.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.mekylei.spring.data.orm.Funcionario;
import br.com.mekylei.spring.data.repository.FuncionarioRepository;
import br.com.mekylei.spring.data.specification.SpecificationFuncionario;

@Service
public class RelatorioFuncionarioDinamico {

	private final FuncionarioRepository funcionarioRepository;
	private final DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scanner) {
		System.out.println("Informe o nome:");
		String nome = scanner.next();

		if (nome.equalsIgnoreCase("NULL")) {
			nome = null;
		}

		System.out.println("Informe o CPF:");
		String cpf = scanner.next();

		if (cpf.equalsIgnoreCase("NULL")) {
			cpf = null;
		}

		System.out.println("Informe o salário:");
		Double salario = scanner.nextDouble();

		if (salario == 0) {
			salario = null;
		}

		System.out.println("Informe a data de contratação:");
		String dataContratacao = scanner.next();

		LocalDate data;

		if (dataContratacao.equalsIgnoreCase("NULL")) {
			data = null;
		} else {
			data = LocalDate.parse(dataContratacao, formatador);
		}

		List<Funcionario> funcionarios = funcionarioRepository
				.findAll(Specification.where(SpecificationFuncionario.nome(nome)
						.or(SpecificationFuncionario.cpf(cpf))
						.or(SpecificationFuncionario.salario(salario))
						.or(SpecificationFuncionario.data(data))
						));

		funcionarios.forEach(System.out::println);

	}

}
