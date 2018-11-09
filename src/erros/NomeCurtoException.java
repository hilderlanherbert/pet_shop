package erros;

public class NomeCurtoException extends Exception {
	public NomeCurtoException() {
		super("Nome invalido, devem haver pelo menos 3 digitos.");
	}
}
