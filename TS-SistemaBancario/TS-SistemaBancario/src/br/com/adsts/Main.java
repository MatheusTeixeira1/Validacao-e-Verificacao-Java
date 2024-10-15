package br.com.adsts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.adsts.dao.ClienteDAO;
import br.com.adsts.dao.ContaCorrenteDAO;
import br.com.adsts.model.Cliente;
import br.com.adsts.model.ContaCorrente;

public class Main {
	static ClienteDAO clienteDAO;
	static ContaCorrenteDAO contaCorrenteDAO;
	static Scanner sc = null;
	
	public static void main(String[] args) {
		inicializa();
		
		sc = new Scanner(System.in);
		boolean continua = true;
		
		while (continua) {
			imprimeMenu();
			int opcao = sc.nextInt();
			
			switch (opcao) {
			case 1:
				System.out.print("ID do cliente: ");
				int idCliente = sc.nextInt();
				Cliente cliente = clienteDAO.pesquisaCliente(idCliente);
				
				if (cliente != null)
					System.out.println(cliente.toString());
				else
					System.out.println("Cliente não encontrado!");
				
				System.out.println("\n");
				break;

			case 2:
				System.out.print("ID da conta corrente: ");
				int idConta = sc.nextInt();
				ContaCorrente conta = contaCorrenteDAO.pesquisaConta(idConta);
				
				if (conta != null)
					System.out.println(conta.toString());
				else
					System.out.println("Conta não encontrado!");
				
				System.out.println("\n");
				break;

			case 3:
				System.out.print("ID do cliente: ");
				int idCliente2 = sc.nextInt();
				Cliente cliente2 = clienteDAO.pesquisaCliente(idCliente2);
				
				if (cliente2 != null) {
					cliente2.setAtivo(true);
					System.out.println("Cliente ativado com sucesso!");
				} else
					System.out.println("Cliente não encontrado!");
			
				System.out.println("\n");
				break;
				
			case 4:
				System.out.print("ID do cliente: ");
				int idCliente3 = sc.nextInt();
				Cliente cliente3 = clienteDAO.pesquisaCliente(idCliente3);
				
				if (cliente3 != null) {
					cliente3.setAtivo(false);
					System.out.println("Cliente desativado com sucesso!");
				} else
					System.out.println("Cliente não encontrado!");
				
				System.out.println("\n");
				break;
			
			case 5:
				continua = false;
				System.out.println("-------------------- Sistema finalizado --------------------");
				break;
				
			default:
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				break;
			} 
		}
	}

	private static void imprimeMenu() {
		System.out.println("Opções\n");
		System.out.println("1) Consultar cliente");
		System.out.println("2) Consultar conta corrente");
		System.out.println("3) Ativar cliente");
		System.out.println("4) Desativar cliente");
		System.out.println("5) Sair");
		System.out.println();
	}

	private static void inicializa() {
		List<ContaCorrente> listaContas = new ArrayList<>();
		List<Cliente> listaClientes = new ArrayList<>();

		ContaCorrente conta01 = new ContaCorrente(1, 0, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);
		listaContas.add(conta01);
		listaContas.add(conta02);
		
		Cliente cliente01 = new Cliente(1, "Fulano", 31, "fulano@gmail.com", conta01.getId(), true);
		Cliente cliente02 = new Cliente(2, "Beltrano", 34, "beltrano@gmail.com", conta02.getId(), true);

		listaClientes.add(cliente01);
		listaClientes.add(cliente02);
		
		clienteDAO = new ClienteDAO(listaClientes);
		contaCorrenteDAO = new ContaCorrenteDAO(listaContas);
	}
}
