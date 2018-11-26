package erros;

public class NomeCurtoException extends Exception {
	public NomeCurtoException() {
		super("Nome inválido, deve haver pelo menos 3 digitos.");
	}
}
