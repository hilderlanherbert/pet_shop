package classesBasicas;

import erros.CpfInvalidoException;
import erros.IdadeInvalidaException;
import erros.NomeCurtoException;
import erros.SalarioMuitoBaixoException;

public class Funcionario extends Pessoa {
	// Atributos exclusivos da classe Funcionario
		private String cargo;
		private double salario;
		
		// Construtor classe Funcionario
		public Funcionario(String nome, String cpf, String dataNascimento, String cargo, double salario)
				throws NomeCurtoException, CpfInvalidoException, SalarioMuitoBaixoException, IdadeInvalidaException {
			super(nome, cpf, dataNascimento);
			this.cargo = cargo;
			
			// Erro do salário abaixo do mínimo
			if (salario >= 954) {
				this.salario = salario;			
			} else {
				SalarioMuitoBaixoException e;
				e = new SalarioMuitoBaixoException();
				throw e;
			}
		}
		
		// Metodos
		public String getCargo() {
			return this.cargo;
		}

		public double getSalario() {
			return this.salario;
		}

		public String getNome() {
			return super.getNome();
		}
		
		// Chama o método setNome da abstrata.
		public void setNome(String nome) throws NomeCurtoException {
			super.setNome(nome);
		}

		public String getCpf() {
			return super.getCpf();
		}

		public String getDataNascimento() {
			return super.getIdade();
		}
}
