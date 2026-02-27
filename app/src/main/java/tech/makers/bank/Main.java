package tech.makers.bank;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Account currentAccount = new Account("current");
        System.out.println(currentAccount.generateStatement());
        currentAccount.deposit(1000, LocalDate.of(2021, 1, 10));
        currentAccount.deposit(2000, LocalDate.of(2021, 1, 13));
        currentAccount.withdraw(500, LocalDate.of(2021, 1, 14));
        currentAccount.deposit(13.52f, LocalDate.of(2021, 2, 2));
        System.out.println(currentAccount.generateStatement());

        Account savingsAccount = new Account("savings");
        savingsAccount.deposit(5000, LocalDate.of(2021, 3, 3));
        savingsAccount.deposit(4000, LocalDate.of(2021, 3, 3));
        System.out.println(savingsAccount.generateStatement());

        BankAccount bankAccount = new BankAccount();
        bankAccount.openAccount(currentAccount);
        bankAccount.openAccount(savingsAccount);
        System.out.println(bankAccount.seeAccounts());

        System.out.println(bankAccount.getTotalBalance());
    }
}
