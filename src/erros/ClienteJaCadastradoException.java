package erros;

public class ClienteJaCadastradoException extends Exception {
	public ClienteJaCadastradoException () {
		super("Esse cliente ja foi cadastrado.");
	}
}
