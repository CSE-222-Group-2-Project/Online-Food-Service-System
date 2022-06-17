package src.demo;

import java.util.NoSuchElementException;
import java.util.Scanner;
import src.auth.Authentication;
import src.datastructures.linkedlistwithmergesort.CustomLinkedList;
import src.restaurant.Food;
import src.restaurant.Menu;
import src.restaurant.Order;
import src.restaurant.Restaurant;
import src.user.Admin;
import src.user.Chef;
import src.user.Customer;
import src.user.Worker;

public class DemoAdmin {

  public static void demoAdmin() {
    Restaurant restaurant = new Restaurant();

    Admin admin = (Admin) Authentication.login();
    if (admin == null) {
      System.out.println();
      return;
    }

    admin.setRestaurant(restaurant);
    int choice = 0;
    Scanner sc = new Scanner(System.in);
    CustomLinkedList<Food> foods = new CustomLinkedList<>();
    CustomLinkedList<Food> foods1 = new CustomLinkedList<>();
    Customer customer = restaurant.getTestCustomer();
    Menu menu = new Menu();
    System.out.println("\nWelcome to the HoldON " + admin.getName() + " !");
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
    Order order1 = new Order(
      2,
      restaurant.getTestCustomer(),
      foods1,
      "ATATURK"
    );
    restaurant.addOrder(order);
    restaurant.addOrder(order1);

    while (choice != 13) {
      printProgramMenu();
      choice = sc.nextInt();
      switch (choice) {
        case 1:
          admin.showWorkersInfo();
          System.out.println("\nWorkers has been shown\n\n");
          break;
        case 2:
          admin.showCustomersInfo();
          System.out.println("\nPast customers has been shown\n\n");
          break;
        case 3:
          admin.printIncomeAndOutcome();
          System.out.println("\nIncome and Outcome has been printed\n\n");
          break;
        case 4:
          getNewWorker(admin);
          System.out.println("\n\nNew Worker has been hired!\n\n");
          break;
        case 5:
          admin.fireWorker();
          System.out.println(
            "\n\nWorkers with less than 4.0 score has been fired!\n\n"
          );

          break;
        case 6:
          admin.editSalary();
          System.out.println(
            "\n\nWorkers with more than 8.0 has been promoted!\n\n"
          );

          break;
        case 7:
          admin.printAllOrders();
          System.out.println("\n\nAll past orders has been printed\n\n");
          break;
        case 8:
          addFoodToMenu(admin);
          System.out.println("\n\nFood has been added to menu\n\n");
          break;
        case 9:
          deleteFoodFromMenu(admin);
          System.out.println("\n\nFood has been deleted from the menu\n\n");
          break;
        case 10:
          admin.seeMenu();
          System.out.println("\n\nMenu has been shown\n\n");
          break;
        case 11:
          admin.customerOfTheMonth();
          System.out.println("\nCustomer of the month has been printed\n\n");
          break;
        case 12:
          System.out.println(admin);
          System.out.println("\n\nAdmin info has been shown\n\n");
          break;
        case 13:
          System.out.println("\n\nSee you later boss!\n\n");
          return;
        default:
          System.out.println(
            "\nInvalid input! Enter an integer between 1-13 please!\n"
          );
      }
    }
  }

  public static void getNewWorker(Admin admin) {
    Chef newWorker = new Chef(
      "Mehmet Burak",
      24,
      "bestasistant",
      "mehbuko12",
      4,
      4
    );
    System.out.println(newWorker);
    admin.hiringWorker(newWorker);
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
    System.out.println("13-> Logout");
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
      System.out.println(
        "\nThe enterd type is wrong,\nPlease enter the valid type"
      );
    } catch (NoSuchElementException e) {
      System.out.println(
        "\nThe enterd type is wrong,\nPlease enter the valid type"
      );
    }
  }

  public static void deleteFoodFromMenu(Admin admin) {
    Scanner sc = new Scanner(System.in);
    Integer foodId;
    System.out.print("Enter Food Id : ");
    foodId = Integer.parseInt(sc.nextLine());
    if (admin.deleteFoodFromMenu(foodId)) {
      System.out.println("Food is deleted from menu");
    } else System.out.println("Food is not found in menu");
  }
}
