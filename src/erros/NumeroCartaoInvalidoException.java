package erros;

public class NumeroCartaoInvalidoException extends Exception {
	public NumeroCartaoInvalidoException() {
		super("N�mero do cart�o inv�lido. Precisa ter 16 d�gitos.");
	}
}