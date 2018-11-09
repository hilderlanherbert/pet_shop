package erros;

public class CpfInvalidoException extends Exception {
	public CpfInvalidoException() {
		super("CPF invalido, devem haver 11 digitos.");
	}
}