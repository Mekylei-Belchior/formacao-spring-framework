package br.com.mekylei.gerenciador.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author mekylei
 * @version 1.0
 * 
 *          Objeto para representar uma empresa
 * 
 */
public class Empresa {

	private Integer id;
	private String nome;
	private LocalDate data;
	protected static DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Empresa(String nome, String data) {

		Banco banco = new Banco();

		this.id = banco.getID();
		this.nome = nome;
		this.data = LocalDate.parse(data, Empresa.FORMATO);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public String getData() {
		return data.format(FORMATO);
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

}
