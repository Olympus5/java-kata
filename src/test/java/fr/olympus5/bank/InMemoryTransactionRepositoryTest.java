package fr.olympus5.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTransactionRepositoryTest {
    private InMemoryTransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
        transactionRepository = new InMemoryTransactionRepository();
    }

    @Test
    void save() {
        final Transaction transaction = new Transaction("2012-01-10", 1000);

        transactionRepository.save(transaction);

        assertIterableEquals(List.of(transaction), transactionRepository.findAll());
    }

    @Test
    void noSave() {
        assertIterableEquals(List.of(), transactionRepository.findAll());
    }
}