package repositorio;

import classesBasicas.Animal;
import classesBasicas.Cliente;
import erros.AnimalNaoEncontradoException;
import erros.ClienteNaoEncontradoException;
import interfaces.RepositorioAnimal;

public class RepositorioListaAnimal implements RepositorioAnimal{
	private Animal animal;
	private RepositorioListaAnimal proximo;
	
	//construtor comum
	public RepositorioListaAnimal() {
		this.animal = null;
		this.proximo = null;
	}
	
	// insere o elemento na posicao da lista e referencia proximo para uma nova lista
	public void inserir(Animal animal)  {
		if (this.animal == null) {
			this.animal = animal;
			this.proximo = new RepositorioListaAnimal();
		} else {
			this.proximo.inserir(animal);
		}
	}

	public void atualizar(Animal animal) throws AnimalNaoEncontradoException {
		Animal animalAnterior;
		animalAnterior = this.procurar(animal.getIdAnimal());
		this.remover(animalAnterior.getIdAnimal());
		this.inserir(animal);
	}

	public void remover(String nomeCpf) throws AnimalNaoEncontradoException {
		Animal animalAchado;
		animalAchado = this.procurar(nomeCpf);
		
		if (this.animal != null) {
			if (this.animal.equals(animalAchado)) {
				this.animal = this.proximo.animal;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(nomeCpf);
			}
		} else {
			AnimalNaoEncontradoException e;
			e = new AnimalNaoEncontradoException();
			throw e;
		}
		
	}
	

	public Animal procurar(String nomeCpf) throws AnimalNaoEncontradoException {
		Animal resposta ;
		resposta = null;
		if (this.animal != null ) {
			if (this.animal.getIdAnimal().equals(nomeCpf)) {
				resposta = this.animal;
			} else {
				this.proximo.procurar(nomeCpf);
			}
		} else {
			AnimalNaoEncontradoException e;
			e = new AnimalNaoEncontradoException();
			throw e;
		}
		
		return resposta;
	}
	

	public boolean existe(String nomeCpf) {
		if (this.animal != null) {
			if (this.animal.getIdAnimal().equals(nomeCpf)) {
				return true;
			} else {
				return this.existe(nomeCpf);
			}
		} else {
			return false;
		}
	}

}
