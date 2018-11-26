package erros;

public class TipoInvalidoException extends Exception {
	public TipoInvalidoException() {
		super("O produto que você tentou cadastrar é inválido.");
	}
}
