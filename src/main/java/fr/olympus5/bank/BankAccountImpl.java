package fr.olympus5.bank;

public class BankAccountImpl implements BankAccount {
    private final TransactionFactory transactionFactory;
    private final TransactionRepository transactionRepository;
    private final StatementPrinter statementPrinter;

    public BankAccountImpl(final TransactionFactory transactionFactory,
                           final TransactionRepository transactionRepository,
                           final StatementPrinter statementPrinter) {
        this.transactionFactory = transactionFactory;
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    @Override
    public void deposit(final int amount) {
        throwExceptionIfAmountIsNegative(amount);

        transactionRepository.save(transactionFactory.newTransaction(amount));
    }

    @Override
    public void withdraw(final int amount) {
        throwExceptionIfAmountIsNegative(amount);

        transactionRepository.save(transactionFactory.newTransaction(-amount));
    }

    @Override
    public void printStatement() {
        statementPrinter.print(transactionRepository.findAll());
    }

    private static void throwExceptionIfAmountIsNegative(final int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }
    }
}
