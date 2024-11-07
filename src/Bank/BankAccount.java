package Bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactionHistory;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        Transaction transaction = new Transaction(new Date(), "deposit", amount);
        transactionHistory.add(transaction);
        balance += amount;
    }

    public void withdrawal(double amount) {
        if (balance < amount) {
            System.err.println("Not enough balance");
            return;
        }
        Transaction transaction = new Transaction(new Date(), "withdrawal", amount);
        transactionHistory.add(transaction);
        balance -= amount;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void displayTransactionHistory() {
        System.out.printf(transactionHistory.toString());
    }

    public static String generateAccountNumber() {
        Random rand = new Random();
        StringBuilder card = new StringBuilder();
        for (int i = 0; i < 16; i++)
        {
            int n = rand.nextInt(10);
            card.append(n);
        }

        return card.toString();
    }
}
