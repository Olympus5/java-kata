package fr.olympus5.bank;

import java.time.Clock;
import java.time.LocalDate;

public class TransactionFactory {
    private final Clock clock;

    public TransactionFactory(final Clock clock) {
        this.clock = clock;
    }

    public Transaction newTransaction(final int amount) {
        return new Transaction(LocalDate.now(clock).toString(), amount);
    }
}
