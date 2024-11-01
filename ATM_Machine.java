import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

// Class representing the ATM machine
public class ATM_Machine {
    private BankAccount account;
    private int pin;
    
    // Constructor to initialize the ATM with a bank account and a pin
    public ATM_Machine(BankAccount account, int pin) {
        this.account = account;
        this.pin = pin;
    }

    // Method to validate the user's PIN
    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    // Method to display the ATM menu
    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    // Method to check the balance
    public void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Successfully deposited $" + amount);
            checkBalance();
        } else {
            System.out.println("Invalid deposit amount. Please try again.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && account.withdraw(amount)) {
            System.out.println("Successfully withdrew $" + amount);
            checkBalance();
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient funds. Please try again.");
        } else {
            System.out.println("Invalid withdrawal amount. Please try again.");
        }
    }

    // Main method to simulate the ATM operation
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a BankAccount object with an initial balance of 1000
        BankAccount userAccount = new BankAccount(1000);

        // Create an ATM object with the user account and a PIN
        ATM_Machine atm = new ATM_Machine(userAccount, 1234);

        // Prompt user for PIN
        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();
        
        if (!atm.validatePin(enteredPin)) {
            System.out.println("Incorrect PIN. Exiting.");
            return; // Exit if the PIN is incorrect
        }

        // Flag to control whether the user wants to exit
        boolean exit = false;

        // Loop to keep showing the menu until the user chooses to exit
        while (!exit) {
            atm.displayMenu(); // Display the ATM menu
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance(); // Check balance
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount); // Deposit money
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount); // Withdraw money
                    break;
                case 4:
                    System.out.println("Exiting... Thank you for using the ATM!");
                    exit = true; // Exit the loop and end the program
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        sc.close();
    }
}