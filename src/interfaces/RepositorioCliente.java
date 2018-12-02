package interfaces;

import classesBasicas.Cliente;
import erros.ClienteJaCadastradoException;
import erros.ClienteNaoEncontradoException;
import erros.LimiteAtingidoException;

public interface RepositorioCliente {	
	public void inserir(Cliente cliente) throws LimiteAtingidoException, ClienteJaCadastradoException;
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException;
	public void remover(String cpf) throws ClienteNaoEncontradoException;
	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException;
	public boolean existe(String cpf);
	
}