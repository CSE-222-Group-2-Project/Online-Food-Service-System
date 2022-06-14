package src.demo;

import java.util.Scanner;
import src.auth.Authentication;
import src.datastructures.linkedlistwithmergesort.CustomLinkedList;
import src.restaurant.Food;
import src.restaurant.Menu;
import src.restaurant.Order;
import src.restaurant.Restaurant;
import src.user.Customer;

public class DemoCustomer {

  public static void demoCustomer() {
    Restaurant restaurant = new Restaurant();
    Customer customer = (Customer) Authentication.login();
    int choice = 0;
    Scanner sc = new Scanner(System.in);
    CustomLinkedList<Food> foods = new CustomLinkedList<>();
    System.out.println("\nWelcome to the HoldON " + customer.getName() + " !");

    while (choice != 5) {
      printProgramMenu();
      choice = sc.nextInt();

      switch (choice) {
        case 1:
          customer.seeMenu();
          break;
        case 2:
          foods = getFoodsFromCustomer();
          Order order = new Order(1, customer, foods, "AKSE");
          customer.giveOrder(restaurant, order);
          System.out.println("Order has been given");
          break;
        case 3:
          System.out.println(customer.orderHistory());
          break;
        case 4:
          System.out.println(customer);
      }
    }
    sc.close();
  }

  public static void printProgramMenu() {
    System.out.println("\nHere is what you can do: ");
    System.out.println("1: See the menu");
    System.out.println("2: Give an order");
    System.out.println("3: See your order history");
    System.out.println("4: Show profile info");
    System.out.println("5: Edit profile info");
    System.out.println("6: Change your password");
    System.out.println("7: Exit");
    System.out.println("\nPlease enter your choice: ");
  }

  public static CustomLinkedList<Food> getFoodsFromCustomer() {
    CustomLinkedList<Food> foods = new CustomLinkedList<>();
    Menu menu = new Menu();
    System.out.println("Create order according to food ID's");
    System.out.println(
        "Enter the ID's of the foods you want to order (exp: 1 3 5 ): ");
    Scanner sc = new Scanner(System.in);
    String foodID = sc.nextLine();
    String[] foodIDs = foodID.split(" ");
    for (String id : foodIDs) {
      Food food = menu.getFood(Integer.parseInt(id));
      if (food != null) {
        foods.add(food);
      }
    }
    return foods;
  }
}
