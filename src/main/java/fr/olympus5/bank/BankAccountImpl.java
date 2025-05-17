package fr.olympus5.bank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Comparator;
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

            final String rows = transactionRepository.findAll().stream()
                    .sorted(Comparator.comparing(Transaction::date).reversed())
                    .map(tx -> String.format("%s || %s || %s%n", tx.date(), tx.amount(), tx.amount()))
                    .reduce(String::concat).orElse("");
            statementWriter.write(rows);

            statementWriter.flush();
        } catch (IOException e) {
            // TODO
        }
    }
}
