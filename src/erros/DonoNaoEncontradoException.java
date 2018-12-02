package erros;

public class DonoNaoEncontradoException extends Exception {
	public DonoNaoEncontradoException() {
		super("O CPF do dono nao foi cadastrado previamente no sistema.");
	}
}