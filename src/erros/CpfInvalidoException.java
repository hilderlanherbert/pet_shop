package erros;

public class CpfInvalidoException extends Exception {
	public CpfInvalidoException() {
		super("CPF inv�lido, devem haver 11 digitos.");
	}
}