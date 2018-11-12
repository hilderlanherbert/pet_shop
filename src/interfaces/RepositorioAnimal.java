package interfaces;

import classesBasicas.Cliente;
import erros.ClienteNaoEncontradoException;
import erros.LimiteAtingidoException;

public interface RepositorioAnimal {
	public void inserir(Animal animal) throws LimiteAtingidoException;
	public void atualizar(Animal animal) throws AnimalNaoEncontradoException;
	public void remover(String nomeCpf) throws AnimalNaoEncontradoException;
	public Cliente procurar(String nomeCpf) throws AnimalNaoEncontradoException;
	public boolean existe(String nomeCpf);
}