package fr.olympus5.bank;

import java.io.BufferedWriter;
import java.io.IOException;

public class BankAccountImpl implements BankAccount {
    private final BufferedWriter statementWriter;

    public BankAccountImpl(BufferedWriter statementWriter) {
        this.statementWriter = statementWriter;
    }

    @Override
    public void deposit(int amount) {

    }

    @Override
    public void withdraw(int amount) {

    }

    @Override
    public void printStatement() {
        try {
            this.statementWriter.write("Date       || Amount || Balance");
            this.statementWriter.flush();
        } catch (IOException e) {
            // TODO
        }
    }
}
