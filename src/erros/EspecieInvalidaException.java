package erros;

public class EspecieInvalidaException extends Exception {
	public EspecieInvalidaException() {
		super("S�o permitidos apenas cachorros, gatos e aves");
	}
}