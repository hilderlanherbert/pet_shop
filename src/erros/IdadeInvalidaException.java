package erros;

public class IdadeInvalidaException extends Exception {
	public IdadeInvalidaException() {
		super("Idade invalida, nao podem haver mais de 3 digitos.");
	}
}
