package fr.olympus5.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionFactoryTest {

    private TransactionFactory transactionFactory;

    @BeforeEach
    void setUp() {
        transactionFactory = new TransactionFactory();
    }

    @Test
    void newTransaction() {
        final int amount = 10;
        final Transaction expected = new Transaction("2012-01-10", amount);

        final Transaction actual = transactionFactory.newTransaction(amount);

        assertEquals(expected, actual);
    }
}