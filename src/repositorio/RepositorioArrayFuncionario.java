package repositorio;

import classesBasicas.Funcionario;
import erros.FuncionarioNaoEncontradoException;
import erros.LimiteAtingidoException;
import interfaces.RepositorioFuncionario;

public class RepositorioArrayFuncionario implements RepositorioFuncionario {
	private Funcionario[] arrayFuncionario = new Funcionario[1000];
	private int contador = 0;
	
	// checa se há posição disponível no array e insere o funcionario
	public void inserir(Funcionario funcionario) throws LimiteAtingidoException {
		if (this.contador < this.arrayFuncionario.length) {
			this.arrayFuncionario[contador] = funcionario;
			this.contador++;
		} else {
			LimiteAtingidoException e;
			e = new LimiteAtingidoException();
			throw e;
		}
	}
	
	// remove o funcionario procurado e reorganiza o array
	public void remover(String cpf) throws FuncionarioNaoEncontradoException {
		int indice = this.getIndice(cpf);
		int indiceAux = indice;
		
		// manda os elementos à direita do removido uma posição para a esquerda
		for (int i = 1; i < (arrayFuncionario.length - indice); i++) {
			arrayFuncionario[indiceAux] = arrayFuncionario [indiceAux + 1];
			indiceAux++;
		}
		arrayFuncionario[arrayFuncionario.length - 1] = null;
		contador = contador - 1;
	}
	
	// procura por um funcionario e o retorna dado o seu cpf
	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException {
		Funcionario resposta = null;
		boolean jaAchou = false;
		for (int i = 0; i < this.contador && !jaAchou; i++) {
			if (this.arrayFuncionario[i].getCpf().equals(cpf)) {
				resposta = this.arrayFuncionario[i];
				jaAchou = true;
			}
		}
		
		// retorna um erro se o funcionario procurado não foi encontrado
		if (jaAchou) {
			return resposta;
		} else {
			FuncionarioNaoEncontradoException e;
			e = new FuncionarioNaoEncontradoException();
			throw e;
		}
	}
	
	// recebe um funcionério, pocura por um com cpf igual, o remove e se insere no lugar
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		int indice = this.getIndice(funcionario.getCpf());
		arrayFuncionario[indice] = funcionario;
	}
	
	// método interno para retornar o índice de um objeto dado seu identficador
	public int getIndice(String cpf) throws FuncionarioNaoEncontradoException {
		int resposta = 0;
		boolean jaAchou = false;
		for (int i = 0; i < this.contador && !jaAchou; i++) {
			if (this.arrayFuncionario[i].getCpf().equals(cpf)) {
				resposta = i;
				jaAchou = true;
			}
		}
		if (jaAchou) {
			return resposta;
		} else {
			FuncionarioNaoEncontradoException e;
			e = new FuncionarioNaoEncontradoException();
			throw e;
		}
	}
	
	// método interno para checar se existe um objeto com um dado id
	public boolean existe(String cpf) {
		boolean resposta = false;
		for (int i = 0; i < this.contador && !resposta; i++) {
			if (this.arrayFuncionario[i].getCpf().equals(cpf)) {
				resposta = true;
			}
		}
		return resposta;
	}
}