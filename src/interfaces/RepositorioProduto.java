package interfaces;

import classesBasicas.Produtos;
import erros.LimiteAtingidoException;
import erros.ProdutoJaCadastradoException;
import erros.ProdutoNaoEncontradoException;

public interface RepositorioProduto {
	
	//CRIAR ERROS NOVOS

	public void inserir(Produtos produto) throws LimiteAtingidoException, ProdutoJaCadastradoException;
	public void atualizar(Produtos Produto) throws ProdutoNaoEncontradoException, ProdutoJaCadastradoException;
	public void remover(String tipo) throws ProdutoNaoEncontradoException;
	public Produtos procurar(String tipo) throws ProdutoNaoEncontradoException;
	public boolean existe(String tipo);
}