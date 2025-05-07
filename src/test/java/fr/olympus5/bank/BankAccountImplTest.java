package fr.olympus5.bank;

import org.junit.jupiter.api.Test;

public class BankAccountImplTest {
    private BankAccount bankAccount;

    @Test
    void emptyStatement() {
        this.bankAccount = new BankAccountImpl();
    }
}
