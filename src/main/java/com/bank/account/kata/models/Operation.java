package com.bank.account.kata.models;

import com.bank.account.kata.enums.OperationType;

import java.time.LocalDate;
/**
 *  Operation model
 * @Auther : KBT
 * 09 January 2025
 */
public class Operation {
    private final LocalDate date;
    private final OperationType type;
    private final double amount;
    private final double balance;

    public Operation(LocalDate date, OperationType type, double amount, double balance) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public OperationType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return date + " | " + type + " | " + amount + " | " + balance;
    }
}
