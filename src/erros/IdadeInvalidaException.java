package erros;

public class IdadeInvalidaException extends Exception {
	public IdadeInvalidaException() {
		super("Idade inv�lida, idade n�o pode ser negativa ou exageradamente elevada.");
	}
}
