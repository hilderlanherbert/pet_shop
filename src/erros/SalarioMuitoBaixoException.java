package erros;

public class SalarioMuitoBaixoException extends Exception{
	public SalarioMuitoBaixoException() {
		super("Salario abaixo do minimo.");
	}
}