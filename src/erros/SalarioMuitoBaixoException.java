package erros;

public class SalarioMuitoBaixoException extends Exception{
	public SalarioMuitoBaixoException() {
		super("Salario abaixo de 954,00 n�o � permitido.");
	}
}