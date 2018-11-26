package erros;

public class IdadeInvalidaException extends Exception {
	public IdadeInvalidaException() {
		super("Idade inválida, não pode haver mais de 3 digitos.");
	}
}
