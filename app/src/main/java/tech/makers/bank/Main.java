package tech.makers.bank;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BankAccount bank = new BankAccount();
        System.out.println(bank.generateStatement());
        bank.deposit(1000, LocalDate.of(2021, 1, 10));
        bank.deposit(2000, LocalDate.of(2021, 1, 13));
        bank.withdraw(500, LocalDate.of(2021, 1, 14));
        bank.deposit(13.52f, LocalDate.of(2021, 2, 2));
        System.out.println(bank.generateStatement());
    }
}
