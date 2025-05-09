package fr.olympus5.bank;

import java.util.List;

public final class InMemoryTransactionRepository implements TransactionRepository {
    private Transaction tx = null;

    @Override
    public void save(final Transaction transaction) {
        tx = transaction;
    }

    @Override
    public List<Transaction> findAll() {
        return List.of(tx);
    }
}
