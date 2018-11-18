package erros;

public class AnimalNaoEncontradoException extends Exception {
	public AnimalNaoEncontradoException() {
		super("Animal nao encontrado.");
	}
}
