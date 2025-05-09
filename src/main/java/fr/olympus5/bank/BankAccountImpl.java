package fr.olympus5.bank;

import java.io.BufferedWriter;
import java.io.IOException;

public class BankAccountImpl implements BankAccount {
    private final TransactionRepository transactionRepository;
    private final BufferedWriter statementWriter;

    public BankAccountImpl(final TransactionRepository transactionRepository, final BufferedWriter statementWriter) {
        this.transactionRepository = transactionRepository;
        this.statementWriter = statementWriter;
    }

    @Override
    public void deposit(final int amount) {
        transactionRepository.save(new Transaction("2012-01-10", amount));
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
                    .map(tx -> String.format("%s || %s || %s%n", tx.date(), tx.amount(), tx.amount()))
                    .reduce(String::concat).orElse("");
            statementWriter.write(rows);
            statementWriter.flush();
        } catch (IOException e) {
            // TODO
        }
    }
}
