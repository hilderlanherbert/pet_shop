package repositorio;

import classesBasicas.Animal;
import erros.AnimalNaoEncontradoException;
import erros.LimiteAtingidoException;
import interfaces.RepositorioAnimal;

public class RepositorioArrayAnimal  implements RepositorioAnimal {

	@Override
	public void inserir(Animal animal) throws LimiteAtingidoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Animal animal) throws AnimalNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(String nomeCpf) throws AnimalNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Animal procurar(String nomeCpf) throws AnimalNaoEncontradoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(String nomeCpf) {
		// TODO Auto-generated method stub
		return false;
	}

}
