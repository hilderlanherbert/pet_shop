package erros;

public class NomeCurtoException extends Exception {
	public NomeCurtoException() {
		super("Nome inv�lido, deve haver pelo menos 3 digitos.");
	}
}
