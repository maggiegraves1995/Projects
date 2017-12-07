import java.util.*;
import java.lang.*;
import java.io.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Bank
{
    private ArrayList<Account> accounts;
    private JFrame chooseOperationFrame;
    private JFrame addNewAccountFrame;
    private JFrame processPaymentFrame;
    private JFrame processPurchaseFrame;
    
 public Bank()
    {
        accounts = new ArrayList<Account>();
        //
        // Choose Operation Type
        {
            chooseOperationFrame = new JFrame("Choose operation type");
            chooseOperationFrame.setLayout(new FlowLayout());
            chooseOperationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JButton createAccountButton = new JButton("Create New Account");
            ActionListener handler = new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    //System.out.println("You pressed: " + event.getActionCommand());
                    createNewAccount();
                }
            };
            createAccountButton.addActionListener(handler);
            chooseOperationFrame.add(createAccountButton);
            JButton purchaseButton = new JButton("Process New Purchase");
            handler = new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    //System.out.println("You pressed: " + event.getActionCommand());
                    processNewPurchase();
                }
            };
            purchaseButton.addActionListener(handler);
            chooseOperationFrame.add(purchaseButton);
            chooseOperationFrame.setSize(300, 100);
            chooseOperationFrame.setVisible(true);
            JButton paymentButton = new JButton("Process New Payment");
            handler = new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    //System.out.println("You pressed: " + event.getActionCommand());
                    processNewPayment();
                }
            };
            paymentButton.addActionListener(handler);
            chooseOperationFrame.add(paymentButton);
            chooseOperationFrame.setSize(300, 100);
            chooseOperationFrame.setVisible(true);
        }
        //
 // Add New Account
        {
            addNewAccountFrame = new JFrame("Add Account Information");
            addNewAccountFrame.setLayout(new FlowLayout());
            addNewAccountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JLabel fNameLabel = new JLabel("First Name:");
            final JTextField fNameField = new JTextField(30);
            fNameLabel.setLabelFor(fNameField);
            addNewAccountFrame.add(fNameLabel);
            addNewAccountFrame.add(fNameField);
            
            JLabel nameLabel = new JLabel("Last Name:");
            addNewAccountFrame.add(nameLabel);
            final JTextField nameField = new JTextField(30);
            nameLabel.setLabelFor(nameField);
            addNewAccountFrame.add(nameField);

            JLabel accountNumLabel = new JLabel("Account Number:");
            addNewAccountFrame.add(accountNumLabel);
            final JTextField accountNumField = new JTextField(30);
            accountNumLabel.setLabelFor(accountNumField);
            addNewAccountFrame.add(accountNumField);

            JLabel balanceLabel = new JLabel("Initial balance:");
            addNewAccountFrame.add(balanceLabel);
            final JTextField balanceField = new JTextField(10);
            balanceLabel.setLabelFor(balanceField);
            addNewAccountFrame.add(balanceField);
            
            JLabel creditLimitLabel = new JLabel("Credit Limit:");
            addNewAccountFrame.add(creditLimitLabel);
            final JTextField creditLimitField = new JTextField(10);
            creditLimitLabel.setLabelFor(creditLimitField);
            addNewAccountFrame.add(creditLimitField);

            JButton submitButton = new JButton("Submit");
            ActionListener handler = new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    //System.out.println("You pressed: " + event.getActionCommand());
                    attemptAddAccount(fNameField, nameField, accountNumField, balanceField, creditLimitField);
                }
            };
            submitButton.addActionListener(handler);
            addNewAccountFrame.add(submitButton);
            addNewAccountFrame.setSize(400, 200);
            addNewAccountFrame.setVisible(false);
        }
 // Process Purchase
        {
            processPurchaseFrame = new JFrame("Process a Purchase");
            processPurchaseFrame.setLayout(new FlowLayout());
            processPurchaseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            processPurchaseFrame.setSize(300, 200);
            processPurchaseFrame.setVisible(false);
            JLabel acctNumLabel = new JLabel("Account Number:");
            processPurchaseFrame.add(acctNumLabel);
            final JTextField acctNumField = new JTextField(30);
            acctNumLabel.setLabelFor(acctNumField);
            processPurchaseFrame.add(acctNumField);

            JLabel paymentLabel = new JLabel("Payment Amount:");
            processPurchaseFrame.add(paymentLabel);
            final JTextField paymentField = new JTextField(30);
            paymentLabel.setLabelFor(paymentField);
            processPurchaseFrame.add(paymentField);
            
            JLabel purchaseLabel = new JLabel("Cost of Purchase:");
            processPurchaseFrame.add(purchaseLabel);
            final JTextField purchaseField = new JTextField(30);
            purchaseLabel.setLabelFor(purchaseField);
            processPurchaseFrame.add(purchaseField);   
            
            JButton submitButton = new JButton("Submit");
            ActionListener handler = new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    //System.out.println("You pressed: " + event.getActionCommand());
                    attemptProcessPurchase(acctNumField, paymentField, purchaseField);
                }
            };
            submitButton.addActionListener(handler);
            processPurchaseFrame.add(submitButton);
            processPurchaseFrame.setSize(400, 200);
            processPurchaseFrame.setVisible(false);
 
        }
 // Process Payment 
        {
            processPaymentFrame = new JFrame("Process a Payment");
            processPaymentFrame.setLayout(new FlowLayout());
            processPaymentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            processPaymentFrame.setSize(300, 200);
            processPaymentFrame.setVisible(false);
            
            JLabel acctNum = new JLabel("Account Number:");
            processPaymentFrame.add(acctNum);
            final JTextField acctNumField = new JTextField(30);
            acctNum.setLabelFor(acctNumField);
            processPaymentFrame.add(acctNumField);
            
            JLabel paymentLabel = new JLabel("Payment Amount:");
            processPaymentFrame.add(paymentLabel);
            final JTextField paymentField = new JTextField(30);
            paymentLabel.setLabelFor(paymentField);
            processPaymentFrame.add(paymentField);
            
            JButton submitButton = new JButton("Submit");
            ActionListener handler = new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    //System.out.println("You pressed: " + event.getActionCommand());
                    attemptProcessPayment(acctNumField, paymentField);
                }
            };
            submitButton.addActionListener(handler);
            processPaymentFrame.add(submitButton);
            processPaymentFrame.setSize(400, 200);
            processPaymentFrame.setVisible(false);
            
        }
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        new Bank();
    }
    private void createNewAccount()
    {
        chooseOperationFrame.setVisible(false);
        addNewAccountFrame.setVisible(true);
    }
    private void processNewPurchase()
    {
        chooseOperationFrame.setVisible(false);
        processPurchaseFrame.setVisible(true);
    }
    private void processNewPayment()
    {
        chooseOperationFrame.setVisible(false);
        processPaymentFrame.setVisible(true); 
    }
    private void attemptAddAccount(JTextField fNameField, JTextField nameField, JTextField accountNumField, JTextField balanceField, JTextField creditLimitField)
    {
    
      boolean isValidInput = false; 
      String firstName = fNameField.getText();
      String lastName = nameField.getText();
      Double accountNumber = Double.parseDouble(accountNumField.getText());
      Double balance = Double.parseDouble(balanceField.getText());
      Double creditLimit = Double.parseDouble(creditLimitField.getText());
      
      Account account = new Account(firstName, lastName, accountNumber);
		
		account.setBegBalance(balance);			
		account.setCreditLimit(creditLimit);
		accounts.add(account);
		String accountDisplay = account.getFirstName() + " " + account.getLastName() + " "
				+"account Number"+ " " + account.getAccountNumber()+" "
				+"begin balance:"+ account.getBegBalance() + "credit limit:"
				+ account.getCreditLimit();
		
		JOptionPane.showMessageDialog(null,"Account Created"+ accountDisplay);
		
    }
    private void attemptProcessPurchase(JTextField acctNumField, JTextField paymentField, JTextField purchaseField)
    {
    	boolean isValidInput = false;
    	Double accountNumber = Double.parseDouble(acctNumField.getText());
    	Double payment = Double.parseDouble(paymentField.getText());
    	Double costOfPurchase = Double.parseDouble(purchaseField.getText());
    	for(Account acct: accounts)    		
    		acct.transactionOne(costOfPurchase, payment);
		
		JOptionPane.showMessageDialog(null,"Account Created"+ accountDisplay);
		

    	
    	 	
    }
    private void attemptProcessPayment(JTextField acctNumField, JTextField paymentField)
    {	
    	Double accountNumber = Double.parseDouble(acctNumField.getText());
    	Double payment = Double.parseDouble(paymentField.getText());
    	for(Account acct : accounts)
    		if accounts.contains(accountNumber)
    	
    		
    }
    
}

