package br.com.agenda.model;

import java.util.Date;

public class Agenda {
	
	//Criação de atributos para a classe
	private int id;
	private String nome;
	private int idade;
	private Date dataCadastro;
	
	//Criação de getters e setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
