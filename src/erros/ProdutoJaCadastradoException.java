package erros;

public class ProdutoJaCadastradoException extends Exception {
	public ProdutoJaCadastradoException() {
		super("Esse produto já foi cadastrado!");
	}
}
