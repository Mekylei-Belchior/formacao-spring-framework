package br.com.mekylei.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.mekylei.spring.data.orm.Funcionario;
import br.com.mekylei.spring.data.orm.FuncionarioProjecao;
import br.com.mekylei.spring.data.repository.FuncionarioRepository;

@Service
public class RelatoriaService {

	private final DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private boolean system = true;

	private final FuncionarioRepository funcionarioRepository;

	public RelatoriaService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;

	}

	public void inicial(Scanner scanner) {

		while (system) {
			System.out.println("[ Relatório ] - Qual ação deseja executar?: ");
			System.out.println("0 - Sair: ");
			System.out.println("1 - Bucar funcionário por nome: ");
			System.out.println("2 - Bucar funcionário por cargo: ");
			System.out.println("3 - Bucar funcionário por data de contratação maior que: ");
			System.out.println("4 - Pesquisa funcionário e salário: ");

			int acao = scanner.nextInt();

			switch (acao) {
			case 1:
				buscaFuncionarioPorNome(scanner);
				break;
			case 2:
				buscaFuncionarioPorDescricao(scanner);
				break;
			case 3:
				buscaFuncionarioPorDataContratacaoMaior(scanner);
				break;
			case 4:
				pesquisaFuncionarioSalario();
				break;
			default:
				system = false;
				break;
			}
		}

	}

	private void buscaFuncionarioPorNome(Scanner scanner) {
		System.out.println("Informe o nome:");
		String nome = scanner.next();
		List<Funcionario> funcionarios = funcionarioRepository.findByNome(nome);
		funcionarios.forEach(funcionario -> System.out.println(funcionario));
	}

	private void buscaFuncionarioPorDescricao(Scanner scanner) {
		System.out.println("Informe a descrição do cargo:");
		String descricao = scanner.next().replace("_", " ");
		List<Funcionario> funcionarios = funcionarioRepository.findByCargoPelaDescricao(descricao);
		funcionarios.forEach(System.out::println);
	}

	private void buscaFuncionarioPorDataContratacaoMaior(Scanner scanner) {
		System.out.println("Informe a data de contratação:");
		String dataContratacao = scanner.next();
		LocalDate data = LocalDate.parse(dataContratacao, formatador);

		List<Funcionario> funcionarios = funcionarioRepository.findDataContratacaoMaior(data);
		funcionarios.forEach(System.out::println);
	}

	private void pesquisaFuncionarioSalario() {
		List<FuncionarioProjecao> funcionarios = funcionarioRepository.findFuncionarioSalario();
		funcionarios.forEach(funcionario -> System.out.println("ID: " + funcionario.getId() + " | " + "Nome: "
				+ funcionario.getNome() + " | " + "Salário: " + funcionario.getSalario()));
	}

}
