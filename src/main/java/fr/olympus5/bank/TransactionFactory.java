package fr.olympus5.bank;

public class TransactionFactory {
    public Transaction newTransaction(final int amount) {
        return new Transaction("2012-01-10", amount);
    }
}
