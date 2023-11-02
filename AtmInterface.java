import java.util.*;

class Transaction {
    private int balance;

    Transaction() {
        this.balance = 100000;
    }

    void WithDrawal(int amount) {
        if (balance > 0 && balance >= amount) {
            this.balance -= amount;
            System.out.println("Transaction successful");
        } else if (balance < amount) {
            System.out.println("Insufficient Balance");
        } else {
            System.out.println("Error: Transaction Amount limit exceeded");
        }
    }

    void Deposit(int deposit) {
        if (deposit > 0) {
            this.balance += deposit;
            System.out.println("Deposit Successful");
        }
    }

    void CheckBalance() {
        System.out.println("Available balance : " + this.balance);
    }
}

class AtmInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert Your Card");

        System.out.print("Enter your pin : ");
        String pinNumber = scanner.nextLine();

        while (pinNumber.length() != 4) {
            System.out.print("Enter valid Four digit pin.");
            System.exit(0);

            if (pinNumber.length() != 4) {
                System.out.println("Enter a valid four-digit number");
            }
        }

        Transaction t = new Transaction();

        while (true) {
            System.out.println("Select your option : ");
            System.out.println("Welcome, Dear Customer");
            System.out.println("1.Deposit\n2.WithDrawal\n3.Check Balance\n4.Exit\n");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter money to deposit : ");
                    try {
                        int deposit = scanner.nextInt();
                        t.Deposit(deposit);
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Transaction Amount limit exceeded");
                        scanner.nextLine();
                    }
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw : ");
                    int amount = scanner.nextInt();
                    t.WithDrawal(amount);
                    break;
                case 3:
                    t.CheckBalance();
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choose a valid service");

            }
        }

    }
}