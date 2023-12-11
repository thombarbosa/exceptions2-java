package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class ProgramBank {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Account number: ");
			int accountNumber = scanner.nextInt();
			System.out.print("Holder name: ");
			scanner.nextLine();
			String accountHolderName = scanner.nextLine();
			System.out.print("Initial balance: $");
			Double initalBalance = scanner.nextDouble();
			System.out.print("Withdraw limit: $");
			Double withdrawLimit = scanner.nextDouble();
			
			Account account = new Account(accountNumber, accountHolderName, initalBalance, withdrawLimit);
			
			System.out.print("Enter amount for withdraw: $");
			Double amount = scanner.nextDouble();
			
			try {
				account.withdraw(amount);
			}catch(DomainException e) {
				System.out.println(e.getMessage());
			}
			
		}
		catch(InputMismatchException e) {
			System.out.println("\nInput error: Invalid data type");
		}
		catch(RuntimeException e) {
			System.out.println("\nUnexpected error");
		}
		
		scanner.close();
	}

}
