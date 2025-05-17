package fr.olympus5.bank;

public interface TransactionFactory {
    Transaction newTransaction(int amount);
}
