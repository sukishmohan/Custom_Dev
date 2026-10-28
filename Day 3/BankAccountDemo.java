public class BankAccountDemo {
    public static void main(String[] args) {
        // Use new to create an object and call its constructor.
        BankAccount account = new BankAccount("Ravi");

        System.out.println("Account holder: " + account.getAccountHolder());
        System.out.println("Starting balance: " + account.getBalance());

        account.deposit(1000);
        System.out.println("After deposit: " + account.getBalance());

        account.withdraw(300);
        System.out.println("After withdrawal: " + account.getBalance());
    }
}
