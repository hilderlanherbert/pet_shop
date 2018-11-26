package erros;

public class NumeroCartaoInvalidoException extends Exception {
	public NumeroCartaoInvalidoException() {
		super("Número do cartão inválido. Precisa ter 16 dígitos.");
	}
}