package erros;

public class EmailInvalidoException extends Exception {
	public EmailInvalidoException() {
		super("E-mail invalido.");
	}
}