package repositorio;

import classesBasicas.Produtos;
import erros.ProdutoNaoEncontradoException;
import interfaces.RepositorioProduto;

public class RepositorioArrayProduto implements RepositorioProduto {
    private Produtos[] arrayProdutos = new Produtos[1000];
    private int counter = 0;

    public void inserir(Produtos produto) {
        if (!(this.counter < this.arrayProdutos.length)) {
            this.duplicarArray();
        }
        this.arrayProdutos[counter] = produto;
        this.counter++;
    }

    private void duplicarArray(){
        if (this.arrayProdutos != null && this.arrayProdutos.length > 0) {
            Produtos[] arrayDuplicado = new Produtos[this.arrayProdutos.length * 2];
            for (int i = 0; i < this.counter; i++) {
                arrayDuplicado[i] = this.arrayProdutos[i];
            }
            this.arrayProdutos = arrayDuplicado;
        }
    }

    public void remover(String tipo) throws ProdutoNaoEncontradoException {
        int i = this.getPos(tipo);
        if (i != this.counter) {
            this.arrayProdutos[i] = this.arrayProdutos[this.counter - 1];
            this.arrayProdutos[this.counter - 1] = null;
            this.counter = this.counter - 1;
        } else {
            throw new ProdutoNaoEncontradoException();
        }
    }

    public void atualizar(Produtos produto) throws ProdutoNaoEncontradoException {
        this.remover(produto.getTipo());
        this.inserir(produto);
    }

    public Produtos procurar(String tipo) throws ProdutoNaoEncontradoException {
        for(int i=0;i<arrayProdutos.length;i++) {
            if(arrayProdutos!=null && arrayProdutos[i].getTipo().equals(tipo)) {
                return arrayProdutos[i];
            }
        }
        throw new ProdutoNaoEncontradoException();
    }

    public boolean existe(String tipo) {
        try {
            this.procurar(tipo);
            return true;
        } catch (ProdutoNaoEncontradoException pnee) {
            return false;
        }
    }

    private int getPos(String tipo){
        for(int i = 0; i<this.counter; i++) {
            if(tipo.equals(arrayProdutos[i].getTipo())) {
                return i;
            }
        }
        return counter;
    }
}
