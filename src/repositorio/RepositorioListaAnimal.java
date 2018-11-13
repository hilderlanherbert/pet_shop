package repositorio;

import classesBasicas.Animal;
import erros.AnimalNaoEncontradoException;
import erros.LimiteAtingidoException;
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
	public void inserir(Animal animal) throws LimiteAtingidoException {
		if (this.animal == null) {
			this.animal = animal;
			this.proximo = new RepositorioListaAnimal();
		} else {
			this.proximo.inserir(animal);
		}
	}

	public void atualizar(Animal animal) throws AnimalNaoEncontradoException {
		
	}

	public void remover(String nomeCpf) throws AnimalNaoEncontradoException {
		
	}

	public Animal procurar(String nomeCpf) throws AnimalNaoEncontradoException {
		return null;
	}
	public boolean existe(String nomeCpf) {
		return false;
	}

}
