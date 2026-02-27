package tech.makers.bank;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class BankAccountTest {

    @Test
    public void openAccountAddsToAccounts() {
        MockAccount mockAccount = new MockAccount();
        BankAccount bankAccount = new BankAccount();
        bankAccount.openAccount(mockAccount);
        bankAccount.openAccount(mockAccount);
         Assert.assertEquals("You currently have these accounts: current, current", bankAccount.seeAccounts());
    }

    @Test
    public void getTotalBalanceReturnsBalance() {
        MockAccount mockAccount = new MockAccount();
        BankAccount bankAccount = new BankAccount();
        bankAccount.openAccount(mockAccount);
        bankAccount.openAccount(mockAccount);
        Assert.assertEquals(200, bankAccount.getTotalBalance(), 0);
    }

    private class MockAccount implements IAccount {

        @Override
        public String getName() {
            return "current";
        }

        @Override
        public float getBalance() {
            return 100;
        }

        @Override
        public void deposit(float amount, LocalDate date) {

        }

        @Override
        public void withdraw(float amount, LocalDate date) {

        }

        @Override
        public String generateStatement() {
            return "";
        }
    }
}
