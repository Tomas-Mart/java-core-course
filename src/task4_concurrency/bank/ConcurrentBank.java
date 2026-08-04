package task4_concurrency.bank;

import java.util.ArrayList;
import java.util.List;

public final class ConcurrentBank {
    private final List<BankAccount> accounts;

    public ConcurrentBank() {
        this.accounts = new ArrayList<>();
    }

    public BankAccount createAccount(long initialBalance) {
        if (initialBalance < 0) throw new IllegalArgumentException("Initial balance cannot be negative");

        synchronized (accounts) {
            BankAccount account = new BankAccount(initialBalance);
            accounts.add(account);
            return account;
        }
    }

    public void transfer(BankAccount from, BankAccount to, long amount) {
        if (from == null || to == null) throw new IllegalArgumentException("Accounts cannot be null");
        if (from == to) throw new IllegalArgumentException("Cannot transfer to the same account");
        if (amount <= 0) throw new IllegalArgumentException("Transfer amount must be positive");

        BankAccount firstLock = from;
        BankAccount secondLock = to;

        if (System.identityHashCode(from) > System.identityHashCode(to)) {
            firstLock = to;
            secondLock = from;
        }

        synchronized (firstLock) {
            synchronized (secondLock) {
                if (from.getBalance() < amount) throw new IllegalStateException("Insufficient funds");
                boolean withdrawn = from.withdraw(amount);

                if (!withdrawn) throw new IllegalStateException("Failed to withdraw");
                to.deposit(amount);
            }
        }
    }

    public long getTotalBalance() {
        synchronized (accounts) {
            long total = 0;
            for (BankAccount account : accounts) {
                total += account.getBalance();
            }
            return total;
        }
    }
}