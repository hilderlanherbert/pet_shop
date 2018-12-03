package classesBasicas;

import erros.NomeCurtoException;
import erros.EspecieInvalidaException;
import erros.RacaInvalidaException;
import erros.IdadeInvalidaException;

public class Animal {
	private Cliente dono;
	private String especie;
	private String nome;
	private String raca;
	private String idAnimal;

	public Animal (String nome, String especie, String raca, Cliente dono)
			throws NomeCurtoException, EspecieInvalidaException, RacaInvalidaException, IdadeInvalidaException {

		// Checa se o nome tem mais que um caracterer 
		if (nome.length() > 1) {
			this.nome = nome;
		} else {
			NomeCurtoException e;
			e = new NomeCurtoException();
			throw e;
		}
		
		// Checa se é uma especie valida
		if (especie.equals("cachorro") || especie.equals("gato") || especie.equals("ave")) {
			this.especie = especie;
		} else {
			EspecieInvalidaException e;
			e = new EspecieInvalidaException();
			throw e;
		}
		
		// Checa se foi digitada uma raça
		if (raca.length() > 1) {
			this.raca = raca;
		} else {
			RacaInvalidaException e;
			e = new RacaInvalidaException();
			throw e;
		}
		
		
			this.dono = dono;
		

	}
	
	// obter nome do animal
	public String getNome() {
		return this.nome;
	}
	
	//obter especie do animal
	public String getEspecie() {
		return this.especie;
	}
	
	//obter raça do animal
	public String getRaca() {
		return this.raca;
	}

	//obter id do animal
	public String getIdAnimal() {
		idAnimal = this.nome+"#"+this.getDono().getCpf();
		return this.idAnimal;
	}
	
	//obter o dono
	public Cliente getDono() {
		return this.dono;
	}

	// Método setNome se o nome entrar errado
	public void setNome(String nome) throws NomeCurtoException {
		if (nome.length() > 1) {
			this.nome = nome;
		} else {
			NomeCurtoException e;
			e = new NomeCurtoException();
			throw e;
		}
	}


	

	
}
