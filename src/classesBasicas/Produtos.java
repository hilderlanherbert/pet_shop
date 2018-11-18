package classesBasicas;

import erros.TipoInvalidoException;
import erros.ValorInvalidoException;


public class Produtos {
	private String tipo;
	private int valor;
	
	public Produtos (String tipo, int valor) 
	throws TipoInvalidoException, ValorInvalidoException{
		
		if (tipo.length() > 0) {
			this.tipo = tipo;
		} else {
			TipoInvalidoException e;
			e = new TipoInvalidoException();
			throw e;
		}
		
		if (valor > 0) {
			this.valor = valor;
		} else {
			ValorInvalidoException e;
			e = new ValorInvalidoException();
			throw e;
		}		
	}
	//obter o tipo
	public String getTipo() {
		return this.tipo;
	}
	//obter o valor
	public int getValor() {
		return this.valor;
	}

}
