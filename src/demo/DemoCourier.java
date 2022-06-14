package src.demo;

import java.util.Scanner;

import src.auth.Authentication;
import src.datastructures.linkedlistwithmergesort.CustomLinkedList;
import src.restaurant.Food;
import src.restaurant.Menu;
import src.restaurant.Order;
import src.restaurant.Restaurant;
import src.user.Courier;

public class DemoCourier {
    public static void demoCourier() {
        Restaurant restaurant = new Restaurant();
        Courier courier = (Courier) Authentication.login();
        Menu menu = new Menu();
        CustomLinkedList<Food> foods = new CustomLinkedList<>();
        CustomLinkedList<Food> foods1 = new CustomLinkedList<>();
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\nWelcome to the HoldON " + courier.getName() + " !");

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
        courier.addOrder(order);
        courier.addOrder(order1);

        while (choice != 6) {
            printProgramMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    courier.showOrders();
                    break;
                case 2:
                    courier.deliverOrderToCustomer();
                    System.out.println("\n\nOrder has been delivered to the customer. (If exists) \n\n");
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
                    System.out.println("\n\nThank you for working with us!\n\n");
                    break;
                default:
                    System.out.println("\n\nPlease enter an integer between 1-6!\n\n");
            }
        }
    }

    public static void printProgramMenu() {
        System.out.println("\nPlease select one of the following operations");
        System.out.println("1-> Show Orders");
        System.out.println("2-> Deliver Order To Customer");
        System.out.println("3-> Show profile info");
        System.out.println("4-> Update profile info");
        System.out.println("5-> Change your password");
        System.out.println("6-> Logout");
        System.out.print("\nPlease enter your choice: ");
    }

    public static void updateProfile(Courier courier) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to update:");
        System.out.println("1: USERNAME");
        System.out.println("2: PHONE NUMBER");
        System.out.print("Enter your input: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                updateCourierUsername(courier);
                break;
            case 2:
                updateCourierPhoneNumber(courier);
                break;
            default:
                System.out.println("\n\nInvalid input. You should have entered an integer between 1-2!\n\n");
        }
    }

    public static void updateCourierUsername(Courier courier) {
        String newUsername = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new username please: ");
        newUsername = sc.next();
        courier.setUsername(newUsername);
        System.out.println("\n\nYour username has been updated!\n");
    }

    public static void updateCourierPhoneNumber(Courier courier) {
        String newNumber = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new phone number please: ");
        newNumber = sc.next();
        courier.setPhoneNumber(newNumber);
        System.out.println("\n\nYour phone number has been updated!\n");

    }

    public static void changePassword(Courier courier) {
        String newPassword = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new password please: ");
        newPassword = sc.next();
        courier.setPassword(newPassword);
        System.out.println("\n\nYour password has been updated!\n");

    }

}
