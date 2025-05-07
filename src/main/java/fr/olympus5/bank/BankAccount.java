package fr.olympus5.bank;

public interface BankAccount {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
}
