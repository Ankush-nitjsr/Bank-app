import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // we'll be creating a bank app
        // features to be added
        // 1. Create bank account
        // 2. add balance
        // 3. withdraw balance
        // 4. check balance

        // Welcome message
        System.out.println("Welcome to the world bank app!");
        // Message to input the details
        System.out.println("Please submit your name, password and opening balance below :");

        // 1. Method to create bank account
        Bank worldBankAccount = new WorldBankAccount();

        // 2. Method to add money in the bank account
        Boolean increaseBalance = worldBankAccount.addMoney();
        if(increaseBalance) System.out.println("Money added in the account successfully");
        else System.out.println("Money couldn't be added");

        // 3. Method to withdraw money from account
        Boolean moneyWithdrawn = worldBankAccount.withdrawMoney();
        if(moneyWithdrawn) System.out.println("Money withdrawn successfully");
        else System.out.println("Money couldn't be withdrawn");

        // 4. Method to check the account balance
        int balance = worldBankAccount.checkBalance();
        System.out.println("Current account balance is INR " + balance);

        // 5. Method to check roi
        int interestRate = worldBankAccount.getROI();

        // 6. Method to get total interest Amount
        int interestAmount = worldBankAccount.totalInterest();
        System.out.println("Your total interest amount is INR " + interestAmount);

        System.out.println();

        System.out.println("Thanks for visiting World bank app, Have a good time!!");

    }
}