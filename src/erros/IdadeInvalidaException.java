package erros;

public class IdadeInvalidaException extends Exception {
	public IdadeInvalidaException() {
		super("Idade inv�lida, n�o pode haver mais de 3 digitos.");
	}
}
