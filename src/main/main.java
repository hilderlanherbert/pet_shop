package main;

import java.util.Scanner;

import classesBasicas.Cliente;
import classesBasicas.Produtos;
import classesBasicas.Funcionario;
import classesBasicas.Animal;
import erros.AnimalJaCadastradoException;
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

		System.out.println("Olá, bem vindo ao PetShop");
		System.out
				.println("Você deseja utilizar nosso sistema em array ou lista? (Digite 0 para array e 1 para lista)");

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

			System.out.println("O que você deseja fazer?");
			System.out.println("0 - Cadastrar");
			System.out.println("1 - Remover");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Procurar");
			System.out.println("3 - Comprar");
			System.out.println("(Para encerrar o sistema digite -1)");

			escolha = in.nextInt();
			if (escolha == 0) {
				System.out.println("O que voce deseja cadastrar?");
				System.out.println("0 - Cliente");
				System.out.println("1 - Animal");
				System.out.println("2 - Produto");
				System.out.println("3 - Funcionário");
				System.out.println("4 - Voltar para o início");
				
				escolha = in.nextInt();
				in.nextLine();
 
				//----------------------------------- CLIENTE -------------------------------------
				if (escolha == 0) {
					System.out.println("Digite o nome:");
					nome = in.nextLine();
					System.out.println("Digite o cpf (somente os dígitos):");
					cpf = in.nextLine();
					System.out.println("Digite a idade:");
					idade = in.nextLine();
					System.out.println("Digite o email:");
					email = in.nextLine();
					System.out.println("Digite o numero do cartão com 16 dígitos:");
					numeroCartao = in.nextLine();
					
					// Tenta cadastrar conferindo se todos os parametros estão certos
					try {
						cliente = new Cliente(nome, cpf, idade, email, numeroCartao);
						petshop.cadastrarCliente(cliente);
						System.out.println("---- Cliente cadastrado com sucesso ----");
						
					// Caso não estejam, estes erros poderão ser lançados
	
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
					System.out.println("Digite a espécie:");
					especie = in.nextLine();

					// Tenta cadastrar conferindo se todos os parametros estão certos
					try {
						animal = new Animal(nome, raca, especie, cliente);
						petshop.cadastrarAnimal(animal);
						System.out.println("---- Animal cadastrado com sucesso ----");
						
					// Caso não estejam, estes erros poderão ser lançados
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
					
					System.out.println("Digite o número de meses do pacote:");
					duracao = in.nextInt();
					in.nextLine();
					
					System.out.println("Digite o identificador do pacote:");
					id = in.nextLine();
				
					//--------------------------------------- FUNCIONARIO ----------------------------------------
				} else if (escolha == 3) {
					System.out.println("Digite o nome do funcionário:");
					nome = in.nextLine();
					System.out.println("Digite o cpf do funcionário (somente os dígitos):");
					cpf = in.nextLine();
					System.out.println("Digite a data de nascimento (no formato xx/xx/xxxx):");
					idade = in.nextLine();
					System.out.println("Digite o cargo do funcionário:");
					cargo = in.nextLine();
					System.out.println("Digite o salário do funcionário:");
					salario = in.nextDouble();
					in.nextLine();

					// Tenta cadastrar conferindo se todos os parametros estão certos
					try {
						funcionario = new Funcionario(nome, cpf, idade, cargo, salario);
						petshop.cadastrarFuncionario(funcionario);
						System.out.println("---- Funcionário cadastrado com sucesso ----");
						
					// Caso não estejam, estes erros poderão ser lançados
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
			} else if (escolha == 2) {
				System.out.println("O que você deseja atualizar?");
				System.out.println("0 - Cliente");
				System.out.println("1 - Animal");
				System.out.println("2 - Produto");
				System.out.println("3 - Funcionário");
				System.out.println("4 - Voltar para o início");
				
				escolha = in.nextInt();
				
				if (escolha == 0) {
					System.out.println("Digite o nome:");
					nome = in.nextLine();
					System.out.println("Digite o cpf (somente os dígitos):");
					cpf = in.nextLine();
					System.out.println("Digite a idade:");
					idade = in.nextLine();
					System.out.println("Digite o email:");
					email = in.nextLine();
					System.out.println("Digite o numero do cartão com 16 dígitos:");
					numeroCartao = in.nextLine();
					
					// Tenta atualizar conferindo se todos os parametros estão corretos
					try {
						cliente = new Cliente(nome, cpf, idade, email, numeroCartao);
						petshop.atualizarCliente(cliente);
						System.out.println("---- Cliente atualizado com sucesso ----");
						
					// Caso não estejam, estes erros poderão ser lançados
	
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
					System.out.println("Digite a raça:");
					raca = in.nextLine();
					System.out.println("Digite a espécie:");
					especie = in.nextLine();

					// Tenta atualizar conferindo se todos os parametros estão certos
					try {
						animal = new Animal(nome, raca, especie, cliente);
						petshop.atualizarAnimal(animal);
						System.out.println("---- Animal atualizado com sucesso ----");
						
					// Caso não estejam, estes erros poderão ser lançados
					} catch (LimiteAtingidoException e) {
						System.out.println(e.getMessage());
					}
					
					//----------------------------------------PRODUTO --------------------------------------_____
				} else if (escolha == 2) {
					System.out.println("Digite o tipo:");
					tipo = in.nextLine();
					System.out.println("Digite o valor");
					valor1 = in.nextLine();
	
					// Tenta atualizar conferindo se todos os parametros estão certos
					try {
						produto = new Produtos(tipo, valor);
						petshop.atualizarProdutos(produto);
						System.out.println("---- Produto atualizado com sucesso ----");
						
					// Caso não estejam, estes erros poderão ser lançados
					} catch (ProdutoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					} catch (TipoInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (ValorInvalidoException e) {
						System.out.println(e.getMessage());
					}
					
					//----------------------------------------FUNCIONARIO --------------------------------------_____
				} else if (escolha == 3) {
					System.out.println("Digite o nome do funcionário:");
					nome = in.nextLine();
					System.out.println("Digite o cpf do funcionário:");
					cpf = in.nextLine();
					System.out.println("Digite a idade:");
					idade = in.nextLine();
					System.out.println("Digite o cargo do funcionário:");
					cargo = in.nextLine();
					System.out.println("Digite o salário do funcionário:");
					salario = in.nextDouble();
					in.nextLine();

					// Tenta atualizar conferindo se todos os parametros estão certos
					try {
						funcionario = new Funcionario(nome, cpf, idade, cargo, salario);
						petshop.atualizarFuncionario(funcionario);
						System.out.println("---- Funcionário atualizado com sucesso ----");
						
					// Caso não estejam, estes erros poderão ser lançados
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
				
				
			}
		}
	
	}
}