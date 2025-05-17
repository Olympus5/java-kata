package fr.olympus5.bank;

import java.util.List;

public interface StatementPrinter {
    void print(List<Transaction> transactions);
}
