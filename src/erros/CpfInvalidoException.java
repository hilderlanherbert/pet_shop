package erros;

public class CpfInvalidoException extends Exception {
	public CpfInvalidoException() {
		super("CPF inválido, devem haver 11 digitos.");
	}
}