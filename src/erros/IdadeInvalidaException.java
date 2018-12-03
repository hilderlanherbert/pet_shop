package erros;

public class IdadeInvalidaException extends Exception {
	public IdadeInvalidaException() {
		super("Idade inválida, idade não pode ser negativa ou exageradamente elevada.");
	}
}
