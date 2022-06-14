package src.demo;

import src.auth.Authentication;
import src.restaurant.Food;
import src.restaurant.Restaurant;
import src.user.Admin;
import src.user.Worker;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class DemoAdmin {
    public static void demoAdmin() {
        Restaurant restaurant = new Restaurant();
        Admin admin = (Admin) Authentication.login();
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWelcome to the HoldON " + admin.getName() + " !");

        while (choice != 6) {
            printProgramMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("gec");
                    admin.showWorkersInfo();
                    System.out.println();
                    break;
                case 2:
                    admin.showCustomersInfo();
                    System.out.println();
                    break;
                case 3:
                    admin.printIncomeAndOutcome();
                    System.out.println();
                    break;
                case 4:
                    // admin.hiringWorker();
                    System.out.println();

                    break;
                case 5:
                    admin.fireWorker();
                    System.out.println();

                    break;
                case 6:
                    admin.editSalary();
                    System.out.println();

                    break;
                case 7:
                    admin.printAllOrders();
                    System.out.println();

                    break;
                case 8:
                    addFoodToMenu(admin);
                    break;
                case 9:
                deleteFoodFromMenu(admin);
                    break;
                case 10:
                    admin.seeMenu();
                    break;
                case 11:
                    admin.customerOfTheMonth();
                    break;
                case 12:
                    System.out.println(admin);
                case 13:
                    return;
                default:
                    System.out.println("\nPlease, Enter a valid authority number");           }

        }
        sc.close();

    }


    public static void printProgramMenu() {
        System.out.println("\nPlease select one of the following operations");
        System.out.println("1-> Show Workers Information");
        System.out.println("2-> Show Customers Information");
        System.out.println("3-> Show Income and Outcome");
        System.out.println("4-> Hire Worker");
        System.out.println("5-> Fire Worker");
        System.out.println("6-> Edit Salary");
        System.out.println("7-> Show All Orders");
        System.out.println("8-> Add Food to Menu");
        System.out.println("9-> Delete Food from Menu");
        System.out.println("10-> See the Menu");
        System.out.println("11-> See the Month of The Customer");
        System.out.println("12-> Show My Information");
        System.out.println("13-> Log out the account");
        System.out.print("\nPlease enter your choice: ");
    }

    public static void addFoodToMenu(Admin admin) {
        Scanner sc = new Scanner(System.in);
        try {
            int foodID;
            String foodName, foodType;
            double foodPrice;

            System.out.print("Enter Food Name : ");
            foodName = sc.nextLine();
            System.out.print("Enter Food Price : ");
            foodPrice = Double.parseDouble(sc.nextLine());
            System.out.print("Enter Food Type : ");
            foodType = sc.nextLine();
            System.out.print("Enter Food Id : ");
            foodID = Integer.parseInt(sc.nextLine());
            admin.addFoodToMenu(new Food(foodID, foodName, foodPrice, foodType));
        } catch (NumberFormatException e) {
            System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type");
        } catch (NoSuchElementException e) {
            System.out.println("\nThe enterd type is wrong,\nPlease enter the valid type");
        }
    }

    public static void deleteFoodFromMenu(Admin admin){
        Scanner sc = new Scanner(System.in);
        Integer foodId;
        System.out.print("Enter Food Id : ");
        foodId = Integer.parseInt(sc.nextLine());
        if (admin.deleteFoodFromMenu(foodId)) {
            System.out.println("Food is deleted from menu");
        } else
            System.out.println("Food is not found in menu");

    }

}
