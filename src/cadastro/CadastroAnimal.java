package cadastro;

import classesBasicas.Animal;
import erros.AnimalJaCadastradoException;
import erros.AnimalNaoEncontradoException;
import erros.LimiteAtingidoException;
import interfaces.RepositorioAnimal;
import repositorio.RepositorioArrayAnimal;
import repositorio.RepositorioListaAnimal;

public class CadastroAnimal {
	private RepositorioAnimal animais;
	
	// se o construtor receber um parâmtro true, inicializa uma lista, senão, um array
	public CadastroAnimal(boolean tipo) {
		if (tipo) {
			this.animais = new RepositorioListaAnimal();
		} else {			
			this.animais = new RepositorioArrayAnimal();
		}
	}
	
	// checa se o cliente já está cadastrado. Se não estiver, o cadastra
	public void cadastrar(Animal animais) throws LimiteAtingidoException, AnimalJaCadastradoException {
		if (!this.animais.existe(animais.getIdAnimal())) {			
			this.animais.inserir(animais);
		} else {
			AnimalJaCadastradoException e;
			e = new AnimalJaCadastradoException();
			throw e;
		}
	}
	
	// chama o remover da interface
	public void remover(String tipo) throws AnimalNaoEncontradoException {
		this.animais.remover(tipo);
	}
	
	// chama o atualizar da interface
	public void atualizar(Animal animais) throws AnimalNaoEncontradoException, AnimalJaCadastradoException {
		this.animais.atualizar(animais);
	}
	
	// chama o procurar da interface
	public Animal animais (String tipo) throws AnimalNaoEncontradoException {
		return this.animais.procurar(tipo);
	}
	
	// chama o existe da interface
	public boolean existe (String tipo) {
		return this.animais.existe(tipo);
	}
}