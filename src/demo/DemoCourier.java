package src.demo;

import java.util.Scanner;

import src.auth.Authentication;
import src.restaurant.Restaurant;
import src.user.Courier;

public class DemoCourier {
    public static void demoCourier() {
        Restaurant restaurant = new Restaurant();
        Courier courier = (Courier) Authentication.login();
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWelcome to the HoldON " + courier.getName() + " !");

        while (choice != 6) {
            printProgramMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                courier.showOrders();
                    break;
                case 2:
                deliverOrder(courier);
                    break;
                case 3:
                System.out.print(courier);
                    break;
                case 4:
                updateProfile(courier);
                    break;
                case 5:
                changePassword(courier);
                    break;
                case 6:
                System.out.println("Thank you for working with us!");
                    break;
                default:
                System.out.println("Please enter an integer between 1-6!");

            }
        }
        sc.close();

    }

    public static void printProgramMenu() {
        System.out.println("\nPlease select one of the following operations");
        System.out.println("1-> Show Orders");
        System.out.println("2-> Deliver Order To Customer");
        System.out.println("3-> Show profile info");
        System.out.println("4-> Update profile info");
        System.out.println("5-> Change your password");
        System.out.println("6-> Exit");
        System.out.print("\nPlease enter your choice: ");
    }

    public static void deliverOrder(Courier courier){

    }

    public static void updateProfile(Courier courier) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to update:");
        System.out.println("1: USERNAME");
        System.out.println("2: PHONE NUMBER");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                updateCourierUsername(courier);
                break;
            case 2:
                updateCourierPhoneNumber(courier);
                break;
            default:
                System.out.println("Invalid input. You should have entered an integer between 1-2!");
        }
    }

    public static void updateCourierUsername(Courier courier) {
        String newUsername = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new username please: ");
        newUsername = sc.next();
        courier.setUsername(newUsername);
        System.out.println("Your username has been updated!\n");
    }

    public static void updateCourierPhoneNumber(Courier courier) {
        String newNumber = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new phone number please: ");
        newNumber = sc.next();
        courier.setPhoneNumber(newNumber);
        System.out.println("Your phone number has been updated!\n");

    }

    public static void changePassword(Courier courier) {
        String newPassword = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new password please: ");
        newPassword = sc.next();
        courier.setPassword(newPassword);
        System.out.println("Your password has been updated!\n");

    }

}
