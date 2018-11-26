package erros;

public class ClienteNaoEncontradoException extends Exception {
	public ClienteNaoEncontradoException () {
		super("Esse cliente não existe em nossa base de dados.");
	}
}
