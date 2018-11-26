package erros;

public class FuncionarioNaoEncontradoException extends Exception{
	public FuncionarioNaoEncontradoException() {
		super("Funcionário não encontrado na base de dados.");
	}
}
