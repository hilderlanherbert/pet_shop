package repositorio;

import classesBasicas.Animal;
import erros.AnimalNaoEncontradoException;
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
		if (this.animal != null) {
			if (this.animal.getIdAnimal().equals(nomeCpf)) {
				this.animal = this.proximo.animal;
				this.proximo = this.proximo.proximo;
			} else {
				this.remover(nomeCpf);
			}
		} else {
			AnimalNaoEncontradoException e;
			e = new AnimalNaoEncontradoException();
			throw e;
		}
		
	}

	public Animal procurar(String nomeCpf) throws AnimalNaoEncontradoException {
		Animal resposta = null;
		if (this.animal != null) {
			if (this.animal.getIdAnimal().equals(nomeCpf)) {
				resposta = this.animal;
			} else {
				this.procurar(nomeCpf);
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
