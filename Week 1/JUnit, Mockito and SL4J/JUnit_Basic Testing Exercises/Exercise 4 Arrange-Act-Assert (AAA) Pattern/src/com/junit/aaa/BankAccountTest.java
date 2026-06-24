package com.junit.aaa;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException();
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAccountTest {
    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount(100.0);
    }

    @After
    public void tearDown() {
        account = null;
    }

    @Test
    public void testDeposit() {
        double depositAmount = 50.0;
        account.deposit(depositAmount);
        assertEquals(150.0, account.getBalance(), 0.0001);
    }

    @Test
    public void testWithdraw() {
        double withdrawAmount = 30.0;
        account.withdraw(withdrawAmount);
        assertEquals(70.0, account.getBalance(), 0.0001);
    }
}
