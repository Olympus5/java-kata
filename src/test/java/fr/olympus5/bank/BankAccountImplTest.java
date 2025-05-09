package fr.olympus5.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountImplTest {
    private BankAccount bankAccount;
    private StringWriter out;

    @BeforeEach
    void setUp() {
        out = new StringWriter();
        TransactionRepository transactionRepository = new InMemoryTransactionRepository();
        bankAccount = new BankAccountImpl(transactionRepository, new BufferedWriter(out));
    }

    @Test
    void noBankOperation() {
        bankAccount.printStatement();

        assertEquals("Date || Amount || Balance" + System.lineSeparator(), out.toString());
    }

    @Test
    void deposit() {
        bankAccount.deposit(1000);

        bankAccount.printStatement();

        assertEquals("""
                Date || Amount || Balance
                2012-01-10 || 1000 || 1000
                """, out.toString());
    }
}
