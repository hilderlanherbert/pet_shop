package erros;

public class FuncionarioJaCadastradoException extends Exception {
	public FuncionarioJaCadastradoException () {
		super("Esse funcion�rio j� existe!");
	}
}
