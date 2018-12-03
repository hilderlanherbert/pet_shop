package classesBasicas;

import erros.CpfInvalidoException;
import erros.NomeCurtoException;
import erros.IdadeInvalidaException;


public abstract class Pessoa {
    protected String nome, cpf, idade;

    protected Pessoa(String nome, String cpf, String idade)
            throws NomeCurtoException, CpfInvalidoException, IdadeInvalidaException {

        // Checa se o nome tem mais que 200 caracteres (Invalido)
        if (nome.length() >= 3) {
            this.nome = nome;
        } else {
            NomeCurtoException e;
            e = new NomeCurtoException();
            throw e;
        }

        // Checa se o cpf tem 11 caracteres
        if (cpf.length() == 11) {
            this.cpf = cpf;
        } else {
            CpfInvalidoException e;
            e = new CpfInvalidoException();
            throw e;
        }

        // Checa se a idade é valida
        
        if (Integer.parseInt(idade) > 0 && Integer.parseInt(idade) < 150 ) {
			this.idade = idade;
		} else {
			IdadeInvalidaException e;
			e = new IdadeInvalidaException();
			throw e;
		}
    }

    protected String getNome() {
        return this.nome;
    }

    // M�todo setNome se o nome entrar errado
    protected void setNome(String nome) throws NomeCurtoException {
        if (nome.length() > 3) {
            this.nome = nome;
        } else {
            NomeCurtoException e;
            e = new NomeCurtoException();
            throw e;
        }
    }

    protected String getCpf() {
        return this.cpf;
    }

    public String getIdade() {
        return this.idade;
    }
}