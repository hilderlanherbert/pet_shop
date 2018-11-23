package repositorio;

import classesBasicas.Cliente;
import erros.ClienteNaoEncontradoException;
import erros.LimiteAtingidoException;
import interfaces.RepositorioCliente;

public class RepositorioArrayCliente implements RepositorioCliente {
	private Cliente[] arrayCliente = new Cliente[1000];
	private int contador = 0;
	
	// checa se há posição disponível no array e insere o cliente
	public void inserir(Cliente cliente) throws LimiteAtingidoException{
		if (this.contador < this.arrayCliente.length) {
			this.arrayCliente[contador] = cliente;
			this.contador++;
		} else {
			LimiteAtingidoException e;
			e = new LimiteAtingidoException();
			throw e;
		}
	}
	
	// remove o cliente procurado e reorganiza o array
	public void remover(String cpf) throws ClienteNaoEncontradoException {
		int indice = this.getIndice(cpf);
		int indiceAux = indice;
		
		// manda os elementos à direita do removido uma posição para a esquerda
		for (int i = 1; i < (arrayCliente.length - indice); i++) {
			arrayCliente[indiceAux] = arrayCliente [indiceAux + 1];
			indiceAux++;
		}
		arrayCliente[arrayCliente.length - 1] = null;
		contador = contador - 1;
	}
	
	
	// procura por um cliente e o retorna dado o seu cpf
	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException {
		Cliente resposta = null;
		boolean jaAchou = false;
		for (int i = 0; i < this.contador && !jaAchou; i++) {
			if (this.arrayCliente[i].getCpf().equals(cpf)) {
				resposta = this.arrayCliente[i];
				jaAchou = true;
			}
		}
		
		// retorna um erro se o cliente procurado não foi encontrado
		if (jaAchou) {
			return resposta;
		} else {
			ClienteNaoEncontradoException e;
			e = new ClienteNaoEncontradoException();
			throw e;
		}
	}
	
	// recebe um cliente, pocura por um com cpf igual, o remove e se insere no lugar
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		int indice = this.getIndice(cliente.getCpf());
		arrayCliente[indice] = cliente;
	}
	
	// método interno para retornar o índice de um objeto dado seu identficador
	public int getIndice(String cpf) throws ClienteNaoEncontradoException {
		int resposta = 0;
		boolean jaAchou = false;
		for (int i = 0; i < this.contador && !jaAchou; i++) {
			if (this.arrayCliente[i].getCpf().equals(cpf)) {
				resposta = i;
				jaAchou = true;
			}
		}
		if (jaAchou) {
			return resposta;
		} else {
			ClienteNaoEncontradoException e;
			e = new ClienteNaoEncontradoException();
			throw e;
		}
	}
	
	// método interno para checar se existe um objeto com um dado cpf
	public boolean existe(String cpf) {
		boolean resposta = false;
		for (int i = 0; i < this.contador && !resposta; i++) {
			if (this.arrayCliente[i].getCpf().equals(cpf)) {
				resposta = true;
			}
		}
		return resposta;
	}
}