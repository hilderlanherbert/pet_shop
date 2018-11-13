package interfaces;

import classesBasicas.Animal;

import erros.AnimalNaoEncontradoException;
import erros.LimiteAtingidoException;

public interface RepositorioAnimal {
	public void inserir(Animal animal) throws LimiteAtingidoException;
	public void atualizar(Animal animal) throws AnimalNaoEncontradoException;
	public void remover(String nomeCpf) throws AnimalNaoEncontradoException;
	public Animal procurar(String nomeCpf) throws AnimalNaoEncontradoException;
	public boolean existe(String nomeCpf);
}