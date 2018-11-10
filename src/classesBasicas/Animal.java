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
	private int idade;
	
	protected Animal (String especie, String nome , String raca, int idade )
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
		if (especie.equals("Cachorro") || (especie.equals("Gato") || (especie.equals("Ave")) {
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
		
		//Checa se a idade é maior que zero
		if (idade > 0) {
			this.idade = idade;
		} else {
			IdadeInvalidaException e;
			e = new IdadeInvalidaException();
			throw e;
		}
	}
	
	// obter nome do animal
	protected String getNome() {
		return this.nome;
	}
	
	//obter especie do animal
	protected String getEspecie() {
		return this.especie;
	}
	
	//obter raça do animal
	protected String getRaca() {
		return this.raca;
	}
	
	
	//obter idade do animal
	protected int getIdade() {
		return this.idade;
	}
	
	// Método setNome se o nome entrar errado
	protected void setNome(String nome) throws NomeCurtoException {
		if (nome.length() > 1) {
			this.nome = nome;
		} else {
			NomeCurtoException e;
			e = new NomeCurtoException();
			throw e;
		}
	}
}
