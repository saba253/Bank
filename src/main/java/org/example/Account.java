package org.example;

public class Account {
    private String accountID;
    private String name;
    private String pin;
    private double balance;

    public Account(String accountID, String name, String pin){
        this.accountID = accountID;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountID;
    }

    public String getName() {
        return name;
    }

    public boolean checkPin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}