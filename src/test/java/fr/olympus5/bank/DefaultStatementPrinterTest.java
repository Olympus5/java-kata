package fr.olympus5.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class DefaultStatementPrinterTest {

    @Test
    void statementPrintException() {
        final StatementPrinter printer = new DefaultStatementPrinter(new BufferedWriter(new Writer() {
            @Override
            public void write(char[] cbuf, int off, int len) throws IOException {
                throw new IOException("failure.");
            }

            @Override
            public void flush() throws IOException {

            }

            @Override
            public void close() throws IOException {

            }
        }));

        assertThrows(StatementPrintException.class,
                () -> printer.print(Collections.singletonList(new Transaction("2012-01-10", 1000))));
    }
}