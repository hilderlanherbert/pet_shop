package fachada;

import cadastro.CadastroCliente;
import cadastro.CadastroFuncionario;
import cadastro.CadastroAnimal;
import cadastro.CadastroProdutos;
import classesBasicas.Animal;
import classesBasicas.Cliente;
import classesBasicas.Funcionario;
import classesBasicas.Produtos;
import erros.ClienteJaCadastradoException;
import erros.ClienteNaoEncontradoException;
import erros.EspecieInvalidaException;
import erros.FuncionarioJaCadastradoException;
import erros.FuncionarioNaoEncontradoException;
import erros.LimiteAtingidoException;
import erros.NomeCurtoException;
import erros.AnimalJaCadastradoException;
import erros.AnimalNaoEncontradoException;
import erros.ProdutoJaCadastradoException;
import erros.ProdutoNaoEncontradoException;
import erros.RacaInvalidaException;

public class PetShop {
	private CadastroCliente clientes;
	private CadastroFuncionario funcionarios;
	private CadastroAnimal animal;
	private CadastroProdutos produtos;

	
	public PetShop(boolean tipo) {
		clientes = new CadastroCliente(tipo);
		funcionarios = new CadastroFuncionario(tipo);
		animal = new CadastroAnimal(tipo);
		produtos = new CadastroProdutos(tipo);

		
	}
	
	// Cliente
	public void cadastrarCliente(Cliente cliente) throws LimiteAtingidoException, ClienteJaCadastradoException {
		clientes.cadastrar(cliente);
	}

	public void removerCliente(String cpf) throws ClienteNaoEncontradoException {
		clientes.remover(cpf);
	}

	public void atualizarCliente(Cliente cliente) throws ClienteNaoEncontradoException {
		clientes.atualizar(cliente);
	}

	public Cliente procurarCliente(String cpf) throws ClienteNaoEncontradoException {
		return clientes.procurar(cpf);
	}
		
	
	//Funcionário
	public void cadastrarFuncionario(Funcionario funcionario) throws LimiteAtingidoException, FuncionarioJaCadastradoException {
		funcionarios.cadastrar(funcionario);
	}

	public void removerFuncionario(String cpf) throws FuncionarioNaoEncontradoException {
		funcionarios.remover(cpf);
	}

	public void atualizarFuncionario(Funcionario funcionario)
			throws FuncionarioNaoEncontradoException, FuncionarioJaCadastradoException {
		funcionarios.atualizar(funcionario);
	}

	public Funcionario procurarFuncionario(String cpf) throws FuncionarioNaoEncontradoException {
		return funcionarios.procurar(cpf);
	}
	
	//Animal
	public void cadastrarAnimal(Animal animais) throws LimiteAtingidoException, AnimalJaCadastradoException, NomeCurtoException, RacaInvalidaException, EspecieInvalidaException {
		animal.cadastrar(animais);
	}

	public void removerAnimal(String idAnimal) throws AnimalNaoEncontradoException {
		animal.remover(idAnimal);
	}

	public void atualizarAnimal(Animal animais)
			throws AnimalNaoEncontradoException, AnimalJaCadastradoException, NomeCurtoException, EspecieInvalidaException, RacaInvalidaException {
		animal.atualizar(animais);
	}

	public Animal procurarAnimal(String tipo) throws AnimalNaoEncontradoException {
		return animal.procurar(tipo);
	}
	
	//Produtos	
	public void cadastrarProdutos(Produtos produto) throws LimiteAtingidoException, ProdutoJaCadastradoException {
		produtos.cadastrar(produto);
	}

	public void removerProdutos(String tipo) throws ProdutoNaoEncontradoException {
		produtos.remover(tipo);
	}

	public void atualizarProdutos(Produtos produto)
			throws ProdutoNaoEncontradoException, ProdutoJaCadastradoException {
		produtos.atualizar(produto);
	}

	public Produtos procurarProdutos(String tipo) throws ProdutoNaoEncontradoException {
		return produtos.procurar(tipo);
	}
}