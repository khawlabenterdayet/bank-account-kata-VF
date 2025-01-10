package com.bank.account.kata.services;

import com.bank.account.kata.models.Operation;

import java.util.List;
/**
 *  AccountService service
 * @Auther : KBT
 * 09 January 2025
 */
public interface AccountService {
    void deposit(double amount);
    void withdraw(double amount);
    List<Operation> getOperations();
    double getBalance();
}
