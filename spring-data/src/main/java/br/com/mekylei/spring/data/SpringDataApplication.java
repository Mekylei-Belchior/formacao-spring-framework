package br.com.mekylei.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mekylei.spring.data.service.CrudCargoService;
import br.com.mekylei.spring.data.service.CrudFuncionarioService;
import br.com.mekylei.spring.data.service.CrudUnidadeDeTrabalhoService;
import br.com.mekylei.spring.data.service.RelatoriaService;
import br.com.mekylei.spring.data.service.RelatorioFuncionarioDinamico;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;
	private final RelatoriaService relatorioService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeDeTrabalhoService unidadeService;
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;
	
	private boolean system = true;

	public SpringDataApplication(
			CrudCargoService cargoService,
			RelatoriaService relatorioService,
			CrudFuncionarioService funcionarioService,
			CrudUnidadeDeTrabalhoService unidadeService,
			RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {

		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeService = unidadeService;
		this.relatorioService = relatorioService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("[Tela Inicial] - Escolha uma ação:");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionário");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatório");
			System.out.println("5 - Relatório Dinâmico");

			int acao = scanner.nextInt();

			switch (acao) {
			case 1:
				cargoService.inicial(scanner);
				break;
			case 2:
				funcionarioService.inicial(scanner);
				break;
			case 3:
				unidadeService.inicial(scanner);
				break;
			case 4:
				relatorioService.inicial(scanner);
				break;
			case 5:
				relatorioFuncionarioDinamico.inicial(scanner);
				break;
			default:
				system = false;
				break;
			}

		}

	}

}
