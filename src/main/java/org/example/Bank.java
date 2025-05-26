package org.example;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank(){
        accounts = new ArrayList<>();
    }

    public void createAccount(String accountID,String name, String pin){
        Account newAccount = new Account(accountID, name, pin);
        accounts.add(newAccount);
        System.out.println("ანგარიში წარმატებით შეიქმნა!");
    }

    public Account login(String accountID, String pin){
        for (Account acc : accounts){
            if(acc.getAccountId().equals(accountID) && acc.checkPin(pin)){
                System.out.println("მოგესალმებით" + acc.getName() + "!");
                return acc;
            }
        }
        System.out.println("არასწორი მონაცემები.");
        return null;
    }
}
