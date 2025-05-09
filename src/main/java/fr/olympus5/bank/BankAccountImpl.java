package fr.olympus5.bank;

import java.io.BufferedWriter;
import java.io.IOException;

public class BankAccountImpl implements BankAccount {
    private final BufferedWriter statementWriter;
    private Transaction transaction = null;

    public BankAccountImpl(final BufferedWriter statementWriter) {
        this.statementWriter = statementWriter;
    }

    @Override
    public void deposit(final int amount) {
        transaction = new Transaction("2012-01-10", amount, amount);
    }

    @Override
    public void withdraw(int amount) {

    }

    @Override
    public void printStatement() {
        try {
            statementWriter.write("Date       || Amount || Balance");
            if (transaction != null) {
                statementWriter.newLine();
                statementWriter.write(transaction.date() + " || " + transaction.amount() + " || " + transaction.balance());
                statementWriter.newLine();
            }
            statementWriter.flush();
        } catch (IOException e) {
            // TODO
        }
    }
}
