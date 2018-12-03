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
import erros.DonoNaoEncontradoException;
import erros.EmailInvalidoException;
import erros.EspecieInvalidaException;
import erros.FuncionarioJaCadastradoException;
import erros.FuncionarioNaoEncontradoException;
import erros.IdadeInvalidaException;
import erros.LimiteAtingidoException;
import erros.NomeCurtoException;
import erros.NumeroCartaoInvalidoException;
import erros.ProdutoJaCadastradoException;
import erros.ProdutoNaoEncontradoException;
import erros.RacaInvalidaException;
import erros.SalarioMuitoBaixoException;
import erros.TipoInvalidoException;
import erros.ValorInvalidoException;
import fachada.PetShop;

public class main {
	public static void main(String[] args) throws NomeCurtoException, EspecieInvalidaException, RacaInvalidaException,
	IdadeInvalidaException, TipoInvalidoException, ValorInvalidoException, ClienteNaoEncontradoException, AnimalNaoEncontradoException, 
	AnimalJaCadastradoException, FuncionarioJaCadastradoException, ProdutoJaCadastradoException, DonoNaoEncontradoException, LimiteAtingidoException {
		Scanner in = new Scanner(System.in);

		System.out.println("Ola, bem vindo ao PetShop");
		System.out
				.println("Voce deseja utilizar nosso sistema em array ou lista? (Digite 0 para array e 1 para lista)");

		int escolha, valor, duracao, carrinho=0;
		double salario;
		String nome = null, cpf, idade, email, numeroCartao, id, cargo, especie, raca, idAnimal = null, tipo, nomeAnimal;
		Cliente dono;
		int valorProduto;
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

			System.out.println("O que voce deseja fazer?");
			System.out.println("0 - Cadastrar");
			System.out.println("1 - Remover");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Procurar");
			System.out.println("(Para encerrar o sistema digite -1)");

			escolha = in.nextInt();
//-------------------------------------------------- CADASTRAR -------------------------------------------------------------
			if (escolha == 0) {
				System.out.println("O que voce deseja cadastrar?");
				System.out.println("0 - Cliente");
				System.out.println("1 - Animal");
				System.out.println("2 - Produto");
				System.out.println("3 - Funcionario");
				System.out.println("4 - Voltar para o inicio");
				
				escolha = in.nextInt();
				in.nextLine();
 
				//----------------------------------- CLIENTE -------------------------------------
				if (escolha == 0) {
					System.out.println("Digite o nome:");
					nome = in.nextLine();
					System.out.println("Digite o cpf (somente os digitos):");
					cpf = in.nextLine();
					System.out.println("Digite a idade:");
					idade = in.nextLine();
					System.out.println("Digite o email:");
					email = in.nextLine();
					System.out.println("Digite o numero do cartao com 16 digitos:");
					numeroCartao = in.nextLine();
					
					// Tenta cadastrar conferindo se todos os parametros estao certos
					try {
						cliente = new Cliente(nome, cpf, idade, email, numeroCartao);
						petshop.cadastrarCliente(cliente);
						System.out.println("---- Cliente cadastrado com sucesso ----");
						
					// Caso nao estejam, estes erros poderao ser lancados
	
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
					} catch (NomeCurtoException e) {
						System.out.println(e.getMessage());
					}
					

					//--------------------------------------- ANIMAL ----------------------------------------
				} else if (escolha == 1) {
					System.out.println("\nATENCAO: para cadastrar um animal, o dono tem que ter sido cadastrado anteriormente.");
					System.out.println("Digite o nome:");
					nome = in.nextLine();
					System.out.println("Digite a especie(cachorro, gato ou ave):");
					especie = in.nextLine();
					System.out.println("Digite a raca(caso seja vira-lata, digite SRD):");
					raca = in.nextLine();
					System.out.println("Digite o CPF do dono:");
					cpf = in.nextLine();

				
					// Tenta cadastrar conferindo se todos os parametros estao certos
					try {
						dono = petshop.procurarCliente(cpf);
						animal = new Animal(nome, especie, raca, dono);
						petshop.cadastrarAnimal(animal);
						System.out.println("---- Animal cadastrado com sucesso ----");
						
					// Caso nao estejam, estes erros poderao ser lancados
					} catch (AnimalJaCadastradoException e) {
						System.out.println(e.getMessage());
					} catch (LimiteAtingidoException e) {
						System.out.println(e.getMessage());
					} catch (EspecieInvalidaException e) {
						System.out.println(e.getMessage());
					} catch (ClienteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					} catch (NomeCurtoException e) {
						System.out.println(e.getMessage());
					}  catch (RacaInvalidaException e) {
						System.out.println(e.getMessage());
					}

					//------------------------------------- PRODUTO -----------------------------------------
				} else if (escolha == 2) {
					System.out.println("Digite o produto a ser cadastrado:");
					tipo = in.nextLine();
					System.out.println("Digite o valor do produto:");
					valorProduto = in.nextInt();
				
					try {
						produto = new Produtos(tipo, valorProduto);
						petshop.cadastrarProdutos(produto);
						System.out.println("---- Produto cadastrado com sucesso ----");

					} catch (ProdutoJaCadastradoException e) {
						System.out.println(e.getMessage());
					} catch (LimiteAtingidoException e) {
						System.out.println(e.getMessage());
					}
					
					//--------------------------------------- FUNCIONARIO ----------------------------------------
				} else if (escolha == 3) {
					System.out.println("Digite o nome do funcionario:");
					nome = in.nextLine();
					System.out.println("Digite o cpf do funcionario (somente os digitos):");
					cpf = in.nextLine();
					System.out.println("Digite a idade:");
					idade = in.nextLine();
					System.out.println("Digite o cargo do funcionario:");
					cargo = in.nextLine();
					System.out.println("Digite o salario do funcionario:");
					salario = in.nextDouble();
					in.nextLine();

					// Tenta cadastrar conferindo se todos os parametros estao certos
					try {
						funcionario = new Funcionario(nome, cpf, idade, cargo, salario);
						petshop.cadastrarFuncionario(funcionario);
						System.out.println("---- Funcionario cadastrado com sucesso ----");
						
					// Caso nao estejam, estes erros poderao ser lancados
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
//---------------------------------------------------------- REMOVER -------------------------------------------------------------
			} else if (escolha == 1) {
				System.out.println("O que voce deseja remover?");
				System.out.println("0 - Cliente");
				System.out.println("1 - Animal");
				System.out.println("2 - Produto");
				System.out.println("3 - Funcionario");
				System.out.println("4 - Voltar para o inicio");
				
				escolha = in.nextInt();
				in.nextLine();
				
				//----------------------------------- CLIENTE -------------------------------------
				if (escolha == 0) {
					System.out.println("Digite o cpf do cliente que vai ser removido:");
					cpf = in.nextLine();
					
					// Confere se existe para remover e procura o nome para dizer quem removeu 
					try {
						nome = petshop.procurarCliente(cpf).getNome();
						petshop.removerCliente(cpf);
						System.out.println("---- Cliente " + nome + " removido com sucesso ----");
						
					// Caso não exista, manda este erro
					} catch (ClienteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
				//----------------------------------- ANIMAL -------------------------------------
				} else if (escolha == 1) {
					System.out.println("Digite o nome do animal");
					nomeAnimal = in.nextLine();
					System.out.println("Digite o CPF do dono do animal para remove-lo");
					cpf=in.nextLine();
					
					idAnimal = nomeAnimal+"#"+cpf;
					System.out.println(idAnimal);
					
					// Confere se o animal existe para remover
					try {
						petshop.removerAnimal(idAnimal);
						System.out.println("---- Animal " +nomeAnimal+" removido com sucesso ----");
						
					// Caso não, manda este erro
					} catch (AnimalNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					
				//----------------------------------- PRODUTO -------------------------------------
				} else if (escolha == 2) {
					System.out.println("Digite o tipo do produto que vai ser removido:");
					tipo = in.nextLine();
					
					// Confere se o pacote existe para remover
					try {
						petshop.removerProdutos(tipo);
						System.out.println("---- Produto " + tipo + " removido com sucesso ----");
					// Caso não exista, manda esse erro
					} catch (ProdutoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
				//--------------------------------- FUNCIONARIO -------------------------------------
				} else if (escolha == 3) {
					System.out.println("Digite o cpf do funcionário que vai ser removido:");
					cpf = in.nextLine();
					
					// Confere se existe para remover e procura o nome para dizer quem removeu
					try {
						nome = petshop.procurarFuncionario(cpf).getNome();
						petshop.removerFuncionario(cpf);
						System.out.println("---- Funcionario " + nome + " removido com sucesso ----");
					
					// Caso não exista, manda este erro
					} catch (FuncionarioNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}

				}
//----------------------------------------------------- ATUALIZAR -------------------------------------------------
			} else if (escolha == 2) {
				System.out.println("O que voce deseja atualizar?");
				System.out.println("0 - Cliente");
				System.out.println("1 - Animal");
				System.out.println("2 - Produto");
				System.out.println("3 - Funcionario");
				System.out.println("4 - Voltar para o inicio");
				
				escolha = in.nextInt();
				in.nextLine();				
				if (escolha == 0) {
					
					System.out.println("Digite o nome:");
					nome = in.nextLine();
					System.out.println("Digite o cpf (somente os digitos):");
					cpf = in.nextLine();
					System.out.println("Digite a idade:");
					idade = in.nextLine();
					System.out.println("Digite o email:");
					email = in.nextLine();
					System.out.println("Digite o numero do cartao com 16 digitos:");
					numeroCartao = in.nextLine();
					
					// Tenta atualizar conferindo se todos os parametros estao corretos
					try {
						cliente = new Cliente(nome, cpf, idade, email, numeroCartao);
						petshop.atualizarCliente(cliente);
						System.out.println("---- Cliente atualizado com sucesso ----");
						
					// Caso nï¿½o estejam, estes erros poderao ser lancados
	
					} catch (CpfInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (IdadeInvalidaException e) {
						System.out.println(e.getMessage());
					} catch (EmailInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (NumeroCartaoInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (ClienteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}  catch (NomeCurtoException e) {
						System.out.println(e.getMessage());
					} 
					

					//--------------------------------------- ANIMAL ----------------------------------------
				} else if (escolha == 1) {
					System.out.println("Não é permitido alterar Nome e CPF!");
					System.out.println("Digite o nome:");
					nome = in.nextLine();
					System.out.println("Digite a especie(cachorro, gato ou ave):");
					especie = in.nextLine();
					System.out.println("Digite a raca(caso seja vira-lata, digite SRD):");
					raca = in.nextLine();
					System.out.println("Digite o CPF do dono:");
					cpf = in.nextLine();


					// Tenta atualizar conferindo se todos os parametros estao certos
					try {
						dono = petshop.procurarCliente(cpf);
						animal = new Animal(nome, especie, raca, dono);
						petshop.atualizarAnimal(animal);
						System.out.println("---- Animal atualizado com sucesso ----");
						
					// caso não consisga, esses erros poderam ser lancados.
					} catch (AnimalNaoEncontradoException e) {
						System.out.println(e.getMessage());
					} catch (EspecieInvalidaException e) {
					System.out.println(e.getMessage());
					} catch (ClienteNaoEncontradoException e) {
					System.out.println(e.getMessage());
					} catch (NomeCurtoException e) {
					System.out.println(e.getMessage());
					}  catch (RacaInvalidaException e) {
					System.out.println(e.getMessage());
					}
					
					//----------------------------------------PRODUTO --------------------------------------_____
				} else if (escolha == 2) {
					System.out.println("Digite o tipo:");
					tipo = in.nextLine();
					System.out.println("Digite o valor");
					valorProduto = in.nextInt();
	
					// Tenta atualizar conferindo se todos os parametros estao certos
					try {
						produto = new Produtos(tipo, valorProduto);
						petshop.atualizarProdutos(produto);
						System.out.println("---- Produto atualizado com sucesso ----");
						
					// Caso nï¿½o estejam, estes erros poderï¿½o ser lanï¿½ados
					} catch (ProdutoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					} catch (TipoInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (ValorInvalidoException e) {
						System.out.println(e.getMessage());
					}
					
					//----------------------------------------FUNCIONARIO --------------------------------------_____
				} else if (escolha == 3) {
					System.out.println("Digite o nome do funcionario:");
					nome = in.nextLine();
					System.out.println("Digite o cpf do funcionario:");
					cpf = in.nextLine();
					System.out.println("Digite a idade:");
					idade = in.nextLine();
					System.out.println("Digite o cargo do funcionario:");
					cargo = in.nextLine();
					System.out.println("Digite o salario do funcionario:");
					salario = in.nextDouble();
					in.nextLine();

					// Tenta atualizar conferindo se todos os parametros estao certos
					try {
						funcionario = new Funcionario(nome, cpf, idade, cargo, salario);
						petshop.cadastrarFuncionario(funcionario);
						System.out.println("---- Funcionario atualizado com sucesso ----");
						
					// Caso nao estejam, estes erros podem ser lancados
					} catch (NomeCurtoException e) {
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
				
//-------------------------------------------------------- PROCURAR -------------------------------------	
			} else if (escolha == 3) {
				System.out.println("O que voce deseja procurar?");
				System.out.println("0 - Cliente");
				System.out.println("1 - Animal");
				System.out.println("2 - Produto");
				System.out.println("3 - Funcionario");
				System.out.println("4 - Voltar para o inicio");
				
				escolha = in.nextInt();
				in.nextLine();
				//----------------------------------- CLIENTE -------------------------------------
				if (escolha == 0) {
					System.out.println("Digite o cpf do cliente que voce deseja procurar:");
					cpf = in.nextLine();
					
					// Procura se existe e informa todos as variaveis de cliente
					try {
						System.out.println("\nO nome do cliente: " + petshop.procurarCliente(cpf).getNome());
						System.out.println("Idade: " + petshop.procurarCliente(cpf).getIdade());
						System.out.println("O email: " + petshop.procurarCliente(cpf).getEmail());
						System.out.println("O numero do cartao: " + petshop.procurarCliente(cpf).getNumeroCartao());
						
					// Caso nao exista, manda este erro
					} catch (ClienteNaoEncontradoException e){
						System.out.println(e.getMessage());
					}
					
					//----------------------------------- ANIMAL -------------------------------------
				} else if (escolha == 1) {
					System.out.println("Digite o ID (nomeAnimal#CPF) do animal que voce deseja procurar:");
					idAnimal = in.nextLine();
					
					// Procura se existe e informa todos as variaveis de animal
					try {
						System.out.println("\nO nome do animal: " + petshop.procurarAnimal(idAnimal).getNome());
						System.out.println("Especie: " + petshop.procurarAnimal(idAnimal).getEspecie());
						System.out.println("Raca: " + petshop.procurarAnimal(idAnimal).getRaca());
						System.out.println("Dono: " + petshop.procurarAnimal(idAnimal).getDono().getNome());
						System.out.println("ID: " + petshop.procurarAnimal(idAnimal).getIdAnimal());
						
						
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
						System.out.println("\nO nome do funcionario: " + petshop.procurarFuncionario(cpf).getNome());
						System.out.println("Idade: " + petshop.procurarFuncionario(cpf).getIdade());
						System.out.println("O cargo: " + petshop.procurarFuncionario(cpf).getCargo());
						System.out.println("O salario: " + petshop.procurarFuncionario(cpf).getSalario() + " reais");
						
					// Caso nao exista, manda esse erro
					} catch (FuncionarioNaoEncontradoException e){
						System.out.println(e.getMessage());
					}
				}
				
			}
		}
		System.out.println("---- Sistema encerrado ----");
	}
}