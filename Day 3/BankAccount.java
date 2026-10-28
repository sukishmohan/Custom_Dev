public class BankAccount {
    // Private fields can only be accessed inside this class.
    private String accountHolder;
    private double balance;

    // The constructor sets up a new account with a zero balance.
    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Not enough balance.");
        } else {
            balance -= amount;
        }
    }
}
