package fr.olympus5.bank;

import java.time.Clock;
import java.time.LocalDate;

public class DefaultTransactionFactory implements TransactionFactory {
    private final Clock clock;

    public DefaultTransactionFactory(final Clock clock) {
        this.clock = clock;
    }

    @Override
    public Transaction newTransaction(final int amount) {
        return new Transaction(LocalDate.now(clock).toString(), amount);
    }
}
