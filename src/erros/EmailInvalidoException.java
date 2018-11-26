package erros;

public class EmailInvalidoException extends Exception {
	public EmailInvalidoException() {
		super("E-mail inválido! Precisar seguir o formato exemplo@exemplo.com");
	}
}