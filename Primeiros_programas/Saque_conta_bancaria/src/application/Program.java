package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DepositException;
import model.exceptions.LimitException;
import model.exceptions.WithdrawException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Entre com os dados da conta:");
			System.out.print("Número: ");
			Integer number = sc.nextInt();
			System.out.print("Titular: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Saldo inicial: ");
			Double balance = sc.nextDouble();
			System.out.print("Limite de saque: ");
			Double withdrawLimit = sc.nextDouble();
			
			Account ac = new Account(number, holder, balance, withdrawLimit);	
			
			System.out.print("Saque ou deposito (S/D)? ");
			char op = sc.next().charAt(0);
			
			if (op != 's' && op != 'S' && op != 'D' && op != 'd') {
				do {
					System.out.print("\nOpção invalida, tente novamente! \n(S/D)? ");
					op = sc.next().charAt(0);
				} while(op != 's' && op != 'S' && op != 'D' && op != 'd');
				System.out.println();
			}
			
			if(op == 'd' || op == 'D') {
				System.out.print("Valor deposito: ");
				Double deposit = sc.nextDouble();
				ac.deposit(deposit);
			}
			if(op == 's' || op == 'S') {
				System.out.print("Valor do saque: ");
				Double withdraw = sc.nextDouble();
				ac.withdraw(withdraw);
			}
			
			System.out.println("\nNovo saldo: " + String.format("%.2f", ac.getBalance()));
		}
		catch (LimitException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		catch (WithdrawException e) {
			System.out.println("\nErro no saque: " + e.getMessage());
		}
		catch (DepositException e) {
			System.out.println("\nErro no deposito: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("\nErro inesperado!");
		}
		
		sc.close();
	}

}
