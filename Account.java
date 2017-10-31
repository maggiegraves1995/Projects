public class Account {
	//Project#1 -  Fall 2017
		//instance variables
		//private String firstName, lastName; 
		private int accountNumber; 
		private double begBalance, creditLimit;
		private double endBalance; 
		
		private int purchases;//number of purchases
		private int payments; // number of payment transactions (code 2)
		private int transactions;//number of transactions, includes denied ones
		private double totPurchaseAmount;//counter for total purchase amount
		                                 // does not include denied ones
		private double totPayment;//counter for total payment
		                                  // does not include denied ones
		
		private final double penalty = 20; //holds penalty value = $20 for overdrawings
		private double totPenalty;
		private Customer owner;
		
		public Account(int accountNumber) 
		{
			this.accountNumber = accountNumber;
		}
		
		//method sets beginning balance
		public void setBegBalance(double begBalance) 
		{      
		    this.begBalance = begBalance; // add it to the balance 
		    
		    //sets endBalance equal to begBalance
		    this.endBalance = begBalance;
		}
		
		//method sets credit limit
		public void setCreditLimit (double creditLimit) 
		{
			this.creditLimit = creditLimit;
		}
		
		//process purchase transactions
		public void processTransaction (double purchaseAmount, double payment)
		{
			transactions++;
			// tentative endbalance
			double tentEndBal = endBalance - purchaseAmount + payment;
			if (tentEndBal >= - creditLimit)  {
			
				//purchase transaction accepted
			   totPurchaseAmount += purchaseAmount;
			   totPayment += payment;
			   //adjust end balance
			   endBalance = tentEndBal;
			   purchases++;
			}
			
			else if (endBalance < creditLimit) {
				//purchase transaction denied
	
				//let client know that credit limit has been exceeded
				System.out.printf("Credit limit has been exceeded for transaction # %d\n"
						+ "A $20 penalty has been charged to your account.", transactions);
				
				//apply $20 penalty
				endBalance -= penalty;
				totPenalty += penalty;
			}
				
			
		}
		
		//method that performs transaction 1 calculations
		public void processTransaction (double payment)
		{
			//adjust end balance
			endBalance += payment;
			totPayment += payment;
			transactions++;
		}
		
		// print summary for account
		public void printStatement () 
		{
			System.out.printf("Name: %s %s\n Account number: %d \nCredit limit: %.2f%n"
		            + " Beginning Balance: %.2f   Ending Balance: %.2f\n Number of "
					+ "purchases: %d\nNumber of transactions: %d\n Total Purchase Ammount: %.2f" 
		            + "  Total Payment Amount: %.2f  Total Penalty: %.2f \n\n", 
					owner, accountNumber, creditLimit, begBalance, 
					endBalance, purchases, transactions, totPurchaseAmount,totPayment, totPenalty);
		}
			
		
		//method returns beginning balance
		public double getBegBalance() 
		{
		    return begBalance; 
		} 	

		// method returns credit limit
	    public double getCreditLimit () 
	    {
		    return creditLimit; 
		} 
	    public void setOwner(Customer customer)
	    {
	    	this.owner = customer;
	    }
	    public Customer getOwner()
		{
			return this.owner;
		}


}  // end class Account  
