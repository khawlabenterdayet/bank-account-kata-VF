package com.bank.account.kata.services.impl;

import com.bank.account.kata.enums.OperationType;
import com.bank.account.kata.models.Account;
import com.bank.account.kata.models.Operation;
import com.bank.account.kata.services.AccountService;

import java.time.LocalDate;
import java.util.List;
/**
 *  AccountServiceImpl serviceImpl
 * @Auther : KBT
 * 09 January 2025
 */
public class AccountServiceImpl implements AccountService {
    private final Account account;

    public AccountServiceImpl(Account account) {
        this.account = account;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
        account.updateBalance(amount);
        account.addOperation(new Operation(LocalDate.now(), OperationType.DEPOSIT, amount, account.getBalance()));
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if (amount > account.getBalance()) {
            throw new IllegalArgumentException("The balance is insufficient to withdraw.");
        }
        account.updateBalance(-amount);
        account.addOperation(new Operation(LocalDate.now(), OperationType.WITHDRAWAL, amount, account.getBalance()));
    }

    @Override
    public List<Operation> getOperations() {
        return account.getOperations();
    }

    @Override
    public double getBalance() {
        return account.getBalance();
    }
}
