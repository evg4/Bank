package tech.makers.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class BankAccount {

    private IAccount[] accounts = new IAccount[5];

    public void openAccount(IAccount account) {
        int i = 0;
        while(accounts[i] != null) {
            i++;
        }
        if (i < 5) {accounts[i] = account;}
        else {
            System.out.println("You have the maximum number of accounts. Please close a different account if you'd like to add this one.");
        }
    }

    public float getTotalBalance() {
        float totalBalance = 0;
        for (IAccount account : accounts) {
            if(account != null) {
            totalBalance = totalBalance + account.getBalance();}
        }
        return totalBalance;
    }

    public String seeAccounts() {
//        ArrayList<String> accountsList = new ArrayList<String>();
//        for (Account account : accounts) {
//            if (account != null) {
//                accountsList.add(account.getName());
//            }
//        }
//        String result = "You currently have these accounts: " + String.join(", ", accountsList);
//        return result;

        String result = Arrays.stream(accounts)
                .filter(account -> account != null)
                .map(account -> account.getName())
                .collect(Collectors.joining(", "));

        return "You currently have these accounts: " + result;
    }
}

// Arrays.stream(accounts) >> this takes the array accounts and turns it into a Stream<Account>
// .filter(account -> account != null) >> this keeps everything that is not null
// .map(account -> account.name) >> this changes our Stream<Account> to Stream<String> by taking just the name from each account
// .collect(Collectors.joining(", ")) >> this takes everything in our Stream<String> and joins them together with a ", "
