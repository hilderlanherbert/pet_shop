package erros;

public class FuncionarioJaCadastradoException extends Exception {
	public FuncionarioJaCadastradoException () {
		super("Esse funcionário já existe!");
	}
}
