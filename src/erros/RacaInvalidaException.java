package erros;

public class RacaInvalidaException extends Exception {
	public RacaInvalidaException() {
		super("A raçã do animal precisa ser definida");
	}
}