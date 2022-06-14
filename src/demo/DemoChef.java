package src.demo;

import java.util.Scanner;

import src.auth.Authentication;
import src.datastructures.linkedlistwithmergesort.CustomLinkedList;
import src.restaurant.Food;
import src.restaurant.Menu;
import src.restaurant.Order;
import src.restaurant.Restaurant;
import src.user.Chef;

public class DemoChef {
    public static void demoChef() {
        Restaurant restaurant = new Restaurant();
        Menu menu = new Menu();
        CustomLinkedList<Food> foods = new CustomLinkedList<>();
        CustomLinkedList<Food> foods1 = new CustomLinkedList<>();

        Chef chef = (Chef) Authentication.login();
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\n\nWelcome to the HoldON " + chef.getName() + " !");

        String IDs = "1 15";
        String[] foodIDs = IDs.split(" ");
        for (String id : foodIDs) {
            Food food = menu.getFood(Integer.parseInt(id));
            if (food != null) {
                foods.add(food);
            }
        }

        IDs = "3 12";
        foodIDs = IDs.split(" ");
        for (String id : foodIDs) {
            Food food = menu.getFood(Integer.parseInt(id));
            if (food != null) {
                foods1.add(food);
            }
        }

        Order order = new Order(1, restaurant.getTestCustomer(), foods, "ATATURK");
        Order order1 = new Order(2, restaurant.getTestCustomer(), foods1, "ATATURK");
        chef.addOrder(order);
        chef.addOrder(order1);

        while (choice != 7) {
            printProgramMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    chef.showOrders();
                    break;
                case 2:
                    chef.prepareOrder();
                    System.out.println("\n\nOrder has been prepared and given to the Courier. (If exists) \n\n");
                    break;
                case 3:
                    System.out.println("\n\nCertificate number is " + chef.incrementCertificateNumber());
                    System.out.println("Certificate number has been incremented..\n\n");
                    break;
                case 4:
                    System.out.println(chef);
                    break;
                case 5:
                    updateProfile(chef);
                    break;
                case 6:
                    changePassword(chef);
                    break;
                case 7:
                    System.out.println("\n\nThank you for working with us!\n\n");
                    return;
                default:

            }
        }
    }

    public static void printProgramMenu() {
        System.out.println("\nPlease select one of the following operations");
        System.out.println("1-> Show New Orders");
        System.out.println("2-> Prepare Order (If there is any)");
        System.out.println("3-> Increment Certificate Number");
        System.out.println("4-> Show profile info");
        System.out.println("5-> Update profile info");
        System.out.println("6-> Change your password");
        System.out.println("7-> Logout");
        System.out.print("\nPlease enter your choice: ");
    }

    public static void updateProfile(Chef chef) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to update:");
        System.out.println("1: USERNAME");
        System.out.println("2: EXIT");
        System.out.print("Enter your input: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                updateUsername(chef);
                break;
            case 2:
                break;
            default:
                System.out.println("\n\nInvalid input!\n\n");
        }
    }

    public static void updateUsername(Chef chef) {
        String newUsername = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new username please: ");
        newUsername = sc.next();
        chef.setUsername(newUsername);
        System.out.println("\n\nYour username has been updated!\n\n");
    }

    public static void changePassword(Chef chef) {
        String newPassword = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new password please: ");
        newPassword = sc.next();
        chef.setPassword(newPassword);
        System.out.println("\n\nYour password has been updated!\n\n");

    }

}
