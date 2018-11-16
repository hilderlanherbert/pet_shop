package erros;

public class ProdutoNaoEncontradoException extends Exception {
	public ProdutoNaoEncontradoException() {
		super("Esse produto não encontra-se cadastrado");
	}
}
