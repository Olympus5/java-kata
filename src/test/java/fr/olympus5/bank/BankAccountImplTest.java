package fr.olympus5.bank;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountImplTest {
    private BankAccount bankAccount;

    @Test
    void noBankOperation() {
        final StringWriter out = new StringWriter();
        this.bankAccount = new BankAccountImpl(new BufferedWriter(out));

        bankAccount.printStatement();

        assertEquals("Date       || Amount || Balance", out.toString());
    }

    @Test
    void deposit() {
        final StringWriter out = new StringWriter();
        this.bankAccount = new BankAccountImpl(new BufferedWriter(out));

        bankAccount.deposit(1000);
        bankAccount.printStatement();

        assertEquals("""
                Date       || Amount || Balance
                2012-01-10 || 1000 || 1000
                """, out.toString());
    }
}
