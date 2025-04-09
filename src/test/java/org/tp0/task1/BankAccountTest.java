package org.tp0.task1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BankAccountTest {

    @Test
    void testDepositPositiveAmount() {
        BankAccount account = new BankAccount(100.0, 0.05);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.0001);
    }

    @Test
    void testDepositNegativeAmountThrowsException() {
        BankAccount account = new BankAccount(100.0, 0.05);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
    }

    @Test
    void testWithdrawPositiveAmount() {
        BankAccount account = new BankAccount(200.0, 0.05);
        account.withdraw(50.0);
        assertEquals(150.0, account.getBalance(), 0.0001);
    }

    @Test
    void testWithdrawMoreThanBalanceThrowsException() {
        BankAccount account = new BankAccount(100.0, 0.05);
        assertThrows(IllegalStateException.class, () -> account.withdraw(150.0));
    }

    @Test
    void testWithdrawNegativeAmountThrowsException() {
        BankAccount account = new BankAccount(100.0, 0.05);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-20.0));
    }

    @Test
    void testTransferMoneySuccessfully() {
        BankAccount account1 = new BankAccount(300.0, 0.05);
        BankAccount account2 = new BankAccount(100.0, 0.05);

        account1.transfer(100.0, account2);

        assertEquals(200.0, account1.getBalance(), 0.0001);
        assertEquals(200.0, account2.getBalance(), 0.0001);
    }

    @Test
    void testTransferNullAccountThrowsException() {
        BankAccount account1 = new BankAccount(300.0, 0.05);
        assertThrows(NullPointerException.class, () -> account1.transfer(50.0, null));
    }

    @Test
    void testTransferInsufficientBalanceThrowsException() {
        BankAccount account1 = new BankAccount(50.0, 0.05);
        BankAccount account2 = new BankAccount(100.0, 0.05);
        assertThrows(IllegalStateException.class, () -> account1.transfer(100.0, account2));
    }

    @Test
    void testAddInterest() {
        BankAccount account = new BankAccount(1000.0, 0.05);
        account.addInterest();
        assertEquals(1050.0, account.getBalance(), 0.0001);
    }
}
