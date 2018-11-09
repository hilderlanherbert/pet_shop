package erros;

public class NumeroCartaoInvalidoException extends Exception {
	public NumeroCartaoInvalidoException() {
		super("Numero do cartao invalido");
	}
}