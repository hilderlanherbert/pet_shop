package repositorio;

import classesBasicas.Produtos;
import erros.LimiteAtingidoException;
import erros.ProdutoNaoEncontradoException;
import interfaces.RepositorioProduto;

public class RepositorioArrayProduto implements RepositorioProduto {
    private Produtos[] arrayProdutos = new Produtos[1000];
    private int contador = 0;

  
 // checa se há posição disponível no array e insere o cliente
 	public void inserir(Produtos produto) throws LimiteAtingidoException{
 		if (this.contador < this.arrayProdutos.length) {
 			this.arrayProdutos[contador] = produto;
 			this.contador++;
 		} else {
 			LimiteAtingidoException e;
 			e = new LimiteAtingidoException();
 			throw e;
 		}
 	}

    public void remover(String tipo) throws ProdutoNaoEncontradoException {
		int indice = this.getIndice(tipo);
		int indiceAux = indice;
		
		// manda os elementos à direita do removido uma posição para a esquerda
		for (int i = 1; i < (arrayProdutos.length - indice); i++) {
			arrayProdutos[indiceAux] = arrayProdutos [indiceAux + 1];
			indiceAux++;
		}
		arrayProdutos[arrayProdutos.length - 1] = null;
		contador = contador - 1;
	}
    
 
 // recebe um produto, pocura por um com tipo igual, o remove e se insere no lugar
 	public void atualizar(Produtos produto) throws ProdutoNaoEncontradoException, LimiteAtingidoException {
 		int indice = this.getIndice(produto.getTipo());
 		arrayProdutos[indice] = produto;
 	}


	// procura por um produto e o retorna dado o seu tipo
	public Produtos procurar(String tipo) throws ProdutoNaoEncontradoException {
		Produtos resposta = null;
		boolean jaAchou = false;
		for (int i = 0; i < this.contador && !jaAchou; i++) {
			if (this.arrayProdutos[i].getTipo().equals(tipo)) {
				resposta = this.arrayProdutos[i];
				jaAchou = true;
			}
		}
	// retorna um erro se o produto procurado não foi encontrado
			if (jaAchou) {
				return resposta;
			} else {
				ProdutoNaoEncontradoException e;
				e = new ProdutoNaoEncontradoException();
				throw e;
			}
		}		
		
    public boolean existe(String tipo) {
        try {
            this.procurar(tipo);
            return true;
        } catch (ProdutoNaoEncontradoException pnee) {
            return false;
        }
    }
    public int getIndice(String tipo) throws ProdutoNaoEncontradoException {
		int resposta = 0;
		boolean jaAchou = false;
		for (int i = 0; i < this.contador && !jaAchou; i++) {
			if (this.arrayProdutos[i].getTipo().equals(tipo)) {
				resposta = i;
				jaAchou = true;
			}
		}
		if (jaAchou) {
			return resposta;
		} else {
			ProdutoNaoEncontradoException e;
			e = new ProdutoNaoEncontradoException();
			throw e;
		}
	}
	
}