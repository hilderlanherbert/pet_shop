package cadastro;

import classesBasicas.Funcionario;
import erros.FuncionarioJaCadastradoException;
import erros.FuncionarioNaoEncontradoException;
import erros.LimiteAtingidoException;
import interfaces.RepositorioFuncionario;
import repositorio.RepositorioArrayFuncionario;
import repositorio.RepositorioListaFuncionario;

public class CadastroFuncionario {
	private RepositorioFuncionario funcionarios;

	// se o construtor receber um parâmtro true, inicializa uma lista, senão, um array
	public CadastroFuncionario(boolean tipo) {
		if (tipo) {
			this.funcionarios = new RepositorioListaFuncionario();
		} else {
			this.funcionarios = new RepositorioArrayFuncionario();
		}
	}

	// checa se o funcionario já está cadastrado. Se não estiver, o cadastra
	public void cadastrar(Funcionario funcionario) throws LimiteAtingidoException, FuncionarioJaCadastradoException {
		if (!this.funcionarios.existe(funcionario.getCpf())) {
			this.funcionarios.inserir(funcionario);
		} else {
			FuncionarioJaCadastradoException e;
			e = new FuncionarioJaCadastradoException();
			throw e;
		}
	}
	
	// chama o remover da interface
	public void remover(String cpf) throws FuncionarioNaoEncontradoException{
		this.funcionarios.remover(cpf);
	}
	
	// chama o atualizar da interface
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException, FuncionarioJaCadastradoException {
		this.funcionarios.atualizar(funcionario);
	}
	
	// chama o procurar da interface
	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException {
		return this.funcionarios.procurar(cpf);
	}
	
	// chama o existe da interface
	public boolean existe(String cpf) {
		return this.funcionarios.existe(cpf);
	}
}