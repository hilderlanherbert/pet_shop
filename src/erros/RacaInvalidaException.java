package erros;

public class RacaInvalidaException extends Exception {
	public RacaInvalidaException() {
		super("A ra�� do animal precisa ser definida");
	}
}