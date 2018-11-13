package repositorio;

import classesBasicas.Animal;
import erros.AnimalNaoEncontradoException;
import erros.LimiteAtingidoException;
import interfaces.RepositorioAnimal;

public class RepositorioArrayAnimal  implements RepositorioAnimal {

	public void inserir(Animal animal) throws LimiteAtingidoException {
		
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
