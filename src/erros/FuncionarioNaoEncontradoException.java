package erros;

public class FuncionarioNaoEncontradoException extends Exception{
	public FuncionarioNaoEncontradoException() {
		super("Funcion�rio n�o encontrado na base de dados.");
	}
}
