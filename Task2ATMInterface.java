import java.util.Scanner;


class BankAccount {
    private double balance;


    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }


    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" Deposit successful. Current balance: ₹" + balance);
        } else {
            System.out.println(" Invalid deposit amount!");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Invalid withdrawal amount!");
            return false;
        } else if (amount > balance) {
            System.out.println(" Insufficient balance!");
            return false;
        } else {
            balance -= amount;
            System.out.println(" Withdrawal successful. Current balance: ₹" + balance);
            return true;
        }
    }


    public double checkBalance() {
        return balance;
    }
}


class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===============================");
            System.out.println("         🏧 ATM MENU");
            System.out.println("===============================");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ₹");
                    double wAmount = sc.nextDouble();
                    account.withdraw(wAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double dAmount = sc.nextDouble();
                    account.deposit(dAmount);
                    break;

                case 3:
                    System.out.println(" Current balance: ₹" + account.checkBalance());
                    break;

                case 4:
                    System.out.println(" Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println(" Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }
}

public class ATMInterface {
    public static void main(String[] args) {

        BankAccount userAccount = new BankAccount(5000.0);

        ATM atm = new ATM(userAccount);

        atm.showMenu();
    }
}
