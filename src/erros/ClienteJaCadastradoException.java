package erros;

public class ClienteJaCadastradoException extends Exception {
	public ClienteJaCadastradoException () {
		super("Esse cliente já possui cadastro.");
	}
}
