package cadastro;

import classesBasicas.Produtos;
import erros.ProdutoJaCadastradoException;
import erros.ProdutoNaoEncontradoException;
import erros.LimiteAtingidoException;
import interfaces.RepositorioProduto;
import repositorio.RepositorioArrayProduto;
import repositorio.RepositorioListaProduto;

public class CadastroProdutos {
	private RepositorioProduto produtos;
	
	// se o construtor receber um parâmtro true, inicializa uma lista, senão, um array
	public CadastroProdutos(boolean tipo) {
		if (tipo) {
			this.produtos = new RepositorioListaProduto();
		} else {			
			this.produtos = new RepositorioArrayProduto();
		}
	}
	
	// checa se o produto já está cadastrado. Se não estiver, o cadastra
	public void cadastrar(Produtos produto) throws LimiteAtingidoException, ProdutoJaCadastradoException {
		if (!this.produtos.existe(produto.getTipo())) {			
			this.produtos.inserir(produto);
		} else {
			ProdutoJaCadastradoException e;
			e = new ProdutoJaCadastradoException();
			throw e;
		}
	}
	
	// chama o remover da interface
	public void remover(String tipo) throws ProdutoNaoEncontradoException {
		this.produtos.remover(tipo);
	}
	
	// chama o atualizar da interface
	public void atualizar(Produtos produto) throws ProdutoNaoEncontradoException, ProdutoJaCadastradoException, LimiteAtingidoException {
		this.produtos.atualizar(produto);
	}
	
	// chama o procurar da interface
	public Produtos procurar (String tipo) throws ProdutoNaoEncontradoException {
		return this.produtos.procurar(tipo);
	}
	
	// chama o existe da interface
	public boolean existe (String tipo) {
		return this.produtos.existe(tipo);
	}


}