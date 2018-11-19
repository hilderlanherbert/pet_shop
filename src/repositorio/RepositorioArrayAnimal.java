package repositorio;

import classesBasicas.Animal;
import erros.AnimalNaoEncontradoException;
import erros.LimiteAtingidoException;
import interfaces.RepositorioAnimal;

public class RepositorioArrayAnimal implements RepositorioAnimal {
	private Animal[] arrayAnimais = new Animal[1000];
	private int contador = 0;

	public void inserir(Animal animal) throws LimiteAtingidoException {
		if (this.contador < this.arrayAnimais.length) {
			this.arrayAnimais[contador] = animal;
			this.contador++;
		} else {
			LimiteAtingidoException e;
			e = new LimiteAtingidoException();
			throw e;
		}
	}

	public void atualizar(Animal animal) throws AnimalNaoEncontradoException {
		int index = this.getIndice(animal.getIdAnimal());
		arrayAnimais[index] = animal;
	}

	public void remover(String nomeCpf) throws AnimalNaoEncontradoException {
		int index = this.getIndice(nomeCpf);
		int indexAux = index;

		for (int i = 1; i < arrayAnimais.length - index; i++) {
			arrayAnimais[indexAux] = arrayAnimais[indexAux + 1];
			indexAux++;
		}
		arrayAnimais[arrayAnimais.length - 1] = null;
		contador = contador - 1;
	}

	public Animal procurar(String nomeCpf) throws AnimalNaoEncontradoException {
		Animal resposta = null;
		boolean achou = false;
		for (int i = 0; i < this.contador && !achou; i++) {
			if (this.arrayAnimais[i].getIdAnimal().equals(nomeCpf)) {
				resposta = this.arrayAnimais[i];
				achou = true;
			}
		}

		if (achou) {
			return resposta;
		} else {
			AnimalNaoEncontradoException e;
			e = new AnimalNaoEncontradoException();
			throw e;
		}
	}

	public boolean existe(String nomeCpf) {
		boolean resposta = false;
		for (int i = 0; i < this.contador && !resposta; i++) {
			if (this.arrayAnimais[i].getIdAnimal().equals(nomeCpf)) {
				resposta = true;
			}
		}		
		return resposta;
	}

	public int getIndice(String nomeCpf) throws AnimalNaoEncontradoException {
		int resposta = 0;
		boolean achou = false;
		for (int i = 0; i < this.contador && !achou; i++) {
			if (this.arrayAnimais[i].getIdAnimal().equals(nomeCpf)) {
				resposta = i;
				achou = true;
			}
		}
		if (achou) {
			return resposta;
		} else {
			AnimalNaoEncontradoException e;
			e = new AnimalNaoEncontradoException();
			throw e;
		}
	}

}
