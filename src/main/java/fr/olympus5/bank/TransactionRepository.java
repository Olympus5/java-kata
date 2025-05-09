package fr.olympus5.bank;

import java.util.List;

public sealed interface TransactionRepository permits InMemoryTransactionRepository {
    void save(Transaction transaction);

    List<Transaction> findAll();
}
