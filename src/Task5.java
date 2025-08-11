import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("✅ Deposit successful. New balance: " + balance);
        } else {
            System.out.println("❌ Deposit amount must be positive!");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                transactionHistory.add("Withdrew: " + amount);
                System.out.println("✅ Withdrawal successful. New balance: " + balance);
            } else {
                System.out.println("❌ Insufficient funds!");
            }
        } else {
            System.out.println("❌ Withdrawal amount must be positive!");
        }
    }

    // View Balance
    public void viewBalance() {
        System.out.println("💰 Current balance: " + balance);
    }

    // View Transaction History
    public void viewTransactionHistory() {
        System.out.println("\n📜 Transaction History:");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Account creation
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial deposit amount: ");
        double initialBalance = sc.nextDouble();

        Account account = new Account(name, initialBalance);

        // Menu loop
        while (true) {
            System.out.println("\n==== BANK MENU ====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.viewBalance();
                    break;

                case 4:
                    account.viewTransactionHistory();
                    break;

                case 5:
                    System.out.println("🏦 Thank you for banking with us!");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid option! Please try again.");
            }
        }
    }
}

