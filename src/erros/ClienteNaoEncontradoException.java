package erros;

public class ClienteNaoEncontradoException extends Exception {
	public ClienteNaoEncontradoException () {
		super("Esse cliente n�o existe em nossa base de dados.");
	}
}
