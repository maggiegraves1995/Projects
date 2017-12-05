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
            JLabel nameLabel = new JLabel("Last Name:");
            addNewAccountFrame.add(nameLabel);
            JTextField nameField = new JTextField(30);
            addNewAccountFrame.add(nameField);

            JLabel accountNumLabel = new JLabel("Account Number:");
            addNewAccountFrame.add(accountNumLabel);
            JTextField accountNumField = new JTextField(30);
            addNewAccountFrame.add(accountNumField);

            JLabel balanceLabel = new JLabel("Initial balance:");
            addNewAccountFrame.add(balanceLabel);
            JTextField balanceField = new JTextField(10);
            addNewAccountFrame.add(balanceField);
            
            JLabel creditLimitLabel = new JLabel("Credit Limit:");
            addNewAccountFrame.add(creditLimitLabel);
            JTextField creditLimitField = new JTextField(10);
            addNewAccountFrame.add(creditLimitField);

            JButton submitButton = new JButton("Submit");
            ActionListener handler = new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    //System.out.println("You pressed: " + event.getActionCommand());
                    attemptAddAccount();
                }
            };
            submitButton.addActionListener(handler);
            addNewAccountFrame.add(submitButton);

            addNewAccountFrame.setSize(400, 200);
            addNewAccountFrame.setVisible(false);
        }

        //
       
 
 // Process Purchase
        {
            processPurchaseFrame = new JFrame("Process a Purchase");
            processPurchaseFrame.setLayout(new FlowLayout());
            processPurchaseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            processPurchaseFrame.setSize(300, 200);
            processPurchaseFrame.setVisible(false);
            JLabel acctNumLabel = new JLabel("Account Number:");
            processPurchaseFrame.add(acctNumLabel);
            JTextField acctNumField = new JTextField(30);
            processPurchaseFrame.add(acctNumField);

            JLabel paymentLabel = new JLabel("Payment Amount:");
            processPurchaseFrame.add(paymentLabel);
            JTextField paymentField = new JTextField(30);
            processPurchaseFrame.add(paymentField);
            
            JLabel purchaseLabel = new JLabel("Cost of Purchase:");
            processPurchaseFrame.add(purchaseLabel);
            JTextField purchaseField = new JTextField(30);
            processPurchaseFrame.add(purchaseField);   
            
            JButton submitButton = new JButton("Submit");
            ActionListener handler = new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    //System.out.println("You pressed: " + event.getActionCommand());
                    attemptProcessPurchase();
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
            JTextField acctNumField = new JTextField(30);
            processPaymentFrame.add(acctNumField);
            
            JLabel paymentLabel = new JLabel("Payment Amount:");
            processPaymentFrame.add(paymentLabel);
            JTextField paymentField = new JTextField(30);
            processPaymentFrame.add(paymentField);
            
            JButton submitButton = new JButton("Submit");
            ActionListener handler = new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    //System.out.println("You pressed: " + event.getActionCommand());
                    attemptProcessPayment();
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
    private void attemptAddAccount()
    {
        boolean isValidInput = false;
        System.out.println("TODO: verify that all fields are filled out & valid");
        System.out.println("TODO: verify that account with specified number doesn't already exist");

        if (isValidInput) {
            System.out.println("TODO: create new account");
        } else {

            JOptionPane.showMessageDialog(null, "Please correct your inputs. Make sure fields are are filled out and account doesn't already exist", "Illegal Input", JOptionPane.ERROR_MESSAGE);

        }
    }
    private void attemptProcessPurchase()
    {
    	
    }
    private void attemptProcessPayment()
    {
    	
    }
    
}
