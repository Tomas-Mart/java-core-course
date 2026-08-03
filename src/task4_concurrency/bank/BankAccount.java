package task4_concurrency.bank;

import java.util.concurrent.atomic.AtomicLong;

public final class BankAccount {
    private final AtomicLong balance;

    public BankAccount(long initialBalance) {
        this.balance = new AtomicLong(initialBalance);
    }

    public long getBalance() {
        return balance.get();
    }

    public void deposit(long amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive");
        balance.addAndGet(amount);
    }

    public boolean withdraw(long amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdraw amount must be positive");
        long currentBalance;

        do {
            currentBalance = balance.get();
            if (currentBalance < amount) return false;
        } while (!balance.compareAndSet(currentBalance, currentBalance - amount));

        return true;
    }
}