package cadastro;

import classesBasicas.Cliente;
import erros.ClienteJaCadastradoException;
import erros.ClienteNaoEncontradoException;
import erros.LimiteAtingidoException;
import interfaces.RepositorioCliente;
import repositorio.RepositorioArrayCliente;
import repositorio.RepositorioListaCliente;

public class CadastroCliente {
	private RepositorioCliente clientes;
	
	// se o construtor receber um parâmtro true, inicializa uma lista, senão, um array
	public CadastroCliente(boolean tipo) {
		if (tipo) {
			this.clientes = new RepositorioListaCliente();
		} else {			
			this.clientes = new RepositorioArrayCliente();
		}
	}
	
	// checa se o cliente já está cadastrado. Se não estiver, o cadastra
	public void cadastrar(Cliente cliente) throws LimiteAtingidoException, ClienteJaCadastradoException {
		if (!this.clientes.existe(cliente.getCpf())) {			
			this.clientes.inserir(cliente);
		} else {
			ClienteJaCadastradoException e;
			e = new ClienteJaCadastradoException();
			throw e;
		}
	}
	
	// chama o remover da interface
	public void remover(String cpf) throws ClienteNaoEncontradoException {
		this.clientes.remover(cpf);
	}
	
	// chama o atualizar da interface
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		this.clientes.atualizar(cliente);
	}
	
	// chama o procurar da interface
	public Cliente procurar (String cpf) throws ClienteNaoEncontradoException {
		return this.clientes.procurar(cpf);
	}
	
	// chama o existe da interface
	public boolean existe (String cpf) {
		return this.clientes.existe(cpf);
	}
}