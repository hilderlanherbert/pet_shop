package erros;

public class AnimalNaoEncontradoException extends Exception {
	public AnimalNaoEncontradoException() {
		super("Desculpe, animal n�oo encontrado.");
	}
}
