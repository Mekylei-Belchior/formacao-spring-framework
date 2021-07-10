package br.com.mekylei.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.mekylei.spring.data.orm.UnidadeDeTrabalho;
import br.com.mekylei.spring.data.repository.UnidadeDeTrabalhoRepository;

@Service
public class CrudUnidadeDeTrabalhoService {

	private Boolean system = true;
	private final UnidadeDeTrabalhoRepository unidadeRepository;

	public CrudUnidadeDeTrabalhoService(UnidadeDeTrabalhoRepository unidadeRepository) {
		this.unidadeRepository = unidadeRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("[ Unidade de Trabalho ] - Qual ação deseja executar?: ");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Exibir");
			System.out.println("4 - Remover");

			int acao = scanner.nextInt();

			switch (acao) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				exibir();
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

	private void salvar(Scanner scanner) {
		System.out.println("Informe o nome da unidade");
		String nome = scanner.next();
		System.out.println("Informe o endereco");
		String endereco = scanner.next();

		UnidadeDeTrabalho unidadeDeTrabalho = new UnidadeDeTrabalho();
		unidadeDeTrabalho.setDescricao(nome);
		unidadeDeTrabalho.setEndereco(endereco);
		unidadeRepository.save(unidadeDeTrabalho);
		
		System.out.println("Ação concluída!");
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Informe o ID da unidade:");
		Integer id = scanner.nextInt();
		System.out.println("Digite o nome da unidade");
		String nome = scanner.next();
		System.out.println("Digite o endereco");
		String endereco = scanner.next();

		UnidadeDeTrabalho unidadeDeTrabalho = new UnidadeDeTrabalho();
		unidadeDeTrabalho.setId(id);
		unidadeDeTrabalho.setDescricao(nome);
		unidadeDeTrabalho.setEndereco(endereco);
		unidadeRepository.save(unidadeDeTrabalho);
		
		System.out.println("Atualizado!");
	}

	private void exibir() {
		Iterable<UnidadeDeTrabalho> unidades = unidadeRepository.findAll();
		unidades.forEach(unidade -> System.out.println(unidade));
	}

	private void remover(Scanner scanner) {
		System.out.println("Informe o ID da unidade:");
		int id = scanner.nextInt();
		unidadeRepository.deleteById(id);
		
		System.out.println("Removido!");
	}

}
