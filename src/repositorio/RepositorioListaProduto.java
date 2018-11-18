package repositorio;

import classesBasicas.Produtos;
import erros.ProdutoNaoEncontradoException;
import interfaces.RepositorioProduto;


public class RepositorioListaProduto implements RepositorioProduto {
    private Produtos produto;
    private RepositorioListaProduto proximo;

    //construtor comum
    public RepositorioListaProduto() {
        this.produto = null;
        this.proximo = null;
    }

    // insere o elemento na posicao da lista e referencia proximo para uma nova lista
    public void inserir(Produtos produto){
        if (this.produto == null) {
            this.produto = produto;
            this.proximo = new RepositorioListaProduto();
        } else {
            this.proximo.inserir(produto);
        }
    }

    public void remover(String tipo) throws ProdutoNaoEncontradoException {
        Produtos produtoAchado = this.procurar(tipo);

        if(this.produto!=null){
            if(this.produto.equals(produtoAchado)){
                this.produto = this.proximo.produto;
                this.proximo = this.proximo.proximo;
            }else{
                this.proximo.remover(tipo);
            }
        }else{
            throw new ProdutoNaoEncontradoException();
        }
    }

    public void atualizar(Produtos produto) throws ProdutoNaoEncontradoException {
        this.remover(produto.getTipo());
        this.inserir(produto);
    }

    public Produtos procurar(String tipo) throws ProdutoNaoEncontradoException {
        if (this.produto != null) {
            if (this.produto.getTipo().equals(tipo)) {
                return this.produto;
            } else {
                this.proximo.procurar(tipo);
            }
        }
        throw new ProdutoNaoEncontradoException();
    }

    public boolean existe(String tipo) {
        try{
            this.procurar(tipo);
            return true;
        }catch(ProdutoNaoEncontradoException pnee){
            return false;
        }
    }
}
