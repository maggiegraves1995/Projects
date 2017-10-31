import java.util.ArrayList;
import java.util.Scanner;

public class AccountTest {
	ArrayList<Account> accts = new ArrayList<Account>();
	ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);	
		
		int transactionCode;
        int num_Of_Acct; //number of accounts
		Account acct, acct1 = null, acct2 = null, acct3 = null, acct4 = null, acct5 = null;
		System.out.println("enter number of accounts");
		num_Of_Acct = input.nextInt();
		
		for (int i=1; i<=num_Of_Acct; i++) {
			//prompt to enter first name, last name, , account number, 
			//credit limit, and beg balance
			System.out.printf("%n%nFor account %d, enter: first name, last name, account number, "
					+ "credit limit, and beg balance %n ", i);	
			String firstName = input.next(); 
			String lastName = input.next();
			int accountNumber = input.nextInt();
			double creditLimit = input.nextDouble();
			double balance = input.nextDouble();			
			
			acct = new Account (firstName, lastName, accountNumber);
					
			acct.setBegBalance(balance);			
			acct.setCreditLimit(creditLimit);
			
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
					acct.processTransaction(costOfPurchase, payment);
					
					//
				}
				// payment only.  input amount and process
				else if (transactionCode == 2) {
					double payment = input.nextDouble();
					acct.processTransaction(payment);
				}
				// input next transaction code
				transactionCode = input.nextInt();
			}//end of while loop
				
			//assign the values of the reference variable "acct" to the 
			//appropriate account objects
			if (i==1)
				acct1 = acct;
			else if (i==2)
				acct2 = acct;
			else if (i==3)
				acct3 = acct;
			else if (i==4)
				acct4 = acct;
			else if (i==5)
				acct5 = acct;
		
			System.out.println();
				
		}//end of for loop
		
		//display an information summary for each account object
		System.out.println("\n\n ****************************************************"
				+ "\nSummary of the accounts \n");
		
		acct1.printStatement();
		acct2.printStatement();
		acct3.printStatement();
		acct4.printStatement();
		acct5.printStatement();
		
	}//end of main method	
}// end of class AccountTest

