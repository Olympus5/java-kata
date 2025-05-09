package fr.olympus5.bank;

import java.io.BufferedWriter;
import java.io.IOException;

public class BankAccountImpl implements BankAccount {
    private final TransactionRepository transactionRepository;
    private final BufferedWriter statementWriter;
    private Transaction transaction = null;

    public BankAccountImpl(final BufferedWriter statementWriter, final TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
        this.statementWriter = statementWriter;
    }

    @Override
    public void deposit(final int amount) {
        transactionRepository.save(new Transaction("2012-01-10", amount, amount));
    }

    @Override
    public void withdraw(int amount) {

    }

    @Override
    public void printStatement() {
        try {
            statementWriter.write("Date       || Amount || Balance");
            if(!transactionRepository.findAll().isEmpty()) statementWriter.newLine();
            final String rows = transactionRepository.findAll().stream()
                    .map(tx -> String.format("%s || %s || %s%n", tx.date(), tx.amount(), tx.balance()))
                    .reduce(String::concat).orElse("");
            statementWriter.write(rows);
            statementWriter.flush();
        } catch (IOException e) {
            // TODO
        }
    }
}
