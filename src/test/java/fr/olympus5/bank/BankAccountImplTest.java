package fr.olympus5.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.threeten.extra.MutableClock;

import java.io.BufferedWriter;
import java.io.StringWriter;
import java.time.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountImplTest {
    private BankAccount bankAccount;
    private StringWriter out;

    @BeforeEach
    void setUp() {
        final Clock clock = MutableClock.of(
                LocalDate.of(2012, 1, 10).atStartOfDay().toInstant(ZoneOffset.UTC),
                ZoneOffset.UTC);
        out = new StringWriter();
        bankAccount = new BankAccountImpl(new TransactionFactory(
                clock),
                new InMemoryTransactionRepository(),
                new BufferedWriter(out));
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
