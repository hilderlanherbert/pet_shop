package erros;

public class AnimalNaoEncontradoException extends Exception {
	public AnimalNaoEncontradoException() {
		super("Cliente nao encontrado");
	}
}
