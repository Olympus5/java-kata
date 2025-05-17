package fr.olympus5.bank;

import java.time.Clock;

public class TransactionFactory {
    private final Clock clock;

    public TransactionFactory(final Clock clock) {
        this.clock = clock;
    }

    public Transaction newTransaction(final int amount) {
        return new Transaction("2012-01-10", amount);
    }
}
