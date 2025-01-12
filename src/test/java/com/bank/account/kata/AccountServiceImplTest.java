package com.bank.account.kata;
import com.bank.account.kata.enums.OperationType;
import com.bank.account.kata.models.Account;
import com.bank.account.kata.models.Operation;
import com.bank.account.kata.services.impl.AccountServiceImpl;
import com.bank.account.kata.services.impl.StatementPrinterImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 *  AccountServiceImplTest Test
 * @Auther : KBT
 * 09 January 2025
 */
public class AccountServiceImplTest {
    private Account account ;
    private AccountServiceImpl service;
    @BeforeEach
    void setUp() {
        // Initialiser un compte avec un solde par défaut
        account = new Account();
        service = new AccountServiceImpl(account);
        account.updateBalance(1000.0); // Par exemple, un solde initial de 1000
    }
    @Test
    void testDeposit_AmountLessThanOrEqualToZero_ShouldThrowException() {
        // Vérifie que l'exception est levée pour un montant <= 0
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.deposit(0);
        });
        assertEquals("Deposit amount must be greater than zero.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            service.deposit(-100);
        });
        assertEquals("Deposit amount must be greater than zero.", exception.getMessage());
    }

    @Test
    void testDeposit_ValidAmount_ShouldSucceed() {

        // Vérifie qu'aucune exception n'est levée et que l'état est mis à jour correctement
        double initialBalance = account.getBalance();
        double depositAmount = 500;

        service.deposit(depositAmount);

        // Vérifie que le solde est mis à jour
        assertEquals(initialBalance + depositAmount, account.getBalance());

        // Vérifie qu'une opération est ajoutée
        assertEquals(1, account.getOperations().size());
        Operation lastOperation = account.getOperations().get(0);
        assertEquals(OperationType.DEPOSIT, lastOperation.getType());
        assertEquals(depositAmount, lastOperation.getAmount());
        assertEquals(account.getBalance(), lastOperation.getBalance());
    }


    @Test
    void testWithdraw_AmountLessThanOrEqualToZero_ShouldThrowException() {


        // Vérifie que l'exception est levée pour un montant <= 0
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.withdraw(0);
        });
        assertEquals("Withdrawal amount must be greater than zero.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            service.withdraw(-100);
        });
        assertEquals("Withdrawal amount must be greater than zero.", exception.getMessage());
    }

    @Test
    void testWithdraw_AmountGreaterThanBalance_ShouldThrowException() {

        // Vérifie que l'exception est levée pour un montant > solde
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.withdraw(2000);
        });
        assertEquals("The balance is insufficient to withdraw.", exception.getMessage());
    }

    @Test
    void testWithdraw_ValidAmount_ShouldSucceed() {

        // Vérifie qu'aucune exception n'est levée et que l'état est mis à jour correctement
        double initialBalance = account.getBalance();
        double withdrawAmount = 500;

        service.withdraw(withdrawAmount);

        assertEquals(initialBalance - withdrawAmount, account.getBalance());
        assertEquals(1, account.getOperations().size()); // Vérifie qu'une opération est ajoutée
        Operation lastOperation = account.getOperations().get(0);
        assertEquals(OperationType.WITHDRAWAL, lastOperation.getType());
        assertEquals(withdrawAmount, lastOperation.getAmount());
        assertEquals(account.getBalance(), lastOperation.getBalance());
    }


}
