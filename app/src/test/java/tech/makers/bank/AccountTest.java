package tech.makers.bank;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class AccountTest {

    @Test
    public void getNameReturnsName() {
        Account account = new Account("savings");
        Assert.assertEquals("savings", account.getName());
    }

    @Test
    public void getBalanceReturnsBalance() {
        Account account = new Account("savings");
        Assert.assertEquals(0, account.getBalance(), 0);
    }

    @Test
    public void depositIncreasesBalance() {
        Account account = new Account("savings");
        account.deposit(100, LocalDate.of(2021, 4, 13));
        account.deposit(250.50f, LocalDate.of(2021, 5, 2));
        Assert.assertEquals(350.5, account.getBalance(), 0);

    }

    @Test
    public void withdrawDecreasesBalance() {
        Account account = new Account("savings");
        account.deposit(1080, LocalDate.of(2000, 5, 5));
        account.withdraw(80, LocalDate.of(2000, 5, 6));
        Assert.assertEquals(1000, account.getBalance(), 0);
    }

    @Test
    public void generateStatementPrintsStatement() {
        Account account = new Account("savings");
        account.deposit(5000, LocalDate.of(2021, 3, 3));
        account.deposit(4000, LocalDate.of(2021, 3, 3));
        Assert.assertEquals("date       || credit || debit || balance\n" +
                "03/03/2021 || 4000.00  ||  -  || 9000.00\n" +
                "03/03/2021 || 5000.00  ||  -  || 5000.00\n", account.generateStatement());
    }

}
