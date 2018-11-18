package repositorio;

import interfaces.RepositorioCliente;
import classesBasicas.Cliente;
import erros.ClienteNaoEncontradoException;

public class RepositorioListaCliente implements RepositorioCliente {
	private Cliente cliente;
	private RepositorioListaCliente proximo;
	
	// construtor básico
	public RepositorioListaCliente() {
		this.cliente = null;
		this.proximo = null;
	}
	
	// insere o elemento na posição da lista e referencia próximo para uma nova lista
	public void inserir(Cliente cliente) {
		if (this.cliente == null) {
			this.cliente = cliente;
			this.proximo = new RepositorioListaCliente();
		} else {			
			this.proximo.inserir(cliente);
		}
	}
	
	// remove o elemento da lista (usa o garbage collector)
	public void remover(String cpf) throws ClienteNaoEncontradoException {
		Cliente clienteAchado;
		clienteAchado = this.procurar(cpf);

		if (this.cliente != null) {
			if (this.cliente.equals(clienteAchado)) {
				this.cliente = this.proximo.cliente;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(cpf);
			}
		} else {
			ClienteNaoEncontradoException e;
			e = new ClienteNaoEncontradoException();
			throw e;
		}
	}
	
	// procura por um objeto com o determinado identificador, o remove, e insere o novo no lugar
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		Cliente clienteAnterior;
		clienteAnterior = procurar(cliente.getCpf());
		this.remover(clienteAnterior.getCpf());
		this.inserir(cliente);
	}
	
	// retorna o objeto cliente dado o seu cpf
	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException {
		Cliente resposta;
		resposta = null;
		if (this.cliente != null) {
			if (this.cliente.getCpf().equals(cpf)) {
				resposta = this.cliente;
			} else {
				this.proximo.procurar(cpf);
			}
		} else {
			ClienteNaoEncontradoException e;
			e = new ClienteNaoEncontradoException();
			throw e;
		}
		return resposta;
	}

	// método interno para checar se há um objeto com determinado identificador
	public boolean existe(String cpf) {
		if (this.cliente != null) {
			if (this.cliente.getCpf().equals(cpf)) {
				return true;
			} else {
				return this.proximo.existe(cpf);
			}
		} else {
			return false;
		}
	}

}