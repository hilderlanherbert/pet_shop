package erros;

public class EmailInvalidoException extends Exception {
	public EmailInvalidoException() {
		super("E-mail inv�lido! Precisar seguir o formato exemplo@exemplo.com");
	}
}