package interfaces;

import classesBasicas.Funcionario;
import erros.LimiteAtingidoException;
import erros.FuncionarioJaCadastradoException;
import erros.FuncionarioNaoEncontradoException;

public interface RepositorioFuncionario {
	
	//CRIAR ERROS NOVOS

	public void inserir(Funcionario funcionario) throws LimiteAtingidoException, FuncionarioJaCadastradoException;
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException, FuncionarioJaCadastradoException;
	public void remover(String cpf) throws FuncionarioNaoEncontradoException;
	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException;
	public boolean existe(String cpf);
}