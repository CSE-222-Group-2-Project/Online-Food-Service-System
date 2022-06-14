package src.demo;

import java.util.Scanner;

import src.auth.Authentication;
import src.restaurant.Restaurant;
import src.user.Chef;


public class DemoChef {
    public static void demoChef() {
        Restaurant restaurant = new Restaurant();
        Chef chef = (Chef) Authentication.login();
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWelcome to the HoldON " + chef.getName() + " !");

        while (choice != 6) {
            printProgramMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    chef.prepareOrder();
                    System.out.print("Order has been prepared and given to the Courier.");
                    break;
                case 2:
                    System.out.println("Certificate number is " + chef.incrementCertificateNumber());
                    System.out.println("Certificate number has been incremented..");
                    break;
                case 3:
                    System.out.println(chef);
                    break;
                case 4:
                updateProfile(chef);
                    break;
                case 5:
                changePassword(chef);
                    break;
                case 6:
                    sc.close();
                    return;
                default:

            }
        }
        sc.close();
    }

    public static void printProgramMenu() {
        System.out.println("\nPlease select one of the following operations");
        System.out.println("1-> Prepare Order (If there is any)");
        System.out.println("2-> Increment Certificate Number");
        System.out.println("3-> Show profile info");
        System.out.println("4-> Update profile info");
        System.out.println("5-> Change your password");
        System.out.println("6-> Exit");
        System.out.print("\nPlease enter your choice: ");
    }

    public static void updateProfile(Chef chef) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to update:");
        System.out.println("1: USERNAME");
        System.out.print("2: EXIT");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                updateUsername(chef);
                break;
                case 2:
                break;
            default:
                System.out.println("Invalid input!");
        }
    }

    public static void updateUsername(Chef chef) {
        String newUsername = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new username please: ");
        newUsername = sc.next();
        chef.setUsername(newUsername);
        System.out.println("Your username has been updated!\n");
    }

    public static void changePassword(Chef chef) {
        String newPassword = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new password please: ");
        newPassword = sc.next();
        chef.setPassword(newPassword);
        System.out.println("Your password has been updated!\n");

    }

}
