package tech.makers.bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Account implements IAccount {
    // fields should be private - rather than directly accessing them, write getters and setters
    private String name;
    private float balance = 0;
    private String transaction = "";

    // constructor
    public Account(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(float amount, LocalDate date) {
        this.balance = this.balance + amount;
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatObj);
        this.transaction = String.format("%s || %.2f  ||  -  || %.2f%n", formattedDate, amount, this.balance ) + this.transaction;
    };

    @Override
    public void withdraw(float amount, LocalDate date) {
        this.balance = this.balance - amount;
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatObj);
        this.transaction = String.format("%s ||   -    || %.2f || %.2f%n", formattedDate, amount, this.balance) + this.transaction;
    };

    @Override
    public String generateStatement() {
        return String.format("date       || credit || debit || balance%n") + this.transaction;
    };

}
