package erros;

public class ProdutoJaCadastradoException extends Exception {
	public ProdutoJaCadastradoException() {
		super("Produto n�o encontrado, digite um produto v�lido.");
	}
}
