package erros;

public class TipoInvalidoException extends Exception {
	public TipoInvalidoException() {
		super("O produto que voce tentou cadastrar e invalido.");
	}
}
