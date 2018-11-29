package main;

import java.util.Scanner;

import classesBasicas.Cliente;
import classesBasicas.Produtos;
import classesBasicas.Funcionario;
import classesBasicas.Animal;
import erros.AnimalJaCadastradoException;
import erros.AnimalNaoEncontradoException;
import erros.ClienteJaCadastradoException;
import erros.ClienteNaoEncontradoException;
import erros.CpfInvalidoException;
import erros.EmailInvalidoException;
import erros.FuncionarioJaCadastradoException;
import erros.FuncionarioNaoEncontradoException;
import erros.IdadeInvalidaException;
import erros.LimiteAtingidoException;
import erros.NomeCurtoException;
import erros.NumeroCartaoInvalidoException;
import erros.ProdutoNaoEncontradoException;
import erros.SalarioMuitoBaixoException;
import erros.TipoInvalidoException;
import erros.ValorInvalidoException;
import fachada.PetShop;

public class main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Ol�, bem vindo ao PetShop");
		System.out
				.println("Voc� deseja utilizar nosso sistema em array ou lista? (Digite 0 para array e 1 para lista)");

		int escolha, valor, duracao, carrinho=0;
		double salario;
		String nome = null, cpf, idade, email, numeroCartao, id, cargo, dono, especie, raca, idAnimal, tipo, valor1;
		PetShop petshop = null;
		Cliente cliente = null;
		Animal animal = null;
		Produtos produto;
		Funcionario funcionario;

		// Escolha do tipo do repositorio
		escolha = in.nextInt();

		if (escolha == 0) {
			petshop = new PetShop(false);
			System.out.println("---- Sistema criado em array ----");
		} else if (escolha == 1) {
			petshop = new PetShop(true);
			System.out.println("---- Sistema criado em lista ----");
		}
		
		//Loop do programa
		while (escolha >= 0) {

			System.out.println("O que voc� deseja fazer?");
			System.out.println("0 - Cadastrar");
			System.out.println("1 - Remover");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Procurar");
			System.out.println("3 - Comprar");
			System.out.println("(Para encerrar o sistema digite -1)");

			escolha = in.nextInt();
			//----------------------------------- CADASTRAR -------------------------------------
			if (escolha == 0) {
				System.out.println("O que voce deseja cadastrar?");
				System.out.println("0 - Cliente");
				System.out.println("1 - Animal");
				System.out.println("2 - Produto");
				System.out.println("3 - Funcion�rio");
				System.out.println("4 - Voltar para o in�cio");
				
				escolha = in.nextInt();
				in.nextLine();
 
				//----------------------------------- CLIENTE -------------------------------------
				if (escolha == 0) {
					System.out.println("Digite o nome:");
					nome = in.nextLine();
					System.out.println("Digite o cpf (somente os d�gitos):");
					cpf = in.nextLine();
					System.out.println("Digite a idade:");
					idade = in.nextLine();
					System.out.println("Digite o email:");
					email = in.nextLine();
					System.out.println("Digite o numero do cart�o com 16 d�gitos:");
					numeroCartao = in.nextLine();
					
					// Tenta cadastrar conferindo se todos os parametros est�o certos
					try {
						cliente = new Cliente(nome, cpf, idade, email, numeroCartao);
						petshop.cadastrarCliente(cliente);
						System.out.println("---- Cliente cadastrado com sucesso ----");
						
					// Caso n�o estejam, estes erros poder�o ser lan�ados
	
					} catch (CpfInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (IdadeInvalidaException e) {
						System.out.println(e.getMessage());
					} catch (EmailInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (NumeroCartaoInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (ClienteJaCadastradoException e) {
						System.out.println(e.getMessage());
					} catch (LimiteAtingidoException e) {
						System.out.println(e.getMessage());
					}
					

					//--------------------------------------- ANIMAL ----------------------------------------
				} else if (escolha == 1) {
					System.out.println("Digite o nome:");
					nome = in.nextLine();
					System.out.println("Digite a raca:");
					raca = in.nextLine();
					System.out.println("Digite a esp�cie:");
					especie = in.nextLine();

					// Tenta cadastrar conferindo se todos os parametros est�o certos
					try {
						animal = new Animal(nome, raca, especie, cliente);
						petshop.cadastrarAnimal(animal);
						System.out.println("---- Animal cadastrado com sucesso ----");
						
					// Caso n�o estejam, estes erros poder�o ser lan�ados
					} catch (AnimalJaCadastradoException e) {
						System.out.println(e.getMessage());
					} catch (LimiteAtingidoException e) {
						System.out.println(e.getMessage());
					}

					//------------------------------------- PRODUTO -----------------------------------------
				} else if (escolha == 2) {
					System.out.println("Digite o produto a ser cadastrado:");
					tipo = in.nextLine();
					System.out.println("Digite o valor do produto:");
					valor1 = in.nextLine();
				
					try {
						cliente = petshop.procurarProduto(tipo);
					} catch (ProdutoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					
					
					try {
						destino = cinbora.procurarDestino(cidade);
						destinoOk = true;
					} catch (DestinoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					
					System.out.println("Digite o valor do pacote:");
					valor = in.nextInt();
					in.nextLine();
					
					System.out.println("Digite o n�mero de meses do pacote:");
					duracao = in.nextInt();
					in.nextLine();
					
					System.out.println("Digite o identificador do pacote:");
					id = in.nextLine();
				
					//--------------------------------------- FUNCIONARIO ----------------------------------------
				} else if (escolha == 3) {
					System.out.println("Digite o nome do funcion�rio:");
					nome = in.nextLine();
					System.out.println("Digite o cpf do funcion�rio (somente os d�gitos):");
					cpf = in.nextLine();
					System.out.println("Digite a data de nascimento (no formato xx/xx/xxxx):");
					idade = in.nextLine();
					System.out.println("Digite o cargo do funcion�rio:");
					cargo = in.nextLine();
					System.out.println("Digite o sal�rio do funcion�rio:");
					salario = in.nextDouble();
					in.nextLine();

					// Tenta cadastrar conferindo se todos os parametros est�o certos
					try {
						funcionario = new Funcionario(nome, cpf, idade, cargo, salario);
						petshop.cadastrarFuncionario(funcionario);
						System.out.println("---- Funcion�rio cadastrado com sucesso ----");
						
					// Caso n�o estejam, estes erros poder�o ser lan�ados
					} catch (NomeCurtoException e) {
						System.out.println(e.getMessage());
					} catch (FuncionarioJaCadastradoException e) {
						System.out.println(e.getMessage());
					} catch (LimiteAtingidoException e) {
						System.out.println(e.getMessage());
					} catch (CpfInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (SalarioMuitoBaixoException e) {
						System.out.println(e.getMessage());
					} catch (IdadeInvalidaException e) {
						System.out.println(e.getMessage());
					}

				}
				//----------------------------------- ATUALIZAR -------------------------------------
			} else if (escolha == 2) {
				System.out.println("O que voce deseja atualizar?");
				System.out.println("0 - Cliente");
				System.out.println("1 - Animal");
				System.out.println("2 - Produto");
				System.out.println("3 - Funcion�rio");
				System.out.println("4 - Voltar para o in�cio");
				
				escolha = in.nextInt();
				
				if (escolha == 0) {
					System.out.println("Digite o nome:");
					nome = in.nextLine();
					System.out.println("Digite o cpf (somente os d�gitos):");
					cpf = in.nextLine();
					System.out.println("Digite a idade:");
					idade = in.nextLine();
					System.out.println("Digite o email:");
					email = in.nextLine();
					System.out.println("Digite o numero do cart�o com 16 d�gitos:");
					numeroCartao = in.nextLine();
					
					// Tenta atualizar conferindo se todos os parametros est�o corretos
					try {
						cliente = new Cliente(nome, cpf, idade, email, numeroCartao);
						petshop.atualizarCliente(cliente);
						System.out.println("---- Cliente atualizado com sucesso ----");
						
					// Caso n�o estejam, estes erros poder�o ser lan�ados
	
					} catch (CpfInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (IdadeInvalidaException e) {
						System.out.println(e.getMessage());
					} catch (EmailInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (NumeroCartaoInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (ClienteJaCadastradoException e) {
						System.out.println(e.getMessage());
					} catch (LimiteAtingidoException e) {
						System.out.println(e.getMessage());
					}
					

					//--------------------------------------- ANIMAL ----------------------------------------
				} else if (escolha == 1) {
					System.out.println("Digite o nome:");
					nome = in.nextLine();
					System.out.println("Digite a ra�a:");
					raca = in.nextLine();
					System.out.println("Digite a esp�cie:");
					especie = in.nextLine();

					// Tenta atualizar conferindo se todos os parametros est�o certos
					try {
						animal = new Animal(nome, raca, especie, cliente);
						petshop.atualizarAnimal(animal);
						System.out.println("---- Animal atualizado com sucesso ----");
						
					// Caso n�o estejam, estes erros poder�o ser lan�ados
					} catch (LimiteAtingidoException e) {
						System.out.println(e.getMessage());
					}
					
					//----------------------------------------PRODUTO --------------------------------------_____
				} else if (escolha == 2) {
					System.out.println("Digite o tipo:");
					tipo = in.nextLine();
					System.out.println("Digite o valor");
					valor1 = in.nextLine();
	
					// Tenta atualizar conferindo se todos os parametros est�o certos
					try {
						produto = new Produtos(tipo, valor);
						petshop.atualizarProdutos(produto);
						System.out.println("---- Produto atualizado com sucesso ----");
						
					// Caso n�o estejam, estes erros poder�o ser lan�ados
					} catch (ProdutoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					} catch (TipoInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (ValorInvalidoException e) {
						System.out.println(e.getMessage());
					}
					
					//----------------------------------------FUNCIONARIO --------------------------------------_____
				} else if (escolha == 3) {
					System.out.println("Digite o nome do funcion�rio:");
					nome = in.nextLine();
					System.out.println("Digite o cpf do funcion�rio:");
					cpf = in.nextLine();
					System.out.println("Digite a idade:");
					idade = in.nextLine();
					System.out.println("Digite o cargo do funcion�rio:");
					cargo = in.nextLine();
					System.out.println("Digite o sal�rio do funcion�rio:");
					salario = in.nextDouble();
					in.nextLine();

					// Tenta atualizar conferindo se todos os parametros est�o certos
					try {
						funcionario = new Funcionario(nome, cpf, idade, cargo, salario);
						petshop.atualizarFuncionario(funcionario);
						System.out.println("---- Funcionario atualizado com sucesso ----");
						
					// Caso nao estejam, estes erros podem ser lancados
					} catch (NomeCurtoException e) {
						System.out.println(e.getMessage());
					} catch (FuncionarioNaoEncontradoException e) {
						System.out.println(e.getMessage());
					} catch (LimiteAtingidoException e) {
						System.out.println(e.getMessage());
					} catch (CpfInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (SalarioMuitoBaixoException e) {
						System.out.println(e.getMessage());
					} catch (IdadeInvalidaException e) {
						System.out.println(e.getMessage());
					}

				}
				
				//----------------------------------- PROCURAR -------------------------------------	
			} else if (escolha == 3) {
				System.out.println("O que voce deseja procurar?");
				System.out.println("0 - Cliente");
				System.out.println("1 - Animal");
				System.out.println("2 - Produto");
				System.out.println("3 - Funcionario");
				System.out.println("4 - Voltar para o inicio");
				
				
				//----------------------------------- CLIENTE -------------------------------------
				if (escolha == 0) {
					System.out.println("Digite o cpf do cliente que voce deseja procurar:");
					cpf = in.nextLine();
					
					// Procura se existe e informa todos as variaveis de cliente
					try {
						System.out.println("O nome do cliente: " + petshop.procurarCliente(cpf).getNome());
						System.out.println("A data de nascimento: " + petshop.procurarCliente(cpf).getIdade());
						System.out.println("O email: " + petshop.procurarCliente(cpf).getEmail());
						System.out.println("O numero do cartao: " + petshop.procurarCliente(cpf).getNumeroCartao());
						
					// Caso nao exista, manda este erro
					} catch (ClienteNaoEncontradoException e){
						System.out.println(e.getMessage());
					}
					
					//----------------------------------- ANIMAL -------------------------------------
				} else if (escolha == 1) {
					System.out.println("Digite o ID do animal que voce deseja procurar:");
					idAnimal = in.nextLine();
					
					// Procura se existe e informa todos as variaveis de animal
					try {
						System.out.println("O nome do animal: " + petshop.procurarAnimal(idAnimal).getNome());
						System.out.println("Especie: " + petshop.procurarAnimal(idAnimal).getEspecie());
						System.out.println("Raca: " + petshop.procurarAnimal(idAnimal).getRaca());
						System.out.println("Dono: " + petshop.procurarAnimal(idAnimal).getDono().getNome());
						
					// Caso nao exista, manda este erro
					} catch (AnimalNaoEncontradoException e){
						System.out.println(e.getMessage());
					}
					
					//----------------------------------- PRODUTO -------------------------------------
				} else if (escolha == 2) {
					System.out.println("Digite o tipo do produto que voce deseja procurar:");
					tipo = in.nextLine();
					
					// Procura se existe e informa todos as variaveis de produto
					try {
						System.out.println("Produto: " + petshop.procurarProdutos(tipo).getTipo());
						System.out.println("Preco: " + petshop.procurarProdutos(tipo).getValor());
						
					// Caso nao exista, manda este erro
					} catch (ProdutoNaoEncontradoException e){
						System.out.println(e.getMessage());
					}
					
					//----------------------------------------FUNCIONARIO --------------------------------------_____
					
				} else if (escolha == 3) {
					System.out.println("Digite o CPF do funcionario que voce deseja procurar:");
					cpf = in.nextLine();
					
					// Procura se existe e informa todos as variaveis de funcionario
					try {
						System.out.println("O nome do funcionario: " + petshop.procurarFuncionario(cpf).getNome());
						System.out.println("A data de nascimento: " + petshop.procurarFuncionario(cpf).getDataNascimento());
						System.out.println("O cargo: " + petshop.procurarFuncionario(cpf).getCargo());
						System.out.println("O salario: " + petshop.procurarFuncionario(cpf).getSalario() + " reais");
						
					// Caso nao exista, manda esse erro
					} catch (FuncionarioNaoEncontradoException e){
						System.out.println(e.getMessage());
					}
				}
				
			}
		}
	
	}
}