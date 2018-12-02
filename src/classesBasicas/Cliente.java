package classesBasicas;

import erros.CpfInvalidoException;
import erros.IdadeInvalidaException;
import erros.EmailInvalidoException;
import erros.NomeCurtoException;
import erros.NumeroCartaoInvalidoException;

public class Cliente extends Pessoa {
	// Atributos exclusivos da classe Cliente
		private String email, numeroCartao;

		// Construtor classe Cliente
		public Cliente(String nome, String cpf, String dataNascimento, String email, String numeroCartao)
				throws NomeCurtoException, CpfInvalidoException, NumeroCartaoInvalidoException, EmailInvalidoException,
				IdadeInvalidaException {
			super(nome, cpf, dataNascimento);
			
			if (email.contains("@")) {
				this.email = email;
			} else {
				EmailInvalidoException e;
				e = new EmailInvalidoException();
				throw e;
			}

			// Checa a quantidade de digitos do número do cartão
			if (numeroCartao.length() == 16) {
				this.numeroCartao = numeroCartao;

				// Erro se for inválido
			} else {
				NumeroCartaoInvalidoException e;
				e = new NumeroCartaoInvalidoException();
				throw e;
			}
		}

		// Metodos
		public String getEmail() {
			return this.email;
		}

		public void setEmail(String email) throws EmailInvalidoException {
			if (email.contains("@")) {
				this.email = email;
			} else {
				EmailInvalidoException e;
				e = new EmailInvalidoException();
				throw e;
			}
		}

		public String getNumeroCartao() {
			return this.numeroCartao;
		}

		public String getNome() {
			return super.getNome();
		}

		// Chama o método setNome da abstrata
		public void setNome(String nome) throws NomeCurtoException {
			super.setNome(nome);
		}

		public String getCpf() {
			return super.getCpf();
		}

		public String getIdade() {
			return super.getIdade();
		}

		public boolean existe(Cliente cliente) {
			return (this.getCpf().equals(cliente.getCpf()));
		}
}
