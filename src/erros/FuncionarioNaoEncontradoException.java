package erros;

public class FuncionarioNaoEncontradoException extends Exception{
	public FuncionarioNaoEncontradoException() {
		super("Este funcioário não foi encontrado");
	}
}
