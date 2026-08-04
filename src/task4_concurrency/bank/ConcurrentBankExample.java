package task4_concurrency.bank;

public final class ConcurrentBankExample {
    public static void main(String[] args) {
        ConcurrentBank bank = new ConcurrentBank();

        BankAccount account1 = bank.createAccount(1000);
        BankAccount account2 = bank.createAccount(500);

        System.out.println("Initial balances:");
        System.out.println("Account 1: " + account1.getBalance());
        System.out.println("Account 2: " + account2.getBalance());
        System.out.println("Total balance: " + bank.getTotalBalance());
        System.out.println();

        Thread transferThread1 = new Thread(() -> {
            try {
                bank.transfer(account1, account2, 200);
                System.out.println("Transfer 200 from Account 1 to Account 2 completed");
            } catch (Exception e) {
                System.err.println("Transfer 1 failed: " + e.getMessage());
            }
        });

        Thread transferThread2 = new Thread(() -> {
            try {
                bank.transfer(account2, account1, 100);
                System.out.println("Transfer 100 from Account 2 to Account 1 completed");
            } catch (Exception e) {
                System.err.println("Transfer 2 failed: " + e.getMessage());
            }
        });

        transferThread1.start();
        transferThread2.start();

        try {
            transferThread1.join();
            transferThread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Transfer interrupted: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Final balances:");
        System.out.println("Account 1: " + account1.getBalance());
        System.out.println("Account 2: " + account2.getBalance());
        System.out.println("Total balance: " + bank.getTotalBalance());
    }
}