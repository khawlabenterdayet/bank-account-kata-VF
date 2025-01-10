package com.bank.account.kata.models;

import java.util.ArrayList;
import java.util.List;
/**
 *  Account model
 * @Auther : KBT
 * 09 January 2025
 */

public class Account {
    private double balance;
    private final List<Operation> operations;

    public Account() {
        this.balance = 0.0;
        this.operations = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void updateBalance(double amount) {
        this.balance += amount;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void addOperation(Operation operation) {
        operations.add(operation);
    }
}
