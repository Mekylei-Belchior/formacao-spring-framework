package br.com.mekylei.spring.data.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.mekylei.spring.data.orm.Cargo;
import br.com.mekylei.spring.data.orm.Funcionario;
import br.com.mekylei.spring.data.repository.CargoRepository;
import br.com.mekylei.spring.data.repository.FuncionarioRepository;

@Service
public class CrudFuncionarioService {

	private final FuncionarioRepository funcionarioRepository;
	private final CargoRepository cargoRepository;
	boolean system = true;

	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository) {
		this.funcionarioRepository = funcionarioRepository;
		this.cargoRepository = cargoRepository;
	}

	public void inicial(Scanner scanner) {

		while (system) {
			System.out.println("[ Funcionário ] - Qual ação deseja executar?: ");
			System.out.println("0 - Sair: ");
			System.out.println("1 - Inserir Funcionário: ");
			System.out.println("2 - Exibir Funcionário: ");
			System.out.println("3 - Atualizar Funcionário: ");
			System.out.println("4 - Remover Funcionário: ");

			int acao = scanner.nextInt();

			switch (acao) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				exibir(scanner);
				break;
			case 3:
				atualizar(scanner);
				break;
			case 4:
				remover(scanner);
				break;

			default:
				system = false;
				break;
			}
		}

	}

	private void remover(Scanner scanner) {
		System.out.println("Informe o ID do Funcionario:");
		int id = scanner.nextInt();
		funcionarioRepository.deleteById(id);
		
		System.out.println("Removido!");

	}

	private void exibir(Scanner scanner) {
		System.out.println("Informe a página que deseja exibir:");
		Integer pagina = scanner.nextInt();
		
		Pageable pageble = PageRequest.of(pagina, 5, Sort.by(Sort.Direction.ASC, "nome"));
		Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageble);
		
		System.out.println("Total de elementos: " + funcionarios.getTotalElements());
		System.out.println(funcionarios);
		System.out.println("Página atual: " + funcionarios.getNumber());
		funcionarios.forEach(System.out::println);

	}

	private void atualizar(Scanner scanner) {
		System.out.println("Informe o ID do funcionário:");
		int id = scanner.nextInt();

		System.out.println("Informe o nome:");
		String nome = scanner.next();
		System.out.println("Informe o CPF:");
		String cpf = scanner.next();
		System.out.println("Informe o salário:");
		Double salario = scanner.nextDouble();
		System.out.println("Informe o ID do cargo:");
		Integer cargoId = scanner.nextInt();
		Optional<Cargo> cargo = cargoRepository.findById(cargoId);

		Funcionario funcionario = new Funcionario(nome, cpf, salario, cargo.get());
		funcionario.setId(id);
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		funcionarioRepository.save(funcionario);
		
		System.out.println("Atualizado!");

	}

	private void salvar(Scanner scanner) {
		System.out.println("Informe o nome:");
		String nome = scanner.next();
		System.out.println("Informe o CPF:");
		String cpf = scanner.next();
		System.out.println("Informe o salário:");
		Double salario = scanner.nextDouble();
		System.out.println("Informe o ID do cargo:");
		Integer cargoId = scanner.nextInt();
		Optional<Cargo> cargo = cargoRepository.findById(cargoId);

		Funcionario funcionario = new Funcionario(nome, cpf, salario, cargo.get());
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		funcionarioRepository.save(funcionario);

		System.out.println("Ação concluída!");
	}

}
