package erros;

public class EspecieInvalidaException extends Exception {
	public EspecieInvalidaException() {
		super("S�o permitidos apenas Cachorros, Gatos e Aves");
	}
}