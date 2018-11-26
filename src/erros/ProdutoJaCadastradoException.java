package erros;

public class ProdutoJaCadastradoException extends Exception {
	public ProdutoJaCadastradoException() {
		super("Produto não encontrado, digite um produto válido.");
	}
}
