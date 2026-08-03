# Task 5: Multithreaded Bank Account

## Description

Thread-safe bank account implementation with deposit, withdraw, and transfer operations.

## Classes

### BankAccount

| Method         | Description                         |
|----------------|-------------------------------------|
| deposit(long)  | Adds funds to account               |
| withdraw(long) | Removes funds if sufficient balance |
| getBalance()   | Returns current balance             |

### ConcurrentBank

| Method                                   | Description                                 |
|------------------------------------------|---------------------------------------------|
| createAccount(long)                      | Creates new account with initial balance    |
| transfer(BankAccount, BankAccount, long) | Atomically transfers funds between accounts |
| getTotalBalance()                        | Returns sum of all account balances         |

## Usage Example

```java
ConcurrentBank bank = new ConcurrentBank();
BankAccount acc1 = bank.createAccount(1000);
BankAccount acc2 = bank.createAccount(500);

bank.transfer(acc1, acc2, 200);
```

## Build and Run

```bash
javac src/task4_concurrency/bank/*.java
java -cp src task4_concurrency.bank.ConcurrentBankExample
```

## Expected Output

```text
Initial balances:
Account 1: 1000
Account 2: 500
Total balance: 1500

Transfer 200 from Account 1 to Account 2 completed
Transfer 100 from Account 2 to Account 1 completed

Final balances:
Account 1: 900
Account 2: 600
Total balance: 1500
```
