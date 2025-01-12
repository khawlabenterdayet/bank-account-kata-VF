package com.bank.account.kata;

import com.bank.account.kata.models.Account;
import com.bank.account.kata.models.Operation;
import com.bank.account.kata.services.impl.AccountServiceImpl;
import com.bank.account.kata.services.impl.StatementPrinterImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *  AccountServiceImplTest Test
 * @Auther : KBT
 * 10 January 2025
 */
public class StatementPrinterImplTest {

    @Test
    public void shouldRecordOperationsInHistory() {
        Account account = new Account();
        AccountServiceImpl service = new AccountServiceImpl(account);
        service.deposit(100.0);
        service.withdraw(50.0);

        List<Operation> operations = service.getOperations();
        assertEquals(2, operations.size());
    }
    @Test
    public void shouldPrintStatement() {
        Account account = new Account();
        AccountServiceImpl service = new AccountServiceImpl(account);
        StatementPrinterImpl printer = new StatementPrinterImpl();

        service.deposit(100.0);
        service.withdraw(50.0);

        printer.print(service.getOperations());
    }
}
