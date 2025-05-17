package fr.olympus5.bank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class BankAccountImpl implements BankAccount {
    private final TransactionFactory transactionFactory;
    private final TransactionRepository transactionRepository;
    private final BufferedWriter statementWriter;

    public BankAccountImpl(final TransactionFactory transactionFactory, final TransactionRepository transactionRepository, final BufferedWriter statementWriter) {
        this.transactionFactory = transactionFactory;
        this.transactionRepository = transactionRepository;
        this.statementWriter = statementWriter;
    }

    @Override
    public void deposit(final int amount) {
        transactionRepository.save(transactionFactory.newTransaction(amount));
    }

    @Override
    public void withdraw(int amount) {

    }

    @Override
    public void printStatement() {
        try {
            statementWriter.write("Date || Amount || Balance");
            statementWriter.newLine();
            final List<Transaction> transactions = transactionRepository.findAll();

            if (!transactions.isEmpty()) {
                final Transaction firstTransaction = transactions.get(0);
                statementWriter.write(String.format("%s || %s || %s%n", firstTransaction.date(), firstTransaction.amount(), firstTransaction.amount()));
            }

            statementWriter.flush();
        } catch (IOException e) {
            // TODO
        }
    }
}
