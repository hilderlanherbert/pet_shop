package interfaces;

import classesBasicas.Animal;
import erros.AnimalJaCadastradoException;
import erros.AnimalNaoEncontradoException;
import erros.ClienteNaoEncontradoException;
import erros.LimiteAtingidoException;
import erros.NomeCurtoException;
import erros.RacaInvalidaException;
import erros.EspecieInvalidaException;

public interface RepositorioAnimal {
	public void inserir(Animal animal) throws LimiteAtingidoException, NomeCurtoException, EspecieInvalidaException, RacaInvalidaException, AnimalJaCadastradoException;
	public void atualizar(Animal animal) throws AnimalNaoEncontradoException, NomeCurtoException , EspecieInvalidaException, RacaInvalidaException, ClienteNaoEncontradoException;
	public void remover(String idAnimal) throws AnimalNaoEncontradoException;
	public Animal procurar(String idAnimal) throws AnimalNaoEncontradoException;
	public boolean existe(String idAnimal);
	
}