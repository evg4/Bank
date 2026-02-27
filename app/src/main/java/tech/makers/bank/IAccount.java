package tech.makers.bank;

import java.time.LocalDate;

public interface IAccount {
    public String getName();
    public float getBalance();
    public void deposit(float amount, LocalDate date);
    public void withdraw(float amount, LocalDate date);
    public String generateStatement();
}
