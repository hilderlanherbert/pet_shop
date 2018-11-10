package erros;

public class EspecieInvalidaException extends Exception {
	public EspecieInvalidaException() {
		super("São permitidos apenas Cachorro, Gato e Ave");
	}
}