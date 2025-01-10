package com.bank.account.kata.services;

import com.bank.account.kata.models.Operation;

import java.util.List;
/**
 *  StatementPrinter service
 * @Auther : KBT
 * 09 January 2025
 */
public interface StatementPrinter {
    void print(List<Operation> operations);
}
