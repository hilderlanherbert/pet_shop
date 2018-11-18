package erros;

public class AnimalJaCadastradoException extends Exception {
	public AnimalJaCadastradoException() {
		super("Animal ja cadastrado.");
	}
}