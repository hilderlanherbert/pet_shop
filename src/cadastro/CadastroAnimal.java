package cadastro;

public class CadastroAnimal {
	private RepositorioAnimal animais;
	
	// se o construtor receber um parametro true, incializara com Lista, senão, com Array
	public CadastroAnimal(boolean tipo) {
		if (tipo) {
			this.animais = new RepositorioListaAnimal();
		} else {
			this.animais = new RepositorioArrayAnimal();
		}
	}
	
	// checa se o animal  já estão cadastrado. Se não estiver, o cadastra
		public void cadastrar(Animal animal) throws LimiteAtingidoException, ClienteJaCadastradoException {
			if (!this.clientes.existe(cliente.getCpf())) {			
				this.clientes.inserir(cliente);
			} else {
				AnimalJaCadastradoException e;
				e = new AnimalJaCadastradoException();
				throw e;
			}
		}
	
	
	

}
