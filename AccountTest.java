import java.util.ArrayList;
import java.util.Scanner;

public class AccountTest {
	ArrayList<Account> accountList;
	ArrayList<Customer> customerList;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);	
		Customer owner;
		Account acct; 
		int transactionCode;
       		int num_Of_Acct; //number of accounts
		System.out.println("enter number of accounts");
		num_Of_Acct = input.nextInt();
		accountList = new ArrayList<>(num_Of_Acct);
		customerList = new ArrayList<>(num_Of_Acct);
		
		for (int counter = 0; counter < num_Of_Acct; counter++) {
			//prompt to enter first name, last name, , account number, 
			//credit limit, and beg balance
			System.out.printf("%n%nFor account %d, enter: first name, last name, account number, "
					+ "credit limit, and beg balance %n ", i);	
			String firstName = input.next(); 
			String lastName = input.next();
			owner = new Customer(firstName, lastName);
			customerList.add(owner);
			int accountNumber = input.nextInt();
			acct = new Account(accountNumber, owner);
			double creditLimit = input.nextDouble();
			double balance = input.nextDouble();			
			accountList.add(acct);		
			accts.setBegBalance(balance);			
			accts.setCreditLimit(creditLimit);
			
			//prompt for all transactions for current account
			System.out.println();
			System.out.print("enter all transactions for account ");
			transactionCode = input.nextInt();
			
			//read transaction and process the transactions
			while (transactionCode != 0) {
				// purchase - input cost and payment and process
				if (transactionCode == 1) {					
					double costOfPurchase = input.nextDouble();					
					double payment = input.nextDouble();
					accts.processTransaction(costOfPurchase, payment);
					
					//
				}
				// payment only.  input amount and process
				else if (transactionCode == 2) {
					double payment = input.nextDouble();
					accts.processTransaction(payment);
				}
				// input next transaction code
				transactionCode = input.nextInt();
			}//end of while loop
				
			
		}//end of for loop
		
		//display an information summary for each account object
		System.out.println("\n\n ****************************************************"
				+ "\nSummary of the accounts \n");
		for (Account anAccount: accts)
		{			  
		
			
		}
			
	}//end of main method	
}// end of class AccountTest

