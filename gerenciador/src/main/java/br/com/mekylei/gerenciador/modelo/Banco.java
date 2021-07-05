package br.com.mekylei.gerenciador.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author mekylei
 * @version 1.0
 * 
 *          Objeto para simular uma base de dados
 * 
 */
public class Banco {

	private static List<Empresa> EMPRESAS = new ArrayList<>();
	private static List<Usuario> USUARIOS = new ArrayList<>();

	private static Integer ID = 1;

	static {

		Empresa microsoft = new Empresa("Microsoft", "12/06/1985");
		incrementaID();
		Empresa linkedin = new Empresa("LinkedIn", "06/02/2001");
		incrementaID();
		Empresa google = new Empresa("Google", "01/12/1995");
		incrementaID();

		Banco.EMPRESAS.add(microsoft);
		Banco.EMPRESAS.add(linkedin);
		Banco.EMPRESAS.add(google);

		Usuario fulano = new Usuario("Fulano", "123");
		Usuario ciclano = new Usuario("Ciclano", "456");
		Usuario maria = new Usuario("Maria", "789");

		Banco.USUARIOS.add(fulano);
		Banco.USUARIOS.add(ciclano);
		Banco.USUARIOS.add(maria);

	}

	public void adiciona(Empresa empresa) {
		Banco.EMPRESAS.add(empresa);
		incrementaID();
	}

	public List<Empresa> getEmpresas() {
		return Banco.EMPRESAS;
	}

	public static void incrementaID() {
		Banco.ID++;
	}

	public Integer getID() {
		return Banco.ID;
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> iterador = Banco.EMPRESAS.iterator();

		while (iterador.hasNext()) {
			Empresa empresa = iterador.next();

			if (empresa.getId() == id) {
				iterador.remove();
			}
		}
	}

	public Empresa getEmpresaPorId(Integer id) {
		for (Empresa empresa : EMPRESAS) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public void editaEmpresa(Integer id, String nome, String data) {
		for (Empresa empresa : EMPRESAS) {
			if (empresa.getId() == id) {
				empresa.setNome(nome);
				empresa.setData(LocalDate.parse(data, Empresa.FORMATO));
			}
		}

	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : Banco.USUARIOS) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}

		return null;
	}

}
