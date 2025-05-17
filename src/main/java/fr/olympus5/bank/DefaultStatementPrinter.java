package fr.olympus5.bank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultStatementPrinter implements StatementPrinter {
    private final BufferedWriter statementWriter;

    public DefaultStatementPrinter(final BufferedWriter statementWriter) {
        this.statementWriter = statementWriter;
    }

    @Override
    public void print(final List<Transaction> transactions) {
        try {
            statementWriter.write("Date || Amount || Balance");
            statementWriter.newLine();

            final AtomicReference<Integer> runningBalance = new AtomicReference<>(0);

            final String rows = transactions.stream()
                    .map(tx -> {
                        final Integer updatedBalance = runningBalance.updateAndGet(b -> b + tx.amount());
                        return String.format("%s || %s || %s%n", tx.date(), tx.amount(), updatedBalance);
                    })
                    .sorted(Comparator.reverseOrder())
                    .reduce(String::concat)
                    .orElse("");
            statementWriter.write(rows);

            statementWriter.flush();
        } catch (IOException e) {
            throw new StatementPrintException(e);
        }
    }
}
