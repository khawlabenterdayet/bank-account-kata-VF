package com.bank.account.kata.services.impl;

import com.bank.account.kata.services.StatementPrinter;
import com.bank.account.kata.models.Operation;

import java.util.List;
import java.util.Locale;

/**
 *  StatementPrinterImpl serviceImpl
 * @Auther : KBT
 * 09 January 2025
 */
public class StatementPrinterImpl implements StatementPrinter {

   public StatementPrinterImpl(){}
    @Override
    public void print(List<Operation> operations) {
        for (Operation operation : operations) {
            System.out.printf(Locale.US, "%-10s | %-10s | %-8.2f | %-8.2f%n",
                    operation.getDate(),
                    operation.getType(),
                    operation.getAmount(),
                    operation.getBalance());
        }
    }
}