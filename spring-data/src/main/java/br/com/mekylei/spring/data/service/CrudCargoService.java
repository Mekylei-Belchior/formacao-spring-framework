package br.com.mekylei.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.mekylei.spring.data.orm.Cargo;
import br.com.mekylei.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	private final CargoRepository repository;
	private boolean system = true;

	public CrudCargoService(CargoRepository repository) {
		this.repository = repository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("[ Cargo ] - Qual ação deseja executar?: ");
			System.out.println("0 - Sair: ");
			System.out.println("1 - Inserir Cargo: ");
			System.out.println("2 - Exibir Cargo: ");
			System.out.println("3 - Atualizar Cargo: ");
			System.out.println("4 - Remover Cargo: ");

			int acao = scanner.nextInt();

			switch (acao) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				exibir();
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
		System.out.println("Informe o ID do cargo:");
		int id = scanner.nextInt();
		repository.deleteById(id);
		
		System.out.println("Removido!");

	}

	private void exibir() {
		Iterable<Cargo> cargos = repository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));

	}

	private void atualizar(Scanner scanner) {
		System.out.println("Informe o ID do cargo:");
		int id = scanner.nextInt();

		System.out.println("Informe a nova descrição:");
		String descricao = scanner.next();
		
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		repository.save(cargo);
		
		System.out.println("Atualizado!");

	}

	private void salvar(Scanner scanner) {
		System.out.println("Informe a descrição do cargo:");
		String descricao = scanner.next();

		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		repository.save(cargo);

		System.out.println("Ação concluída!");
	}

}
