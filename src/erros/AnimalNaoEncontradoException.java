package erros;

public class AnimalNaoEncontradoException extends Exception {
	public AnimalNaoEncontradoException() {
		super("Desculpe, o animal n�o foi encontado no nosso sistema!");
	}
}
