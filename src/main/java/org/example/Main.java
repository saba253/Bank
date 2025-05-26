package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n===== საბანკო სისტემა =====");
            System.out.println("1. ანგარიშის გახსნა");
            System.out.println("2. ანგარიშზე შესვლა");
            System.out.println("3. გასვლა");
            System.out.print("აირჩიე მოქმედება: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // nextInt()-ის შემდეგ ცარიელი ხაზის გასუფთავება

            switch (choice) {
                case 1:
                    System.out.print("შეიყვანე ID: ");
                    String newId = scanner.nextLine();
                    System.out.print("შეიყვანე სახელი: ");
                    String name = scanner.nextLine();
                    System.out.print("შეიყვანე 4-ნიშნა PIN: ");
                    String pin = scanner.nextLine();
                    bank.createAccount(newId, name, pin);
                    break;

                case 2:
                    System.out.print("შეიყვანე ID: ");
                    String loginId = scanner.nextLine();
                    System.out.print("შეიყვანე PIN: ");
                    String loginPin = scanner.nextLine();
                    Account user = bank.login(loginId, loginPin);
                    if (user != null) {
                        loggedInMenu(scanner, user);
                    }
                    break;

                case 3:
                    System.out.println("ნახვამდის!");
                    scanner.close();
                    return;

                default:
                    System.out.println("არასწორი არჩევანი.");
            }
        }
    }

    // მომხმარებლის მენიუ როცა უკვე შესულია
    private static void loggedInMenu(Scanner scanner, Account user) {
        while (true) {
            System.out.println("\n--- ანგარიში: " + user.getAccountId() + " ---");
            System.out.println("1. ბალანსის ნახვა");
            System.out.println("2. თანხის შეტანა");
            System.out.println("3. თანხის გამოტანა");
            System.out.println("4. გამოსვლა");
            System.out.print("აირჩიე მოქმედება: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("ბალანსი: ₾" + user.getBalance());
                    break;

                case 2:
                    System.out.print("შეიყვანე თანხა: ");
                    double depositAmount = scanner.nextDouble();
                    user.deposit(depositAmount);
                    System.out.println("თანხა ჩარიცხულია.");
                    break;

                case 3:
                    System.out.print("შეიყვანე თანხა: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (user.withdraw(withdrawAmount)) {
                        System.out.println("თანხა გამოტანილია.");
                    } else {
                        System.out.println("არასაკმარისი თანხა.");
                    }
                    break;

                case 4:
                    System.out.println("თქვენ გამოხვედით ანგარიშიდან.");
                    return;

                default:
                    System.out.println("არასწორი არჩევანი.");
            }
        }
    }
}