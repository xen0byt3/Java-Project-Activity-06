import java.util.Scanner;

public class ReyesPasswordSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String correctPIN = "1234";
        boolean isLoggedIn = false;

        // Login System with 3 attempts
        for (int attempt = 1; attempt <= 3; attempt++) {

            System.out.print("Enter PIN: ");
            String enteredPIN = input.nextLine();

            if (enteredPIN.equals(correctPIN)) {
                System.out.println("Access Granted!");
                isLoggedIn = true;
                break;
            } else {
                if (attempt == 1) {
                    System.out.println("Attempt 1! Incorrect PIN");
                } else if (attempt == 2) {
                    System.out.println("Attempt 2! Warning: Last attempt remaining");
                } else if (attempt == 3) {
                    System.out.println("Attempt 3! Card Blocked");
                }
            }
        }

        // Check if login failed
        if (!isLoggedIn) {
            System.out.println("Card Blocked.");
            System.out.println("Please contact your bank.");
            System.exit(0);
        }

        // ATM System after successful login
        double balance = 1000.00;
        int choice;

        while (true) {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1 - Check Balance");
            System.out.println("2 - Deposit");
            System.out.println("3 - Withdraw");
            System.out.println("4 - Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.printf("Your current balance is: %.2f\n", balance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = input.nextDouble();

                    if (deposit > 0) {
                        balance += deposit;
                        System.out.printf("Deposit successful! New Balance: %.2f\n", balance);
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = input.nextDouble();

                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.printf("Withdrawal successful! Remaining Balance: %.2f\n", balance);
                    } else {
                        System.out.println("Insufficient Balance");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM System");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1-4 only.");
            }
        }
    }
}