package repositorio;

import interfaces.RepositorioFuncionario;
import classesBasicas.Funcionario;
import erros.FuncionarioJaCadastradoException;
import erros.FuncionarioNaoEncontradoException;

public class RepositorioListaFuncionario implements RepositorioFuncionario {
	private Funcionario funcionario;
	private RepositorioListaFuncionario proximo;
	
	// construtor básico
	public RepositorioListaFuncionario() {
		this.funcionario = null;
		this.proximo = null;
	}
	
	// insere o elemento na posição da lista e referencia próximo para uma nova lista
	public void inserir(Funcionario funcionario) {
		if (this.funcionario == null) {
			this.funcionario = funcionario;
			this.proximo = new RepositorioListaFuncionario();
		} else {
			this.proximo.inserir(funcionario);
		}
	}
	
	// remove o elemento da lista (usa o garbage collector)
	public void remover(String cpf) throws FuncionarioNaoEncontradoException {
		Funcionario funcionarioAchado;
		funcionarioAchado = this.procurar(cpf);

		if (this.funcionario != null) {
			if (this.funcionario.equals(funcionarioAchado)) {
				this.funcionario = this.proximo.funcionario;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(cpf);
			}
		} else {
			FuncionarioNaoEncontradoException e;
			e = new FuncionarioNaoEncontradoException();
			throw e;
		}
	}
	
	// procura por um objeto com o determinado identificador, o remove, e insere o novo no lugar
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException, FuncionarioJaCadastradoException {
		Funcionario funcionarioAnterior;
		funcionarioAnterior = procurar(funcionario.getCpf());
		this.remover(funcionarioAnterior.getCpf());
		this.inserir(funcionario);
	}
	
	// retorna o funcionário dado o seu cpf
	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException {
		Funcionario resposta;
		resposta = null;
		if (this.funcionario != null) {
			if (this.funcionario.getCpf().equals(cpf)) {
				resposta = this.funcionario;
			} else {
				this.proximo.procurar(cpf);
			}
		} else {
			FuncionarioNaoEncontradoException e;
			e = new FuncionarioNaoEncontradoException();
			throw e;
		}
		return resposta;
	}
	
	// método interno para checar se há um objeto com determinado identificador
	public boolean existe(String cpf) {
		if (this.funcionario != null) {
			if (this.funcionario.getCpf().equals(cpf)) {
				return true;
			} else {
				return this.proximo.existe(cpf);
			}
		} else {
			return false;
		}
	}
}