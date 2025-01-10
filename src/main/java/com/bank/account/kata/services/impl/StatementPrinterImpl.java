package com.bank.account.kata.services.impl;

import com.bank.account.kata.services.StatementPrinter;
import com.bank.account.kata.models.Operation;

import java.util.List;
/**
 *  StatementPrinterImpl serviceImpl
 * @Auther : KBT
 * 09 January 2025
 */
public class StatementPrinterImpl implements StatementPrinter {
    @Override
    public void print(List<Operation> operations) {
        System.out.println("DATE       | OPERATION  | AMOUNT  | BALANCE");
        for (Operation operation : operations) {
            System.out.println(operation);
        }
    }
}