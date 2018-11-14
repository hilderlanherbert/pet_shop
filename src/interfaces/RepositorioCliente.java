package interfaces;

import classesBasicas.Cliente;
import erros.ClienteNaoEncontradoException;
import erros.LimiteAtingidoException;

public interface RepositorioCliente {
	
	//CRIAR ERROS NOVOS
	
	public void inserir(Cliente cliente) throws LimiteAtingidoException;
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException;
	public void remover(String cpf) throws ClienteNaoEncontradoException;
	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException;
	public boolean existe(String cpf);
}