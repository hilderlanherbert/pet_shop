package erros;

public class TipoInvalidoException extends Exception {
	public TipoInvalidoException() {
		super("O produto que voc� tentou cadastrar � inv�lido.");
	}
}
