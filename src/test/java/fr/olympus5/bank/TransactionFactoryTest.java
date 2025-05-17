package fr.olympus5.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class TransactionFactoryTest {

    private TransactionFactory transactionFactory;

    @BeforeEach
    void setUp() {
        final Clock clock = Clock.fixed(
                LocalDate.of(2012, 1, 10).atStartOfDay().toInstant(ZoneOffset.UTC),
                ZoneOffset.UTC);
        transactionFactory = new TransactionFactory(clock);
    }

    @Test
    void newTransaction() {
        final int amount = 10;
        final Transaction expected = new Transaction("2012-01-10", amount);

        final Transaction actual = transactionFactory.newTransaction(amount);

        assertEquals(expected, actual);
    }
}