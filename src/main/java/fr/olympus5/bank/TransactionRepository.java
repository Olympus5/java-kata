package fr.olympus5.bank;

public sealed interface TransactionRepository permits InMemoryTransactionRepository {
    void save(Transaction transaction);
}
