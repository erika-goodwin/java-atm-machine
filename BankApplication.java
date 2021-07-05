import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BankAccount<String, String> account = new BankAccount<>("Andasan", "citi00001");
        System.out.println("Welcome " + account.getCustomerName());
        System.out.println("Your ID is " + account.getCustomerId());
        System.out.println("\n");

        account.showMenu();
    }
}

class BankAccount<s1,s2> {
    int balance;
    int previousTransaction;
    private final s1 customerName;
    private final s2 customerId;

    BankAccount(s1 customerName, s2 customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    public s1 getCustomerName() {
        return customerName;
    }

    public s2 getCustomerId() {
        return customerId;
    }

    void deposit(int amount) {
        if (amount >= 0 && balance != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        } else {
            if (amount <= 0) {
                errorMessage("Invalid Amount!! Please Enter Correct Amount...");
            } else {
                errorMessage("Invalid Input!! Please Enter Correct Amount...");
            }
        }
    }

    void withdraw(int amount) {
        if (amount >= 0 && balance != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        } else {
            if (amount <= 0) {
                errorMessage("Invalid Amount!! Please Enter Correct Amount...");
            } else {
                errorMessage("Insufficient Balance");
            }
        }
    }

    void errorMessage(String message) {
        System.out.println("\n");
        System.out.println("-------------------------------------------------------");
        System.out.println("!!! " + message);
        System.out.println("-------------------------------------------------------");
        System.out.println("\n");
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: $" + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdraw: $" + Math.abs(previousTransaction));
        }else {
            System.out.println("No Transaction Occurred");
        }
    }

    void showMenu() {

        char option;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("Enter Your Option");
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("A : Check Your Balance");
            System.out.println("B : Deposit");
            System.out.println("C : Withdraw");
            System.out.println("D : Previous Transaction");
            System.out.println("E : Exit The System");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (Character.toLowerCase(option)) {

                case 'a':
                    System.out.println("-------------------------------------------------------");
                    System.out.println("Balance = $" + balance);
                    System.out.println("-------------------------------------------------------");
                    System.out.println("\n");
                    break;

                case 'b':
                    System.out.println("-------------------------------------------------------");
                    System.out.println("Enter an amount to deposit ");
                    System.out.println("-------------------------------------------------------");

                    try {
                        int amount = scanner.nextInt();
                        deposit(amount);
                        System.out.println("\n");
                    } catch (Exception e) {
                        errorMessage("Wrong input! Input only integer numbers please...");
                        scanner.nextLine();
                    }
                    break;

                case 'c':
                    System.out.println("-------------------------------------------------------");
                    System.out.println("Enter an amount to withdraw ");
                    System.out.println("-------------------------------------------------------");

                    try {
                        int amount2 = scanner.nextInt();
                        withdraw(amount2);
                        System.out.println("\n");
                    } catch (Exception e) {
                        errorMessage("Wrong input! Input only integer numbers please...");
                        scanner.nextLine();
                    }
                    break;

                case 'd':
                    System.out.println("-------------------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("-------------------------------------------------------");
                    System.out.println("\n");
                    break;

                case 'e':
                    System.out.println("=========================================================================================================");
                    break;

                default:
                    System.out.println("Invalid Option!! Please Enter Correct Opton...");
                    break;
            }
        } while (option != 'E');
        System.out.println("Thank You for banking with us.....!!");
        scanner.close();
    }
}
