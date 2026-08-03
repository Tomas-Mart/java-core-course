package task4_concurrency.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public final class ConcurrentBank {
    private final List<BankAccount> accounts;
    private final ReentrantLock lock;

    public ConcurrentBank() {
        this.accounts = new ArrayList<>();
        this.lock = new ReentrantLock();
    }

    public BankAccount createAccount(long initialBalance) {
        if (initialBalance < 0) throw new IllegalArgumentException("Initial balance cannot be negative");
        lock.lock();

        try {
            BankAccount account = new BankAccount(initialBalance);
            accounts.add(account);
            return account;
        } finally {
            lock.unlock();
        }
    }

    public void transfer(BankAccount from, BankAccount to, long amount) {
        if (from == null || to == null) throw new IllegalArgumentException("Accounts cannot be null");
        if (from == to) throw new IllegalArgumentException("Cannot transfer to the same account");
        if (amount <= 0) throw new IllegalArgumentException("Transfer amount must be positive");
        lock.lock();

        try {
            if (from.getBalance() < amount) throw new IllegalStateException("Insufficient funds");
            boolean withdrawn = from.withdraw(amount);

            if (!withdrawn) throw new IllegalStateException("Failed to withdraw");
            to.deposit(amount);

        } finally {
            lock.unlock();
        }
    }

    public long getTotalBalance() {
        lock.lock();

        try {
            long total = 0;
            for (BankAccount account : accounts) {
                total += account.getBalance();
            }
            return total;
        } finally {
            lock.unlock();
        }
    }
}