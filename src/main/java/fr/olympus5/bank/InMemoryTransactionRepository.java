package fr.olympus5.bank;

import java.util.ArrayList;
import java.util.List;

public final class InMemoryTransactionRepository implements TransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public void save(final Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> findAll() {
        return transactions;
    }
}
